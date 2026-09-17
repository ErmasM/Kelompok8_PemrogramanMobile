package com.kelompok8.studytrack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .requiredWidth(358.dp)
            .requiredHeight(907.dp)
            .background(Color(0xfff9f8ff))
    ) {

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 8.dp,
                    vertical = 24.dp
                )
        ) {

            // =========================
            // HEADER / LOGO
            // =========================

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(246.dp)
            ) {

                Column(
                    modifier = Modifier
                        .requiredWidth(342.dp)
                        .padding(
                            top = 32.dp,
                            bottom = 16.dp
                        )
                ) {

                    // Logo
                    Box(
                        modifier = Modifier
                            .requiredSize(112.dp)
                    ) {

                        Box(
                            modifier = Modifier
                                .requiredSize(112.dp)
                                .clip(RoundedCornerShape(24.dp))
                                .background(Color.White)
                                .padding(12.dp)
                                .shadow(
                                    elevation = 10.dp,
                                    shape = RoundedCornerShape(24.dp)
                                )
                        ) {
                            Image(
                                painter = painterResource(
                                    id = R.drawable.studytracklogo
                                ),
                                contentDescription = "StudyTrack Logo",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(16.dp))
                            )
                        }

                        // Version badge
                        Surface(
                            shape = RoundedCornerShape(9999.dp),
                            color = Color(0xff0059b8),
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .offset(
                                    x = 8.dp,
                                    y = 8.dp
                                )
                                .shadow(
                                    elevation = 4.dp,
                                    shape = RoundedCornerShape(9999.dp)
                                )
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(
                                    horizontal = 10.dp,
                                    vertical = 4.dp
                                )
                            ) {
                                Text(
                                    text = "✧",
                                    color = Color.White,
                                    fontSize = 12.sp
                                )

                                Text(
                                    text = "RK v2.4",
                                    color = Color.White,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    // Title
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "StudyTrack",
                            color = Color(0xff071747),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = (-0.7).sp
                            )
                        )

                        SpacerSmall()

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                8.dp,
                                Alignment.CenterHorizontally
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = "Plan",
                                color = Color(0xff505f76),
                                fontSize = 14.sp
                            )

                            Badge(
                                containerColor = Color(0xff1171e3)
                            )

                            Text(
                                text = "Study",
                                color = Color(0xff505f76),
                                fontSize = 14.sp
                            )

                            Badge(
                                containerColor = Color(0xff1171e3)
                            )

                            Text(
                                text = "Achieve",
                                color = Color(0xff505f76),
                                fontSize = 14.sp
                            )
                        }
                    }
                }

                // Glow background
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(
                            x = 43.dp,
                            y = (-40).dp
                        )
                        .requiredSize(256.dp)
                        .clip(RoundedCornerShape(9999.dp))
                        .blur(64.dp)
                        .background(
                            Color(0xffd7e2ff).copy(alpha = 0.4f)
                        )
                )
            }

            // =========================
            // ILLUSTRATION
            // =========================

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xfff3f2ff),
                    modifier = Modifier
                        .requiredWidth(320.dp)
                        .requiredHeight(240.dp)
                        .shadow(
                            elevation = 2.dp,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {

                        Image(
                            painter = painterResource(
                                id = R.drawable.svg
                            ),
                            contentDescription = "StudyTrack Illustration",
                            modifier = Modifier
                                .requiredSize(176.dp)
                                .shadow(3.dp)
                        )

                        // Glow kanan atas
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .offset(
                                    x = 32.dp,
                                    y = (-32).dp
                                )
                                .requiredSize(128.dp)
                                .clip(RoundedCornerShape(9999.dp))
                                .blur(24.dp)
                                .background(
                                    Color(0xffd0e1fb).copy(alpha = 0.6f)
                                )
                        )

                        // Glow kiri bawah
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .offset(
                                    x = (-24).dp,
                                    y = 24.dp
                                )
                                .requiredSize(112.dp)
                                .clip(RoundedCornerShape(9999.dp))
                                .blur(16.dp)
                                .background(
                                    Color(0xffd7e2ff).copy(alpha = 0.5f)
                                )
                        )
                    }
                }

                // =========================
                // FEATURE CARDS
                // =========================

                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        8.dp,
                        Alignment.CenterHorizontally
                    ),
                    modifier = Modifier
                        .requiredWidth(320.dp)
                        .padding(top = 16.dp)
                ) {

                    FeatureCard(
                        title = "Smart Sync"
                    )

                    FeatureCard(
                        title = "Focus Flow"
                    )

                    FeatureCard(
                        title = "GPA Trends"
                    )
                }
            }

            // =========================
            // BUTTON & LOGIN
            // =========================

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {

                // Get Started
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xff1171e3),
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(52.dp)
                        .shadow(
                            elevation = 4.dp,
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {

                        Text(
                            text = "Get Started  →",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }

                // Login
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 26.dp,
                            bottom = 10.dp
                        )
                ) {

                    Text(
                        text = "Already have an account? ",
                        color = Color(0xff414753),
                        fontSize = 14.sp
                    )

                    Text(
                        text = "Log in",
                        color = Color(0xff0059b8),
                        fontSize = 14.sp
                    )
                }

                // Footer
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        6.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 16.dp)
                ) {

                    Text(
                        text = "◆",
                        color = Color(0xff0059b8),
                        fontSize = 12.sp
                    )

                    Text(
                        text = "DESIGNED FOR 140+ UNIVERSITIES",
                        color = Color(0xff505f76),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.25.sp
                    )
                }
            }
        }
    }
}

// =====================================
// FEATURE CARD
// =====================================

@Composable
fun FeatureCard(
    title: String,
    modifier: Modifier = Modifier
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .requiredWidth(101.dp)
            .requiredHeight(82.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(10.dp)
    ) {

        Image(
            painter = painterResource(
                id = R.drawable.icon
            ),
            contentDescription = title,
            modifier = Modifier
                .requiredWidth(18.dp)
                .requiredHeight(18.dp)
        )

        Text(
            text = title,
            color = Color(0xff071747),
            textAlign = TextAlign.Center,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

// =====================================
// SPACER
// =====================================

@Composable
private fun SpacerSmall() {
    Box(
        modifier = Modifier
            .requiredHeight(6.dp)
    )
}

// =====================================
// PREVIEW
// =====================================

@Preview(
    widthDp = 358,
    heightDp = 907,
    showBackground = true
)
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen()
}