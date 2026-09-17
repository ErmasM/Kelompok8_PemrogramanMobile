package com.kelompok8.studytrack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
fun Frame(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 390.dp)
            .requiredHeight(height = 969.dp)
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
                        bottom = 25.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .requiredWidth(width = 30.dp)
                                        .requiredHeight(height = 32.dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color(0xff1171e3))
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color.White))
                                }
                                Column() {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "Assignment Details",
                                            color = Color(0xff071747),
                                            lineHeight = 1.33.em,
                                            style = TextStyle(
                                                fontSize = 18.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "Keep your semester deliverables on\nschedule",
                                            color = Color(0xff414753),
                                            lineHeight = 1.33.em,
                                            style = TextStyle(
                                                fontSize = 12.sp,
                                                letterSpacing = 0.24.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                            }
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .padding(horizontal = 8.dp,
                                        vertical = 4.dp)
                            ) {
                                Text(
                                    text = "Cancel",
                                    color = Color(0xff505f76),
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.43.em,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        letterSpacing = 0.14.sp),
                                    modifier = Modifier
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Column() {
                                    Text(
                                        text = "Task Title",
                                        color = Color(0xff0059b8),
                                        lineHeight = 1.33.em,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            letterSpacing = 0.24.sp),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                                Column() {
                                    Text(
                                        text = "*",
                                        color = Color(0xffba1a1a),
                                        lineHeight = 1.33.em,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            letterSpacing = 0.24.sp),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .background(color = Color.White)
                                    .shadow(elevation = 8.dp,
                                        shape = RoundedCornerShape(12.dp))
                            ) {
                                Column(
                                    modifier = Modifier
                                        .requiredHeight(height = 52.dp)
                                        .weight(weight = 1f)
                                        .padding(horizontal = 16.dp,
                                            vertical = 15.5.dp)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "Cryptography Assignment 2",
                                            color = Color(0xff071747),
                                            style = TextStyle(
                                                fontSize = 16.sp),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                                Image(
                                    painter = painterResource(id = R.drawable.container),
                                    contentDescription = "Container",
                                    colorFilter = ColorFilter.tint(Color(0xff0059b8)),
                                    modifier = Modifier
                                        .padding(end = 16.dp,
                                            bottom = 4.dp))
                            }
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Column() {
                                    Text(
                                        text = "Course",
                                        color = Color(0xff0059b8),
                                        lineHeight = 1.33.em,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            letterSpacing = 0.24.sp),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                                Column() {
                                    Text(
                                        text = "*",
                                        color = Color(0xffba1a1a),
                                        lineHeight = 1.33.em,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            letterSpacing = 0.24.sp),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                            }
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = Color.White,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .shadow(elevation = 8.dp,
                                        shape = RoundedCornerShape(12.dp))
                            ) {
                                Box(
                                    modifier = Modifier
                                        .requiredWidth(width = 358.dp)
                                        .requiredHeight(height = 52.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredWidth(width = 358.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .requiredHeight(height = 52.dp)
                                                .padding(start = 44.dp,
                                                    end = 40.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Cryptography & Network Security (CS-402)",
                                                    color = Color(0xff071747),
                                                    lineHeight = 1.38.em,
                                                    style = TextStyle(
                                                        fontSize = 16.sp),
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                    }
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff505f76)),
                                        modifier = Modifier
                                            .align(alignment = Alignment.TopEnd)
                                            .offset(x = (-16).dp,
                                                y = 0.dp)
                                            .fillMaxHeight())
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .align(alignment = Alignment.TopStart)
                                            .offset(x = 16.dp,
                                                y = 0.dp)
                                            .fillMaxHeight()
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.container),
                                            contentDescription = "Container",
                                            colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                    }
                                }
                            }
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(125.72.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Column() {
                                    Text(
                                        text = "Description & Notes",
                                        color = Color(0xff414753),
                                        lineHeight = 1.33.em,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Medium,
                                            letterSpacing = 0.24.sp),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                                Column() {
                                    Text(
                                        text = "Markdown supported",
                                        color = Color(0xff505f76),
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
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .background(color = Color.White)
                                    .padding(start = 12.dp,
                                        end = 12.dp,
                                        top = 12.dp,
                                        bottom = 16.dp)
                                    .shadow(elevation = 8.dp,
                                        shape = RoundedCornerShape(12.dp))
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .requiredHeight(height = 60.dp)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "Implement RSA and Diffie-Hellman key exchange \nprotocols in Python. Include unit tests with edge-\ncase prime vectors and submit PDF proof along \nwith GitHub repository link.",
                                            color = Color(0xff071747),
                                            lineHeight = 1.43.em,
                                            style = TextStyle(
                                                fontSize = 14.sp),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                            }
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Priority Level",
                                    color = Color(0xff414753),
                                    lineHeight = 1.33.em,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = 0.24.sp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .requiredHeight(height = 44.dp)
                                        .clip(shape = RoundedCornerShape(12.dp))
                                        .background(color = Color.White)
                                        .padding(start = 36.40999984741211.dp,
                                            end = 36.41999816894531.dp)
                                        .shadow(elevation = 4.dp,
                                            shape = RoundedCornerShape(12.dp))
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredSize(size = 10.dp)
                                            .clip(shape = RoundedCornerShape(9999.dp))
                                            .background(color = Color(0xff006947)))
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "Low",
                                            color = Color(0xff071747),
                                            textAlign = TextAlign.Center,
                                            lineHeight = 1.33.em,
                                            style = TextStyle(
                                                fontSize = 12.sp,
                                                letterSpacing = 0.24.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .requiredHeight(height = 44.dp)
                                        .clip(shape = RoundedCornerShape(12.dp))
                                        .background(color = Color.White)
                                        .padding(start = 24.829999923706055.dp,
                                            end = 24.84000015258789.dp)
                                        .shadow(elevation = 4.dp,
                                            shape = RoundedCornerShape(12.dp))
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredSize(size = 10.dp)
                                            .clip(shape = RoundedCornerShape(9999.dp))
                                            .background(color = Color(0xfff59e0b)))
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "Medium",
                                            color = Color(0xff071747),
                                            textAlign = TextAlign.Center,
                                            lineHeight = 1.33.em,
                                            style = TextStyle(
                                                fontSize = 12.sp,
                                                letterSpacing = 0.24.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .requiredHeight(height = 44.dp)
                                        .clip(shape = RoundedCornerShape(12.dp))
                                        .background(color = Color(0xffffdad6))
                                        .padding(start = 25.1299991607666.dp,
                                            end = 25.139999389648438.dp)
                                        .shadow(elevation = 8.dp,
                                            shape = RoundedCornerShape(12.dp))
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xffba1a1a)))
                                    Box(
                                        modifier = Modifier
                                            .requiredSize(size = 8.dp)
                                            .clip(shape = RoundedCornerShape(9999.dp))
                                            .background(color = Color(0xffba1a1a)))
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "High",
                                            color = Color(0xff93000a),
                                            textAlign = TextAlign.Center,
                                            lineHeight = 1.33.em,
                                            style = TextStyle(
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold,
                                                letterSpacing = 0.24.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                            }
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Due Date & Time",
                                    color = Color(0xff414753),
                                    lineHeight = 1.33.em,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = 0.24.sp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .weight(weight = 0.5f)
                                        .clip(shape = RoundedCornerShape(12.dp))
                                        .background(color = Color.White)
                                        .shadow(elevation = 8.dp,
                                            shape = RoundedCornerShape(12.dp))
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .padding(start = 12.dp,
                                                end = 4.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.container),
                                            contentDescription = "Container",
                                            colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                    }
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .requiredHeight(height = 48.dp)
                                            .padding(end = 8.dp,
                                                top = 15.dp,
                                                bottom = 15.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Text(
                                                text = "Sep 17, 2026",
                                                color = Color(0xff071747),
                                                style = TextStyle(
                                                    fontSize = 14.sp,
                                                    letterSpacing = 0.14.sp),
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                    }
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .weight(weight = 0.5f)
                                        .clip(shape = RoundedCornerShape(12.dp))
                                        .background(color = Color.White)
                                        .shadow(elevation = 8.dp,
                                            shape = RoundedCornerShape(12.dp))
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .padding(start = 12.dp,
                                                end = 4.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.container),
                                            contentDescription = "Container",
                                            colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                    }
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .requiredHeight(height = 48.dp)
                                            .padding(end = 8.dp,
                                                top = 15.dp,
                                                bottom = 15.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Text(
                                                text = "11:59 PM",
                                                color = Color(0xff071747),
                                                style = TextStyle(
                                                    fontSize = 14.sp,
                                                    letterSpacing = 0.14.sp),
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                    }
                                }
                            }
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Status",
                                    color = Color(0xff414753),
                                    lineHeight = 1.33.em,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = 0.24.sp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .requiredHeight(height = 40.dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color.White)
                                        .padding(start = 21.84000015258789.dp,
                                            end = 21.860000610351562.dp,
                                            top = 11.5.dp,
                                            bottom = 12.5.dp)
                                        .shadow(elevation = 2.dp,
                                            shape = RoundedCornerShape(9999.dp))
                                ) {
                                    Text(
                                        text = "Not Started",
                                        color = Color(0xff505f76),
                                        textAlign = TextAlign.Center,
                                        lineHeight = 1.33.em,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            letterSpacing = 0.24.sp),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                                Surface(
                                    shape = RoundedCornerShape(9999.dp),
                                    color = Color(0xff0059b8),
                                    modifier = Modifier
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .shadow(elevation = 4.dp,
                                            shape = RoundedCornerShape(9999.dp))
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredWidth(width = 109.dp)
                                            .requiredHeight(height = 40.dp)
                                            .shadow(elevation = 4.dp)
                                    ) {
                                        Box(
                                            contentAlignment = Alignment.Center,
                                            modifier = Modifier
                                                .requiredHeight(height = 40.dp)
                                                .padding(start = 13.579999923706055.dp,
                                                    end = 13.59000015258789.dp)
                                        ) {
                                            Column(
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Text(
                                                    text = "In Progress",
                                                    color = Color.White,
                                                    textAlign = TextAlign.Center,
                                                    lineHeight = 1.33.em,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        letterSpacing = 0.24.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color.White))
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .requiredHeight(height = 40.dp)
                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                .background(color = Color.White)
                                                .shadow(elevation = 4.dp,
                                                    shape = RoundedCornerShape(9999.dp)))
                                    }
                                }
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .requiredHeight(height = 40.dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color.White)
                                        .padding(start = 22.639999389648438.dp,
                                            end = 22.65999984741211.dp,
                                            top = 11.5.dp,
                                            bottom = 12.5.dp)
                                        .shadow(elevation = 2.dp,
                                            shape = RoundedCornerShape(9999.dp))
                                ) {
                                    Text(
                                        text = "Completed",
                                        color = Color(0xff505f76),
                                        textAlign = TextAlign.Center,
                                        lineHeight = 1.33.em,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            letterSpacing = 0.24.sp),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                            }
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(133.91.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Column() {
                                    Text(
                                        text = "Attachment & Documents",
                                        color = Color(0xff414753),
                                        lineHeight = 1.33.em,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Medium,
                                            letterSpacing = 0.24.sp),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff006947)))
                                    Text(
                                        text = "Encrypted",
                                        color = Color(0xff006947),
                                        lineHeight = 1.4.em,
                                        style = TextStyle(
                                            fontSize = 10.sp,
                                            letterSpacing = 0.4.sp),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                            }
                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .background(color = Color(0xfff3f2ff))
                                    .padding(all = 16.dp)
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(16.dp))
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .requiredSize(size = 48.dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color(0xffd0e1fb))
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff54647a)))
                                }
                                Column() {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "Tap to attach files or photos",
                                            color = Color(0xff071747),
                                            textAlign = TextAlign.Center,
                                            lineHeight = 1.38.em,
                                            style = TextStyle(
                                                fontSize = 16.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "PDF, PNG, DOCX up to 10MB",
                                            color = Color(0xff414753),
                                            textAlign = TextAlign.Center,
                                            lineHeight = 1.33.em,
                                            style = TextStyle(
                                                fontSize = 12.sp,
                                                letterSpacing = 0.24.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(12.dp))
                                        .background(color = Color.White)
                                        .padding(horizontal = 12.dp,
                                            vertical = 8.dp)
                                        .shadow(elevation = 2.dp,
                                            shape = RoundedCornerShape(12.dp))
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                    Column(
                                        modifier = Modifier
                                            .weight(weight = 1f)
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Text(
                                                text = "lab_crypto_spec_v2.pdf",
                                                color = Color(0xff071747),
                                                lineHeight = 1.33.em,
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    letterSpacing = 0.24.sp),
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Text(
                                                text = "2.4 MB • Uploaded",
                                                color = Color(0xff414753),
                                                lineHeight = 1.4.em,
                                                style = TextStyle(
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    letterSpacing = 0.4.sp),
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .clip(shape = RoundedCornerShape(9999.dp))
                                            .padding(start = 4.dp,
                                                end = 4.dp,
                                                top = 4.dp,
                                                bottom = 8.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.container),
                                            contentDescription = "Container",
                                            colorFilter = ColorFilter.tint(Color(0xff505f76)))
                                    }
                                }
                            }
                        }
                        CenterAlignedTopAppBar(
                            title = {
                                Surface(
                                    shape = RoundedCornerShape(9999.dp),
                                    color = Color(0xff0059b8),
                                    modifier = Modifier
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .shadow(elevation = 6.dp,
                                            shape = RoundedCornerShape(9999.dp))
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredWidth(width = 358.dp)
                                            .requiredHeight(height = 52.dp)
                                            .shadow(elevation = 6.dp)
                                    ) {
                                        Box(
                                            contentAlignment = Alignment.Center,
                                            modifier = Modifier
                                                .requiredWidth(width = 358.dp)
                                                .requiredHeight(height = 52.dp)
                                        ) {
                                            Column(
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Text(
                                                    text = "Save Task",
                                                    color = Color.White,
                                                    textAlign = TextAlign.Center,
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        letterSpacing = 0.14.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color.White))
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .requiredHeight(height = 52.dp)
                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                .background(color = Color.White)
                                                .shadow(elevation = 6.dp,
                                                    shape = RoundedCornerShape(9999.dp)))
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
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
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
                                colorFilter = ColorFilter.tint(Color(0xff071747)))
                        }
                        Image(
                            painter = painterResource(id = R.drawable.studytracklogo),
                            contentDescription = "StudyTrack Logo",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .requiredSize(size = 32.dp))
                        Column(
                            modifier = Modifier
                                .padding(start = 4.dp)
                        ) {
                            Column() {
                                Text(
                                    text = "Add Task",
                                    color = Color(0xff071747),
                                    lineHeight = 1.33.em,
                                    style = TextStyle(
                                        fontSize = 18.sp),
                                    modifier = Modifier
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                        }
                    }
                },
                actions = {
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
                })
        }
    }
}

@Preview(widthDp = 390, heightDp = 969)
@Composable
private fun FramePreview() {
    Frame(Modifier)
}