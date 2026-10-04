package com.kelompok8.studytrack.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.data.UserData
import com.kelompok8.studytrack.regulation.UserRegulation
import com.kelompok8.studytrack.ui.components.StudyTrackHeader
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyNavy
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun EditProfileScreen(
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit
) {
    val currentUser = UserData.currentUser

    var name by rememberSaveable { mutableStateOf(currentUser.name) }
    var email by rememberSaveable { mutableStateOf(currentUser.email) }
    var major by rememberSaveable { mutableStateOf(currentUser.major) }
    var year by rememberSaveable { mutableStateOf(currentUser.year) }

    val isValid = UserRegulation.validateProfileUpdate(name, email, major, year)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // =========================
        // HEADER
        // =========================

        StudyTrackHeader(
            title = "Edit Profil",
            onBackClick = onBackClick,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
        )

        // =========================
        // CONTENT
        // =========================

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(4.dp))

            // =========================
            // PROFILE PHOTO
            // =========================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(86.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFE8EBFF)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Foto Profil",
                            tint = StudyBlue,
                            modifier = Modifier.size(52.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Foto Profil",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyNavy
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Foto profil dapat diubah nanti.",
                            fontSize = 13.sp,
                            color = StudyTextSecondary
                        )
                    }
                }
            }

            // =========================
            // FORM
            // =========================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(
                        text = "Informasi Pribadi",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = StudyNavy
                    )

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Nama") },
                        leadingIcon = {
                            Icon(imageVector = Icons.Outlined.Person, contentDescription = null)
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp)
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Email") },
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp)
                    )

                    OutlinedTextField(
                        value = major,
                        onValueChange = { major = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Jurusan") },
                        leadingIcon = {
                            Icon(imageVector = Icons.Outlined.School, contentDescription = null)
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp)
                    )

                    OutlinedTextField(
                        value = year,
                        onValueChange = { year = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Angkatan") },
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // =========================
            // SAVE BUTTON
            // =========================

            Button(
                onClick = {
                    if (isValid) {
                        UserData.currentUser = UserData.currentUser.copy(
                            name = name,
                            email = email,
                            major = major,
                            year = year
                        )
                        onSaveClick()
                    }
                },
                enabled = isValid,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = StudyBlue,
                    contentColor = Color.White,
                    disabledContainerColor = Color(0xFFB8C4D8)
                )
            ) {
                Icon(
                    imageVector = Icons.Outlined.Check,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Simpan Perubahan",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}