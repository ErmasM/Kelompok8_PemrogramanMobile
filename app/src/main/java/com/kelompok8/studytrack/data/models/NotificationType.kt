package com.kelompok8.studytrack.data.models

import kotlinx.serialization.Serializable

@Serializable
enum class NotificationType {
    URGENT,
    WARNING,
    COMPLETED,
    REMINDER,
    ONBOARDING
}
