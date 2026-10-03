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

import com.kelompok8.studytrack.data.Task
import com.kelompok8.studytrack.ui.components.BottomNavBar
import com.kelompok8.studytrack.ui.screens.AddTaskScreen
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
    const val ADD_TASK = "add_task"

    const val TASK_DETAIL = "task_detail/{taskTitle}"
}


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val backStackEntry by
    navController.currentBackStackEntryAsState()

    val currentRoute =
        backStackEntry?.destination?.route


    // =========================================================
    // EXIT DIALOG
    // =========================================================

    var showExitDialog by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current
    val activity = context as? Activity


    // =========================================================
    // TASK DATA
    // =========================================================

    var tasks by remember {

        mutableStateOf(

            listOf(

                Task(
                    subject = "Pemrograman Mobile",
                    title = "Membuat UI StudyTrack",
                    deadline = "Besok • 23.59",
                    priority = "Tinggi",
                    status = "Sedang Dikerjakan"
                ),

                Task(
                    subject = "Sistem Operasi",
                    title = "Lab 3: Kernel Locks",
                    deadline = "2 hari lagi • 17.00",
                    priority = "Tinggi",
                    status = "Sedang Dikerjakan"
                ),

                Task(
                    subject = "Basis Data",
                    title = "Normalisasi Database",
                    deadline = "4 hari lagi • 23.59",
                    priority = "Sedang",
                    status = "Belum Dimulai"
                ),

                Task(
                    subject = "Pemrograman Web",
                    title = "Membuat Website E-Commerce",
                    deadline = "6 hari lagi • 23.59",
                    priority = "Rendah",
                    status = "Sedang Dikerjakan"
                ),

                Task(
                    subject = "UI/UX Design",
                    title = "Evaluasi Heuristik",
                    deadline = "12 September • Selesai",
                    priority = "Sedang",
                    status = "Selesai"
                ),

                Task(
                    subject = "Algoritma",
                    title = "Algorithm Complexity Problem Set",
                    deadline = "10 September • Selesai",
                    priority = "Tinggi",
                    status = "Selesai"
                )
            )
        )
    }


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

            composable(Routes.LOGIN) {

                LoginScreen(

                    onRegisterClick = {

                        navController.navigate(
                            Routes.REGISTER
                        )
                    },

                    onLoginSuccess = {

                        navController.navigate(
                            Routes.HOME
                        ) {

                            // Hapus Welcome, Register,
                            // dan Login dari back stack
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
                    }
                )
            }


            // =================================================
            // HOME
            // =================================================

            composable(Routes.HOME) {

                HomeScreen(

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

                    onTaskClick = { taskTitle ->

                        navController.navigate(
                            "task_detail/${Uri.encode(taskTitle)}"
                        )
                    },

                    onAddTaskClick = {

                        navController.navigate(
                            Routes.ADD_TASK
                        )
                    }
                )
            }


            // =================================================
            // ADD TASK
            // =================================================

            composable(Routes.ADD_TASK) {

                AddTaskScreen(

                    onBackClick = {

                        navController.popBackStack()
                    },

                    onSaveTask = { newTask ->

                        tasks = tasks + newTask

                        navController.popBackStack()
                    }
                )
            }


            // =================================================
            // CALENDAR
            // =================================================

            composable(Routes.CALENDAR) {

                CalendarScreen(

                    onNotificationClick = {

                        navController.navigate(
                            Routes.NOTIFICATIONS
                        )
                    },

                    onProfileClick = {

                        navController.navigate(
                            Routes.PROFILE
                        )
                    }
                )
            }


            // =================================================
            // ANALYTICS
            // =================================================

            composable(Routes.ANALYTICS) {

                AnalyticsScreen(

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

                    onNotificationClick = {

                        navController.navigate(
                            Routes.NOTIFICATIONS
                        )
                    },

                    onEditProfileClick = {

                        navController.navigate(
                            Routes.EDIT_PROFILE
                        )
                    }
                )
            }


            // =================================================
            // EDIT PROFILE
            // =================================================

            composable(Routes.EDIT_PROFILE) {

                EditProfileScreen(

                    onBackClick = {

                        navController.popBackStack()
                    },

                    onSaveClick = {

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
                    }
                )
            }


            // =================================================
            // TASK DETAIL
            // =================================================

            composable(Routes.TASK_DETAIL) { backStackEntry ->

                val taskTitle =

                    backStackEntry
                        .arguments
                        ?.getString("taskTitle")
                        ?.let {
                            Uri.decode(it)
                        }
                        ?: ""


                val task = tasks.find {

                    it.title == taskTitle
                }


                if (task != null) {

                    TaskDetailScreen(

                        task = task,

                        onBackClick = {

                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}