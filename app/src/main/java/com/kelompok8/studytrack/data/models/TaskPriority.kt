package com.kelompok8.studytrack.data.models

import kotlinx.serialization.Serializable

@Serializable
enum class TaskPriority(val label: String) {
    HIGH("Tinggi"),
    MEDIUM("Sedang"),
    LOW("Rendah");

    companion object {
        fun fromLabel(label: String): TaskPriority {
            return values().find { it.label.equals(label, ignoreCase = true) } ?: MEDIUM
        }
    }
}
