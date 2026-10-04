package com.kelompok8.studytrack.navigation

import android.app.Activity
import android.net.Uri

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.kelompok8.studytrack.data.NotificationData
import com.kelompok8.studytrack.data.TaskData
import com.kelompok8.studytrack.regulation.NotificationRegulation
import com.kelompok8.studytrack.regulation.TaskRegulation
import com.kelompok8.studytrack.ui.components.BottomNavBar
import com.kelompok8.studytrack.ui.screens.AnalyticsScreen
import com.kelompok8.studytrack.ui.screens.CalendarScreen
import com.kelompok8.studytrack.ui.screens.CoursesScreen
import com.kelompok8.studytrack.ui.screens.EditProfileScreen
import com.kelompok8.studytrack.ui.screens.HomeScreen
import com.kelompok8.studytrack.ui.screens.LoginScreen
import com.kelompok8.studytrack.ui.screens.NotificationScreen
import com.kelompok8.studytrack.ui.screens.ProfileScreen
import com.kelompok8.studytrack.ui.screens.RegisterScreen
import com.kelompok8.studytrack.ui.screens.TaskDetailScreen
import com.kelompok8.studytrack.ui.screens.TasksScreen
import com.kelompok8.studytrack.ui.screens.WelcomeScreen
import androidx.compose.runtime.collectAsState
import com.kelompok8.studytrack.data.repository.AppRepository
import com.kelompok8.studytrack.data.UserData


object Routes {

    const val WELCOME = "welcome"
    const val LOGIN = "login"
    const val REGISTER = "register"

    const val HOME = "home"
    const val TASKS = "tasks"
    const val CALENDAR = "calendar"
    const val ANALYTICS = "analytics"
    const val PROFILE = "profile"

    const val COURSES = "courses"

    const val EDIT_PROFILE = "edit_profile"

    const val NOTIFICATIONS = "notifications"

    const val TASK_DETAIL = "task_detail/{taskId}"
}


