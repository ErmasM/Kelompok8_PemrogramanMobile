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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun RegisterScreen(
    onLoginClick: () -> Unit
) {

    val nameState = rememberTextFieldState()
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // =========================
        // LOGO
        // =========================

        Icon(
            imageVector = Icons.Outlined.School,
            contentDescription = "StudyTrack",
            modifier = Modifier.height(64.dp),
            tint = StudyBlue
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // =========================
        // TITLE
        // =========================

        Text(
            text = "Create Account",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Start your study journey with StudyTrack",
            fontSize = 15.sp,
            color = StudyTextSecondary
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        // =========================
        // FULL NAME
        // =========================

        OutlinedTextField(
            state = nameState,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Full Name")
            },
            placeholder = {
                Text("Enter your name")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Name"
                )
            }
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // =========================
        // EMAIL
        // =========================

        OutlinedTextField(
            state = emailState,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Email")
            },
            placeholder = {
                Text("example@email.com")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = "Email"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // =========================
        // PASSWORD
        // =========================

        OutlinedSecureTextField(
            state = passwordState,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Password")
            },
            placeholder = {
                Text("Create a password")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = "Password"
                )
            }
        )

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        // =========================
        // REGISTER BUTTON
        // =========================

        Button(
            onClick = {
                // Nanti dihubungkan ke proses register
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(
                text = "Create Account",
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // =========================
        // LOGIN
        // =========================

        Text(
            text = "Already have an account? Login",
            fontSize = 15.sp,
            color = StudyBlue,
            modifier = Modifier.clickable(
                onClick = onLoginClick
            )
        )
    }
}