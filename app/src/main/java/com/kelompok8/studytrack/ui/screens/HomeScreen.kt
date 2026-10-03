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
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.Person
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
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyBlueLight
import com.kelompok8.studytrack.ui.theme.StudyNavy
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun HomeScreen(
    onNavigate: (String) -> Unit,
    onNotificationClick: () -> Unit
) {

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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 2.dp,
                        vertical = 4.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // =================================================
                // LOGO STUDYTRACK
                // =================================================

                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            color = StudyBlue,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Outlined.School,
                        contentDescription = "StudyTrack",
                        tint = Color.White,
                        modifier = Modifier.size(29.dp)
                    )
                }

                Spacer(
                    modifier = Modifier.width(12.dp)
                )

                // =================================================
                // JUDUL
                // =================================================

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "STUDYTRACK",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = StudyBlue,
                        letterSpacing = 0.5.sp
                    )

                    Text(
                        text = "Beranda",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = StudyNavy
                    )
                }

                // =================================================
                // NOTIFIKASI
                // =================================================

                Icon(
                    imageVector = Icons.Outlined.NotificationsNone,
                    contentDescription = "Notifikasi",
                    tint = StudyNavy,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable {
                            onNotificationClick()
                        }
                )

                Spacer(
                    modifier = Modifier.width(16.dp)
                )

                // =================================================
                // PROFILE
                // =================================================

                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .background(
                            color = StudyBlue,
                            shape = CircleShape
                        )
                        .clickable {
                            onNavigate("profile")
                        },
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Profil",
                        tint = Color.White,
                        modifier = Modifier.size(26.dp)
                    )
                }
            }
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

                    Spacer(
                        modifier = Modifier.width(16.dp)
                    )

                    Column {

                        Text(
                            text = "SEMANGAT HARI INI",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyBlue
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = "Tetap semangat!",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

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
            ProgressCard()
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

                    Spacer(
                        modifier = Modifier.width(14.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Mata Kuliah",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(
                            modifier = Modifier.height(3.dp)
                        )

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
                    text = "4 tugas",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = StudyBlue
                )
            }
        }


        // ====================================================
        // DAFTAR DEADLINE
        // ====================================================

        items(
            items = listOf(
                "Pemrograman Mobile",
                "Sistem Operasi",
                "Basis Data",
                "Pemrograman Web"
            ),
            key = { it }
        ) { subject ->

            DeadlineCard(
                subject = subject
            )
        }
    }
}


// =====================================================
// DEADLINE CARD
// =====================================================

@Composable
private fun DeadlineCard(
    subject: String
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

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = subject,
                    modifier = Modifier.weight(1f),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = StudyBlue
                )

                Text(
                    text = "Tinggi",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = StudyBlue
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Tugas dan proyek kuliah",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Outlined.CalendarMonth,
                    contentDescription = "Deadline",
                    modifier = Modifier.size(20.dp),
                    tint = StudyTextSecondary
                )

                Spacer(
                    modifier = Modifier.size(8.dp)
                )

                Text(
                    text = "Deadline besok • 23.59",
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
private fun ProgressCard() {

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
                        text = "Semester 5 • 2026/2027",
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

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier.size(130.dp),
                    contentAlignment = Alignment.Center
                ) {

                    CircularProgressIndicator(
                        progress = { 0.58f },
                        modifier = Modifier.fillMaxSize(),
                        strokeWidth = 12.dp,
                        color = StudyBlue,
                        trackColor = StudyBlueLight
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "58%",
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

                Spacer(
                    modifier = Modifier.size(20.dp)
                )

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    ProgressItem(
                        title = "Total Tugas",
                        value = "12"
                    )

                    ProgressItem(
                        title = "Selesai",
                        value = "7"
                    )

                    ProgressItem(
                        title = "Sedang Dikerjakan",
                        value = "4"
                    )

                    ProgressItem(
                        title = "Belum Dimulai",
                        value = "1"
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