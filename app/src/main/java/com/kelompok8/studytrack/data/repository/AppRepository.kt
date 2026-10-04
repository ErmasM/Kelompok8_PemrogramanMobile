package com.kelompok8.studytrack.data.repository

import android.util.Log
import com.kelompok8.studytrack.data.CourseData
import com.kelompok8.studytrack.data.NotificationData
import com.kelompok8.studytrack.data.TaskData
import com.kelompok8.studytrack.data.UserData
import com.kelompok8.studytrack.data.database.SurrealDbClient
import com.kelompok8.studytrack.data.database.SurrealDbDataSource
import com.kelompok8.studytrack.data.models.AppNotification
import com.kelompok8.studytrack.data.models.Course
import com.kelompok8.studytrack.data.models.Task
import com.kelompok8.studytrack.data.models.UserProfile
import com.kelompok8.studytrack.data.security.PasswordHasher
import com.kelompok8.studytrack.regulation.NotificationRegulation
import com.kelompok8.studytrack.regulation.TaskRegulation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * AppRepository — Single Source of Truth (SSOT) untuk seluruh data aplikasi.
 *
 * Arsitektur: Offline-First dengan SurrealDB Sync
 * ─────────────────────────────────────────────────
 * 1. UI selalu membaca dari StateFlow lokal (in-memory) → UI selalu responsif
 * 2. Setiap mutasi data juga dikirim ke SurrealDB secara async (fire-and-forget)
 * 3. Saat startup, data dimuat dari SurrealDB jika tersedia → else pakai mock data
 * 4. Jika SurrealDB offline, aplikasi tetap berjalan normal dengan data lokal
 */
object AppRepository {

    private const val TAG = "AppRepository"

    // CoroutineScope untuk operasi background (SurrealDB sync)
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    // Default User dengan password "password123"
    private val defaultUser = UserData.currentUser.copy(
        passwordHash = PasswordHasher.hashPassword("password123")
    )

    // =========================================================
    // STATE FLOWS (SSOT - Single Source of Truth)
    // =========================================================

    private val _users = MutableStateFlow<List<UserProfile>>(listOf(defaultUser))
    val users: StateFlow<List<UserProfile>> = _users.asStateFlow()

    private val _currentUser = MutableStateFlow<UserProfile?>(defaultUser)
    val currentUser: StateFlow<UserProfile?> = _currentUser.asStateFlow()

    private val _tasks = MutableStateFlow<List<Task>>(TaskData.initialTasks)
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    private val _courses = MutableStateFlow<List<Course>>(CourseData.initialCourses)
    val courses: StateFlow<List<Course>> = _courses.asStateFlow()

    private val _notifications = MutableStateFlow<List<AppNotification>>(NotificationData.initialNotifications)
    val notifications: StateFlow<List<AppNotification>> = _notifications.asStateFlow()

    /** Status koneksi SurrealDB (untuk ditampilkan di UI jika perlu) */
    private val _isDbConnected = MutableStateFlow(false)
    val isDbConnected: StateFlow<Boolean> = _isDbConnected.asStateFlow()

    // =========================================================
    // INITIALIZATION - Load dari SurrealDB saat koneksi berhasil
    // =========================================================

    /**
     * Inisialisasi koneksi SurrealDB dan sinkronisasi data awal.
     * Versi fire-and-forget (untuk MainViewModel.init{}).
     * Tidak memblok UI - berjalan di background.
     */
    fun initializeSurrealDb() {
        scope.launch {
            initializeSurrealDbInternal()
        }
    }

    /**
     * Versi suspend dari initializeSurrealDb — menunggu koneksi selesai.
     * Dipanggil dari LaunchedEffect di AppNavigation sebelum checkSavedSession().
     */
    suspend fun initializeSurrealDbAndWait() {
        initializeSurrealDbInternal()
    }

    private suspend fun initializeSurrealDbInternal() {
        val connected = SurrealDbClient.initialize()
        _isDbConnected.value = connected

        if (connected) {
            Log.i(TAG, "🌐 SurrealDB online. Initializing schema and syncing data...")
            SurrealDbDataSource.initializeSchema()
            syncFromDatabase()
        } else {
            Log.i(TAG, "📱 SurrealDB offline. Using local mock data.")
        }
    }

