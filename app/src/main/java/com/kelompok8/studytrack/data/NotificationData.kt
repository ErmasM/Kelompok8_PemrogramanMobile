package com.kelompok8.studytrack.data

import com.kelompok8.studytrack.data.models.AppNotification
import com.kelompok8.studytrack.data.models.NotificationType

object NotificationData {
    val initialNotifications = listOf(
        AppNotification(
            id = "notif_1",
            title = "Tugas Kriptografi",
            timeAgo = "15 menit lalu",
            description = "Dikumpulkan besok • 23.59. Jangan lupa kumpulkan sebelum portal ditutup.",
            tags = listOf("Segera Dikumpulkan", "INF 438"),
            type = NotificationType.URGENT,
            isRead = false
        ),
        AppNotification(
            id = "notif_2",
            title = "Praktikum Sistem Operasi 3",
            timeAgo = "2 jam lalu",
            description = "Dikumpulkan dalam 2 hari • 17.00. Benchmark kernel diperlukan.",
            tags = listOf("INF 350", "Benchmarking"),
            type = NotificationType.WARNING,
            isRead = false
        ),
        AppNotification(
            id = "notif_3",
            title = "Normalisasi Database",
            timeAgo = "4 jam lalu",
            description = "Ditandai selesai hari ini • 11.00. Kerja bagus!",
            tags = listOf("✓ Selesai", "INF 340"),
            type = NotificationType.COMPLETED,
            isRead = true
        ),
        AppNotification(
            id = "notif_4",
            title = "Kuis UI/UX Design",
            timeAgo = "Kemarin",
            description = "Dikumpulkan dalam 1 minggu • 16.00. Pelajari Bab 3–5.",
            tags = listOf("DES 201", "Persiapan Kuis"),
            type = NotificationType.REMINDER,
            isRead = false
        ),
        AppNotification(
            id = "notif_5",
            title = "Selamat Datang di StudyTrack!",
            timeAgo = "3 hari lalu",
            description = "Selamat menikmati perjalanan belajarmu. Atur mata kuliah semester untuk mendapatkan pengalaman yang lebih personal...",
            tags = listOf("Pengaturan Awal"),
            type = NotificationType.ONBOARDING,
            isRead = true
        )
    )
}
