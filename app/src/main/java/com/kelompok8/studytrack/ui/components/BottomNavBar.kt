package com.kelompok8.studytrack.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Checklist
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.kelompok8.studytrack.ui.theme.StudyBlue

@Composable
fun BottomNavBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {

    NavigationBar {

        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = {
                onNavigate("home")
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Beranda"
                )
            },
            label = {
                Text("Beranda")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = StudyBlue,
                selectedTextColor = StudyBlue,
                indicatorColor = StudyBlue.copy(alpha = 0.15f),
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray
            )
        )

        NavigationBarItem(
            selected = currentRoute == "tasks",
            onClick = {
                onNavigate("tasks")
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Checklist,
                    contentDescription = "Tugas"
                )
            },
            label = {
                Text("Tugas")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = StudyBlue,
                selectedTextColor = StudyBlue,
                indicatorColor = StudyBlue.copy(alpha = 0.15f),
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray
            )
        )

        NavigationBarItem(
            selected = currentRoute == "calendar",
            onClick = {
                onNavigate("calendar")
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.CalendarMonth,
                    contentDescription = "Kalender"
                )
            },
            label = {
                Text("Kalender")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = StudyBlue,
                selectedTextColor = StudyBlue,
                indicatorColor = StudyBlue.copy(alpha = 0.15f),
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray
            )
        )

        NavigationBarItem(
            selected = currentRoute == "analytics",
            onClick = {
                onNavigate("analytics")
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.BarChart,
                    contentDescription = "Analisis"
                )
            },
            label = {
                Text("Analisis")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = StudyBlue,
                selectedTextColor = StudyBlue,
                indicatorColor = StudyBlue.copy(alpha = 0.15f),
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray
            )
        )

        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick = {
                onNavigate("profile")
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Profil"
                )
            },
            label = {
                Text("Profil")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = StudyBlue,
                selectedTextColor = StudyBlue,
                indicatorColor = StudyBlue.copy(alpha = 0.15f),
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray
            )
        )
    }
}