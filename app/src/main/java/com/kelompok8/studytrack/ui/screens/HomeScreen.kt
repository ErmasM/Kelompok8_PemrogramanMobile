package com.kelompok8.studytrack.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.TrendingUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.data.TaskData
import com.kelompok8.studytrack.data.UserData
import com.kelompok8.studytrack.data.models.Task
import com.kelompok8.studytrack.data.models.UserProfile
import com.kelompok8.studytrack.data.models.TaskStatus
import com.kelompok8.studytrack.regulation.TaskRegulation
import com.kelompok8.studytrack.ui.components.StudyTrackHeader
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyBlueLight
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun HomeScreen(
    onNavigate: (String) -> Unit,
    onNotificationClick: () -> Unit,
    tasks: List<Task> = TaskData.initialTasks,
    user: UserProfile = UserData.currentUser
) {
    val upcomingTasks = TaskRegulation.getUpcomingDeadlines(tasks).take(4)

    val totalTasks = tasks.size
    val completedCount = TaskRegulation.countTasksByStatus(tasks, TaskStatus.COMPLETED)
    val inProgressCount = TaskRegulation.countTasksByStatus(tasks, TaskStatus.IN_PROGRESS)
    val notStartedCount = TaskRegulation.countTasksByStatus(tasks, TaskStatus.NOT_STARTED)
    val completionPercentage = TaskRegulation.calculateCompletionPercentage(tasks)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(
            start = 20.dp,
            end = 20.dp,
            top = 4.dp,
            bottom = 20.dp
        ),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        // ====================================================
        // HEADER
        // ====================================================

        item {
            StudyTrackHeader(
                title = "Beranda",
                onNotificationClick = onNotificationClick,
                onProfileClick = { onNavigate("profile") }
            )
        }


        // ====================================================
        // SEMANGAT HARI INI
        // ====================================================

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = StudyBlueLight
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(58.dp)
                            .background(
                                color = Color.White.copy(alpha = 0.75f),
                                shape = RoundedCornerShape(18.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.TrendingUp,
                            contentDescription = "Progress",
                            tint = StudyBlue,
                            modifier = Modifier.size(34.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = "SEMANGAT HARI INI",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyBlue
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Tetap semangat, ${user.name}!",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "\"Langkah kecil setiap hari membawa hasil besar.\"",
                            fontSize = 14.sp,
                            color = StudyTextSecondary
                        )
                    }
                }
            }
        }


        // ====================================================
        // PROGRESS
        // ====================================================

        item {
            ProgressCard(
                semesterText = "${user.semester} • ${user.academicYear}",
                completionPercentage = completionPercentage,
                totalTasks = totalTasks,
                completedTasks = completedCount,
                inProgressTasks = inProgressCount,
                notStartedTasks = notStartedCount
            )
        }


        // ====================================================
        // MATA KULIAH
        // ====================================================

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onNavigate("courses")
                    },
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 20.dp,
                            vertical = 18.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(
                                color = StudyBlueLight,
                                shape = RoundedCornerShape(14.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.School,
                            contentDescription = "Mata Kuliah",
                            tint = StudyBlue,
                            modifier = Modifier.size(27.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Mata Kuliah",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Lihat progres dan tugas setiap mata kuliah",
                            fontSize = 13.sp,
                            color = StudyTextSecondary
                        )
                    }

                    Icon(
                        imageVector = Icons.Outlined.ArrowForwardIos,
                        contentDescription = "Lihat Mata Kuliah",
                        tint = StudyBlue,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }


        // ====================================================
        // JUDUL DEADLINE
        // ====================================================

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Deadline Mendatang",
                    modifier = Modifier.weight(1f),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Text(
                    text = "${upcomingTasks.size} tugas",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = StudyBlue
                )
            }
        }


        // ====================================================
        // DAFTAR DEADLINE (ITEMS)
        // ====================================================

        items(
            items = upcomingTasks,
            key = { it.id }
        ) { task ->
            DeadlineCard(
                task = task,
                onClick = { onNavigate("task_detail/${task.id}") }
            )
        }
    }
}


// =====================================================
// DEADLINE CARD
// =====================================================

@Composable
private fun DeadlineCard(
    task: Task,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = task.subject,
                    modifier = Modifier.weight(1f),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = StudyBlue
                )

                Text(
                    text = task.priorityLabel,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = StudyBlue
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = task.title,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.CalendarMonth,
                    contentDescription = "Deadline",
                    modifier = Modifier.size(20.dp),
                    tint = StudyTextSecondary
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = task.deadline,
                    fontSize = 14.sp,
                    color = StudyTextSecondary
                )
            }
        }
    }
}


// =====================================================
// PROGRESS CARD
// =====================================================

@Composable
private fun ProgressCard(
    semesterText: String,
    completionPercentage: Int,
    totalTasks: Int,
    completedTasks: Int,
    inProgressTasks: Int,
    notStartedTasks: Int
) {
    val progressFraction = completionPercentage / 100f

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Progress Belajarmu",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Text(
                        text = semesterText,
                        fontSize = 16.sp,
                        color = StudyTextSecondary
                    )
                }

                Text(
                    text = "Target Semester",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = StudyBlue
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.size(130.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        progress = { progressFraction },
                        modifier = Modifier.fillMaxSize(),
                        strokeWidth = 12.dp,
                        color = StudyBlue,
                        trackColor = StudyBlueLight
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "$completionPercentage%",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyBlue
                        )

                        Text(
                            text = "Selesai",
                            fontSize = 14.sp,
                            color = StudyTextSecondary
                        )
                    }
                }

                Spacer(modifier = Modifier.size(20.dp))

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ProgressItem(
                        title = "Total Tugas",
                        value = totalTasks.toString()
                    )

                    ProgressItem(
                        title = "Selesai",
                        value = completedTasks.toString()
                    )

                    ProgressItem(
                        title = "Sedang Dikerjakan",
                        value = inProgressTasks.toString()
                    )

                    ProgressItem(
                        title = "Belum Dimulai",
                        value = notStartedTasks.toString()
                    )
                }
            }
        }
    }
}


// =====================================================
// ITEM STATISTIK
// =====================================================

@Composable
private fun ProgressItem(
    title: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 13.sp,
            color = StudyTextSecondary
        )

        Text(
            text = value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}