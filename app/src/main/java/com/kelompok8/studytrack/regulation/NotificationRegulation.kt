package com.kelompok8.studytrack.regulation

import com.kelompok8.studytrack.data.models.AppNotification
import com.kelompok8.studytrack.data.models.NotificationType

object NotificationRegulation {

    fun countUrgentNotifications(notifications: List<AppNotification>): Int {
        return notifications.count { it.type == NotificationType.URGENT || it.type == NotificationType.WARNING }
    }

    fun countUnreadNotifications(notifications: List<AppNotification>): Int {
        return notifications.count { !it.isRead }
    }

    fun getActiveNotifications(notifications: List<AppNotification>): List<AppNotification> {
        return notifications.filter { it.type != NotificationType.COMPLETED }
    }

    fun filterNotifications(notifications: List<AppNotification>, filter: String): List<AppNotification> {
        return when (filter) {
            "Belum Dibaca" -> notifications.filter { !it.isRead }
            "Urgent" -> notifications.filter { it.type == NotificationType.URGENT || it.type == NotificationType.WARNING }
            else -> notifications
        }
    }

    fun markAsRead(notifications: List<AppNotification>, notificationId: String): List<AppNotification> {
        return notifications.map {
            if (it.id == notificationId) it.copy(isRead = true) else it
        }
    }

    fun markAllAsRead(notifications: List<AppNotification>): List<AppNotification> {
        return notifications.map { it.copy(isRead = true) }
    }
}
