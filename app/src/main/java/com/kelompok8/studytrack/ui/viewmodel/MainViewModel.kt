package com.kelompok8.studytrack.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelompok8.studytrack.data.database.SurrealDbClient
import com.kelompok8.studytrack.data.models.AppNotification
import com.kelompok8.studytrack.data.models.Course
import com.kelompok8.studytrack.data.models.Task
import com.kelompok8.studytrack.data.models.UserProfile
import com.kelompok8.studytrack.data.repository.AppRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    val currentUser: StateFlow<UserProfile?> = AppRepository.currentUser
    val tasks: StateFlow<List<Task>> = AppRepository.tasks
    val courses: StateFlow<List<Course>> = AppRepository.courses
    val notifications: StateFlow<List<AppNotification>> = AppRepository.notifications
    val isDbConnected: StateFlow<Boolean> = AppRepository.isDbConnected

    init {
        // Inisialisasi koneksi SurrealDB di background saat ViewModel pertama dibuat
        AppRepository.initializeSurrealDb()
    }

    fun login(context: android.content.Context?, email: String, password: String): Boolean {
        return AppRepository.login(context, email, password)
    }

    fun register(context: android.content.Context?, name: String, email: String, password: String): Boolean {
        return AppRepository.register(context, name, email, password)
    }

    fun logout(context: android.content.Context? = null) {
        AppRepository.logout(context)
    }

    fun updateProfile(name: String, email: String, major: String, year: String, avatarUri: String? = null) {
        AppRepository.updateProfile(name, email, major, year, avatarUri)
    }

    fun updateTargetStudyHours(targetHours: Int) {
        AppRepository.updateTargetStudyHours(targetHours)
    }

    fun updateAvatar(avatarUri: String) {
        AppRepository.updateAvatar(avatarUri)
    }

    fun submitAssignment(taskId: String, note: String, attachmentUri: String? = null, attachmentName: String? = null) {
        AppRepository.submitAssignment(taskId, note, attachmentUri, attachmentName)
    }

    fun toggleTaskStatus(taskId: String) {
        AppRepository.toggleTaskStatus(taskId)
    }

    fun toggleChecklistItem(taskId: String, itemId: String) {
        AppRepository.toggleChecklistItem(taskId, itemId)
    }

    fun addAttachmentToTask(
        taskId: String,
        fileName: String,
        fileType: String,
        fileSize: String,
        fileUri: String? = null
    ) {
        AppRepository.addAttachmentToTask(taskId, fileName, fileType, fileSize, fileUri)
    }

    fun deleteTask(taskId: String) {
        AppRepository.deleteTask(taskId)
    }

    fun markNotificationAsRead(notificationId: String) {
        AppRepository.markNotificationAsRead(notificationId)
    }

    fun markAllNotificationsAsRead() {
        AppRepository.markAllNotificationsAsRead()
    }

    override fun onCleared() {
        super.onCleared()
        // Tutup koneksi SurrealDB saat ViewModel di-destroy
        viewModelScope.launch {
            SurrealDbClient.close()
        }
    }
}
