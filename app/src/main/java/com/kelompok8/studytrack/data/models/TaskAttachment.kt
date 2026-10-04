package com.kelompok8.studytrack.data.models

import kotlinx.serialization.Serializable

@Serializable
data class TaskAttachment(
    val id: String,
    val fileName: String,
    val fileSize: String,
    val uploadDate: String,
    val fileType: String,
    val fileUri: String? = null
)
