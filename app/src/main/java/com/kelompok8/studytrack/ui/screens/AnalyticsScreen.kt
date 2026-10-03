package com.kelompok8.studytrack.ui.screens

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.MoreHoriz
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Storage
import androidx.compose.material.icons.outlined.Terminal
import androidx.compose.material.icons.outlined.Timer
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyNavy
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun AnalyticsScreen(
    onNotificationClick: () -> Unit
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

        // ====================================================
        // HEADER
        // ====================================================

        item {
            AnalyticsHeader(
                onNotificationClick = onNotificationClick
            )
        }

        // ====================================================
        // OVERALL COMPLETION
        // ====================================================

        item {
            OverallCompletionCard()
        }

        // ====================================================
        // ACTIVITY
        // ====================================================

        item {
            ActivityCard()
        }

        // ====================================================
        // PROGRESS BY COURSE
        // ====================================================

        item {
            ProgressByCourseHeader()
        }

        item {
            CourseProgressCard(
                icon = Icons.Outlined.Lock,
                title = "Cryptography",
                completed = "3 dari 4 tugas selesai",
                progress = 0.75f,
                percentage = "75%",
                status = "✓ Sesuai Target",
                statusColor = StudyGreen,
                iconBackground = Color(0xFFD9E7FF)
            )
        }

        item {
            CourseProgressCard(
                icon = Icons.Outlined.Palette,
                title = "UI/UX Design",
                completed = "4 dari 5 tugas selesai",
                progress = 0.80f,
                percentage = "80%",
                status = "☆ Progres Terbaik",
                statusColor = StudyGreen,
                iconBackground = Color(0xFFBFF5DF)
            )
        }

        item {
            CourseProgressCard(
                icon = Icons.Outlined.Storage,
                title = "Database Systems",
                completed = "3 dari 5 tugas selesai",
                progress = 0.60f,
                percentage = "60%",
                status = "◷ Stabil",
                statusColor = StudyTextSecondary,
                iconBackground = Color(0xFFD9E7FF)
            )
        }

        item {
            CourseProgressCard(
                icon = Icons.Outlined.Terminal,
                title = "Operating Systems",
                completed = "2 dari 4 tugas selesai",
                progress = 0.50f,
                percentage = "50%",
                status = "⌁ Setengah Jalan",
                statusColor = StudyTextSecondary,
                iconBackground = Color(0xFFE7E9FF)
            )
        }

        item {
            CourseProgressCard(
                icon = Icons.Outlined.Code,
                title = "Web Programming",
                completed = "2 dari 5 tugas selesai",
                progress = 0.40f,
                percentage = "40%",
                status = "⚑ Selanjutnya",
                statusColor = StudyBlue,
                iconBackground = Color(0xFFD9E7FF)
            )
        }
    }
}


// =====================================================
// HEADER
// =====================================================

@Composable
private fun AnalyticsHeader(
    onNotificationClick: () -> Unit
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

        // =================================================
        // LOGO
        // =================================================

        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(StudyBlue),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = Icons.Outlined.MenuBook,
                contentDescription = "StudyTrack",
                tint = Color.White,
                modifier = Modifier.size(29.dp)
            )
        }

        Spacer(
            modifier = Modifier.width(12.dp)
        )

        // =================================================
        // TITLE
        // =================================================

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
                text = "Statistik",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        // =================================================
        // NOTIFICATION
        // =================================================

        Icon(
            imageVector = Icons.Outlined.NotificationsNone,
            contentDescription = "Notifikasi",
            tint = MaterialTheme.colorScheme.onBackground,
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
                .clip(CircleShape)
                .background(StudyBlue)
                .clickable {
                    // Navigasi profile bisa ditambahkan dari AppNavigation
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


// =====================================================
// OVERALL COMPLETION
// =====================================================

@Composable
private fun OverallCompletionCard() {
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
                        modifier = Modifier.padding(
                            horizontal = 12.dp,
                            vertical = 6.dp
                        ),
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
                            text = "Semester 1",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = StudyBlue
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            CompletionRing()

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
                text = "Tingkat penyelesaian semester 12% lebih tinggi dari " +
                        "target tengah semester. Pertahankan progresmu!",
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
                    number = "7",
                    label = "Selesai",
                    dotColor = StudyGreen,
                    icon = Icons.Outlined.CheckCircle
                )

                StatBox(
                    modifier = Modifier.weight(1f),
                    number = "4",
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
                    number = "1",
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


// =====================================================
// CIRCULAR PROGRESS
// =====================================================

@Composable
private fun CompletionRing() {
    Box(
        modifier = Modifier.size(160.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
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
                sweepAngle = 208.8f,
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
                text = "58%",
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


// =====================================================
// STAT BOX
// =====================================================

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
                    tint = if (numberColor == StudyGreen) {
                        StudyGreen
                    } else {
                        StudyBlue
                    },
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


// =====================================================
// ACTIVITY
// =====================================================

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
                        modifier = Modifier.padding(
                            horizontal = 12.dp,
                            vertical = 7.dp
                        ),
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


// =====================================================
// ACTIVITY CHART
// =====================================================

@Composable
private fun ActivityChart() {
    val values = listOf(
        0.55f,
        0.82f,
        1.00f,
        0.72f,
        0.95f,
        0.45f,
        0.65f
    )

    val labels = listOf(
        "S",
        "S",
        "R",
        "K",
        "J",
        "S",
        "M"
    )

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
                            modifier = Modifier.padding(
                                horizontal = 9.dp,
                                vertical = 5.dp
                            ),
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
                        .clip(
                            RoundedCornerShape(
                                topStart = 9.dp,
                                topEnd = 9.dp
                            )
                        )
                        .background(
                            if (index == 2) {
                                StudyBlue
                            } else {
                                Color(0xFFD1E0F8)
                            }
                        )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = labels[index],
                    fontSize = 13.sp,
                    fontWeight = if (index == 2) {
                        FontWeight.Bold
                    } else {
                        FontWeight.Normal
                    },
                    color = if (index == 2) {
                        StudyBlue
                    } else {
                        Color(0xFF4B5565)
                    }
                )
            }
        }
    }
}


// =====================================================
// PROGRESS BY COURSE
// =====================================================

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

        Text(
            text = "5 Mata Kuliah Aktif",
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = StudyTextSecondary
        )
    }
}


// =====================================================
// COURSE PROGRESS CARD
// =====================================================

@Composable
private fun CourseProgressCard(
    icon: ImageVector,
    title: String,
    completed: String,
    progress: Float,
    percentage: String,
    status: String,
    statusColor: Color,
    iconBackground: Color
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
            modifier = Modifier.padding(
                horizontal = 18.dp,
                vertical = 14.dp
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(43.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(iconBackground),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = StudyBlue,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = title,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Medium,
                        color = StudyNavy
                    )

                    Text(
                        text = completed,
                        fontSize = 12.sp,
                        color = Color(0xFF4B5565)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = percentage,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (statusColor == StudyGreen) {
                            StudyGreen
                        } else {
                            StudyBlue
                        }
                    )

                    Text(
                        text = status,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = statusColor
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFE3E7FA))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(progress)
                        .height(10.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(
                            if (statusColor == StudyGreen) {
                                StudyGreen
                            } else {
                                StudyBlue
                            }
                        )
                )
            }
        }
    }
}