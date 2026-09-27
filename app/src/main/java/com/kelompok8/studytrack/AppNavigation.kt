package com.kelompok8.studytrack

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object Screen {
    const val Welcome = "welcome"
    const val Home = "home"
    const val Tasks = "tasks"
    const val TaskDetail = "task_detail"
    const val AddTask = "add_task"
    const val Calendar = "calendar"
    const val Courses = "courses"
    const val Notifications = "notifications"
    const val Profile = "profile"
    const val Statistics = "statistics"
}

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    taskViewModel: TaskViewModel = TaskViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome
    ) {
        // 1. Welcome Screen
        composable(Screen.Welcome) {
            WelcomeScreen(
                onGetStartedClick = {
                    navController.navigate(Screen.Home) {
                        popUpTo(Screen.Welcome) { inclusive = true }
                    }
                }
            )
        }

        // 2. Home Screen
        composable(Screen.Home) {
            HomeScreen(
                onTasksClick = { navController.navigate(Screen.Tasks) },
                onCalendarClick = { navController.navigate(Screen.Calendar) },
                onAnalyticsClick = { navController.navigate(Screen.Statistics) },
                onProfileClick = { navController.navigate(Screen.Profile) },
                onAddTaskClick = { navController.navigate(Screen.AddTask) },
                onNotificationClick = { navController.navigate(Screen.Notifications) }
            )
        }

        // 3. Task List Screen
        composable(Screen.Tasks) {
            Main()
        }

        // 4. Task Detail Screen
        composable(Screen.TaskDetail) {
            Frame(badgeNumber = "66%")
        }

        // 5. Add Task Screen
        composable(Screen.AddTask) {
            AddTaskScreen()
        }

        // 6. Calendar Screen
        composable(Screen.Calendar) {
            CalendarScreen(badgeNumber = "1")
        }

        // 7. Courses Screen
        composable(Screen.Courses) {
            CoursesScreen()
        }

        // 8. Notifications Screen
        composable(Screen.Notifications) {
            NotificationScreen()
        }

        // 9. Profile Screen
        composable(Screen.Profile) {
            ProfileScreen()
        }

        // 10. Statistics Screen
        composable(Screen.Statistics) {
            StatisticsScreen()
        }
    }
}