    /**
     * Muat data dari SurrealDB dan update StateFlow lokal.
     * Hanya mengganti data jika SurrealDB mengembalikan data yang tidak kosong.
     */
    private suspend fun syncFromDatabase() {
        try {
            // Sync users
            val dbUsers = SurrealDbDataSource.getAllUsers()
            if (dbUsers.isNotEmpty()) {
                _users.value = dbUsers
                Log.d(TAG, "📥 Loaded ${dbUsers.size} users from SurrealDB")
            } else {
                // Seed default user ke DB
                SurrealDbDataSource.upsertUser(defaultUser)
                Log.d(TAG, "📤 Seeded default user to SurrealDB")
            }

            // Sync tasks
            val dbTasks = SurrealDbDataSource.getAllTasks()
            if (dbTasks.isNotEmpty()) {
                _tasks.value = dbTasks
                Log.d(TAG, "📥 Loaded ${dbTasks.size} tasks from SurrealDB")
            } else {
                // Seed initial tasks ke DB
                TaskData.initialTasks.forEach { SurrealDbDataSource.upsertTask(it) }
                Log.d(TAG, "📤 Seeded ${TaskData.initialTasks.size} tasks to SurrealDB")
            }

            // Sync courses
            val dbCourses = SurrealDbDataSource.getAllCourses()
            if (dbCourses.isNotEmpty()) {
                _courses.value = dbCourses
                Log.d(TAG, "📥 Loaded ${dbCourses.size} courses from SurrealDB")
            } else {
                // Seed initial courses ke DB
                CourseData.initialCourses.forEach { SurrealDbDataSource.upsertCourse(it) }
                Log.d(TAG, "📤 Seeded ${CourseData.initialCourses.size} courses to SurrealDB")
            }

            // Sync notifications
            val dbNotifications = SurrealDbDataSource.getAllNotifications()
            if (dbNotifications.isNotEmpty()) {
                _notifications.value = dbNotifications
                Log.d(TAG, "📥 Loaded ${dbNotifications.size} notifications from SurrealDB")
            } else {
                // Seed initial notifications ke DB
                NotificationData.initialNotifications.forEach {
                    SurrealDbDataSource.upsertNotification(it)
                }
                Log.d(TAG, "📤 Seeded ${NotificationData.initialNotifications.size} notifications to SurrealDB")
            }

        } catch (e: Exception) {
            Log.e(TAG, "❌ Error syncing from database: ${e.message}")
        }
    }

    // =========================================================
    // AUTHENTICATION & SESSION METHODS
    // =========================================================

    /**
     * Cek apakah ada sesi tersimpan di SharedPreferences.
     * Jika user tidak ditemukan in-memory (karena SurrealDB belum selesai sync),
     * coba cari langsung dari SurrealDB berdasarkan email yang tersimpan.
     *
     * Fungsi ini bersifat suspend agar dapat dipanggil dari LaunchedEffect.
     */
    suspend fun checkSavedSession(context: android.content.Context): Boolean {
        val savedUserId = com.kelompok8.studytrack.data.security.SessionManager.getSavedUserId(context)
            ?: return false
        val savedEmail = com.kelompok8.studytrack.data.security.SessionManager.getSavedUserEmail(context)

        // 1. Coba cari in-memory terlebih dahulu (fast path)
        var user = _users.value.find { it.id == savedUserId }

        // 2. Jika tidak ditemukan in-memory, coba muat dari SurrealDB (slow path)
        if (user == null && savedEmail != null) {
            try {
                val dbUsers = SurrealDbDataSource.getAllUsers()
                if (dbUsers.isNotEmpty()) {
                    // Update state in-memory dengan data dari DB
                    _users.value = dbUsers
                    user = dbUsers.find { it.id == savedUserId }
                }
            } catch (e: Exception) {
                Log.w(TAG, "⚠️ checkSavedSession: gagal query SurrealDB, menggunakan local data. ${e.message}")
            }
        }

        if (user == null) return false

        _currentUser.value = user
        UserData.currentUser = user
        Log.i(TAG, "✅ Auto-login berhasil: ${user.email}")
        return true
    }

    fun login(context: android.content.Context?, email: String, password: String): Boolean {
        val existingUser = _users.value.find { it.email.equals(email, ignoreCase = true) }
        if (existingUser != null && PasswordHasher.verifyPassword(password, existingUser.passwordHash)) {
            _currentUser.value = existingUser
            UserData.currentUser = existingUser
            context?.let {
                com.kelompok8.studytrack.data.security.SessionManager.saveSession(it, existingUser.id, existingUser.email)
            }
            return true
        }
        return false
    }

    fun register(context: android.content.Context?, name: String, email: String, password: String): Boolean {
        if (_users.value.any { it.email.equals(email, ignoreCase = true) }) {
            return false // User already exists
        }
        val newUser = UserProfile(
            id = "usr_${System.currentTimeMillis()}",
            name = name,
            email = email,
            passwordHash = PasswordHasher.hashPassword(password)
        )
        _users.update { it + newUser }
        _currentUser.value = newUser
        UserData.currentUser = newUser
        context?.let {
            com.kelompok8.studytrack.data.security.SessionManager.saveSession(it, newUser.id, newUser.email)
        }

        // Sync ke SurrealDB secara async
        scope.launch {
            SurrealDbDataSource.upsertUser(newUser)
        }

        return true
    }

    fun logout(context: android.content.Context? = null) {
        _currentUser.value = null
        context?.let {
            com.kelompok8.studytrack.data.security.SessionManager.clearSession(it)
        }
    }

    // =========================================================
    // PROFILE UPDATES
    // =========================================================

