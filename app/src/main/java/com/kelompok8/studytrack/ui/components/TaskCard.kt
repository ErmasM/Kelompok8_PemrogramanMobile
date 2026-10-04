package com.kelompok8.studytrack.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.kelompok8.studytrack.data.models.Task
import com.kelompok8.studytrack.data.models.TaskPriority
import com.kelompok8.studytrack.data.models.TaskStatus
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyBlueLight
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun TaskCard(
    task: Task,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isDone = task.status == TaskStatus.COMPLETED

    val statusColor = if (isDone) {
        StudyGreen
    } else {
        StudyBlue
    }

    val priorityColor = when (task.priority) {
        TaskPriority.HIGH -> Color(0xFFD32F2F)
        TaskPriority.MEDIUM -> StudyBlue
        TaskPriority.LOW -> StudyGreen
    }

    val priorityBackground = when (task.priority) {
        TaskPriority.HIGH -> Color(0xFFFFE0E0)
        TaskPriority.MEDIUM -> Color(0xFFE8E9FF)
        TaskPriority.LOW -> Color(0xFFE2F8EF)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
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
                    .height(155.dp)
                    .background(
                        color = statusColor,
                        shape = RoundedCornerShape(
                            topStart = 20.dp,
                            bottomStart = 20.dp
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(18.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TaskBadge(
                        text = task.subject,
                        backgroundColor = StudyBlueLight,
                        textColor = MaterialTheme.colorScheme.onSurface
                    )

                    TaskBadge(
                        text = task.priorityLabel,
                        backgroundColor = priorityBackground,
                        textColor = priorityColor
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    TaskBadge(
                        text = task.statusLabel,
                        backgroundColor = if (isDone) Color(0xFFD1FAE5) else StudyBlueLight,
                        textColor = statusColor
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = task.title,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = if (isDone) Icons.Outlined.CheckCircle else Icons.Outlined.CalendarMonth,
                        contentDescription = "Deadline",
                        modifier = Modifier.size(20.dp),
                        tint = statusColor
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = task.deadline,
                        fontSize = 14.sp,
                        color = if (isDone) StudyGreen else StudyTextSecondary
                    )
                }
            }
        }
    }
}

@Composable
fun TaskBadge(
    text: String,
    backgroundColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(50.dp)
            )
            .padding(
                horizontal = 10.dp,
                vertical = 6.dp
            ),
        fontSize = 11.sp,
        fontWeight = FontWeight.Medium,
        color = textColor
    )
}
