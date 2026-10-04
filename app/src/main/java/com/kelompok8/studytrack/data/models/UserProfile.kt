package com.kelompok8.studytrack.data.models

data class UserProfile(
    val id: String = "1",
    val name: String = "Ermas",
    val email: String = "ermas@student.unsoed.ac.id",
    val major: String = "Informatika",
    val year: String = "2024",
    val semester: String = "Semester 5",
    val academicYear: String = "2026/2027",
    val cumulativeGpa: Double = 3.82,
    val estimatedGpa: Double = 3.88,
    val targetWeeklyStudyHours: Int = 24,
    val isStudentActive: Boolean = true
)
