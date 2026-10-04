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
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.School
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.data.UserData
import com.kelompok8.studytrack.data.models.UserProfile
import com.kelompok8.studytrack.regulation.UserRegulation
import com.kelompok8.studytrack.ui.components.StudyTrackHeader
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyNavy
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun ProfileScreen(
    onNotificationClick: () -> Unit,
    onEditProfileClick: () -> Unit,
    user: UserProfile = UserData.currentUser
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
            StudyTrackHeader(
                title = "Profil",
                onNotificationClick = onNotificationClick,
                onProfileClick = {},
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp)
            )
        }

        item {
            ProfileCard(
                user = user,
                onEditProfileClick = onEditProfileClick
            )
        }

        item {
            ProfileStats(user = user)
        }

        item {
            SectionTitle("PREFERENSI & AKADEMIK")
        }

        item {
            PreferencesCard(user = user)
        }

        item {
            SectionTitle("DUKUNGAN & INFORMASI")
        }

        item {
            SupportCard()
        }

        item {
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
private fun ProfileCard(
    user: UserProfile,
    onEditProfileClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(108.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE8EBFF)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.AccountCircle,
                        contentDescription = "Foto Profil",
                        tint = StudyBlue,
                        modifier = Modifier.size(82.dp)
                    )
                }

                Spacer(modifier = Modifier.width(18.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = user.name,
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold,
                        color = StudyNavy,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = user.email,
                        fontSize = 14.sp,
                        color = StudyTextSecondary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = Color(0xFFE0F5ED)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.School,
                                contentDescription = null,
                                tint = StudyGreen,
                                modifier = Modifier.size(15.dp)
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            Text(
                                text = UserRegulation.getStudentBio(user),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Medium,
                                color = StudyGreen
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color(0xFFEEF0F6))
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.CheckCircle,
                        contentDescription = null,
                        tint = StudyGreen,
                        modifier = Modifier.size(22.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Status Mahasiswa ${if (user.isStudentActive) "Aktif" else "Non-Aktif"}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF4B5565)
                    )
                }

                Surface(
                    modifier = Modifier.clickable { onEditProfileClick() },
                    shape = RoundedCornerShape(22.dp),
                    color = Color(0xFFE9ECFF)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 9.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Edit,
                            contentDescription = null,
                            tint = StudyBlue,
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            text = "Edit Profil",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = StudyBlue
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ProfileStats(user: UserProfile) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ProfileStat(
                icon = Icons.Outlined.CheckCircle,
                value = "12",
                label = "TUGAS SELESAI",
                iconColor = StudyBlue
            )

            VerticalDivider()

            ProfileStat(
                icon = Icons.Outlined.MenuBook,
                value = "5",
                label = "MATA KULIAH",
                iconColor = StudyBlue
            )

            VerticalDivider()

            ProfileStat(
                icon = Icons.Outlined.AutoAwesome,
                value = user.cumulativeGpa.toString(),
                label = "IPK KUMULATIF",
                iconColor = StudyGreen,
                valueColor = StudyGreen
            )
        }
    }
}

@Composable
private fun ProfileStat(
    icon: ImageVector,
    value: String,
    label: String,
    iconColor: Color,
    valueColor: Color = StudyNavy
) {
    Column(
        modifier = Modifier.width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(21.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = value,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = valueColor
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = label,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = StudyTextSecondary,
            maxLines = 1
        )
    }
}

@Composable
private fun VerticalDivider() {
    Box(
        modifier = Modifier
            .width(1.dp)
            .height(54.dp)
            .background(Color(0xFFE8EBF5))
    )
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(start = 4.dp, top = 2.dp),
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        color = StudyTextSecondary,
        letterSpacing = 0.5.sp
    )
}

@Composable
private fun PreferencesCard(user: UserProfile) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
        ) {
            ProfileMenuItem(
                icon = Icons.Outlined.Timer,
                title = "Target Belajar",
                description = "Atur target jam belajar mingguan",
                badge = "${user.targetWeeklyStudyHours} jam/minggu"
            )

            MenuDivider()

            ProfileMenuItem(
                icon = Icons.Outlined.NotificationsNone,
                title = "Pengaturan Notifikasi",
                description = "Pengingat harian dan deadline"
            )

            MenuDivider()

            ProfileMenuItem(
                icon = Icons.Outlined.Palette,
                title = "Tampilan",
                description = "Atur tema dan tampilan aplikasi",
                badge = "Terang"
            )

            MenuDivider()

            ProfileMenuItem(
                icon = Icons.Outlined.MenuBook,
                title = "Preferensi Mata Kuliah",
                description = "Semester dan sinkronisasi kalender"
            )
        }
    }
}

@Composable
private fun SupportCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
        ) {
            ProfileMenuItem(
                icon = Icons.Outlined.HelpOutline,
                title = "Bantuan & Dukungan",
                description = "Panduan mahasiswa, FAQ, dan kontak"
            )

            MenuDivider()

            ProfileMenuItem(
                icon = Icons.Outlined.Info,
                title = "Tentang StudyTrack",
                description = "Versi 1.0.0 • Kebijakan Privasi"
            )
        }
    }
}

@Composable
private fun ProfileMenuItem(
    icon: ImageVector,
    title: String,
    description: String,
    badge: String? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(52.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(Color(0xFFD9E7FF)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = StudyBlue,
                modifier = Modifier.size(27.dp)
            )
        }

        Spacer(modifier = Modifier.width(14.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = StudyNavy
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = description,
                fontSize = 13.sp,
                color = StudyTextSecondary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        if (badge != null) {
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color(0xFFE9EEFF)
            ) {
                Text(
                    text = badge,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = StudyBlue,
                    maxLines = 1
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
        }

        Icon(
            imageVector = Icons.Outlined.ChevronRight,
            contentDescription = "Buka",
            tint = Color(0xFF7A8190),
            modifier = Modifier.size(22.dp)
        )
    }
}

@Composable
private fun MenuDivider() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(1.dp)
            .background(Color(0xFFEEF0F6))
    )
}