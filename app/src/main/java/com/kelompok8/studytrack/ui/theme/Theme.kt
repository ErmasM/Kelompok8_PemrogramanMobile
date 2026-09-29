package com.kelompok8.studytrack.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = StudyBlue,
    secondary = StudyGreen,
    background = StudyBackground,
    surface = StudyWhite,

    onPrimary = StudyWhite,
    onSecondary = StudyWhite,
    onBackground = StudyTextPrimary,
    onSurface = StudyTextPrimary
)

private val DarkColorScheme = darkColorScheme(
    primary = StudyBlue,
    secondary = StudyGreen
)

@Composable
fun StudytrackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}