package com.kelompok8.studytrack.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val id: String = "",
    val subject: String,
    val title: String,
    val deadline: String,
    val dueDateText: String = "",
    val dueTimeText: String = "",
    val priority: TaskPriority,
    val status: TaskStatus,
    val courseCode: String = "",
    val exerciseSubtitle: String = "",
    val description: String = "",
    val weightPercentage: Int = 0,
    val hoursRemainingText: String = "",
    val dayOfMonth: Int = 16,
    val checklist: List<TaskChecklistItem> = emptyList(),
    val attachments: List<TaskAttachment> = emptyList(),
    val submissionNote: String = "",
    val submission: TaskSubmission? = null
) {
    val priorityLabel: String
        get() = priority.label

    val statusLabel: String
        get() = status.label
}
