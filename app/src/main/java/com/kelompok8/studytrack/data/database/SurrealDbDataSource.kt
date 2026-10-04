package com.kelompok8.studytrack.data.database

import android.util.Log
import com.kelompok8.studytrack.data.models.AppNotification
import com.kelompok8.studytrack.data.models.Course
import com.kelompok8.studytrack.data.models.Task
import com.kelompok8.studytrack.data.models.UserProfile
import com.surrealdb.Surreal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Data Source layer untuk komunikasi remote dengan SurrealDB Cloud.
 *
 * Menggunakan arsitektur Offline-First:
 * - Jika SurrealDB offline atau terjadi error jaringan, fungsi mengembalikan null / emptyList.
 * - AppRepository menangani fallback ke state lokal (in-memory) secara transparan.
 *
 * PENTING: Semua operasi "upsert" menggunakan SurrealQL query langsung:
 *   UPSERT <table>:<id> CONTENT { ... }
 * Ini memastikan INSERT jika baru, UPDATE jika sudah ada — tidak pernah error duplikat.
 */
object SurrealDbDataSource {

    private const val TAG = "SurrealDbDataSource"

    private val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    }

    private fun getActiveClient(): Surreal? {
        val client = SurrealDbClient.client
        if (client == null || !SurrealDbClient.isConnected) {
            Log.w(TAG, "SurrealDB client not active - operating in local mode.")
            return null
        }
        return client
    }

    // =========================================================
    // USER OPERATIONS
    // =========================================================

    suspend fun upsertUser(user: UserProfile): Boolean = withContext(Dispatchers.IO) {
        val client = getActiveClient() ?: return@withContext false
        try {
            // Gunakan UPSERT agar tidak error jika record sudah ada
            val contentJson = json.encodeToString(user)
            client.query(
                "UPSERT ${SurrealDbConfig.TABLE_USERS}:`${user.id}` CONTENT $contentJson",
                emptyMap<String, Any>()
            )
            Log.d(TAG, "✅ User upserted to SurrealDB: ${user.id}")
            true
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to upsert user ${user.id}: ${e.message}")
            false
        }
    }

    suspend fun findUserByEmail(email: String): UserProfile? = withContext(Dispatchers.IO) {
        val client = getActiveClient() ?: return@withContext null
        try {
            val iterator = client.select(UserProfile::class.java, SurrealDbConfig.TABLE_USERS)
            iterator.asSequence().find { user -> user.email.equals(email, ignoreCase = true) }
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to find user by email '$email': ${e.message}")
            null
        }
    }

    suspend fun getAllUsers(): List<UserProfile> = withContext(Dispatchers.IO) {
        val client = getActiveClient() ?: return@withContext emptyList()
        try {
            val iterator = client.select(UserProfile::class.java, SurrealDbConfig.TABLE_USERS)
            iterator.asSequence().toList()
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to get all users: ${e.message}")
            emptyList()
        }
    }

    // =========================================================
    // TASK OPERATIONS
    // =========================================================

    suspend fun getAllTasks(): List<Task> = withContext(Dispatchers.IO) {
        val client = getActiveClient() ?: return@withContext emptyList()
        try {
            val iterator = client.select(Task::class.java, SurrealDbConfig.TABLE_TASKS)
            iterator.asSequence().toList()
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to get tasks: ${e.message}")
            emptyList()
        }
    }

    suspend fun upsertTask(task: Task): Boolean = withContext(Dispatchers.IO) {
        val client = getActiveClient() ?: return@withContext false
        try {
            val contentJson = json.encodeToString(task)
            client.query(
                "UPSERT ${SurrealDbConfig.TABLE_TASKS}:`${task.id}` CONTENT $contentJson",
                emptyMap<String, Any>()
            )
            Log.d(TAG, "✅ Task upserted to SurrealDB: ${task.id}")
            true
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to upsert task ${task.id}: ${e.message}")
            false
        }
    }

    suspend fun deleteTask(taskId: String): Boolean = withContext(Dispatchers.IO) {
        val client = getActiveClient() ?: return@withContext false
        try {
            client.query(
                "DELETE ${SurrealDbConfig.TABLE_TASKS}:`$taskId`",
                emptyMap<String, Any>()
            )
            Log.d(TAG, "✅ Task deleted from SurrealDB: $taskId")
            true
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to delete task $taskId: ${e.message}")
            false
        }
    }

    // =========================================================
    // COURSE OPERATIONS
    // =========================================================

    suspend fun getAllCourses(): List<Course> = withContext(Dispatchers.IO) {
        val client = getActiveClient() ?: return@withContext emptyList()
        try {
            val iterator = client.select(Course::class.java, SurrealDbConfig.TABLE_COURSES)
            iterator.asSequence().toList()
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to get courses: ${e.message}")
            emptyList()
        }
    }

    suspend fun upsertCourse(course: Course): Boolean = withContext(Dispatchers.IO) {
        val client = getActiveClient() ?: return@withContext false
        try {
            val contentJson = json.encodeToString(course)
            client.query(
                "UPSERT ${SurrealDbConfig.TABLE_COURSES}:`${course.id}` CONTENT $contentJson",
                emptyMap<String, Any>()
            )
            Log.d(TAG, "✅ Course upserted to SurrealDB: ${course.id}")
            true
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to upsert course ${course.id}: ${e.message}")
            false
        }
    }

    // =========================================================
    // NOTIFICATION OPERATIONS
    // =========================================================

    suspend fun getAllNotifications(): List<AppNotification> = withContext(Dispatchers.IO) {
        val client = getActiveClient() ?: return@withContext emptyList()
        try {
            val iterator = client.select(AppNotification::class.java, SurrealDbConfig.TABLE_NOTIFICATIONS)
            iterator.asSequence().toList()
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to get notifications: ${e.message}")
            emptyList()
        }
    }

    suspend fun updateNotificationReadStatus(notificationId: String, isRead: Boolean): Boolean = withContext(Dispatchers.IO) {
        val client = getActiveClient() ?: return@withContext false
        try {
            client.query(
                "UPDATE ${SurrealDbConfig.TABLE_NOTIFICATIONS}:`$notificationId` SET is_read = $isRead",
                emptyMap<String, Any>()
            )
            Log.d(TAG, "✅ Notification read status updated: $notificationId")
            true
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to update notification read status $notificationId: ${e.message}")
            false
        }
    }

    suspend fun upsertNotification(notification: AppNotification): Boolean = withContext(Dispatchers.IO) {
        val client = getActiveClient() ?: return@withContext false
        try {
            val contentJson = json.encodeToString(notification)
            client.query(
                "UPSERT ${SurrealDbConfig.TABLE_NOTIFICATIONS}:`${notification.id}` CONTENT $contentJson",
                emptyMap<String, Any>()
            )
            Log.d(TAG, "✅ Notification upserted to SurrealDB: ${notification.id}")
            true
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to upsert notification ${notification.id}: ${e.message}")
            false
        }
    }

    // =========================================================
    // SCHEMA INITIALIZATION
    // =========================================================

    suspend fun initializeSchema(): Boolean = withContext(Dispatchers.IO) {
        val client = getActiveClient() ?: return@withContext false
        try {
            client.query(
                """
                DEFINE TABLE IF NOT EXISTS users SCHEMALESS;
                DEFINE INDEX IF NOT EXISTS idx_users_email ON users FIELDS email UNIQUE;

                DEFINE TABLE IF NOT EXISTS tasks SCHEMALESS;
                DEFINE TABLE IF NOT EXISTS courses SCHEMALESS;
                DEFINE TABLE IF NOT EXISTS notifications SCHEMALESS;
                """.trimIndent(),
                emptyMap<String, Any>()
            )
            Log.i(TAG, "✅ SurrealDB schema initialized")
            true
        } catch (e: Exception) {
            Log.e(TAG, "❌ Schema initialization skipped or failed: ${e.message}")
            false
        }
    }
}
