package com.kelompok8.studytrack.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Key
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.Storage
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.data.models.Course
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyNavy
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun CourseCard(
    course: Course,
    modifier: Modifier = Modifier
) {
    val courseIcon = when (course.code) {
        "INF-438" -> Icons.Outlined.Key
        "INF-340" -> Icons.Outlined.Storage
        "IMK-201" -> Icons.Outlined.School
        else -> Icons.Outlined.Code
    }

    val iconBg = if (course.code == "INF-340") Color(0xFFB9F8DF) else Color(0xFFDCE7FF)
    val iconTint = if (course.code == "INF-340") StudyGreen else StudyBlue

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(
                modifier = Modifier
                    .width(6.dp)
                    .height(300.dp)
                    .background(
                        color = if (course.isActive) StudyBlue else Color(0xFFC9CED8)
                    )
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {
                    Card(
                        modifier = Modifier.size(60.dp),
                        shape = RoundedCornerShape(15.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = iconBg
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 0.dp
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = courseIcon,
                                contentDescription = course.name,
                                tint = iconTint,
                                modifier = Modifier.size(31.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = course.code,
                                modifier = Modifier
                                    .background(
                                        color = Color(0xFFDCE7FF),
                                        shape = RoundedCornerShape(5.dp)
                                    )
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = StudyNavy
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(
                                text = course.room,
                                fontSize = 11.sp,
                                color = StudyTextSecondary
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = course.name,
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyNavy
                        )
                    }

                    Text(
                        text = "⋮",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = StudyTextSecondary
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Dosen",
                        tint = StudyBlue,
                        modifier = Modifier.size(21.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = course.lecturer.name,
                        fontSize = 16.sp,
                        color = StudyTextSecondary
                    )
                }

                Spacer(modifier = Modifier.height(17.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFF5F4FF)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 0.dp
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Progres Mata Kuliah",
                                modifier = Modifier.weight(1f),
                                fontSize = 14.sp,
                                color = StudyTextSecondary
                            )

                            Text(
                                text = "${course.progressPercentage}%",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (course.progressPercentage > 0) StudyBlue else StudyTextSecondary
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            Text(
                                text = "(${course.completedTasks} dari ${course.totalTasks} tugas)",
                                fontSize = 11.sp,
                                color = StudyTextSecondary
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = if (course.deadlineText == "Besok") Icons.Outlined.Timer else Icons.Outlined.CalendarMonth,
                        contentDescription = null,
                        tint = if (course.deadlineText == "Besok") Color(0xFFD32F2F) else StudyBlue,
                        modifier = Modifier.size(19.dp)
                    )

                    Spacer(modifier = Modifier.width(7.dp))

                    Column {
                        Text(
                            text = course.nextTaskTitle,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyNavy
                        )

                        Text(
                            text = "Deadline: ${course.deadlineText}",
                            fontSize = 12.sp,
                            color = StudyTextSecondary
                        )
                    }
                }
            }
        }
    }
}
