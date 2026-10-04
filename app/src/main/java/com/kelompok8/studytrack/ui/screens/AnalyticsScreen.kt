package com.kelompok8.studytrack.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Key
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.MoreHoriz
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.Storage
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.data.CourseData
import com.kelompok8.studytrack.data.TaskData
import com.kelompok8.studytrack.data.models.Course
import com.kelompok8.studytrack.data.models.Task
import com.kelompok8.studytrack.data.models.TaskStatus
import com.kelompok8.studytrack.regulation.TaskRegulation
import com.kelompok8.studytrack.ui.components.StudyTrackHeader
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyNavy
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun AnalyticsScreen(
    onNotificationClick: () -> Unit,
    courses: List<Course> = CourseData.initialCourses,
    tasks: List<Task> = TaskData.initialTasks
) {
    val completedCount = TaskRegulation.countTasksByStatus(tasks, TaskStatus.COMPLETED)
    val inProgressCount = TaskRegulation.countTasksByStatus(tasks, TaskStatus.IN_PROGRESS)
    val notStartedCount = TaskRegulation.countTasksByStatus(tasks, TaskStatus.NOT_STARTED)
    val completionPercentage = TaskRegulation.calculateCompletionPercentage(tasks)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp,
            bottom = 24.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // ====================================================
        // HEADER
        // ====================================================

        item {
            StudyTrackHeader(
                title = "Statistik",
                logoIcon = Icons.Outlined.MenuBook,
                onNotificationClick = onNotificationClick,
                onProfileClick = {},
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp)
            )
        }

        // ====================================================
        // OVERALL COMPLETION
        // ====================================================

        item {
            OverallCompletionCard(
                completionPercentage = completionPercentage,
                completedCount = completedCount,
                inProgressCount = inProgressCount,
                notStartedCount = notStartedCount
            )
        }

        // ====================================================
        // ACTIVITY
        // ====================================================

        item {
            ActivityCard()
        }

        // ====================================================
        // PROGRESS BY COURSE HEADER
        // ====================================================

        item {
            ProgressByCourseHeader()
        }

        // ====================================================
        // PROGRESS BY COURSE LIST (COLLECTION)
        // ====================================================

        items(
            items = courses,
            key = { it.id }
        ) { course ->
            CourseProgressCard(course = course)
        }
    }
}

@Composable
private fun OverallCompletionCard(
    completionPercentage: Int,
    completedCount: Int,
    inProgressCount: Int,
    notStartedCount: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "PERFORMA AKADEMIK",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = StudyTextSecondary,
                        letterSpacing = 0.4.sp
                    )

                    Text(
                        text = "Penyelesaian Keseluruhan",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium,
                        color = StudyNavy
                    )
                }

                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = Color(0xFFE8F0FF)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.MenuBook,
                            contentDescription = null,
                            tint = StudyBlue,
                            modifier = Modifier.size(16.dp)
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "Semester 5",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = StudyBlue
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            CompletionRing(percentage = completionPercentage)

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "✿",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = StudyGreen
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Lebih cepat dari target",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = StudyGreen
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Tingkat penyelesaian semester 12% lebih tinggi dari target tengah semester. Pertahankan progresmu!",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Color(0xFF4B5565)
            )

            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                StatBox(
                    modifier = Modifier.weight(1f),
                    number = completedCount.toString(),
                    label = "Selesai",
                    dotColor = StudyGreen,
                    icon = Icons.Outlined.CheckCircle
                )

                StatBox(
                    modifier = Modifier.weight(1f),
                    number = inProgressCount.toString(),
                    label = "Sedang Dikerjakan",
                    dotColor = StudyBlue,
                    icon = Icons.Outlined.MoreHoriz
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                StatBox(
                    modifier = Modifier.weight(1f),
                    number = notStartedCount.toString(),
                    label = "Belum Dimulai",
                    dotColor = Color(0xFF7A8190),
                    icon = Icons.Outlined.Timer
                )

                StatBox(
                    modifier = Modifier.weight(1f),
                    number = "0",
                    label = "Semua Selesai!",
                    dotColor = StudyGreen,
                    icon = Icons.Outlined.CheckCircle,
                    numberColor = StudyGreen
                )
            }
        }
    }
}

@Composable
private fun CompletionRing(percentage: Int) {
    val sweepAngle = (percentage / 100f) * 360f

    Box(
        modifier = Modifier.size(160.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = 14.dp.toPx()
            val diameter = size.minDimension - strokeWidth
            val topLeft = Offset(
                x = (size.width - diameter) / 2,
                y = (size.height - diameter) / 2
            )

            drawArc(
                color = Color(0xFFE5EBF8),
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = topLeft,
                size = Size(diameter, diameter),
                style = androidx.compose.ui.graphics.drawscope.Stroke(
                    width = strokeWidth,
                    cap = StrokeCap.Round
                )
            )

            drawArc(
                color = StudyBlue,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                topLeft = topLeft,
                size = Size(diameter, diameter),
                style = androidx.compose.ui.graphics.drawscope.Stroke(
                    width = strokeWidth,
                    cap = StrokeCap.Round
                )
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$percentage%",
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                color = StudyNavy
            )

            Text(
                text = "Selesai",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF4B5565)
            )
        }
    }
}

