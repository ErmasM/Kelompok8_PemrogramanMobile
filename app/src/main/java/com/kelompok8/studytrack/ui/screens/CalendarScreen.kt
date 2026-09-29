package com.kelompok8.studytrack.ui.screens

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.ChevronLeft
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.School
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
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyBlueLight
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun CalendarScreen() {

    var selectedDay by remember {
        mutableIntStateOf(16)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(
            horizontal = 20.dp,
            vertical = 20.dp
        ),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {

        // =========================
        // HEADER
        // =========================

        item {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Outlined.School,
                    contentDescription = "StudyTrack",
                    modifier = Modifier.size(44.dp),
                    tint = StudyBlue
                )

                Spacer(
                    modifier = Modifier.size(12.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "STUDYTRACK",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = StudyBlue
                    )

                    Text(
                        text = "Kalender",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Notifikasi",
                    modifier = Modifier.size(28.dp),
                    tint = MaterialTheme.colorScheme.onBackground
                )

                Spacer(
                    modifier = Modifier.size(16.dp)
                )

                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Profil",
                    modifier = Modifier.size(30.dp),
                    tint = StudyBlue
                )
            }
        }

        // =========================
        // KALENDER
        // =========================

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

                    // =========================
                    // BULAN
                    // =========================

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

                    Spacer(
                        modifier = Modifier.height(24.dp)
                    )

                    CalendarGrid(
                        selectedDay = selectedDay,
                        onDaySelected = {
                            selectedDay = it
                        }
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    CalendarLegend()
                }
            }
        }

        // =========================
        // AGENDA
        // =========================

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
                        modifier = Modifier.padding(
                            horizontal = 12.dp,
                            vertical = 8.dp
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.CalendarMonth,
                            contentDescription = null,
                            modifier = Modifier.size(17.dp),
                            tint = StudyBlue
                        )

                        Spacer(
                            modifier = Modifier.size(5.dp)
                        )

                        Text(
                            text = "3 Tugas",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyBlue
                        )
                    }
                }
            }
        }

        // =========================
        // AGENDA 1
        // =========================

        item {

            CalendarTaskCard(
                subject = "UI/UX Design",
                title = "UI/UX Design Heuristic Evaluation",
                time = "14:00",
                priority = "Sedang",
                status = "Selesai",
                color = StudyGreen
            )
        }

        // =========================
        // AGENDA 2
        // =========================

        item {

            CalendarTaskCard(
                subject = "Basis Data",
                title = "Normalisasi Database",
                time = "18:00",
                priority = "Rendah",
                status = "Sedang Dikerjakan",
                color = StudyBlue
            )
        }

        // =========================
        // AGENDA 3
        // =========================

        item {

            CalendarTaskCard(
                subject = "Kriptografi",
                title = "Cryptography Assignment 2",
                time = "23:59",
                priority = "Tinggi",
                status = "Sedang Dikerjakan",
                color = Color(0xFFD32F2F)
            )
        }
    }
}


// =====================================================
// CALENDAR GRID
// =====================================================

@Composable
private fun CalendarGrid(
    selectedDay: Int,
    onDaySelected: (Int) -> Unit
) {

    val days = listOf(
        "M", "S", "S", "R", "K", "J", "S"
    )

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
                    color = if (index == 0) {
                        Color(0xFFD32F2F)
                    } else {
                        StudyTextSecondary
                    }
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

                        Spacer(
                            modifier = Modifier.size(36.dp)
                        )

                    } else {

                        val day = date.toInt()

                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(
                                    if (day == selectedDay) {
                                        StudyBlue
                                    } else {
                                        Color.Transparent
                                    }
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = date,
                                fontSize = 14.sp,
                                fontWeight = if (day == selectedDay) {
                                    FontWeight.Bold
                                } else {
                                    FontWeight.Medium
                                },
                                color = if (day == selectedDay) {
                                    Color.White
                                } else {
                                    MaterialTheme.colorScheme.onSurface
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}


// =====================================================
// LEGEND
// =====================================================

@Composable
private fun CalendarLegend() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        LegendItem(
            color = Color(0xFFD32F2F),
            text = "Tinggi"
        )

        Spacer(
            modifier = Modifier.size(18.dp)
        )

        LegendItem(
            color = Color(0xFFFFB300),
            text = "Sedang"
        )

        Spacer(
            modifier = Modifier.size(18.dp)
        )

        LegendItem(
            color = StudyGreen,
            text = "Rendah"
        )
    }
}

@Composable
private fun LegendItem(
    color: Color,
    text: String
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(9.dp)
                .clip(CircleShape)
                .background(color)
        )

        Spacer(
            modifier = Modifier.size(5.dp)
        )

        Text(
            text = text,
            fontSize = 12.sp,
            color = StudyTextSecondary
        )
    }
}


// =====================================================
// CALENDAR TASK CARD
// =====================================================

@Composable
private fun CalendarTaskCard(
    subject: String,
    title: String,
    time: String,
    priority: String,
    status: String,
    color: Color
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
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
                    .background(color)
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
                        text = subject,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = StudyBlue
                    )

                    Spacer(
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = time,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = StudyTextSecondary
                    )
                }

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = priority,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = color
                    )

                    Spacer(
                        modifier = Modifier.weight(1f)
                    )

                    Card(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (status == "Selesai") {
                                Color(0xFFD1FAE5)
                            } else {
                                StudyBlueLight
                            }
                        )
                    ) {

                        Text(
                            text = status,
                            modifier = Modifier.padding(
                                horizontal = 12.dp,
                                vertical = 6.dp
                            ),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (status == "Selesai") {
                                StudyGreen
                            } else {
                                StudyBlue
                            }
                        )
                    }
                }
            }
        }
    }
}