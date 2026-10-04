package com.kelompok8.studytrack.data

import com.kelompok8.studytrack.data.models.Task
import com.kelompok8.studytrack.data.models.TaskAttachment
import com.kelompok8.studytrack.data.models.TaskChecklistItem
import com.kelompok8.studytrack.data.models.TaskPriority
import com.kelompok8.studytrack.data.models.TaskStatus

object TaskData {
    val initialTasks = listOf(
        Task(
            id = "t_1",
            subject = "Kriptografi",
            title = "Tugas Kriptografi",
            deadline = "Besok • 23.59",
            dueDateText = "17 Sep 2026",
            dueTimeText = "23.59",
            dayOfMonth = 17,
            priority = TaskPriority.HIGH,
            status = TaskStatus.IN_PROGRESS,
            courseCode = "INF-438",
            exerciseSubtitle = "Lab Exercise: Symmetric & Asymmetric Implementations",
            description = "Mengerjakan soal latihan dan membuat laporan sesuai dengan format yang diberikan. Pastikan mengimplementasikan algoritma AES dan RSA dengan benchmark waktu eksekusi.",
            weightPercentage = 15,
            hoursRemainingText = "23 hours left",
            checklist = listOf(
                TaskChecklistItem("c_1", "Implement AES-128 Encryption & Decryption", true),
                TaskChecklistItem("c_2", "Implement RSA Key Generation (2048-bit)", true),
                TaskChecklistItem("c_3", "Generate benchmark time graphs & final PDF report", false)
            ),
            attachments = listOf(
                TaskAttachment("a_1", "tugas-kriptografi.pdf", "2.4 MB", "Uploaded Sep 14", "PDF")
            ),
            submissionNote = "Laporan dikumpulkan dalam format PDF disertai source code (C++ / Python / Go) dalam file archive .ZIP."
        ),
        Task(
            id = "t_2",
            subject = "Pemrograman Mobile",
            title = "Membuat UI StudyTrack",
            deadline = "Besok • 23.59",
            dueDateText = "17 Sep 2026",
            dueTimeText = "23.59",
            dayOfMonth = 17,
            priority = TaskPriority.HIGH,
            status = TaskStatus.IN_PROGRESS,
            courseCode = "INF-401",
            exerciseSubtitle = "Implementasi Jetpack Compose & Clean Architecture",
            description = "Membuat desain antarmuka aplikasi StudyTrack dengan arsitektur data model yang modular dan tanpa overengineering.",
            weightPercentage = 20,
            hoursRemainingText = "24 hours left",
            checklist = listOf(
                TaskChecklistItem("c_4", "Buat Wireframe & Layout Dasar", true),
                TaskChecklistItem("c_5", "Refactor Data Layer & Models", true),
                TaskChecklistItem("c_6", "Pengujian & Buat Dokumentasi Laporan", false)
            ),
            attachments = listOf(
                TaskAttachment("a_2", "spec-studytrack.pdf", "1.8 MB", "Uploaded Sep 15", "PDF")
            ),
            submissionNote = "Kumpulkan link repository GitHub dan file APK debug."
        ),
        Task(
            id = "t_3",
            subject = "Sistem Operasi",
            title = "Lab 3: Kernel Locks",
            deadline = "2 hari lagi • 17.00",
            dueDateText = "18 Sep 2026",
            dueTimeText = "17.00",
            dayOfMonth = 18,
            priority = TaskPriority.HIGH,
            status = TaskStatus.IN_PROGRESS,
            courseCode = "INF-350",
            exerciseSubtitle = "Synchronization primitives & spinlock implementation",
            description = "Praktikum implementasi mutex, semaphore, dan spinlock pada simulasi kernel sederhana.",
            weightPercentage = 10,
            hoursRemainingText = "42 hours left",
            checklist = listOf(
                TaskChecklistItem("c_7", "Implementasi Spinlock pada C Code", true),
                TaskChecklistItem("c_8", "Uji Deadlock Scenario & Benchmarking", false)
            ),
            attachments = listOf(
                TaskAttachment("a_3", "kernel-lab3-guide.pdf", "3.1 MB", "Uploaded Sep 12", "PDF")
            ),
            submissionNote = "Sertakan screenshot eksekusi log kernel."
        ),
        Task(
            id = "t_4",
            subject = "Basis Data",
            title = "Normalisasi Database",
            deadline = "4 hari lagi • 23.59",
            dueDateText = "20 Sep 2026",
            dueTimeText = "23.59",
            dayOfMonth = 16,
            priority = TaskPriority.MEDIUM,
            status = TaskStatus.NOT_STARTED,
            courseCode = "INF-340",
            exerciseSubtitle = "Perancangan Skema 1NF hingga 3NF & BCNF",
            description = "Latihan melakukan normalisasi tabel unnormalized data menjadi struktur relational 3NF.",
            weightPercentage = 10,
            hoursRemainingText = "96 hours left",
            checklist = listOf(
                TaskChecklistItem("c_9", "Identifikasi Functional Dependency", false),
                TaskChecklistItem("c_10", "Gambarkan ERD & Relasi Tabel", false)
            ),
            attachments = listOf(
                TaskAttachment("a_4", "studi-kasus-normalisasi.pdf", "1.2 MB", "Uploaded Sep 13", "PDF")
            ),
            submissionNote = "Format PDF beserta file SQL Script DDL."
        ),
        Task(
            id = "t_5",
            subject = "Pemrograman Web",
            title = "Membuat Website E-Commerce",
            deadline = "6 hari lagi • 23.59",
            dueDateText = "22 Sep 2026",
            dueTimeText = "23.59",
            dayOfMonth = 22,
            priority = TaskPriority.LOW,
            status = TaskStatus.IN_PROGRESS,
            courseCode = "INF-320",
            exerciseSubtitle = "Frontend & Backend Integration dengan REST API",
            description = "Membangun antarmuka e-commerce responsive beserta fitur shopping cart dan checkout flow.",
            weightPercentage = 15,
            hoursRemainingText = "140 hours left",
            checklist = listOf(
                TaskChecklistItem("c_11", "Desain Halaman Catalog", true),
                TaskChecklistItem("c_12", "Integrasi Payment Gateway API", false)
            ),
            attachments = emptyList(),
            submissionNote = "Push kode ke Vercel / Netlify dan cantumkan URL demo."
        ),
        Task(
            id = "t_6",
            subject = "UI/UX Design",
            title = "Evaluasi Heuristik",
            deadline = "12 September • Selesai",
            dueDateText = "12 Sep 2026",
            dueTimeText = "16.00",
            dayOfMonth = 16,
            priority = TaskPriority.MEDIUM,
            status = TaskStatus.COMPLETED,
            courseCode = "IMK-201",
            exerciseSubtitle = "Nielsen 10 Usability Heuristics Audit",
            description = "Melakukan usability audit pada aplikasi perbankan digital lokal.",
            weightPercentage = 10,
            hoursRemainingText = "Completed",
            checklist = listOf(
                TaskChecklistItem("c_13", "Observasi User Flow", true),
                TaskChecklistItem("c_14", "Penyusunan Severity Rating Report", true)
            ),
            attachments = listOf(
                TaskAttachment("a_5", "heuristic-audit-v1.pdf", "4.5 MB", "Uploaded Sep 11", "PDF")
            ),
            submissionNote = "Tugas telah dinilai 92/100."
        ),
        Task(
            id = "t_7",
            subject = "Algoritma",
            title = "Algorithm Complexity Problem Set",
            deadline = "10 September • Selesai",
            dueDateText = "10 Sep 2026",
            dueTimeText = "23.59",
            dayOfMonth = 10,
            priority = TaskPriority.HIGH,
            status = TaskStatus.COMPLETED,
            courseCode = "INF-210",
            exerciseSubtitle = "Big-O Notation & Recurrence Relations",
            description = "Analisis kompleksitas waktu dan ruang untuk algoritma sorting & graph search.",
            weightPercentage = 10,
            hoursRemainingText = "Completed",
            checklist = listOf(
                TaskChecklistItem("c_15", "Solusi Master Theorem Problem 1-5", true)
            ),
            attachments = emptyList(),
            submissionNote = "Tugas telah selesai."
        )
    )
}