@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val context = LocalContext.current
    val activity = context as? Activity

    val backStackEntry by
    navController.currentBackStackEntryAsState()

    val currentRoute =
        backStackEntry?.destination?.route


    // =========================================================
    // AUTO-LOGIN: Cek sesi tersimpan saat aplikasi pertama dibuka
    // =========================================================

    LaunchedEffect(Unit) {
        // 1. Tunggu inisialisasi koneksi SurrealDB & sync data awal
        AppRepository.initializeSurrealDbAndWait()

        // 2. Cek sesi tersimpan → auto-login jika ada
        val hasSavedSession = AppRepository.checkSavedSession(context)
        if (hasSavedSession) {
            // Sesi valid → langsung ke Home, hapus semua stack auth
            navController.navigate(Routes.HOME) {
                popUpTo(Routes.WELCOME) { inclusive = true }
                launchSingleTop = true
            }
        }
        // Jika tidak ada sesi → tetap di Welcome (startDestination default)
    }


    // =========================================================
    // EXIT DIALOG
    // =========================================================

    var showExitDialog by remember {
        mutableStateOf(false)
    }


    // =========================================================
    // SINGLE SOURCE OF TRUTH (REACTIVE STATEFLOW STREAMS)
    // =========================================================

    val tasks by AppRepository.tasks.collectAsState()
    val courses by AppRepository.courses.collectAsState()
    val notifications by AppRepository.notifications.collectAsState()
    val currentUser by AppRepository.currentUser.collectAsState()


    // =========================================================
    // BOTTOM NAVIGATION ROUTES
    // =========================================================

    val mainRoutes = listOf(

        Routes.HOME,
        Routes.TASKS,
        Routes.CALENDAR,
        Routes.ANALYTICS,
        Routes.PROFILE
    )


    // =========================================================
    // SYSTEM BACK BUTTON
    // =========================================================

    BackHandler {

        when {

            // ---------------------------------------------
            // HOME / WELCOME
            // Tekan Back = konfirmasi keluar aplikasi
            // ---------------------------------------------

            currentRoute == Routes.HOME ||
                    currentRoute == Routes.WELCOME -> {

                showExitDialog = true
            }


            // ---------------------------------------------
            // HALAMAN UTAMA
            // Back = kembali ke Home
            // ---------------------------------------------

            currentRoute in mainRoutes -> {

                navController.navigate(
                    Routes.HOME
                ) {

                    popUpTo(
                        Routes.HOME
                    ) {

                        inclusive = false
                    }

                    launchSingleTop = true
                }
            }


            // ---------------------------------------------
            // HALAMAN LAIN
            // Back = kembali ke halaman sebelumnya
            // ---------------------------------------------

            else -> {

                navController.popBackStack()
            }
        }
    }


    // =========================================================
    // EXIT CONFIRMATION DIALOG
    // =========================================================

    if (showExitDialog) {

        AlertDialog(

            onDismissRequest = {

                showExitDialog = false
            },

            title = {

                Text(
                    text = "Keluar dari StudyTrack?"
                )
            },

            text = {

                Text(
                    text = "Apakah kamu yakin ingin keluar dari aplikasi?"
                )
            },

            confirmButton = {

                TextButton(

                    onClick = {

                        showExitDialog = false

                        activity?.finish()
                    }

                ) {

                    Text(
                        text = "Keluar"
                    )
                }
            },

            dismissButton = {

                TextButton(

                    onClick = {

                        showExitDialog = false
                    }

                ) {

                    Text(
                        text = "Batal"
                    )
                }
            }
        )
    }


    // =========================================================
    // SCAFFOLD
    // =========================================================

    Scaffold(

        modifier = Modifier.fillMaxSize(),

        bottomBar = {

            if (currentRoute in mainRoutes) {

                BottomNavBar(

                    currentRoute =
                        currentRoute ?: Routes.HOME,

                    onNavigate = { route ->

                        navController.navigate(route) {

                            popUpTo(Routes.HOME) {

                                saveState = true
                            }

                            launchSingleTop = true

                            restoreState = true
                        }
                    }
                )
            }
        }

    ) { innerPadding ->


        // =====================================================
        // NAV HOST
        // =====================================================

        NavHost(

            navController = navController,

            startDestination = Routes.WELCOME,

            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)

        ) {


            // =================================================
            // WELCOME
            // =================================================

            composable(Routes.WELCOME) {

                WelcomeScreen(

                    onGetStartedClick = {

                        navController.navigate(
                            Routes.REGISTER
                        )
                    },

                    onLoginClick = {

                        navController.navigate(
                            Routes.LOGIN
                        )
                    }
                )
            }


            // =================================================
            // LOGIN
            // =================================================

            // =================================================
            // LOGIN
            // =================================================

            composable(Routes.LOGIN) {

                LoginScreen(

                    onRegisterClick = {

                        navController.navigate(
                            Routes.REGISTER
                        )
                    },

                    onPerformLogin = { email, password ->
                        // Teruskan context agar sesi dapat disimpan ke SharedPreferences
                        AppRepository.login(context, email, password)
                    },

                    onLoginSuccess = {

                        navController.navigate(
                            Routes.HOME
                        ) {

                            popUpTo(Routes.WELCOME) {

                                inclusive = true
                            }

                            launchSingleTop = true
                        }
                    }
                )
            }


            // =================================================
            // REGISTER
            // =================================================

            composable(Routes.REGISTER) {

                RegisterScreen(

                    onLoginClick = {

                        navController.navigate(
                            Routes.LOGIN
                        )
                    },

                    onPerformRegister = { name, email, password ->
                        // Teruskan context agar sesi dapat disimpan ke SharedPreferences
                        AppRepository.register(context, name, email, password)
                    },

                    onRegisterSuccess = {

                        navController.navigate(
                            Routes.HOME
                        ) {

                            popUpTo(Routes.WELCOME) {
                                inclusive = true
                            }

                            launchSingleTop = true
                        }
                    }
                )
            }


            // =================================================
            // HOME
            // =================================================

            composable(Routes.HOME) {

                HomeScreen(

                    tasks = tasks,

                    user = currentUser ?: UserData.currentUser,

                    onNavigate = { route ->

                        navController.navigate(route)
                    },

                    onNotificationClick = {

                        navController.navigate(
                            Routes.NOTIFICATIONS
                        )
                    }
                )
            }


            // =================================================
            // COURSES / MATA KULIAH
            // =================================================

            composable(Routes.COURSES) {

                CoursesScreen(

                    courses = courses,

                    onBackClick = {

                        navController.popBackStack()
                    }
                )
            }


            // =================================================
            // TASKS
            // =================================================

            composable(Routes.TASKS) {

                TasksScreen(

                    tasks = tasks,

                    onNavigate = { route ->

                        navController.navigate(route)
                    },

                    onNotificationClick = {

                        navController.navigate(
                            Routes.NOTIFICATIONS
                        )
                    },

                    onTaskClick = { taskId ->

                        navController.navigate(
                            "task_detail/$taskId"
                        )
                    }
                )
            }


            // =================================================
            // CALENDAR
            // =================================================

            composable(Routes.CALENDAR) {

                CalendarScreen(

                    tasks = tasks,

                    onNotificationClick = {

                        navController.navigate(
                            Routes.NOTIFICATIONS
                        )
                    },

                    onProfileClick = {

                        navController.navigate(
                            Routes.PROFILE
                        )
                    },

                    onTaskClick = { taskId ->

                        navController.navigate(
                            "task_detail/$taskId"
                        )
                    }
                )
            }


            // =================================================
            // ANALYTICS
            // =================================================

            composable(Routes.ANALYTICS) {

                AnalyticsScreen(

                    courses = courses,

                    tasks = tasks,

                    onNotificationClick = {

                        navController.navigate(
                            Routes.NOTIFICATIONS
                        )
                    }
                )
            }


            // =================================================
            // PROFILE
            // =================================================

            composable(Routes.PROFILE) {

                ProfileScreen(

                    user = currentUser ?: UserData.currentUser,

                    onNotificationClick = {

                        navController.navigate(
                            Routes.NOTIFICATIONS
                        )
                    },

                    onEditProfileClick = {

                        navController.navigate(
                            Routes.EDIT_PROFILE
                        )
                    },

                    onLogout = {
                        // Hapus sesi dari SharedPreferences lalu kembali ke Welcome
                        AppRepository.logout(context)
                        navController.navigate(Routes.WELCOME) {
                            popUpTo(0) { inclusive = true }
                            launchSingleTop = true
                        }
                    },

                    onUpdateTargetHours = { hours ->
                        AppRepository.updateTargetStudyHours(hours)
                    }
                )
            }


            // =================================================
            // EDIT PROFILE
            // =================================================

            composable(Routes.EDIT_PROFILE) {

                EditProfileScreen(

                    user = currentUser ?: UserData.currentUser,

                    onBackClick = {

                        navController.popBackStack()
                    },

                    onSaveClick = { name, email, major, year, avatarUri ->

                        AppRepository.updateProfile(name, email, major, year, avatarUri)

                        navController.popBackStack()
                    }
                )
            }


            // =================================================
            // NOTIFICATIONS
            // =================================================

            composable(Routes.NOTIFICATIONS) {

                NotificationScreen(

                    onBackClick = {

                        navController.popBackStack()
                    },

                    notifications = notifications,

                    onMarkAsRead = { notificationId ->

                        AppRepository.markNotificationAsRead(notificationId)
                    },

                    onMarkAllAsRead = {

                        AppRepository.markAllNotificationsAsRead()
                    }
                )
            }


            // =================================================
            // TASK DETAIL
            // =================================================

            composable(Routes.TASK_DETAIL) { backStackEntry ->

                val taskId =
                    backStackEntry
                        .arguments
                        ?.getString("taskId")
                        ?: ""


                val task = tasks.find {
                    it.id == taskId
                }


                if (task != null) {

                    TaskDetailScreen(

                        task = task,

                        onBackClick = {

                            navController.popBackStack()
                        },

                        onToggleTaskStatus = { taskId ->

                            AppRepository.toggleTaskStatus(taskId)
                        },

                        onToggleChecklistItem = { taskId, itemId ->

                            AppRepository.toggleChecklistItem(taskId, itemId)
                        },

                        onAddAttachment = { taskId, fileName, fileType, fileSize, fileUri ->

                            AppRepository.addAttachmentToTask(taskId, fileName, fileType, fileSize, fileUri)
                        },

                        onDeleteTask = { taskId ->

                            AppRepository.deleteTask(taskId)
                        }
                    )
                }
            }
        }
    }
}
