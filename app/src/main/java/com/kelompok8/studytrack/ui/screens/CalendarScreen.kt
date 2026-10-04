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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.ChevronLeft
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.data.TaskData
import com.kelompok8.studytrack.data.models.Task
import com.kelompok8.studytrack.data.models.TaskPriority
import com.kelompok8.studytrack.data.models.TaskStatus
import com.kelompok8.studytrack.regulation.TaskRegulation
import com.kelompok8.studytrack.ui.components.StudyTrackHeader
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyBlueLight
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun CalendarScreen(
    onNotificationClick: () -> Unit,
    onProfileClick: () -> Unit,
    tasks: List<Task> = emptyList(),
    onTaskClick: (String) -> Unit = {}
) {
    var selectedDay by remember { mutableIntStateOf(16) }
    val agendaTasks = TaskRegulation.getTasksForDay(tasks, selectedDay)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        // ====================================================
        // HEADER
        // ====================================================

        item {
            StudyTrackHeader(
                title = "Kalender",
                onNotificationClick = onNotificationClick,
                onProfileClick = onProfileClick
            )
        }

        // ====================================================
        // KALENDER GRID CARD
        // ====================================================

        item {
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
                    modifier = Modifier.padding(20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ChevronLeft,
                            contentDescription = "Bulan sebelumnya",
                            modifier = Modifier.size(28.dp),
                            tint = StudyBlue
                        )

                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "September 2026",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Text(
                                text = "Semester 5",
                                fontSize = 12.sp,
                                color = StudyTextSecondary
                            )
                        }

                        Icon(
                            imageVector = Icons.Outlined.ChevronRight,
                            contentDescription = "Bulan berikutnya",
                            modifier = Modifier.size(28.dp),
                            tint = StudyBlue
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    CalendarGrid(
                        selectedDay = selectedDay,
                        onDaySelected = { selectedDay = it }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    CalendarLegend()
                }
            }
        }

        // ====================================================
        // AGENDA HEADER
        // ====================================================

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Hari Ini, $selectedDay September 2026",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Text(
                        text = "Agenda Kuliah",
                        fontSize = 14.sp,
                        color = StudyTextSecondary
                    )
                }

                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = StudyBlueLight
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.CalendarMonth,
                            contentDescription = null,
                            modifier = Modifier.size(17.dp),
                            tint = StudyBlue
                        )

                        Spacer(modifier = Modifier.size(5.dp))

                        Text(
                            text = "${agendaTasks.size} Tugas",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyBlue
                        )
                    }
                }
            }
        }

        // ====================================================
        // AGENDA ITEMS (COLLECTION)
        // ====================================================

        items(
            items = agendaTasks,
            key = { it.id }
        ) { task ->
            CalendarTaskCard(
                task = task,
                onClick = { onTaskClick(task.id) }
            )
        }

        if (agendaTasks.isEmpty()) {
            item {
                Text(
                    text = "Tidak ada agenda pada tanggal ini.",
                    fontSize = 14.sp,
                    color = StudyTextSecondary,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
        }
    }
}

@Composable
private fun CalendarGrid(
    selectedDay: Int,
    onDaySelected: (Int) -> Unit
) {
    val days = listOf("M", "S", "S", "R", "K", "J", "S")

    val dates = listOf(
        null, null, "1", "2", "3", "4", "5",
        "6", "7", "8", "9", "10", "11", "12",
        "13", "14", "15", "16", "17", "18", "19",
        "20", "21", "22", "23", "24", "25", "26",
        "27", "28", "29", "30", null, null, null
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            days.forEachIndexed { index, day ->
                Text(
                    text = day,
                    modifier = Modifier.width(36.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (index == 0) Color(0xFFD32F2F) else StudyTextSecondary
                )
            }
        }

        dates.chunked(7).forEach { week ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                week.forEach { date ->
                    if (date == null) {
                        Spacer(modifier = Modifier.size(36.dp))
                    } else {
                        val day = date.toInt()

                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(
                                    if (day == selectedDay) StudyBlue else Color.Transparent
                                )
                                .clickable { onDaySelected(day) },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = date,
                                fontSize = 14.sp,
                                fontWeight = if (day == selectedDay) FontWeight.Bold else FontWeight.Medium,
                                color = if (day == selectedDay) Color.White else MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun CalendarLegend() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        LegendItem(color = Color(0xFFD32F2F), text = "Tinggi")
        Spacer(modifier = Modifier.size(18.dp))
        LegendItem(color = Color(0xFFFFB300), text = "Sedang")
        Spacer(modifier = Modifier.size(18.dp))
        LegendItem(color = StudyGreen, text = "Rendah")
    }
}

@Composable
private fun LegendItem(color: Color, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(9.dp)
                .clip(CircleShape)
                .background(color)
        )
        Spacer(modifier = Modifier.size(5.dp))
        Text(text = text, fontSize = 12.sp, color = StudyTextSecondary)
    }
}

@Composable
private fun CalendarTaskCard(
    task: Task,
    onClick: () -> Unit = {}
) {
    val accentColor = when (task.priority) {
        TaskPriority.HIGH -> Color(0xFFD32F2F)
        TaskPriority.MEDIUM -> StudyBlue
        TaskPriority.LOW -> StudyGreen
    }

    val isDone = task.status == TaskStatus.COMPLETED

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
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(
                modifier = Modifier
                    .width(6.dp)
                    .height(150.dp)
                    .background(accentColor)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(18.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = task.subject,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = StudyBlue
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = task.dueTimeText,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = StudyTextSecondary
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = task.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = task.priorityLabel,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = accentColor
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Card(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isDone) Color(0xFFD1FAE5) else StudyBlueLight
                        )
                    ) {
                        Text(
                            text = task.statusLabel,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isDone) StudyGreen else StudyBlue
                        )
                    }
                }
            }
        }
    }
}