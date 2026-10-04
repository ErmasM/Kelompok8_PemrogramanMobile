package com.kelompok8.studytrack.data.models

import kotlinx.serialization.Serializable

@Serializable
data class TaskChecklistItem(
    val id: String,
    val text: String,
    val isChecked: Boolean = false
) {
    val isDone: Boolean get() = isChecked
}