@Composable
private fun StatBox(
    modifier: Modifier,
    number: String,
    label: String,
    dotColor: Color,
    icon: ImageVector,
    numberColor: Color = StudyNavy
) {
    Box(
        modifier = modifier
            .height(112.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFFF0F0FF))
            .padding(14.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(11.dp)
                        .clip(RoundedCornerShape(50))
                        .background(dotColor)
                )

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = if (numberColor == StudyGreen) StudyGreen else StudyBlue,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = number,
                fontSize = 40.sp,
                fontWeight = FontWeight.Medium,
                color = numberColor
            )

            Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF4B5565)
            )
        }
    }
}

@Composable
private fun ActivityCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.BarChart,
                    contentDescription = null,
                    tint = StudyBlue,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Aktivitas Belajar & Tugas",
                    modifier = Modifier.weight(1f),
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Medium,
                    color = StudyNavy
                )

                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = Color(0xFFD9E7FF)
                ) {
                    Text(
                        text = "Minggu Ini",
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = StudyTextSecondary
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            ActivityChart()

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "⚡ 20 tugas tercatat minggu ini",
                    modifier = Modifier.weight(1f),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF4B5565)
                )

                Text(
                    text = "Log Detail",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = StudyBlue
                )
            }
        }
    }
}

@Composable
private fun ActivityChart() {
    val values = listOf(0.55f, 0.82f, 1.00f, 0.72f, 0.95f, 0.45f, 0.65f)
    val labels = listOf("S", "S", "R", "K", "J", "S", "M")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        values.forEachIndexed { index, value ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                if (index == 2) {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = StudyBlue
                    ) {
                        Text(
                            text = "Tertinggi",
                            modifier = Modifier.padding(horizontal = 9.dp, vertical = 5.dp),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                } else {
                    Spacer(modifier = Modifier.height(29.dp))
                }

                Box(
                    modifier = Modifier
                        .width(34.dp)
                        .height((105 * value).dp)
                        .clip(RoundedCornerShape(topStart = 9.dp, topEnd = 9.dp))
                        .background(if (index == 2) StudyBlue else Color(0xFFD1E0F8))
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = labels[index],
                    fontSize = 13.sp,
                    fontWeight = if (index == 2) FontWeight.Bold else FontWeight.Normal,
                    color = if (index == 2) StudyBlue else Color(0xFF4B5565)
                )
            }
        }
    }
}

@Composable
private fun ProgressByCourseHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.MenuBook,
            contentDescription = null,
            tint = StudyBlue,
            modifier = Modifier.size(25.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Progres Mata Kuliah",
            modifier = Modifier.weight(1f),
            fontSize = 21.sp,
            fontWeight = FontWeight.Medium,
            color = StudyNavy
        )
    }
}

@Composable
private fun CourseProgressCard(course: Course) {
    val icon = when (course.code) {
        "INF-438" -> Icons.Outlined.Key
        "INF-340" -> Icons.Outlined.Storage
        "IMK-201" -> Icons.Outlined.Palette
        else -> Icons.Outlined.Code
    }

    val (statusText, statusColor) = when {
        course.progressPercentage >= 80 -> "☆ Progres Terbaik" to StudyGreen
        course.progressPercentage >= 75 -> "✓ Sesuai Target" to StudyGreen
        course.progressPercentage >= 60 -> "◷ Stabil" to StudyTextSecondary
        course.progressPercentage >= 50 -> "⌁ Setengah Jalan" to StudyTextSecondary
        else -> "⚑ Selanjutnya" to StudyBlue
    }

    val iconBg = when (course.code) {
        "INF-340" -> Color(0xFFB9F8DF)
        "IMK-201" -> Color(0xFFBFF5DF)
        else -> Color(0xFFD9E7FF)
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(iconBg),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = StudyBlue,
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = course.name,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = StudyNavy,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = "${course.progressPercentage}%",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = StudyBlue
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${course.completedTasks} dari ${course.totalTasks} tugas selesai",
                    fontSize = 12.sp,
                    color = StudyTextSecondary
                )

                Spacer(modifier = Modifier.height(8.dp))

                LinearProgressIndicator(
                    progress = { course.progressPercentage / 100f },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    color = StudyBlue,
                    trackColor = Color(0xFFE8EBFF)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = statusText,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = statusColor
                )
            }
        }
    }
}