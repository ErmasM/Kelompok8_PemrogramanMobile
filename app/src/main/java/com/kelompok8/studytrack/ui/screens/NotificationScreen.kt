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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.data.NotificationData
import com.kelompok8.studytrack.data.models.AppNotification
import com.kelompok8.studytrack.regulation.NotificationRegulation
import com.kelompok8.studytrack.ui.components.NotificationItem
import com.kelompok8.studytrack.ui.components.StudyTrackHeader
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyNavy

import androidx.compose.foundation.clickable
import androidx.compose.material3.FilterChip
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun NotificationScreen(
    onBackClick: () -> Unit,
    notifications: List<AppNotification> = NotificationData.initialNotifications,
    onMarkAsRead: (String) -> Unit = {},
    onMarkAllAsRead: () -> Unit = {}
) {
    var selectedFilter by rememberSaveable { mutableStateOf("Semua") }

    val urgentCount = NotificationRegulation.countUrgentNotifications(notifications)
    val unreadCount = NotificationRegulation.countUnreadNotifications(notifications)
    val filteredNotifications = NotificationRegulation.filterNotifications(notifications, selectedFilter)

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
            StudyTrackHeader(
                title = "Notifikasi",
                onBackClick = onBackClick,
                onProfileClick = {},
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp)
            )
        }

        item {
            TrackStatusCard(urgentCount = urgentCount)
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(
                        selected = selectedFilter == "Semua",
                        onClick = { selectedFilter = "Semua" },
                        label = { Text("Semua (${notifications.size})") }
                    )

                    FilterChip(
                        selected = selectedFilter == "Belum Dibaca",
                        onClick = { selectedFilter = "Belum Dibaca" },
                        label = { Text("Belum Dibaca ($unreadCount)") }
                    )

                    FilterChip(
                        selected = selectedFilter == "Urgent",
                        onClick = { selectedFilter = "Urgent" },
                        label = { Text("Urgent ($urgentCount)") }
                    )
                }

                if (unreadCount > 0) {
                    TextButton(onClick = onMarkAllAsRead) {
                        Text(
                            text = "Tandai dibaca",
                            fontSize = 13.sp,
                            color = StudyBlue,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }

        items(
            items = filteredNotifications,
            key = { it.id }
        ) { notification ->
            NotificationItem(
                notification = notification,
                onClick = { onMarkAsRead(notification.id) }
            )
        }

        if (filteredNotifications.isEmpty()) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Tidak ada notifikasi",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = StudyNavy
                    )
                }
            }
        }

        item {
            SyncedFooter()
        }
    }
}

@Composable
private fun TrackStatusCard(urgentCount: Int) {
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
                    text = "Ada $urgentCount deadline prioritas tinggi minggu ini.",
                    fontSize = 15.sp,
                    lineHeight = 21.sp,
                    color = Color(0xFF4B5565)
                )
            }
        }
    }
}

@Composable
private fun SyncedFooter() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp),
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