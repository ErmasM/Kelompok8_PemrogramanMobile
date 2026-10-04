package com.kelompok8.studytrack.data.models

import kotlinx.serialization.Serializable

@Serializable
data class TaskSubmission(
    val id: String = "",
    val taskId: String = "",
    val submittedAt: String = "",
    val note: String = "",
    val attachmentUri: String? = null,
    val attachmentName: String? = null,
    val isSubmitted: Boolean = true
)
