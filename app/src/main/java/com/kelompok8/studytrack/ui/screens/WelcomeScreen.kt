package com.kelompok8.studytrack.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyBlueLight
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun WelcomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(
                horizontal = 24.dp,
                vertical = 32.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // =========================
        // LOGO SEMENTARA
        // =========================

        Text(
            text = "🎓",
            fontSize = 52.sp
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        // =========================
        // NAMA APLIKASI
        // =========================

        Text(
            text = "StudyTrack",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        // =========================
        // TAGLINE
        // =========================

        Text(
            text = "Plan • Study • Achieve",
            fontSize = 18.sp,
            color = StudyTextSecondary
        )

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        // =========================
        // ILUSTRASI
        // =========================

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = StudyBlueLight
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "🎓",
                    fontSize = 88.sp
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Text(
                    text = "Your academic journey",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Plan your studies and stay on track",
                    fontSize = 14.sp,
                    color = StudyTextSecondary
                )
            }
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // =========================
        // FEATURE CARDS
        // =========================

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            FeatureCard(
                icon = "📅",
                title = "Smart Sync",
                modifier = Modifier.weight(1f)
            )

            FeatureCard(
                icon = "⏱",
                title = "Focus Flow",
                modifier = Modifier.weight(1f)
            )

            FeatureCard(
                icon = "📈",
                title = "GPA Trends",
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        // =========================
        // GET STARTED
        // =========================

        Button(
            onClick = {
                // Nanti diarahkan ke RegisterScreen
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = StudyBlue,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {

            Text(
                text = "Get Started  →",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        // =========================
        // LOGIN
        // =========================

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Already have an account? ",
                fontSize = 15.sp,
                color = StudyTextSecondary
            )

            Text(
                text = "Log in",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = StudyBlue
            )
        }

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        // =========================
        // FOOTER
        // =========================

        Text(
            text = "StudyTrack • Plan • Study • Achieve",
            fontSize = 12.sp,
            color = StudyTextSecondary
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )
    }
}

@Composable
private fun FeatureCard(
    icon: String,
    title: String,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier.height(92.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(92.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = icon,
                fontSize = 24.sp
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}