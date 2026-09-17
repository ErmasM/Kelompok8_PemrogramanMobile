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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
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
            .requiredHeight(height = 1450.dp)
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
                        bottom = 24.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(height = 1426.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(48.74.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column() {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        text = "Fall Semester",
                                        color = Color(0xff071747),
                                        lineHeight = 1.27.em,
                                        style = TextStyle(
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.Bold),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        text = "5 Active Modules • 18 Credits",
                                        color = Color(0xff505f76),
                                        lineHeight = 1.33.em,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            letterSpacing = 0.24.sp),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .requiredHeight(height = 40.dp)
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .background(color = Color(0xff0059b8))
                                    .padding(horizontal = 16.dp)
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(9999.dp))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.container),
                                    contentDescription = "Container",
                                    colorFilter = ColorFilter.tint(Color.White))
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Add Course",
                                        color = Color.White,
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
                    }
                    Column(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 0.dp,
                                y = 60.dp)
                            .fillMaxWidth()
                            .padding(bottom = 20.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .requiredHeight(height = 48.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .requiredWidth(width = 358.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .requiredHeight(height = 48.dp)
                                        .clip(shape = RoundedCornerShape(12.dp))
                                        .background(color = Color.White)
                                        .padding(start = 44.dp,
                                            end = 40.dp,
                                            top = 15.dp,
                                            bottom = 15.dp)
                                        .shadow(elevation = 2.dp,
                                            shape = RoundedCornerShape(12.dp))
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "Search courses or lecturers...",
                                            color = Color(0xff505f76),
                                            style = TextStyle(
                                                fontSize = 14.sp),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(start = 16.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.container),
                                    contentDescription = "Container",
                                    colorFilter = ColorFilter.tint(Color(0xff505f76)))
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 0.dp,
                                y = 128.dp)
                            .fillMaxWidth()
                            .padding(bottom = 20.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .weight(weight = 0.33f)
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .background(color = Color.White)
                                    .padding(all = 12.dp)
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(12.dp))
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "60%",
                                        color = Color(0xff0059b8),
                                        textAlign = TextAlign.Center,
                                        lineHeight = 1.27.em,
                                        style = TextStyle(
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.Bold),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "AVG PROGRESS",
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
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .weight(weight = 0.33f)
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .background(color = Color.White)
                                    .padding(all = 12.dp)
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(12.dp))
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "6",
                                        color = Color(0xff071747),
                                        textAlign = TextAlign.Center,
                                        lineHeight = 1.27.em,
                                        style = TextStyle(
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.Bold),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "DEADLINES",
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
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .weight(weight = 0.33f)
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .background(color = Color.White)
                                    .padding(all = 12.dp)
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(12.dp))
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "3.88",
                                        color = Color(0xff006947),
                                        textAlign = TextAlign.Center,
                                        lineHeight = 1.27.em,
                                        style = TextStyle(
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.Bold),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "EST. GPA",
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
                    Column(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 0.dp,
                                y = 214.dp)
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .requiredHeight(height = 32.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterStart)
                                    .offset(x = 0.dp,
                                        y = (-4).dp)
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .background(color = Color(0xffd0e1fb))
                                    .padding(horizontal = 16.dp,
                                        vertical = 4.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.container),
                                    contentDescription = "Container",
                                    colorFilter = ColorFilter.tint(Color(0xff0b1c30)))
                                Text(
                                    text = "All Courses",
                                    color = Color(0xff0b1c30),
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.33.em,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        letterSpacing = 0.24.sp),
                                    modifier = Modifier
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterStart)
                                    .offset(x = 126.98.dp,
                                        y = (-4).dp)
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .background(color = Color.White)
                                    .padding(horizontal = 16.dp,
                                        vertical = 4.dp)
                            ) {
                                Text(
                                    text = "Due Soon",
                                    color = Color(0xff505f76),
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.33.em,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        letterSpacing = 0.24.sp),
                                    modifier = Modifier
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterStart)
                                    .offset(x = 224.77.dp,
                                        y = (-4).dp)
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .background(color = Color.White)
                                    .padding(horizontal = 16.dp,
                                        vertical = 4.dp)
                            ) {
                                Text(
                                    text = "In Progress",
                                    color = Color(0xff505f76),
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.33.em,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        letterSpacing = 0.24.sp),
                                    modifier = Modifier
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterStart)
                                    .offset(x = 331.59.dp,
                                        y = (-4).dp)
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .background(color = Color.White)
                                    .padding(horizontal = 16.dp,
                                        vertical = 4.dp)
                            ) {
                                Text(
                                    text = "Labs & Projects",
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
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 0.dp,
                                y = 262.dp)
                            .fillMaxWidth()
                    ) {
                        item {
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = Color.White,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(16.dp))
                            ) {
                                Box(
                                    modifier = Modifier
                                        .requiredWidth(width = 358.dp)
                                        .requiredHeight(height = 212.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredWidth(width = 358.dp)
                                            .padding(all = 16.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(113.73.dp, Alignment.Start),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.Center,
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .requiredSize(size = 44.dp)
                                                        .clip(shape = RoundedCornerShape(12.dp))
                                                        .background(color = Color(0xffd7e2ff))
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.container),
                                                        contentDescription = "Container",
                                                        colorFilter = ColorFilter.tint(Color(0xff0059b8)))
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
                                                                .clip(shape = MaterialTheme.shapes.small)
                                                                .background(color = Color(0xffd7e2ff))
                                                                .padding(horizontal = 6.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "CS-402",
                                                                color = Color(0xff004591),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                        Column() {
                                                            Text(
                                                                text = "Room 304B",
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
                                                    ) {
                                                        Text(
                                                            text = "Cryptography",
                                                            color = Color(0xff071747),
                                                            lineHeight = 1.25.em,
                                                            style = TextStyle(
                                                                fontSize = 18.sp,
                                                                fontWeight = FontWeight.Bold),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                }
                                            }
                                            Row(
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .requiredSize(size = 32.dp)
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff505f76)))
                                            }
                                        }
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(start = 4.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                            Column() {
                                                Text(
                                                    text = "Dr. Sarah Jenkins",
                                                    color = Color(0xff505f76),
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 2.dp)
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clip(shape = RoundedCornerShape(12.dp))
                                                    .background(color = Color(0xfff3f2ff).copy(alpha = 0.7f))
                                                    .padding(all = 12.dp)
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(109.11.dp, Alignment.Start),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Column() {
                                                        Text(
                                                            text = "Course Progress",
                                                            color = Color(0xff505f76),
                                                            lineHeight = 1.33.em,
                                                            style = TextStyle(
                                                                fontSize = 12.sp,
                                                                fontWeight = FontWeight.Medium,
                                                                letterSpacing = 0.24.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                    Row(
                                                        verticalAlignment = Alignment.Bottom
                                                    ) {
                                                        Text(
                                                            text = "75% ",
                                                            color = Color(0xff0059b8),
                                                            lineHeight = 1.33.em,
                                                            style = TextStyle(
                                                                fontSize = 12.sp,
                                                                fontWeight = FontWeight.Bold,
                                                                letterSpacing = 0.24.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                        Text(
                                                            text = "(3 of 4 tasks)",
                                                            color = Color(0xff505f76),
                                                            lineHeight = 1.4.em,
                                                            style = TextStyle(
                                                                fontSize = 10.sp,
                                                                letterSpacing = 0.4.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                }
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .requiredHeight(height = 8.dp)
                                                        .clip(shape = RoundedCornerShape(9999.dp))
                                                        .background(color = Color(0xffdce1ff))
                                                ) {
                                                    Box(
                                                        modifier = Modifier
                                                            .fillMaxSize()
                                                            .clip(shape = RoundedCornerShape(9999.dp))
                                                            .background(color = Color(0xff0059b8)))
                                                }
                                            }
                                        }
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(144.93.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 4.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xffba1a1a)))
                                                Column() {
                                                    Text(
                                                        text = "Assignment 2",
                                                        color = Color(0xff414753),
                                                        lineHeight = 1.33.em,
                                                        style = TextStyle(
                                                            fontSize = 12.sp,
                                                            fontWeight = FontWeight.Medium,
                                                            letterSpacing = 0.24.sp),
                                                        modifier = Modifier
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                            }
                                            Column(
                                                modifier = Modifier
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                                    .background(color = Color(0xffffdad6))
                                                    .padding(horizontal = 8.dp,
                                                        vertical = 2.dp)
                                            ) {
                                                Text(
                                                    text = "Tomorrow",
                                                    color = Color(0xff93000a),
                                                    lineHeight = 1.33.em,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        letterSpacing = 0.24.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 4.dp)
                                            .background(color = Color(0xff0059b8)))
                                }
                            }
                        }
                        item {
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = Color.White,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(16.dp))
                            ) {
                                Box(
                                    modifier = Modifier
                                        .requiredWidth(width = 358.dp)
                                        .requiredHeight(height = 212.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredWidth(width = 358.dp)
                                            .padding(all = 16.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(68.81.dp, Alignment.Start),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.Center,
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .requiredSize(size = 44.dp)
                                                        .clip(shape = RoundedCornerShape(12.dp))
                                                        .background(color = Color(0xffd0e1fb))
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.container),
                                                        contentDescription = "Container",
                                                        colorFilter = ColorFilter.tint(Color(0xff38485d)))
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
                                                                .clip(shape = MaterialTheme.shapes.small)
                                                                .background(color = Color(0xffd3e4fe))
                                                                .padding(horizontal = 6.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "CS-301",
                                                                color = Color(0xff38485d),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                        Column() {
                                                            Text(
                                                                text = "Turing Hall",
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
                                                    ) {
                                                        Text(
                                                            text = "Operating Systems",
                                                            color = Color(0xff071747),
                                                            lineHeight = 1.25.em,
                                                            style = TextStyle(
                                                                fontSize = 18.sp,
                                                                fontWeight = FontWeight.Bold),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                }
                                            }
                                            Row(
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .requiredSize(size = 32.dp)
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff505f76)))
                                            }
                                        }
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(start = 4.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                            Column() {
                                                Text(
                                                    text = "Prof. Robert Davis",
                                                    color = Color(0xff505f76),
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 2.dp)
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clip(shape = RoundedCornerShape(12.dp))
                                                    .background(color = Color(0xfff3f2ff).copy(alpha = 0.7f))
                                                    .padding(all = 12.dp)
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(107.18.dp, Alignment.Start),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Column() {
                                                        Text(
                                                            text = "Course Progress",
                                                            color = Color(0xff505f76),
                                                            lineHeight = 1.33.em,
                                                            style = TextStyle(
                                                                fontSize = 12.sp,
                                                                fontWeight = FontWeight.Medium,
                                                                letterSpacing = 0.24.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                    Row(
                                                        verticalAlignment = Alignment.Bottom
                                                    ) {
                                                        Text(
                                                            text = "50% ",
                                                            color = Color(0xff0059b8),
                                                            lineHeight = 1.33.em,
                                                            style = TextStyle(
                                                                fontSize = 12.sp,
                                                                fontWeight = FontWeight.Bold,
                                                                letterSpacing = 0.24.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                        Text(
                                                            text = "(2 of 4 tasks)",
                                                            color = Color(0xff505f76),
                                                            lineHeight = 1.4.em,
                                                            style = TextStyle(
                                                                fontSize = 10.sp,
                                                                letterSpacing = 0.4.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                }
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .requiredHeight(height = 8.dp)
                                                        .clip(shape = RoundedCornerShape(9999.dp))
                                                        .background(color = Color(0xffdce1ff))
                                                ) {
                                                    Box(
                                                        modifier = Modifier
                                                            .fillMaxSize()
                                                            .clip(shape = RoundedCornerShape(9999.dp))
                                                            .background(color = Color(0xff0059b8)))
                                                }
                                            }
                                        }
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(120.17.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 4.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                                Column() {
                                                    Text(
                                                        text = "Lab 3: Kernel Locks",
                                                        color = Color(0xff414753),
                                                        lineHeight = 1.33.em,
                                                        style = TextStyle(
                                                            fontSize = 12.sp,
                                                            fontWeight = FontWeight.Medium,
                                                            letterSpacing = 0.24.sp),
                                                        modifier = Modifier
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                            }
                                            Column(
                                                modifier = Modifier
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                                    .background(color = Color(0xffd0e1fb))
                                                    .padding(horizontal = 8.dp,
                                                        vertical = 2.dp)
                                            ) {
                                                Text(
                                                    text = "In 2 days",
                                                    color = Color(0xff54647a),
                                                    lineHeight = 1.33.em,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        letterSpacing = 0.24.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 4.dp)
                                            .background(color = Color(0xff0059b8)))
                                }
                            }
                        }
                        item {
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = Color.White,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(16.dp))
                            ) {
                                Box(
                                    modifier = Modifier
                                        .requiredWidth(width = 358.dp)
                                        .requiredHeight(height = 212.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredWidth(width = 358.dp)
                                            .padding(all = 16.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(74.94.dp, Alignment.Start),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.Center,
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .requiredSize(size = 44.dp)
                                                        .clip(shape = RoundedCornerShape(12.dp))
                                                        .background(color = Color(0xff6ffbbe))
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.container),
                                                        contentDescription = "Container",
                                                        colorFilter = ColorFilter.tint(Color(0xff005236)))
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
                                                                .clip(shape = MaterialTheme.shapes.small)
                                                                .background(color = Color(0xff4edea3))
                                                                .padding(horizontal = 6.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "CS-305",
                                                                color = Color(0xff002113),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                        Column() {
                                                            Text(
                                                                text = "Lab 12",
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
                                                    ) {
                                                        Text(
                                                            text = "Database Systems",
                                                            color = Color(0xff071747),
                                                            lineHeight = 1.25.em,
                                                            style = TextStyle(
                                                                fontSize = 18.sp,
                                                                fontWeight = FontWeight.Bold),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                }
                                            }
                                            Row(
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .requiredSize(size = 32.dp)
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff505f76)))
                                            }
                                        }
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(start = 4.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                            Column() {
                                                Text(
                                                    text = "Dr. Michael Chang",
                                                    color = Color(0xff505f76),
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 2.dp)
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clip(shape = RoundedCornerShape(12.dp))
                                                    .background(color = Color(0xfff3f2ff).copy(alpha = 0.7f))
                                                    .padding(all = 12.dp)
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(110.89.dp, Alignment.Start),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Column() {
                                                        Text(
                                                            text = "Course Progress",
                                                            color = Color(0xff505f76),
                                                            lineHeight = 1.33.em,
                                                            style = TextStyle(
                                                                fontSize = 12.sp,
                                                                fontWeight = FontWeight.Medium,
                                                                letterSpacing = 0.24.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(0.01.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.Bottom
                                                    ) {
                                                        Text(
                                                            text = "33% ",
                                                            color = Color(0xff0059b8),
                                                            lineHeight = 1.33.em,
                                                            style = TextStyle(
                                                                fontSize = 12.sp,
                                                                fontWeight = FontWeight.Bold,
                                                                letterSpacing = 0.24.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                        Text(
                                                            text = "(1 of 3 tasks)",
                                                            color = Color(0xff505f76),
                                                            lineHeight = 1.4.em,
                                                            style = TextStyle(
                                                                fontSize = 10.sp,
                                                                letterSpacing = 0.4.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                }
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .requiredHeight(height = 8.dp)
                                                        .clip(shape = RoundedCornerShape(9999.dp))
                                                        .background(color = Color(0xffdce1ff))
                                                ) {
                                                    Box(
                                                        modifier = Modifier
                                                            .fillMaxSize()
                                                            .clip(shape = RoundedCornerShape(9999.dp))
                                                            .background(color = Color(0xff0059b8)))
                                                }
                                            }
                                        }
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(151.36.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 4.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                                Column() {
                                                    Text(
                                                        text = "Normalization",
                                                        color = Color(0xff414753),
                                                        lineHeight = 1.33.em,
                                                        style = TextStyle(
                                                            fontSize = 12.sp,
                                                            fontWeight = FontWeight.Medium,
                                                            letterSpacing = 0.24.sp),
                                                        modifier = Modifier
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                            }
                                            Column(
                                                modifier = Modifier
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                                    .background(color = Color(0xffebedff))
                                                    .padding(horizontal = 8.dp,
                                                        vertical = 2.dp)
                                            ) {
                                                Text(
                                                    text = "In 4 days",
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
                                    Box(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 4.dp)
                                            .background(color = Color(0xff0059b8)))
                                }
                            }
                        }
                        item {
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = Color.White,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(16.dp))
                            ) {
                                Box(
                                    modifier = Modifier
                                        .requiredWidth(width = 358.dp)
                                        .requiredHeight(height = 212.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredWidth(width = 358.dp)
                                            .padding(all = 16.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(74.66.dp, Alignment.Start),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.Center,
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .requiredSize(size = 44.dp)
                                                        .clip(shape = RoundedCornerShape(12.dp))
                                                        .background(color = Color(0xffe4e7ff))
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.container),
                                                        contentDescription = "Container",
                                                        colorFilter = ColorFilter.tint(Color(0xff0059b8)))
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
                                                                .clip(shape = MaterialTheme.shapes.small)
                                                                .background(color = Color(0xffdce1ff))
                                                                .padding(horizontal = 6.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "CS-220",
                                                                color = Color(0xff071747),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                        Column() {
                                                            Text(
                                                                text = "Online / Sync",
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
                                                    ) {
                                                        Text(
                                                            text = "Web Programming",
                                                            color = Color(0xff071747),
                                                            lineHeight = 1.25.em,
                                                            style = TextStyle(
                                                                fontSize = 18.sp,
                                                                fontWeight = FontWeight.Bold),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                }
                                            }
                                            Row(
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .requiredSize(size = 32.dp)
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff505f76)))
                                            }
                                        }
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(start = 4.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                            Column() {
                                                Text(
                                                    text = "Maya Lin, M.Sc.",
                                                    color = Color(0xff505f76),
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 2.dp)
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clip(shape = RoundedCornerShape(12.dp))
                                                    .background(color = Color(0xfff3f2ff).copy(alpha = 0.7f))
                                                    .padding(all = 12.dp)
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(113.47.dp, Alignment.Start),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Column() {
                                                        Text(
                                                            text = "Course Progress",
                                                            color = Color(0xff505f76),
                                                            lineHeight = 1.33.em,
                                                            style = TextStyle(
                                                                fontSize = 12.sp,
                                                                fontWeight = FontWeight.Medium,
                                                                letterSpacing = 0.24.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                    Row(
                                                        verticalAlignment = Alignment.Bottom
                                                    ) {
                                                        Text(
                                                            text = "0% ",
                                                            color = Color(0xff505f76),
                                                            lineHeight = 1.33.em,
                                                            style = TextStyle(
                                                                fontSize = 12.sp,
                                                                fontWeight = FontWeight.Bold,
                                                                letterSpacing = 0.24.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                        Text(
                                                            text = "(0 of 4 tasks)",
                                                            color = Color(0xff505f76),
                                                            lineHeight = 1.4.em,
                                                            style = TextStyle(
                                                                fontSize = 10.sp,
                                                                letterSpacing = 0.4.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                }
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .requiredHeight(height = 8.dp)
                                                        .clip(shape = RoundedCornerShape(9999.dp))
                                                        .background(color = Color(0xffdce1ff)))
                                            }
                                        }
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(68.64.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 4.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff505f76)))
                                                Column() {
                                                    Text(
                                                        text = "Build E-Commerce Website",
                                                        color = Color(0xff414753),
                                                        lineHeight = 1.33.em,
                                                        style = TextStyle(
                                                            fontSize = 12.sp,
                                                            fontWeight = FontWeight.Medium,
                                                            letterSpacing = 0.24.sp),
                                                        modifier = Modifier
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                            }
                                            Column(
                                                modifier = Modifier
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                                    .background(color = Color(0xffebedff))
                                                    .padding(horizontal = 8.dp,
                                                        vertical = 2.dp)
                                            ) {
                                                Text(
                                                    text = "In 6 days",
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
                                    Box(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 4.dp)
                                            .background(color = Color(0xffc1c6d6)))
                                }
                            }
                        }
                        item {
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = Color.White,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(16.dp))
                            ) {
                                Box(
                                    modifier = Modifier
                                        .requiredWidth(width = 358.dp)
                                        .requiredHeight(height = 212.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredWidth(width = 358.dp)
                                            .padding(all = 16.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(109.81.dp, Alignment.Start),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.Center,
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .requiredSize(size = 44.dp)
                                                        .clip(shape = RoundedCornerShape(12.dp))
                                                        .background(color = Color(0xffacc7ff))
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.container),
                                                        contentDescription = "Container",
                                                        colorFilter = ColorFilter.tint(Color(0xff1171e3)))
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
                                                                .clip(shape = MaterialTheme.shapes.small)
                                                                .background(color = Color(0xffdce1ff))
                                                                .padding(horizontal = 6.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "DES-201",
                                                                color = Color(0xff071747),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                        Column() {
                                                            Text(
                                                                text = "Design Lab 4",
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
                                                    ) {
                                                        Text(
                                                            text = "UI/UX Design",
                                                            color = Color(0xff071747),
                                                            lineHeight = 1.25.em,
                                                            style = TextStyle(
                                                                fontSize = 18.sp,
                                                                fontWeight = FontWeight.Bold),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                }
                                            }
                                            Row(
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .requiredSize(size = 32.dp)
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff505f76)))
                                            }
                                        }
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(start = 4.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                            Column() {
                                                Text(
                                                    text = "Elena Rostova",
                                                    color = Color(0xff505f76),
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 2.dp)
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clip(shape = RoundedCornerShape(12.dp))
                                                    .background(color = Color(0xfff3f2ff).copy(alpha = 0.7f))
                                                    .padding(all = 12.dp)
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(113.69.dp, Alignment.Start),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Column() {
                                                        Text(
                                                            text = "Course Progress",
                                                            color = Color(0xff505f76),
                                                            lineHeight = 1.33.em,
                                                            style = TextStyle(
                                                                fontSize = 12.sp,
                                                                fontWeight = FontWeight.Medium,
                                                                letterSpacing = 0.24.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                    Row(
                                                        verticalAlignment = Alignment.Bottom
                                                    ) {
                                                        Text(
                                                            text = "0% ",
                                                            color = Color(0xff505f76),
                                                            lineHeight = 1.33.em,
                                                            style = TextStyle(
                                                                fontSize = 12.sp,
                                                                fontWeight = FontWeight.Bold,
                                                                letterSpacing = 0.24.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                        Text(
                                                            text = "(0 of 3 tasks)",
                                                            color = Color(0xff505f76),
                                                            lineHeight = 1.4.em,
                                                            style = TextStyle(
                                                                fontSize = 10.sp,
                                                                letterSpacing = 0.4.sp),
                                                            modifier = Modifier
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                }
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .requiredHeight(height = 8.dp)
                                                        .clip(shape = RoundedCornerShape(9999.dp))
                                                        .background(color = Color(0xffdce1ff)))
                                            }
                                        }
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(37.86.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 4.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff505f76)))
                                                Column() {
                                                    Text(
                                                        text = "No deadlines this week",
                                                        color = Color(0xff505f76),
                                                        lineHeight = 1.33.em,
                                                        style = TextStyle(
                                                            fontSize = 12.sp,
                                                            fontWeight = FontWeight.Medium,
                                                            letterSpacing = 0.24.sp),
                                                        modifier = Modifier
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                            }
                                            Column(
                                                modifier = Modifier
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                                    .background(color = Color(0xffd0e1fb))
                                                    .padding(horizontal = 10.dp,
                                                        vertical = 2.dp)
                                            ) {
                                                Text(
                                                    text = "3 Upcoming Tasks",
                                                    color = Color(0xff54647a),
                                                    lineHeight = 1.33.em,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        letterSpacing = 0.24.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 4.dp)
                                            .background(color = Color(0xffc1c6d6)))
                                }
                            }
                        }
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
                                    text = "Courses",
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

@Preview(widthDp = 390, heightDp = 1450)
@Composable
private fun FramePreview() {
    Frame(Modifier)
}