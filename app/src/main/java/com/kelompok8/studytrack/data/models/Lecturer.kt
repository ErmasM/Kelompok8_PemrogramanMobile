package com.kelompok8.studytrack.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Lecturer(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val department: String = "Dept. of Computer Science",
    val officeHours: String = "Mon-Fri 9 AM - 5 PM"
)

