package com.kelompok8.studytrack

import java.util.UUID

enum class Priority {
    HIGH, MEDIUM, LOW
}

enum class TaskStatus {
    NOT_STARTED, IN_PROGRESS, COMPLETED
}

data class TaskItem(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val course: String,
    val description: String = "",
    val dueDate: String = "",
    val dueTime: String = "",
    val priority: Priority = Priority.MEDIUM,
    val status: TaskStatus = TaskStatus.NOT_STARTED,
    val attachmentName: String? = null,
    val lecturerName: String? = null
)
