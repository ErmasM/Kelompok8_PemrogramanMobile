package com.kelompok8.studytrack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun Profil(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 390.dp)
            .requiredHeight(height = 1143.dp)
            .background(color = Color(0xfffaf8ff))
    ) {
        Column(
            modifier = Modifier
                .requiredWidth(width = 390.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xfffaf8ff))
                    .padding(start = 16.dp,
                        end = 16.dp,
                        bottom = 80.dp)
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                ) {
                    item {
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = Color.White,
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(16.dp))
                                .shadow(elevation = 12.dp,
                                    shape = RoundedCornerShape(16.dp))
                        ) {
                            Box(
                                modifier = Modifier
                                    .requiredWidth(width = 358.dp)
                                    .requiredHeight(height = 329.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .requiredWidth(width = 358.dp)
                                        .padding(all = 20.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .requiredSize(size = 220.dp)
                                            ) {
                                                Column() {
                                                    Column(
                                                        verticalArrangement = Arrangement.Center,
                                                        modifier = Modifier
                                                            .clip(shape = RoundedCornerShape(9999.dp))
                                                            .background(brush = Brush.linearGradient(
                                                                0f to Color(0xff0059b8),
                                                                1f to Color(0xff6ffbbe),
                                                                start = Offset(0f, 220.34f),
                                                                end = Offset(220.34f, 0f)))
                                                            .padding(all = 2.dp)
                                                    ) {
                                                        Box(
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                                .requiredHeight(height = 216.dp)
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffebedff)))
                                                    }
                                                }
                                                Row(
                                                    horizontalArrangement = Arrangement.Center,
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .align(alignment = Alignment.BottomEnd)
                                                        .offset(x = 4.dp,
                                                            y = 4.dp)
                                                        .requiredSize(size = 24.dp)
                                                        .clip(shape = RoundedCornerShape(9999.dp))
                                                        .background(color = Color(0xff0059b8))
                                                        .shadow(elevation = 2.dp,
                                                            shape = RoundedCornerShape(9999.dp))
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.container),
                                                        contentDescription = "Container",
                                                        colorFilter = ColorFilter.tint(Color.White))
                                                }
                                            }
                                            Column() {
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Column(
                                                        modifier = Modifier
                                                            .requiredWidth(width = 31.dp)
                                                    ) {
                                                        Text(
                                                            text = "Alex",
                                                            color = Color(0xff071747),
                                                            lineHeight = 1.27.em,
                                                            style = TextStyle(
                                                                fontSize = 22.sp,
                                                                fontWeight = FontWeight.Bold),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                    InputChip(
                                                        label = {
                                                            Text(
                                                                text = "CS\n'26",
                                                                color = Color(0xff006947),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        },
                                                        leadingIcon = {
                                                            Image(
                                                                painter = painterResource(id = R.drawable.container),
                                                                contentDescription = "Container",
                                                                colorFilter = ColorFilter.tint(Color(0xff006947)))
                                                        },
                                                        shape = RoundedCornerShape(9999.dp),
                                                        colors = FilterChipDefaults.filterChipColors(
                                                            containerColor = Color(0xff00855b).copy(alpha = 0.15f)
                                                        ),
                                                        selected = true,
                                                        onClick = { })
                                                }
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Text(
                                                        text = "alex@student.ac.id",
                                                        color = Color(0xff505f76),
                                                        lineHeight = 1.43.em,
                                                        style = TextStyle(
                                                            fontSize = 14.sp),
                                                        modifier = Modifier
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(top = 2.dp)
                                                ) {
                                                    Spacer(
                                                        modifier = Modifier
                                                            .fillMaxWidth())
                                                }
                                            }
                                        }
                                    }
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(53.81.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 16.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff006947)))
                                            Column() {
                                                Text(
                                                    text = "Active Enrolled Status",
                                                    color = Color(0xff414753),
                                                    lineHeight = 1.4.em,
                                                    style = TextStyle(
                                                        fontSize = 10.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        letterSpacing = 0.4.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                        InputChip(
                                            label = {
                                                Text(
                                                    text = "Edit Profile",
                                                    color = Color(0xff0059b8),
                                                    textAlign = TextAlign.Center,
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp,
                                                        letterSpacing = 0.14.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            },
                                            leadingIcon = {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                            },
                                            shape = RoundedCornerShape(9999.dp),
                                            colors = FilterChipDefaults.filterChipColors(
                                                containerColor = Color(0xffebedff)
                                            ),
                                            selected = true,
                                            onClick = { })
                                    }
                                }
                                Box(
                                    modifier = Modifier
                                        .align(alignment = Alignment.TopEnd)
                                        .offset(x = 24.dp,
                                            y = (-24).dp)
                                        .requiredSize(size = 128.dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .blur(radius = 40.dp)
                                        .background(color = Color(0xffd0e1fb).copy(alpha = 0.4f)))
                            }
                        }
                    }
                    item {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(16.dp))
                                .background(color = Color.White)
                                .padding(all = 16.dp)
                                .shadow(elevation = 12.dp,
                                    shape = RoundedCornerShape(16.dp))
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .requiredWidth(width = 109.dp)
                                    .padding(horizontal = 8.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "12",
                                            color = Color(0xff0059b8),
                                            textAlign = TextAlign.Center,
                                            lineHeight = 1.27.em,
                                            style = MaterialTheme.typography.titleLarge,
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                                Column(
                                    modifier = Modifier
                                        .padding(top = 2.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "TASKS DUE",
                                            color = Color(0xff505f76),
                                            textAlign = TextAlign.Center,
                                            lineHeight = 1.4.em,
                                            style = TextStyle(
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                letterSpacing = 0.5.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                            }
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .requiredWidth(width = 109.dp)
                                    .padding(horizontal = 8.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "5",
                                            color = Color(0xff071747),
                                            textAlign = TextAlign.Center,
                                            lineHeight = 1.27.em,
                                            style = MaterialTheme.typography.titleLarge,
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                                Column(
                                    modifier = Modifier
                                        .padding(top = 2.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "COURSES",
                                            color = Color(0xff505f76),
                                            textAlign = TextAlign.Center,
                                            lineHeight = 1.4.em,
                                            style = TextStyle(
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                letterSpacing = 0.5.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                            }
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .requiredWidth(width = 109.dp)
                                    .padding(horizontal = 8.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff006947)))
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "3.82",
                                            color = Color(0xff006947),
                                            textAlign = TextAlign.Center,
                                            lineHeight = 1.27.em,
                                            style = MaterialTheme.typography.titleLarge,
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                                Column(
                                    modifier = Modifier
                                        .padding(top = 2.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "CUM. GPA",
                                            color = Color(0xff505f76),
                                            textAlign = TextAlign.Center,
                                            lineHeight = 1.4.em,
                                            style = TextStyle(
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                letterSpacing = 0.5.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                            }
                        }
                    }
                    item {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp)
                            ) {
                                Text(
                                    text = "PREFERENCES & ACADEMIC",
                                    color = Color(0xff505f76),
                                    lineHeight = 1.33.em,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.6.sp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .background(color = Color.White)
                                    .shadow(elevation = 12.dp,
                                        shape = RoundedCornerShape(16.dp))
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 16.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .requiredSize(size = 40.dp)
                                                .clip(shape = RoundedCornerShape(12.dp))
                                                .background(color = Color(0xffd0e1fb))
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                        }
                                        Column() {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Study Goals",
                                                    color = Color(0xff071747),
                                                    lineHeight = 1.38.em,
                                                    style = TextStyle(
                                                        fontSize = 16.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Set weekly study hours and target grades",
                                                    color = Color(0xff505f76),
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                    }
                                    Column(
                                        modifier = Modifier
                                            .padding(start = 8.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                                    .background(color = Color(0xffd7e2ff))
                                                    .padding(horizontal = 8.dp,
                                                        vertical = 2.dp)
                                            ) {
                                                Text(
                                                    text = "24h/wk",
                                                    color = Color(0xff004591),
                                                    lineHeight = 1.4.em,
                                                    style = TextStyle(
                                                        fontSize = 10.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        letterSpacing = 0.4.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff727785)))
                                        }
                                    }
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .requiredHeight(height = 1.dp)
                                        .padding(horizontal = 16.dp)
                                ) {
                                    Divider(
                                        color = Color(0xfff3f2ff),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .requiredHeight(height = 1.dp))
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(36.5.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 16.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .requiredSize(size = 40.dp)
                                                .clip(shape = RoundedCornerShape(12.dp))
                                                .background(color = Color(0xffd0e1fb))
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                        }
                                        Column() {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Notification Settings",
                                                    color = Color(0xff071747),
                                                    lineHeight = 1.38.em,
                                                    style = TextStyle(
                                                        fontSize = 16.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Daily reminders, deadline alerts",
                                                    color = Color(0xff505f76),
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                    }
                                    Image(
                                        painter = painterResource(id = R.drawable.margin),
                                        contentDescription = "Margin",
                                        colorFilter = ColorFilter.tint(Color(0xff727785)),
                                        modifier = Modifier
                                            .padding(start = 8.dp))
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .requiredHeight(height = 1.dp)
                                        .padding(horizontal = 16.dp)
                                ) {
                                    Divider(
                                        color = Color(0xfff3f2ff),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .requiredHeight(height = 1.dp))
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 16.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .requiredSize(size = 40.dp)
                                                .clip(shape = RoundedCornerShape(12.dp))
                                                .background(color = Color(0xffd0e1fb))
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                        }
                                        Column() {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Appearance",
                                                    color = Color(0xff071747),
                                                    lineHeight = 1.38.em,
                                                    style = TextStyle(
                                                        fontSize = 16.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Theme selection and layout",
                                                    color = Color(0xff505f76),
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                    }
                                    Column(
                                        modifier = Modifier
                                            .padding(start = 8.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                                    .background(color = Color(0xffebedff))
                                                    .padding(horizontal = 10.dp,
                                                        vertical = 4.dp)
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                                Text(
                                                    text = "Light",
                                                    color = Color(0xff071747),
                                                    lineHeight = 1.4.em,
                                                    style = TextStyle(
                                                        fontSize = 10.sp,
                                                        letterSpacing = 0.4.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff727785)))
                                        }
                                    }
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .requiredHeight(height = 1.dp)
                                        .padding(horizontal = 16.dp)
                                ) {
                                    Divider(
                                        color = Color(0xfff3f2ff),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .requiredHeight(height = 1.dp))
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(2.72.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 16.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .requiredSize(size = 40.dp)
                                                .clip(shape = RoundedCornerShape(12.dp))
                                                .background(color = Color(0xffd0e1fb))
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                        }
                                        Column() {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Course Preferences",
                                                    color = Color(0xff071747),
                                                    lineHeight = 1.38.em,
                                                    style = TextStyle(
                                                        fontSize = 16.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Term dates, academic calendar sync",
                                                    color = Color(0xff505f76),
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                    }
                                    Image(
                                        painter = painterResource(id = R.drawable.margin),
                                        contentDescription = "Margin",
                                        colorFilter = ColorFilter.tint(Color(0xff727785)),
                                        modifier = Modifier
                                            .padding(start = 8.dp))
                                }
                            }
                        }
                    }
                    item {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp)
                            ) {
                                Text(
                                    text = "SUPPORT & LEGAL",
                                    color = Color(0xff505f76),
                                    lineHeight = 1.33.em,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.6.sp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .background(color = Color.White)
                                    .shadow(elevation = 12.dp,
                                        shape = RoundedCornerShape(16.dp))
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 16.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .requiredSize(size = 40.dp)
                                                .clip(shape = RoundedCornerShape(12.dp))
                                                .background(color = Color(0xffd0e1fb))
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                        }
                                        Column() {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Help & Support",
                                                    color = Color(0xff071747),
                                                    lineHeight = 1.38.em,
                                                    style = TextStyle(
                                                        fontSize = 16.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Student guides, FAQ, contact support",
                                                    color = Color(0xff505f76),
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                    }
                                    Image(
                                        painter = painterResource(id = R.drawable.margin),
                                        contentDescription = "Margin",
                                        colorFilter = ColorFilter.tint(Color(0xff727785)),
                                        modifier = Modifier
                                            .padding(start = 8.dp))
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .requiredHeight(height = 1.dp)
                                        .padding(horizontal = 16.dp)
                                ) {
                                    Divider(
                                        color = Color(0xfff3f2ff),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .requiredHeight(height = 1.dp))
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 16.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .requiredSize(size = 40.dp)
                                                .clip(shape = RoundedCornerShape(12.dp))
                                                .background(color = Color(0xffd0e1fb))
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                        }
                                        Column() {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "About StudyTrack",
                                                    color = Color(0xff071747),
                                                    lineHeight = 1.38.em,
                                                    style = TextStyle(
                                                        fontSize = 16.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Version 2.4.0 (Build 512) • Privacy Policy",
                                                    color = Color(0xff505f76),
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                    }
                                    Image(
                                        painter = painterResource(id = R.drawable.margin),
                                        contentDescription = "Margin",
                                        colorFilter = ColorFilter.tint(Color(0xff727785)),
                                        modifier = Modifier
                                            .padding(start = 8.dp))
                                }
                            }
                        }
                    }
                    item {
                        CenterAlignedTopAppBar(
                            title = {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .clip(shape = RoundedCornerShape(16.dp))
                                        .background(color = Color(0xffffdad6).copy(alpha = 0.3f))
                                        .padding(horizontal = 16.dp,
                                            vertical = 14.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xffba1a1a)))
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "Logout",
                                            color = Color(0xffba1a1a),
                                            textAlign = TextAlign.Center,
                                            lineHeight = 1.38.em,
                                            style = TextStyle(
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Bold),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                            })
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .requiredWidth(width = 390.dp)
                .background(color = Color(0xfffaf8ff).copy(alpha = 0.8f))
                .shadow(elevation = 8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(162.84.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(height = 64.dp)
                    .padding(horizontal = 16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.studytracklogo),
                        contentDescription = "StudyTrack Logo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .requiredSize(size = 32.dp))
                    Column() {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "STUDYTRACK",
                                color = Color(0xff0059b8),
                                lineHeight = 1.4.em,
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 0.5.sp),
                                modifier = Modifier
                                    .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Profile",
                                color = Color(0xff071747),
                                lineHeight = 1.25.em,
                                style = TextStyle(
                                    fontSize = 18.sp),
                                modifier = Modifier
                                    .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .requiredSize(size = 44.dp)
                            .clip(shape = RoundedCornerShape(9999.dp))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.container),
                            contentDescription = "Container",
                            colorFilter = ColorFilter.tint(Color(0xff414753)))
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .requiredSize(size = 32.dp)
                            .clip(shape = RoundedCornerShape(9999.dp))
                            .background(color = Color(0xff0059b8))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.container),
                            contentDescription = "Container",
                            colorFilter = ColorFilter.tint(Color.White))
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .align(alignment = Alignment.BottomStart)
                .offset(x = 0.dp,
                    y = 0.dp)
                .requiredWidth(width = 390.dp)
                .background(color = Color(0xfffaf8ff).copy(alpha = 0.9f))
                .padding(bottom = 80.dp)
                .shadow(elevation = 12.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.4.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(height = 80.dp)
                    .padding(horizontal = 4.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .requiredWidth(width = 64.dp)
                            .requiredHeight(height = 32.dp)
                            .clip(shape = RoundedCornerShape(9999.dp))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.container),
                            contentDescription = "Container",
                            colorFilter = ColorFilter.tint(Color(0xff414753)))
                    }
                    Column() {
                        Text(
                            text = "Home",
                            color = Color(0xff414753),
                            lineHeight = 1.4.em,
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.4.sp),
                            modifier = Modifier
                                .wrapContentHeight(align = Alignment.CenterVertically))
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .requiredWidth(width = 64.dp)
                            .requiredHeight(height = 32.dp)
                            .clip(shape = RoundedCornerShape(9999.dp))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.container),
                            contentDescription = "Container",
                            colorFilter = ColorFilter.tint(Color(0xff414753)))
                    }
                    Column() {
                        Text(
                            text = "Tasks",
                            color = Color(0xff414753),
                            lineHeight = 1.4.em,
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.4.sp),
                            modifier = Modifier
                                .wrapContentHeight(align = Alignment.CenterVertically))
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .requiredWidth(width = 64.dp)
                            .requiredHeight(height = 32.dp)
                            .clip(shape = RoundedCornerShape(9999.dp))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.container),
                            contentDescription = "Container",
                            colorFilter = ColorFilter.tint(Color(0xff414753)))
                    }
                    Column() {
                        Text(
                            text = "Calendar",
                            color = Color(0xff414753),
                            lineHeight = 1.4.em,
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.4.sp),
                            modifier = Modifier
                                .wrapContentHeight(align = Alignment.CenterVertically))
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .requiredWidth(width = 64.dp)
                            .requiredHeight(height = 32.dp)
                            .clip(shape = RoundedCornerShape(9999.dp))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.container),
                            contentDescription = "Container",
                            colorFilter = ColorFilter.tint(Color(0xff414753)))
                    }
                    Column() {
                        Text(
                            text = "Analytics",
                            color = Color(0xff414753),
                            lineHeight = 1.4.em,
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.4.sp),
                            modifier = Modifier
                                .wrapContentHeight(align = Alignment.CenterVertically))
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .requiredWidth(width = 64.dp)
                            .requiredHeight(height = 32.dp)
                            .clip(shape = RoundedCornerShape(9999.dp))
                            .background(color = Color(0xffd0e1fb))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.container),
                            contentDescription = "Container",
                            colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                    }
                    Column() {
                        Text(
                            text = "Profile",
                            color = Color(0xff0059b8),
                            lineHeight = 1.4.em,
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.4.sp),
                            modifier = Modifier
                                .wrapContentHeight(align = Alignment.CenterVertically))
                    }
                }
            }
        }
    }
}

@Preview(widthDp = 390, heightDp = 1143)
@Composable
private fun ProfilPreview() {
    Profil(Modifier)
}