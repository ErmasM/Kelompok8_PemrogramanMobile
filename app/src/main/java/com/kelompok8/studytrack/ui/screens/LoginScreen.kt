package com.kelompok8.studytrack.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.R
import com.kelompok8.studytrack.data.UserData
import com.kelompok8.studytrack.regulation.UserRegulation
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun LoginScreen(
    onRegisterClick: () -> Unit,
    onLoginSuccess: () -> Unit,
    onPerformLogin: (email: String, password: String) -> Boolean = { _, _ -> false }
) {
    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    var errorMessage by rememberSaveable {
        mutableStateOf<String?>(null)
    }

    val isValid = UserRegulation.validateLoginCredentials(email, password)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // =========================
        // LOGO STUDYTRACK
        // =========================

        Image(
            painter = painterResource(id = R.drawable.studytrack_logo_compact),
            contentDescription = "StudyTrack",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // =========================
        // TITLE
        // =========================

        Text(
            text = "Selamat Datang Kembali!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Login untuk mengelola tugas dan perkuliahanmu",
            fontSize = 15.sp,
            color = StudyTextSecondary
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        // =========================
        // EMAIL
        // =========================

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                errorMessage = null
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Email Mahasiswa")
            },
            placeholder = {
                Text("contoh@student.unsoed.ac.id")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = "Email"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            shape = RoundedCornerShape(16.dp),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // =========================
        // PASSWORD
        // =========================

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                errorMessage = null
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Password")
            },
            placeholder = {
                Text("Masukkan password")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = "Password"
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            shape = RoundedCornerShape(16.dp),
            singleLine = true
        )

        // =========================
        // ERROR MESSAGE
        // =========================

        if (errorMessage != null) {
            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = errorMessage!!,
                color = Color(0xFFD32F2F),
                fontSize = 13.sp,
                modifier = Modifier.align(Alignment.Start)
            )
        }

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        // =========================
        // LOGIN BUTTON
        // =========================

        Button(
            onClick = {
                if (isValid) {
                    val success = onPerformLogin(email, password)

                    if (success) {
                        onLoginSuccess()
                    } else {
                        errorMessage = "Email atau password tidak cocok."
                    }
                } else {
                    errorMessage =
                        "Email harus valid dan password minimal 8 karakter."
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = StudyBlue,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Login",
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // =========================
        // REGISTER
        // =========================

        Text(
            text = "Belum punya akun? Daftar",
            fontSize = 15.sp,
            color = StudyBlue,
            modifier = Modifier.clickable(
                onClick = onRegisterClick
            )
        )
    }
}