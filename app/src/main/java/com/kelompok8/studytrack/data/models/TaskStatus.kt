package com.kelompok8.studytrack.data.models

enum class TaskStatus(val label: String) {
    NOT_STARTED("Belum Dimulai"),
    IN_PROGRESS("Sedang Dikerjakan"),
    COMPLETED("Selesai");

    companion object {
        fun fromLabel(label: String): TaskStatus {
            return values().find { it.label.equals(label, ignoreCase = true) } ?: NOT_STARTED
        }
    }
}
