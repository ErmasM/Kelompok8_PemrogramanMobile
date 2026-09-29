package com.kelompok8.studytrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kelompok8.studytrack.navigation.AppNavigation
import com.kelompok8.studytrack.ui.theme.StudytrackTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudytrackTheme {
                AppNavigation()
            }
        }
    }
}