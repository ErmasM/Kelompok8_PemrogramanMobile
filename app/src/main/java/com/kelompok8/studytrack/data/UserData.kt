package com.kelompok8.studytrack.data

import com.kelompok8.studytrack.data.models.UserProfile

object UserData {
    var currentUser = UserProfile(
        id = "usr_101",
        name = "Ermas",
        email = "ermas@student.unsoed.ac.id",
        major = "Informatika",
        year = "2024",
        semester = "Semester 5",
        academicYear = "2026/2027",
        cumulativeGpa = 3.82,
        estimatedGpa = 3.88,
        targetWeeklyStudyHours = 24,
        isStudentActive = true
    )
}
