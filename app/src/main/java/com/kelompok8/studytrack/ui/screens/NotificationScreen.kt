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
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyNavy
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun NotificationScreen(
    onBackClick: () -> Unit
) {
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

        item {
            NotificationHeader(
                onBackClick = onBackClick
            )
        }

        item {
            TrackStatusCard()
        }

        item {
            NotificationItem(
                accentColor = StudyBlue,
                icon = Icons.Outlined.Notifications,
                iconBackground = Color(0xFFD9E7FF),
                title = "Tugas Kriptografi",
                time = "15 menit lalu",
                description = "Dikumpulkan besok • 23.59. Jangan lupa kumpulkan sebelum portal ditutup.",
                tags = listOf("Segera Dikumpulkan", "INF 438"),
                urgent = true
            )
        }

        item {
            NotificationItem(
                accentColor = Color(0xFFD71920),
                icon = Icons.Outlined.ErrorOutline,
                iconBackground = Color(0xFFFFD9D6),
                title = "Praktikum Sistem Operasi 3",
                time = "2 jam lalu",
                description = "Dikumpulkan dalam 2 hari • 17.00. Benchmark kernel diperlukan.",
                tags = listOf("INF 350", "Benchmarking"),
                urgent = false
            )
        }

        item {
            NotificationItem(
                accentColor = StudyGreen,
                icon = Icons.Outlined.CheckCircle,
                iconBackground = Color(0xFF72F2C0),
                title = "Normalisasi Database",
                time = "4 jam lalu",
                description = "Ditandai selesai hari ini • 11.00. Kerja bagus!",
                tags = listOf("✓ Selesai", "INF 340"),
                completed = true
            )
        }

        item {
            NotificationItem(
                accentColor = Color(0xFF9BBEFF),
                icon = Icons.Outlined.CalendarMonth,
                iconBackground = Color(0xFFD9E7FF),
                title = "Kuis UI/UX Design",
                time = "Kemarin",
                description = "Dikumpulkan dalam 1 minggu • 16.00. Pelajari Bab 3–5.",
                tags = listOf("DES 201", "Persiapan Kuis")
            )
        }

        item {
            NotificationItem(
                accentColor = StudyBlue,
                icon = Icons.Outlined.School,
                iconBackground = StudyBlue,
                title = "Selamat Datang di StudyTrack!",
                time = "3 hari lalu",
                description = "Selamat menikmati perjalanan belajarmu. Atur mata kuliah semester untuk mendapatkan pengalaman yang lebih personal...",
                tags = listOf("Pengaturan Awal"),
                onboarding = true
            )
        }

        item {
            SyncedFooter()
        }
    }
}

/* ============================================================
   HEADER
   ============================================================ */

@Composable
private fun NotificationHeader(
    onBackClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 4.dp,
                vertical = 4.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        androidx.compose.material3.IconButton(
            onClick = onBackClick,
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "Kembali",
                tint = StudyNavy,
                modifier = Modifier.size(30.dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(13.dp))
                .background(StudyBlue),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.School,
                contentDescription = "StudyTrack",
                tint = Color.White,
                modifier = Modifier.size(31.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "Notifikasi",
            modifier = Modifier.weight(1f),
            fontSize = 27.sp,
            fontWeight = FontWeight.Medium,
            color = StudyNavy
        )

        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(50))
                .background(StudyBlue),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Profil",
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}

/* ============================================================
   TRACK STATUS
   ============================================================ */

@Composable
private fun TrackStatusCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF0F0FF)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFD5E5FF)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.AutoAwesome,
                    contentDescription = null,
                    tint = StudyBlue,
                    modifier = Modifier.size(38.dp)
                )
            }

            Spacer(modifier = Modifier.width(18.dp))

            Column {
                Text(
                    text = "Progresmu tetap terjaga!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = StudyNavy
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Ada 2 deadline prioritas tinggi minggu ini.",
                    fontSize = 15.sp,
                    lineHeight = 21.sp,
                    color = Color(0xFF4B5565)
                )
            }
        }
    }
}

/* ============================================================
   NOTIFICATION ITEM
   ============================================================ */

@Composable
private fun NotificationItem(
    accentColor: Color,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconBackground: Color,
    title: String,
    time: String,
    description: String,
    tags: List<String>,
    urgent: Boolean = false,
    completed: Boolean = false,
    onboarding: Boolean = false
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (completed || onboarding) {
                Color(0xFFF0F0FF)
            } else {
                Color.White
            }
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Box(
                modifier = Modifier
                    .width(7.dp)
                    .height(220.dp)
                    .background(accentColor)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        start = 18.dp,
                        end = 18.dp,
                        top = 20.dp,
                        bottom = 18.dp
                    )
            ) {

                Row(
                    verticalAlignment = Alignment.Top
                ) {

                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(iconBackground),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = if (onboarding) {
                                Color.White
                            } else {
                                if (completed) StudyGreen else StudyBlue
                            },
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = title,
                                modifier = Modifier.weight(1f),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium,
                                color = StudyNavy,
                                maxLines = 2
                            )

                            if (!completed && !onboarding) {
                                Box(
                                    modifier = Modifier
                                        .size(9.dp)
                                        .clip(CircleShape)
                                        .background(StudyBlue)
                                )

                                Spacer(modifier = Modifier.width(8.dp))
                            }

                            Text(
                                text = time,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF4B5565)
                            )
                        }

                        Spacer(modifier = Modifier.height(7.dp))

                        Text(
                            text = description,
                            fontSize = 15.sp,
                            lineHeight = 22.sp,
                            color = Color(0xFF4B5565)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            tags.forEach { tag ->
                                NotificationTag(
                                    text = tag,
                                    urgent = urgent,
                                    completed = completed
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

/* ============================================================
   TAG
   ============================================================ */

@Composable
private fun NotificationTag(
    text: String,
    urgent: Boolean,
    completed: Boolean
) {
    Surface(
        shape = RoundedCornerShape(18.dp),
        color = when {
            urgent -> Color(0xFFFFD9D6)
            completed -> Color(0xFFDDEBFF)
            else -> Color(0xFFE9ECFA)
        }
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(
                horizontal = 11.dp,
                vertical = 6.dp
            ),
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = when {
                urgent -> Color(0xFFB3131B)
                completed -> StudyGreen
                else -> Color(0xFF4B5565)
            }
        )
    }
}

/* ============================================================
   FOOTER
   ============================================================ */

@Composable
private fun SyncedFooter() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 8.dp
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Outlined.CheckCircle,
            contentDescription = null,
            tint = Color(0xFF4B5565),
            modifier = Modifier.size(22.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Tersinkron dengan Google Classroom & Canvas",
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF4B5565)
        )
    }
}