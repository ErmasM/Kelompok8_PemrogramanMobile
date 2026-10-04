package com.kelompok8.studytrack.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import com.kelompok8.studytrack.data.models.AppNotification
import com.kelompok8.studytrack.data.models.NotificationType
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyNavy

@Composable
fun NotificationItem(
    notification: AppNotification,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val accentColor = when (notification.type) {
        NotificationType.URGENT -> StudyBlue
        NotificationType.WARNING -> Color(0xFFD71920)
        NotificationType.COMPLETED -> StudyGreen
        NotificationType.REMINDER -> Color(0xFF9BBEFF)
        NotificationType.ONBOARDING -> StudyBlue
    }

    val iconBackground = when (notification.type) {
        NotificationType.URGENT -> Color(0xFFD9E7FF)
        NotificationType.WARNING -> Color(0xFFFFD9D6)
        NotificationType.COMPLETED -> Color(0xFF72F2C0)
        NotificationType.REMINDER -> Color(0xFFD9E7FF)
        NotificationType.ONBOARDING -> StudyBlue
    }

    val icon = when (notification.type) {
        NotificationType.URGENT -> Icons.Outlined.Notifications
        NotificationType.WARNING -> Icons.Outlined.ErrorOutline
        NotificationType.COMPLETED -> Icons.Outlined.CheckCircle
        NotificationType.REMINDER -> Icons.Outlined.CalendarMonth
        NotificationType.ONBOARDING -> Icons.Outlined.School
    }

    val isCompleted = notification.type == NotificationType.COMPLETED
    val isOnboarding = notification.type == NotificationType.ONBOARDING
    val isUrgent = notification.type == NotificationType.URGENT

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isCompleted || isOnboarding) Color(0xFFF0F0FF) else Color.White
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
                    .padding(start = 18.dp, end = 18.dp, top = 20.dp, bottom = 18.dp)
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
                            tint = if (isOnboarding) Color.White else if (isCompleted) StudyGreen else StudyBlue,
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
                                text = notification.title,
                                modifier = Modifier.weight(1f),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium,
                                color = StudyNavy,
                                maxLines = 2
                            )

                            if (!notification.isRead) {
                                Box(
                                    modifier = Modifier
                                        .size(9.dp)
                                        .clip(CircleShape)
                                        .background(StudyBlue)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                            }

                            Text(
                                text = notification.timeAgo,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF4B5565)
                            )
                        }

                        Spacer(modifier = Modifier.height(7.dp))

                        Text(
                            text = notification.description,
                            fontSize = 15.sp,
                            lineHeight = 22.sp,
                            color = Color(0xFF4B5565)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            notification.tags.forEach { tag ->
                                NotificationTagItem(
                                    text = tag,
                                    urgent = isUrgent,
                                    completed = isCompleted
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun NotificationTagItem(
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
            modifier = Modifier.padding(horizontal = 11.dp, vertical = 6.dp),
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