    fun updateProfile(name: String, email: String, major: String, year: String, avatarUri: String? = null) {
        val current = _currentUser.value ?: return
        val updated = current.copy(
            name = name,
            email = email,
            major = major,
            year = year,
            avatarUri = avatarUri ?: current.avatarUri
        )
        _currentUser.value = updated
        UserData.currentUser = updated
        _users.update { list ->
            list.map { if (it.id == updated.id) updated else it }
        }

        // Sync ke SurrealDB
        scope.launch {
            SurrealDbDataSource.upsertUser(updated)
        }
    }

    fun updateTargetStudyHours(targetHours: Int) {
        val current = _currentUser.value ?: return
        val updated = current.copy(targetWeeklyStudyHours = targetHours)
        _currentUser.value = updated
        UserData.currentUser = updated
        _users.update { list ->
            list.map { if (it.id == updated.id) updated else it }
        }

        scope.launch {
            SurrealDbDataSource.upsertUser(updated)
        }
    }

    fun updateAvatar(avatarUri: String) {
        val current = _currentUser.value ?: return
        val updated = current.copy(avatarUri = avatarUri)
        _currentUser.value = updated
        UserData.currentUser = updated
        _users.update { list ->
            list.map { if (it.id == updated.id) updated else it }
        }

        // Sync ke SurrealDB
        scope.launch {
            SurrealDbDataSource.upsertUser(updated)
        }
    }

    // =========================================================
    // TASK OPERATIONS
    // =========================================================

    fun toggleTaskStatus(taskId: String) {
        _tasks.update { list ->
            list.map { task ->
                if (task.id == taskId) TaskRegulation.toggleTaskStatus(task) else task
            }
        }

        // Sync ke SurrealDB
        val updatedTask = _tasks.value.find { it.id == taskId } ?: return
        scope.launch {
            SurrealDbDataSource.upsertTask(updatedTask)
        }
    }

    fun toggleChecklistItem(taskId: String, itemId: String) {
        _tasks.update { list ->
            list.map { task ->
                if (task.id == taskId) TaskRegulation.toggleChecklistItem(task, itemId) else task
            }
        }

        // Sync ke SurrealDB
        val updatedTask = _tasks.value.find { it.id == taskId } ?: return
        scope.launch {
            SurrealDbDataSource.upsertTask(updatedTask)
        }
    }

    fun submitAssignment(
        taskId: String,
        note: String,
        attachmentUri: String? = null,
        attachmentName: String? = null
    ) {
        val submission = com.kelompok8.studytrack.data.models.TaskSubmission(
            id = "sub_${System.currentTimeMillis()}",
            taskId = taskId,
            submittedAt = "Hari ini",
            note = note,
            attachmentUri = attachmentUri,
            attachmentName = attachmentName,
            isSubmitted = true
        )

        _tasks.update { list ->
            list.map { task ->
                if (task.id == taskId) {
                    task.copy(
                        status = com.kelompok8.studytrack.data.models.TaskStatus.COMPLETED,
                        submissionNote = if (note.isNotBlank()) note else task.submissionNote,
                        submission = submission
                    )
                } else task
            }
        }

        val updatedTask = _tasks.value.find { it.id == taskId } ?: return
        scope.launch {
            SurrealDbDataSource.upsertTask(updatedTask)
        }
    }

    fun addAttachmentToTask(
        taskId: String,
        fileName: String,
        fileType: String,
        fileSize: String,
        fileUri: String? = null
    ) {
        _tasks.update { list ->
            list.map { task ->
                if (task.id == taskId) {
                    val newAttachment = com.kelompok8.studytrack.data.models.TaskAttachment(
                        id = "att_${System.currentTimeMillis()}",
                        fileName = fileName,
                        fileSize = fileSize,
                        uploadDate = "Hari ini",
                        fileType = fileType,
                        fileUri = fileUri
                    )
                    task.copy(attachments = task.attachments + newAttachment)
                } else task
            }
        }

        // Sync ke SurrealDB
        val updatedTask = _tasks.value.find { it.id == taskId } ?: return
        scope.launch {
            SurrealDbDataSource.upsertTask(updatedTask)
        }
    }

    fun deleteTask(taskId: String) {
        _tasks.update { list ->
            TaskRegulation.deleteTask(list, taskId)
        }

        // Sync ke SurrealDB
        scope.launch {
            SurrealDbDataSource.deleteTask(taskId)
        }
    }

    // =========================================================
    // NOTIFICATION OPERATIONS
    // =========================================================

    fun markNotificationAsRead(notificationId: String) {
        _notifications.update { list ->
            NotificationRegulation.markAsRead(list, notificationId)
        }

        // Sync ke SurrealDB
        scope.launch {
            SurrealDbDataSource.updateNotificationReadStatus(notificationId, true)
        }
    }

    fun markAllNotificationsAsRead() {
        _notifications.update { list ->
            NotificationRegulation.markAllAsRead(list)
        }

        // Sync ke SurrealDB (update semua yang belum terbaca)
        scope.launch {
            _notifications.value
                .filter { it.isRead }
                .forEach { notification ->
                    SurrealDbDataSource.updateNotificationReadStatus(notification.id, true)
                }
        }
    }
}
