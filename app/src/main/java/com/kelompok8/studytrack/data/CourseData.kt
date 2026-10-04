package com.kelompok8.studytrack.data

import com.kelompok8.studytrack.data.models.Course

object CourseData {
    val initialCourses = listOf(
        Course(
            id = "c_1",
            code = "INF-438",
            name = "Kriptografi",
            room = "Ruang 304B",
            lecturer = LecturerData.sarahJenkins,
            totalTasks = 4,
            completedTasks = 3,
            nextTaskTitle = "Tugas Kriptografi",
            deadlineText = "Besok",
            isActive = true
        ),
        Course(
            id = "c_2",
            code = "INF-350",
            name = "Sistem Operasi",
            room = "Gedung Kuliah A",
            lecturer = LecturerData.robertDavis,
            totalTasks = 4,
            completedTasks = 2,
            nextTaskTitle = "Lab 3: Kernel Locks",
            deadlineText = "2 hari lagi",
            isActive = true
        ),
        Course(
            id = "c_3",
            code = "INF-340",
            name = "Basis Data",
            room = "Lab 12",
            lecturer = LecturerData.michaelChang,
            totalTasks = 3,
            completedTasks = 1,
            nextTaskTitle = "Normalisasi Database",
            deadlineText = "4 hari lagi",
            isActive = true
        ),
        Course(
            id = "c_4",
            code = "INF-320",
            name = "Pemrograman Web",
            room = "Online / Sinkron",
            lecturer = LecturerData.mayaLin,
            totalTasks = 4,
            completedTasks = 0,
            nextTaskTitle = "Membuat Website E-Commerce",
            deadlineText = "6 hari lagi",
            isActive = true
        ),
        Course(
            id = "c_5",
            code = "IMK-201",
            name = "UI/UX Design",
            room = "Studio Desain 4",
            lecturer = LecturerData.elenaRostova,
            totalTasks = 3,
            completedTasks = 0,
            nextTaskTitle = "Evaluasi Heuristik",
            deadlineText = "12 September",
            isActive = false
        ),
        Course(
            id = "c_6",
            code = "INF-401",
            name = "Pemrograman Mobile",
            room = "Lab 10",
            lecturer = LecturerData.wardhana,
            totalTasks = 5,
            completedTasks = 3,
            nextTaskTitle = "Membuat UI StudyTrack",
            deadlineText = "Besok • 23.59",
            isActive = true
        ),
        Course(
            id = "c_7",
            code = "INF-210",
            name = "Algoritma",
            room = "Ruang 201",
            lecturer = LecturerData.sarahJenkins,
            totalTasks = 3,
            completedTasks = 3,
            nextTaskTitle = "Algorithm Complexity Problem Set",
            deadlineText = "Selesai",
            isActive = true
        )
    )
}
