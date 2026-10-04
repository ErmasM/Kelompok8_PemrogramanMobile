package com.kelompok8.studytrack.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Course(
    val id: String,
    val code: String,
    val name: String,
    val room: String,
    val lecturer: Lecturer,
    val totalTasks: Int,
    val completedTasks: Int,
    val nextTaskTitle: String,
    val deadlineText: String,
    val isActive: Boolean = true
) {
    val progressPercentage: Int
        get() = if (totalTasks > 0) (completedTasks * 100) / totalTasks else 0
}
