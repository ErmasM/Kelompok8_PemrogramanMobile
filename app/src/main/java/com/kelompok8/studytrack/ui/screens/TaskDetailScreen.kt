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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.AttachFile
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kelompok8.studytrack.data.Task
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyBlueLight
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyNavy
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun TaskDetailScreen(
    task: Task,
    onBackClick: () -> Unit
) {

    val isDone = task.status == "Selesai"

    val statusColor = if (isDone) {
        StudyGreen
    } else {
        StudyBlue
    }

    val priorityColor = when (task.priority) {
        "Tinggi" -> Color(0xFFD32F2F)
        "Sedang" -> StudyBlue
        else -> StudyGreen
    }

    val priorityBackground = when (task.priority) {
        "Tinggi" -> Color(0xFFFFE0E0)
        "Sedang" -> Color(0xFFE8E9FF)
        else -> Color(0xFFE2F8EF)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFF9F8FF)
            ),
        contentPadding = PaddingValues(
            bottom = 28.dp
        ),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {

        // =====================================================
        // HEADER
        // =====================================================

        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(
                        horizontal = 20.dp,
                        vertical = 16.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = onBackClick
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Kembali",
                        tint = StudyNavy,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(StudyBlue),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.School,
                        contentDescription = "StudyTrack",
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Spacer(
                    modifier = Modifier.width(12.dp)
                )

                Text(
                    text = "Task Detail",
                    modifier = Modifier.weight(1f),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = StudyNavy
                )

                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
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

        // =====================================================
        // TASK INFORMATION
        // =====================================================

        item {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Box(
                        modifier = Modifier
                            .width(7.dp)
                            .height(330.dp)
                            .background(
                                color = priorityColor,
                                shape = RoundedCornerShape(
                                    topStart = 22.dp,
                                    bottomStart = 22.dp
                                )
                            )
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(20.dp)
                    ) {

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            DetailBadge(
                                text = "${task.subject} • CS-402",
                                backgroundColor = StudyBlueLight,
                                textColor = StudyTextSecondary
                            )

                            DetailBadge(
                                text = "● ${task.priority} Priority",
                                backgroundColor = priorityBackground,
                                textColor = priorityColor
                            )
                        }

                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        DetailBadge(
                            text = if (isDone) {
                                "✓ Completed"
                            } else {
                                "⊙ In Progress"
                            },
                            backgroundColor = if (isDone) {
                                Color(0xFFE2F8EF)
                            } else {
                                StudyBlueLight
                            },
                            textColor = statusColor
                        )

                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )

                        Text(
                            text = task.title,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyNavy
                        )

                        Spacer(
                            modifier = Modifier.height(6.dp)
                        )

                        Text(
                            text = "Lab Exercise: Symmetric & Asymmetric\nImplementations",
                            fontSize = 16.sp,
                            color = StudyTextSecondary,
                            lineHeight = 24.sp
                        )

                        Spacer(
                            modifier = Modifier.height(24.dp)
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(
                                    RoundedCornerShape(16.dp)
                                )
                                .background(
                                    Color(0xFFF0EFFF)
                                )
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(58.dp)
                                    .clip(CircleShape)
                                    .background(StudyBlue),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.CalendarMonth,
                                    contentDescription = "Deadline",
                                    tint = Color.White,
                                    modifier = Modifier.size(30.dp)
                                )
                            }

                            Spacer(
                                modifier = Modifier.width(14.dp)
                            )

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    text = task.deadline,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = StudyNavy
                                )

                                Spacer(
                                    modifier = Modifier.height(3.dp)
                                )

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Icon(
                                        imageVector = Icons.Outlined.Timer,
                                        contentDescription = null,
                                        tint = Color.Red,
                                        modifier = Modifier.size(17.dp)
                                    )

                                    Spacer(
                                        modifier = Modifier.width(4.dp)
                                    )

                                    Text(
                                        text = "23 hours left",
                                        fontSize = 13.sp,
                                        color = Color.Red
                                    )
                                }
                            }

                            Column(
                                horizontalAlignment = Alignment.End
                            ) {

                                Text(
                                    text = "Weight",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = StudyTextSecondary
                                )

                                Text(
                                    text = "15%",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = StudyBlue
                                )
                            }
                        }
                    }
                }
            }
        }

        // =====================================================
        // CHECKLIST
        // =====================================================

        item {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 1.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(24.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.CheckCircle,
                            contentDescription = null,
                            tint = StudyGreen,
                            modifier = Modifier.size(27.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(10.dp)
                        )

                        Text(
                            text = "Checklist Progress",
                            modifier = Modifier.weight(1f),
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Medium,
                            color = StudyNavy
                        )

                        Text(
                            text = "66%",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyGreen
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    LinearProgressIndicator(
                        progress = { 0.66f },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(12.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        color = StudyGreen,
                        trackColor = Color(0xFFE8EBFF)
                    )

                    Spacer(
                        modifier = Modifier.height(28.dp)
                    )

                    ChecklistItem(
                        text = "Implement AES-128 Encryption & Decryption",
                        checked = true
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    ChecklistItem(
                        text = "Implement RSA Key Generation (2048-bit)",
                        checked = true
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    ChecklistItem(
                        text = "Generate benchmark time graphs & final PDF report",
                        checked = false
                    )
                }
            }
        }

        // =====================================================
        // DESCRIPTION
        // =====================================================

        item {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 1.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(24.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.Description,
                            contentDescription = null,
                            tint = StudyBlue,
                            modifier = Modifier.size(27.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(10.dp)
                        )

                        Text(
                            text = "Description",
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyNavy
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(
                        text = "Mengerjakan soal latihan dan membuat laporan sesuai dengan format yang diberikan. Pastikan mengimplementasikan algoritma AES dan RSA dengan benchmark waktu eksekusi.",
                        fontSize = 16.sp,
                        color = StudyTextSecondary,
                        lineHeight = 26.sp
                    )

                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(14.dp)
                            )
                            .background(
                                Color(0xFFF0EFFF)
                            )
                            .padding(16.dp),
                        verticalAlignment = Alignment.Top
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.ErrorOutline,
                            contentDescription = null,
                            tint = StudyBlue,
                            modifier = Modifier.size(22.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(10.dp)
                        )

                        Text(
                            text = "Laporan dikumpulkan dalam format PDF disertai source code (C++ / Python / Go) dalam file archive .ZIP.",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyTextSecondary,
                            lineHeight = 19.sp
                        )
                    }
                }
            }
        }

        // =====================================================
        // ATTACHMENTS
        // =====================================================

        item {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 1.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(24.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.AttachFile,
                            contentDescription = null,
                            tint = StudyBlue,
                            modifier = Modifier.size(27.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(10.dp)
                        )

                        Text(
                            text = "Attachments (1)",
                            modifier = Modifier.weight(1f),
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyNavy
                        )

                        Text(
                            text = "+ Add File",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = StudyBlue
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(16.dp)
                            )
                            .background(
                                Color(0xFFF0EFFF)
                            )
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(
                                    RoundedCornerShape(12.dp)
                                )
                                .background(
                                    Color(0xFFFFD9D6)
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = "PDF",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFB00020)
                            )
                        }

                        Spacer(
                            modifier = Modifier.width(12.dp)
                        )

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = "tugas-kriptografi.pdf",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = StudyNavy
                            )

                            Text(
                                text = "2.4 MB • Uploaded Sep 14",
                                fontSize = 13.sp,
                                color = StudyTextSecondary
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape)
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Download,
                                contentDescription = "Download",
                                tint = StudyNavy,
                                modifier = Modifier.size(22.dp)
                            )
                        }

                        Spacer(
                            modifier = Modifier.width(8.dp)
                        )

                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape)
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Visibility,
                                contentDescription = "Lihat",
                                tint = StudyNavy,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    }
                }
            }
        }

        // =====================================================
        // DOSEN
        // =====================================================

        item {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 1.dp
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(72.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(
                                Color(0xFFE8EBFF)
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Dosen",
                            tint = StudyBlue,
                            modifier = Modifier.size(40.dp)
                        )
                    }

                    Spacer(
                        modifier = Modifier.width(16.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Prof. Dr. Ir. H. Wardhana",
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyNavy
                        )

                        Text(
                            text = "Dept. of Computer Science • Office Hours: Thu 2–4 PM",
                            fontSize = 13.sp,
                            color = StudyTextSecondary
                        )

                        Spacer(
                            modifier = Modifier.height(6.dp)
                        )

                        Text(
                            text = "▣ Contact Lecturer",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = StudyBlue
                        )
                    }
                }
            }
        }

        // =====================================================
        // ACTION BUTTON
        // =====================================================

        item {

            Column(
                modifier = Modifier.padding(
                    horizontal = 16.dp
                )
            ) {

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = StudyGreen
                    )
                ) {

                    Icon(
                        imageVector = Icons.Outlined.CheckCircle,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Text(
                        text = if (isDone) {
                            "Completed"
                        } else {
                            "Mark as Completed"
                        },
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {

                    OutlinedButton(
                        onClick = {},
                        modifier = Modifier
                            .weight(1f)
                            .height(58.dp),
                        shape = RoundedCornerShape(30.dp)
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.Edit,
                            contentDescription = null,
                            modifier = Modifier.size(21.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(6.dp)
                        )

                        Text(
                            text = "Edit Task",
                            fontSize = 16.sp
                        )
                    }

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .weight(1f)
                            .height(58.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFD9D6),
                            contentColor = Color(0xFFB00020)
                        )
                    ) {

                        Text(
                            text = "Delete",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}


// =====================================================
// CHECKLIST ITEM
// =====================================================

@Composable
private fun ChecklistItem(
    text: String,
    checked: Boolean
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {

        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(
                    if (checked) {
                        StudyBlue
                    } else {
                        Color.Transparent
                    }
                )
                .clickable {},
            contentAlignment = Alignment.Center
        ) {

            if (!checked) {
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(Color.White)
                )
            }
        }

        Spacer(
            modifier = Modifier.width(14.dp)
        )

        Text(
            text = text,
            fontSize = 16.sp,
            color = if (checked) {
                StudyTextSecondary
            } else {
                StudyNavy
            },
            lineHeight = 24.sp
        )
    }
}


// =====================================================
// DETAIL BADGE
// =====================================================

@Composable
private fun DetailBadge(
    text: String,
    backgroundColor: Color,
    textColor: Color
) {

    Text(
        text = text,
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(backgroundColor)
            .padding(
                horizontal = 12.dp,
                vertical = 6.dp
            ),
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        color = textColor
    )
}