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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun Main(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .requiredWidth(width = 390.dp)
            .background(color = Color(0xfffaf8ff))
            .padding(start = 16.dp,
                end = 16.dp,
                bottom = 80.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredHeight(height = 44.dp)
                                .weight(weight = 1f)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .requiredWidth(width = 314.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(16.dp))
                                        .background(color = Color.White)
                                        .padding(start = 44.dp,
                                            end = 40.dp,
                                            top = 13.dp,
                                            bottom = 13.dp)
                                        .shadow(elevation = 2.dp,
                                            shape = RoundedCornerShape(16.dp))
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "Search tasks, courses, tags...",
                                            color = Color(0xff505f76),
                                            style = TextStyle(
                                                fontSize = 14.sp),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                            }
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "Icon",
                                modifier = Modifier
                                    .align(alignment = Alignment.TopStart)
                                    .offset(x = 18.75.dp,
                                        y = 13.75.dp)
                                    .requiredSize(size = 17.dp))
                        }
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .requiredSize(size = 44.dp)
                                .clip(shape = RoundedCornerShape(16.dp))
                                .background(color = Color.White)
                                .shadow(elevation = 2.dp,
                                    shape = RoundedCornerShape(16.dp))
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.container),
                                contentDescription = "Container",
                                colorFilter = ColorFilter.tint(Color(0xff414753)))
                        }
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(height = 54.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .requiredHeight(height = 38.dp)
                            .padding(horizontal = -16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterStart)
                                .offset(x = 16.dp,
                                    y = (-4).dp)
                                .clip(shape = RoundedCornerShape(9999.dp))
                                .background(color = Color(0xff0059b8))
                                .padding(horizontal = 16.dp,
                                    vertical = 6.dp)
                                .shadow(elevation = 2.dp,
                                    shape = RoundedCornerShape(9999.dp))
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "All",
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.33.em,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        letterSpacing = 0.24.sp),
                                    modifier = Modifier
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .background(color = Color.White.copy(alpha = 0.2f))
                                    .padding(horizontal = 6.dp,
                                        vertical = 2.dp)
                            ) {
                                Text(
                                    text = "12",
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.4.em,
                                    style = TextStyle(
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.4.sp),
                                    modifier = Modifier
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterStart)
                                .offset(x = 99.72.dp,
                                    y = (-4).dp)
                                .clip(shape = RoundedCornerShape(9999.dp))
                                .background(color = Color.White)
                                .padding(horizontal = 16.dp,
                                    vertical = 6.dp)
                                .shadow(elevation = 2.dp,
                                    shape = RoundedCornerShape(9999.dp))
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
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
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .background(color = Color(0xffebedff))
                                    .padding(horizontal = 6.dp,
                                        vertical = 2.dp)
                            ) {
                                Text(
                                    text = "1",
                                    color = Color(0xff414753),
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.4.em,
                                    style = TextStyle(
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.4.sp),
                                    modifier = Modifier
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterStart)
                                .offset(x = 232.45.dp,
                                    y = (-4).dp)
                                .clip(shape = RoundedCornerShape(9999.dp))
                                .background(color = Color.White)
                                .padding(horizontal = 16.dp,
                                    vertical = 6.dp)
                                .shadow(elevation = 2.dp,
                                    shape = RoundedCornerShape(9999.dp))
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
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
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .background(color = Color(0xffd0e1fb))
                                    .padding(horizontal = 6.dp,
                                        vertical = 2.dp)
                            ) {
                                Text(
                                    text = "4",
                                    color = Color(0xff505f76),
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.4.em,
                                    style = TextStyle(
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.4.sp),
                                    modifier = Modifier
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(6.01.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterStart)
                                .offset(x = 364.23.dp,
                                    y = (-4).dp)
                                .clip(shape = RoundedCornerShape(9999.dp))
                                .background(color = Color.White)
                                .padding(horizontal = 16.dp,
                                    vertical = 6.dp)
                                .shadow(elevation = 2.dp,
                                    shape = RoundedCornerShape(9999.dp))
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
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
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .background(color = Color(0xffe4e7ff))
                                    .padding(horizontal = 6.dp,
                                        vertical = 2.dp)
                            ) {
                                Text(
                                    text = "7",
                                    color = Color(0xff006947),
                                    textAlign = TextAlign.Center,
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
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(58.38.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 4.dp,
                                end = 3.990000009536743.dp)
                    ) {
                        Column() {
                            Text(
                                text = "CURRENT FOCUS & DUE SOON",
                                color = Color(0xff505f76),
                                lineHeight = 1.33.em,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 0.6.sp),
                                modifier = Modifier
                                    .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                        Column() {
                            Text(
                                text = "Showing 6 curated",
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
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 40.dp)
                ) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                        modifier = Modifier
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
                                        .requiredHeight(height = 98.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredWidth(width = 358.dp)
                                            .padding(all = 16.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(start = 6.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .weight(weight = 1f)
                                            ) {
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(bottom = 4.dp)
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Column(
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffd7e2ff))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "Cryptography",
                                                                color = Color(0xff001a40),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                        Row(
                                                            horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.Start),
                                                            verticalAlignment = Alignment.CenterVertically,
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffffdad6))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Image(
                                                                painter = painterResource(id = R.drawable.container),
                                                                contentDescription = "Container",
                                                                colorFilter = ColorFilter.tint(Color(0xff93000a)))
                                                            Text(
                                                                text = "High",
                                                                color = Color(0xff93000a),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                    }
                                                }
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Text(
                                                        text = "Cryptography Assignment 2",
                                                        color = Color(0xff071747),
                                                        lineHeight = 1.38.em,
                                                        style = TextStyle(
                                                            fontSize = 16.sp),
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(top = 6.dp)
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.container),
                                                            contentDescription = "Container",
                                                            colorFilter = ColorFilter.tint(Color(0xffba1a1a)))
                                                        Column() {
                                                            Text(
                                                                text = "Tomorrow • 11:59 PM",
                                                                color = Color(0xffba1a1a),
                                                                lineHeight = 1.33.em,
                                                                style = TextStyle(
                                                                    fontSize = 12.sp,
                                                                    fontWeight = FontWeight.Medium,
                                                                    letterSpacing = 0.24.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                    }
                                                }
                                            }
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxHeight()
                                            ) {
                                                Column(
                                                    verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                                                    horizontalAlignment = Alignment.End,
                                                    modifier = Modifier
                                                        .fillMaxHeight()
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .clip(shape = RoundedCornerShape(9999.dp))
                                                            .background(color = Color(0xffd0e1fb))
                                                            .padding(horizontal = 10.dp,
                                                                vertical = 4.dp)
                                                    ) {
                                                        Badge(
                                                            containerColor = Color(0xff0059b8))
                                                        Text(
                                                            text = "In Progress",
                                                            color = Color(0xff0059b8),
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
                                                        colorFilter = ColorFilter.tint(Color(0xffc1c6d6)))
                                                }
                                            }
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 6.dp)
                                            .clip(shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))
                                            .background(color = Color(0xffba1a1a)))
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
                                        .requiredHeight(height = 120.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredWidth(width = 358.dp)
                                            .padding(all = 16.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(start = 6.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .weight(weight = 1f)
                                            ) {
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(bottom = 4.dp)
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Column(
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffd7e2ff))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "Operating Systems",
                                                                color = Color(0xff001a40),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                        Row(
                                                            horizontalArrangement = Arrangement.spacedBy(1.99.dp, Alignment.Start),
                                                            verticalAlignment = Alignment.CenterVertically,
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffffdad6))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Image(
                                                                painter = painterResource(id = R.drawable.container),
                                                                contentDescription = "Container",
                                                                colorFilter = ColorFilter.tint(Color(0xff93000a)))
                                                            Text(
                                                                text = "High",
                                                                color = Color(0xff93000a),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                    }
                                                }
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Text(
                                                        text = "Operating Systems Lab 3: Kernel Locks",
                                                        color = Color(0xff071747),
                                                        lineHeight = 1.38.em,
                                                        style = TextStyle(
                                                            fontSize = 16.sp),
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(top = 6.dp)
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.container),
                                                            contentDescription = "Container",
                                                            colorFilter = ColorFilter.tint(Color(0xff505f76)))
                                                        Column() {
                                                            Text(
                                                                text = "In 2 days • 5:00 PM",
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
                                                }
                                            }
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxHeight()
                                            ) {
                                                Column(
                                                    verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                                                    horizontalAlignment = Alignment.End,
                                                    modifier = Modifier
                                                        .fillMaxHeight()
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .clip(shape = RoundedCornerShape(9999.dp))
                                                            .background(color = Color(0xffd0e1fb))
                                                            .padding(horizontal = 10.dp,
                                                                vertical = 4.dp)
                                                    ) {
                                                        Badge(
                                                            containerColor = Color(0xff0059b8))
                                                        Text(
                                                            text = "In Progress",
                                                            color = Color(0xff0059b8),
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
                                                        colorFilter = ColorFilter.tint(Color(0xffc1c6d6)))
                                                }
                                            }
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 6.dp)
                                            .clip(shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))
                                            .background(color = Color(0xffba1a1a)))
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
                                        .requiredHeight(height = 120.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredWidth(width = 358.dp)
                                            .padding(all = 16.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(start = 6.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .weight(weight = 1f)
                                            ) {
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(bottom = 4.dp)
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Column(
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffebedff))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "Database Systems",
                                                                color = Color(0xff414753),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                        Row(
                                                            horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.Start),
                                                            verticalAlignment = Alignment.CenterVertically,
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffe4e7ff))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Image(
                                                                painter = painterResource(id = R.drawable.container),
                                                                contentDescription = "Container",
                                                                colorFilter = ColorFilter.tint(Color(0xff071747)))
                                                            Text(
                                                                text = "Medium",
                                                                color = Color(0xff071747),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                    }
                                                }
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Text(
                                                        text = "Database Normalization & Constraints",
                                                        color = Color(0xff071747),
                                                        lineHeight = 1.38.em,
                                                        style = TextStyle(
                                                            fontSize = 16.sp),
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(top = 6.dp)
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.container),
                                                            contentDescription = "Container",
                                                            colorFilter = ColorFilter.tint(Color(0xff505f76)))
                                                        Column() {
                                                            Text(
                                                                text = "In 4 days • 11:00 PM",
                                                                color = Color(0xff505f76),
                                                                lineHeight = 1.33.em,
                                                                style = TextStyle(
                                                                    fontSize = 12.sp,
                                                                    letterSpacing = 0.24.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                    }
                                                }
                                            }
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxHeight()
                                            ) {
                                                Column(
                                                    verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                                                    horizontalAlignment = Alignment.End,
                                                    modifier = Modifier
                                                        .fillMaxHeight()
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
                                                        Badge(
                                                            containerColor = Color(0xff727785))
                                                        Text(
                                                            text = "Not Started",
                                                            color = Color(0xff505f76),
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
                                                        colorFilter = ColorFilter.tint(Color(0xffc1c6d6)))
                                                }
                                            }
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 6.dp)
                                            .clip(shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))
                                            .background(color = Color(0xffd0e1fb)))
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
                                        .requiredHeight(height = 98.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredWidth(width = 358.dp)
                                            .padding(all = 16.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(start = 6.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .weight(weight = 1f)
                                            ) {
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(bottom = 4.dp)
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Column(
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffd0e1fb))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "Web Programming",
                                                                color = Color(0xff54647a),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                        Row(
                                                            horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.Start),
                                                            verticalAlignment = Alignment.CenterVertically,
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xfff3f2ff))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Image(
                                                                painter = painterResource(id = R.drawable.container),
                                                                contentDescription = "Container",
                                                                colorFilter = ColorFilter.tint(Color(0xff006947)))
                                                            Text(
                                                                text = "Low",
                                                                color = Color(0xff006947),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                    }
                                                }
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Text(
                                                        text = "Build E-Commerce Website",
                                                        color = Color(0xff071747),
                                                        lineHeight = 1.38.em,
                                                        style = TextStyle(
                                                            fontSize = 16.sp),
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(top = 6.dp)
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.container),
                                                            contentDescription = "Container",
                                                            colorFilter = ColorFilter.tint(Color(0xff505f76)))
                                                        Column() {
                                                            Text(
                                                                text = "In 6 days • 11:59 PM",
                                                                color = Color(0xff505f76),
                                                                lineHeight = 1.33.em,
                                                                style = TextStyle(
                                                                    fontSize = 12.sp,
                                                                    letterSpacing = 0.24.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                    }
                                                }
                                            }
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxHeight()
                                            ) {
                                                Column(
                                                    verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                                                    horizontalAlignment = Alignment.End,
                                                    modifier = Modifier
                                                        .fillMaxHeight()
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .clip(shape = RoundedCornerShape(9999.dp))
                                                            .background(color = Color(0xffd0e1fb))
                                                            .padding(horizontal = 10.dp,
                                                                vertical = 4.dp)
                                                    ) {
                                                        Badge(
                                                            containerColor = Color(0xff0059b8))
                                                        Text(
                                                            text = "In Progress",
                                                            color = Color(0xff0059b8),
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
                                                        colorFilter = ColorFilter.tint(Color(0xffc1c6d6)))
                                                }
                                            }
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 6.dp)
                                            .clip(shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))
                                            .background(color = Color(0xff4edea3)))
                                }
                            }
                        }
                        item {
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = Color.White.copy(alpha = 0.8f),
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(16.dp))
                            ) {
                                Box(
                                    modifier = Modifier
                                        .requiredWidth(width = 358.dp)
                                        .requiredHeight(height = 98.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredWidth(width = 358.dp)
                                            .padding(all = 16.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(start = 6.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .weight(weight = 1f)
                                            ) {
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(bottom = 4.dp)
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Column(
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffebedff))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "UI/UX Design",
                                                                color = Color(0xff414753),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                        Column(
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffe4e7ff))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "Medium",
                                                                color = Color(0xff071747),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                    }
                                                }
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Text(
                                                        text = "UI/UX Heuristic Evaluation",
                                                        color = Color(0xff071747),
                                                        textDecoration = TextDecoration.LineThrough,
                                                        lineHeight = 1.38.em,
                                                        style = TextStyle(
                                                            fontSize = 16.sp),
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(top = 6.dp)
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.container),
                                                            contentDescription = "Container",
                                                            colorFilter = ColorFilter.tint(Color(0xff006947)))
                                                        Column() {
                                                            Text(
                                                                text = "Sep 12 • Completed",
                                                                color = Color(0xff006947),
                                                                lineHeight = 1.33.em,
                                                                style = TextStyle(
                                                                    fontSize = 12.sp,
                                                                    fontWeight = FontWeight.Medium,
                                                                    letterSpacing = 0.24.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                    }
                                                }
                                            }
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxHeight()
                                            ) {
                                                Column(
                                                    verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                                                    horizontalAlignment = Alignment.End,
                                                    modifier = Modifier
                                                        .fillMaxHeight()
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(3.99.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .clip(shape = RoundedCornerShape(9999.dp))
                                                            .background(color = Color(0xff6ffbbe))
                                                            .padding(horizontal = 10.dp,
                                                                vertical = 4.dp)
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.container),
                                                            contentDescription = "Container",
                                                            colorFilter = ColorFilter.tint(Color(0xff005236)))
                                                        Text(
                                                            text = "Done",
                                                            color = Color(0xff005236),
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
                                                        colorFilter = ColorFilter.tint(Color(0xffc1c6d6)))
                                                }
                                            }
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 6.dp)
                                            .clip(shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))
                                            .background(color = Color(0xff006947)))
                                }
                            }
                        }
                        item {
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = Color.White.copy(alpha = 0.8f),
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(16.dp))
                            ) {
                                Box(
                                    modifier = Modifier
                                        .requiredWidth(width = 358.dp)
                                        .requiredHeight(height = 120.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredWidth(width = 358.dp)
                                            .padding(all = 16.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(start = 6.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .weight(weight = 1f)
                                            ) {
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(bottom = 4.dp)
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Column(
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffebedff))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "Algorithms",
                                                                color = Color(0xff414753),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                        Column(
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffffdad6))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "High",
                                                                color = Color(0xff93000a),
                                                                lineHeight = 1.4.em,
                                                                style = TextStyle(
                                                                    fontSize = 10.sp,
                                                                    letterSpacing = 0.4.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                    }
                                                }
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Text(
                                                        text = "Algorithm Complexity Problem Set",
                                                        color = Color(0xff071747),
                                                        textDecoration = TextDecoration.LineThrough,
                                                        lineHeight = 1.38.em,
                                                        style = TextStyle(
                                                            fontSize = 16.sp),
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(top = 6.dp)
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.container),
                                                            contentDescription = "Container",
                                                            colorFilter = ColorFilter.tint(Color(0xff006947)))
                                                        Column() {
                                                            Text(
                                                                text = "Sep 8 • Completed",
                                                                color = Color(0xff006947),
                                                                lineHeight = 1.33.em,
                                                                style = TextStyle(
                                                                    fontSize = 12.sp,
                                                                    fontWeight = FontWeight.Medium,
                                                                    letterSpacing = 0.24.sp),
                                                                modifier = Modifier
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                    }
                                                }
                                            }
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxHeight()
                                            ) {
                                                Column(
                                                    verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                                                    horizontalAlignment = Alignment.End,
                                                    modifier = Modifier
                                                        .fillMaxHeight()
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(3.99.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .clip(shape = RoundedCornerShape(9999.dp))
                                                            .background(color = Color(0xff6ffbbe))
                                                            .padding(horizontal = 10.dp,
                                                                vertical = 4.dp)
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.container),
                                                            contentDescription = "Container",
                                                            colorFilter = ColorFilter.tint(Color(0xff005236)))
                                                        Text(
                                                            text = "Done",
                                                            color = Color(0xff005236),
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
                                                        colorFilter = ColorFilter.tint(Color(0xffc1c6d6)))
                                                }
                                            }
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 6.dp)
                                            .clip(shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))
                                            .background(color = Color(0xff006947)))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(widthDp = 390, heightDp = 976)
@Composable
private fun MainPreview() {
    Main(Modifier)
}