package com.kelompok8.studytrack.data.models

data class AppNotification(
    val id: String,
    val title: String,
    val timeAgo: String,
    val description: String,
    val tags: List<String>,
    val type: NotificationType,
    val isRead: Boolean = false
)
