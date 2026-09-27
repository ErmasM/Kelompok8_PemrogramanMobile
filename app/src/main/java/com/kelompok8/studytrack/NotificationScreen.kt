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
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.material3.ExperimentalMaterial3Api
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 390.dp)
            .requiredHeight(height = 928.dp)
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
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    item {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(102.33.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column() {
                                    Text(
                                        text = "Inbox",
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
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color(0xff0059b8))
                                        .padding(horizontal = 8.dp,
                                            vertical = 2.dp)
                                        .shadow(elevation = 2.dp,
                                            shape = RoundedCornerShape(9999.dp))
                                ) {
                                    Text(
                                        text = "3 unread",
                                        color = Color.White,
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
                                        text = "Mark all as read",
                                        color = Color(0xff0059b8),
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
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .requiredHeight(height = 32.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 32.dp)
                                    .padding(horizontal = 0.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .align(alignment = Alignment.CenterStart)
                                        .offset(x = 16.dp,
                                            y = (-2).dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color(0xff0059b8))
                                        .padding(horizontal = 16.dp,
                                            vertical = 6.dp)
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
                                            text = "All (5)",
                                            color = Color.White,
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
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .align(alignment = Alignment.CenterStart)
                                        .offset(x = 111.78.dp,
                                            y = (-2).dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color(0xfff3f2ff))
                                        .padding(horizontal = 16.dp,
                                            vertical = 6.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "Deadlines (2)",
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
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .align(alignment = Alignment.CenterStart)
                                        .offset(x = 230.19.dp,
                                            y = (-2).dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color(0xfff3f2ff))
                                        .padding(horizontal = 16.dp,
                                            vertical = 6.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "Reminders (2)",
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
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .align(alignment = Alignment.CenterStart)
                                        .offset(x = 352.75.dp,
                                            y = (-2).dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color(0xfff3f2ff))
                                        .padding(horizontal = 16.dp,
                                            vertical = 6.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "System (1)",
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
                        }
                    }
                    item {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = Color(0xfff3f2ff),
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(12.dp))
                                .shadow(elevation = 2.dp,
                                    shape = RoundedCornerShape(12.dp))
                        ) {
                            Box(
                                modifier = Modifier
                                    .requiredWidth(width = 358.dp)
                                    .requiredHeight(height = 72.dp)
                            ) {
                                Box(
                                    contentAlignment = Alignment.CenterStart,
                                    modifier = Modifier
                                        .requiredWidth(width = 358.dp)
                                        .padding(all = 16.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .requiredSize(size = 40.dp)
                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                .background(color = Color(0xffd0e1fb))
                                                .shadow(elevation = 2.dp,
                                                    shape = RoundedCornerShape(9999.dp))
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
                                                    text = "You're on track!",
                                                    color = Color(0xff071747),
                                                    lineHeight = 1.25.em,
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
                                                    text = "2 high priority deadlines approaching this week.",
                                                    color = Color(0xff414753),
                                                    lineHeight = 1.33.em,
                                                    style = TextStyle(
                                                        fontSize = 12.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                    }
                                }
                                Box(
                                    modifier = Modifier
                                        .align(alignment = Alignment.TopEnd)
                                        .offset(x = 8.dp,
                                            y = (-8).dp)
                                        .requiredSize(size = 48.dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .blur(radius = 24.dp)
                                        .background(color = Color(0xffd7e2ff).copy(alpha = 0.4f)))
                            }
                        }
                    }
                    item {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
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
                                            .requiredHeight(height = 124.dp)
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
                                                    .padding(start = 4.dp)
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
                                                Column(
                                                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Row(
                                                            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                                                            verticalAlignment = Alignment.CenterVertically
                                                        ) {
                                                            Column(
                                                                modifier = Modifier
                                                                    .padding(end = 5.440000057220459.dp)
                                                            ) {
                                                                Text(
                                                                    text = "Cryptography Assignment 2",
                                                                    color = Color(0xff071747),
                                                                    lineHeight = 1.38.em,
                                                                    style = TextStyle(
                                                                        fontSize = 16.sp),
                                                                    modifier = Modifier
                                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                                            }
                                                            Box(
                                                                modifier = Modifier
                                                                    .requiredSize(size = 8.dp)
                                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                                                    .background(color = Color(0xff0059b8)))
                                                        }
                                                        Column() {
                                                            Text(
                                                                text = "15m ago",
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
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Text(
                                                            text = "Due tomorrow • 11:59 PM. Don't forget to\nsubmit before the portal closes.",
                                                            color = Color(0xff414753),
                                                            lineHeight = 1.43.em,
                                                            style = TextStyle(
                                                                fontSize = 14.sp),
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .padding(top = 4.dp)
                                                    ) {
                                                        Row(
                                                            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                            verticalAlignment = Alignment.CenterVertically,
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffffdad6))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Badge(
                                                                containerColor = Color(0xffba1a1a))
                                                            Text(
                                                                text = "Due Soon",
                                                                color = Color(0xff93000a),
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
                                                                .background(color = Color(0xffebedff))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "CS 438",
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
                                                }
                                            }
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxHeight()
                                                .requiredWidth(width = 6.dp)
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
                                            .requiredHeight(height = 124.dp)
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
                                                    .padding(start = 4.dp)
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.Center,
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .requiredSize(size = 40.dp)
                                                        .clip(shape = RoundedCornerShape(12.dp))
                                                        .background(color = Color(0xffffdad6))
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.container),
                                                        contentDescription = "Container",
                                                        colorFilter = ColorFilter.tint(Color(0xffba1a1a)))
                                                }
                                                Column(
                                                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(27.92.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Row(
                                                            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                                                            verticalAlignment = Alignment.CenterVertically
                                                        ) {
                                                            Column() {
                                                                Text(
                                                                    text = "Operating Systems Lab 3",
                                                                    color = Color(0xff071747),
                                                                    lineHeight = 1.38.em,
                                                                    style = TextStyle(
                                                                        fontSize = 16.sp),
                                                                    modifier = Modifier
                                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                                            }
                                                            Box(
                                                                modifier = Modifier
                                                                    .requiredSize(size = 8.dp)
                                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                                                    .background(color = Color(0xff0059b8)))
                                                        }
                                                        Column() {
                                                            Text(
                                                                text = "2h ago",
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
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Text(
                                                            text = "Due in 2 days • 5:00 PM. Kernel lock\nbenchmark required.",
                                                            color = Color(0xff414753),
                                                            lineHeight = 1.43.em,
                                                            style = TextStyle(
                                                                fontSize = 14.sp),
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .padding(top = 4.dp)
                                                    ) {
                                                        Column(
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffebedff))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "CS 350",
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
                                                                .background(color = Color(0xffebedff))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "Benchmarking",
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
                                                }
                                            }
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxHeight()
                                                .requiredWidth(width = 6.dp)
                                                .background(color = Color(0xffba1a1a)))
                                    }
                                }
                            }
                            item {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(16.dp))
                                        .background(color = Color(0xfff3f2ff))
                                        .padding(all = 16.dp)
                                        .shadow(elevation = 2.dp,
                                            shape = RoundedCornerShape(16.dp))
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .requiredSize(size = 40.dp)
                                                .clip(shape = RoundedCornerShape(12.dp))
                                                .background(color = Color(0xff6ffbbe))
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff002113)))
                                        }
                                        Column(
                                            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(54.52.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Column() {
                                                    Text(
                                                        text = "Database Normalization",
                                                        color = Color(0xff071747),
                                                        lineHeight = 1.38.em,
                                                        style = TextStyle(
                                                            fontSize = 16.sp),
                                                        modifier = Modifier
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                                Column() {
                                                    Text(
                                                        text = "4h ago",
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
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Marked as completed today • 11:00 AM.\nGreat work!",
                                                    color = Color(0xff414753),
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp),
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(top = 4.dp)
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .clip(shape = RoundedCornerShape(9999.dp))
                                                        .background(color = Color(0xffdce1ff))
                                                        .padding(horizontal = 8.dp,
                                                            vertical = 2.dp)
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.container),
                                                        contentDescription = "Container",
                                                        colorFilter = ColorFilter.tint(Color(0xff006947)))
                                                    Text(
                                                        text = "Completed",
                                                        color = Color(0xff006947),
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
                                                        .background(color = Color(0xffebedff))
                                                        .padding(horizontal = 8.dp,
                                                            vertical = 2.dp)
                                                ) {
                                                    Text(
                                                        text = "INFO 340",
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
                                        }
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
                                            .requiredHeight(height = 124.dp)
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
                                                    .padding(start = 4.dp)
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
                                                Column(
                                                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(63.95.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Row(
                                                            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                                                            verticalAlignment = Alignment.CenterVertically
                                                        ) {
                                                            Column() {
                                                                Text(
                                                                    text = "UI/UX Design Quiz",
                                                                    color = Color(0xff071747),
                                                                    lineHeight = 1.38.em,
                                                                    style = TextStyle(
                                                                        fontSize = 16.sp),
                                                                    modifier = Modifier
                                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                                            }
                                                            Box(
                                                                modifier = Modifier
                                                                    .requiredSize(size = 8.dp)
                                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                                                    .background(color = Color(0xff0059b8)))
                                                        }
                                                        Column() {
                                                            Text(
                                                                text = "Yesterday",
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
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                    ) {
                                                        Text(
                                                            text = "Due in 1 week • 4:00 PM. Review\nChapters 3–5.",
                                                            color = Color(0xff414753),
                                                            lineHeight = 1.43.em,
                                                            style = TextStyle(
                                                                fontSize = 14.sp),
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .padding(top = 4.dp)
                                                    ) {
                                                        Column(
                                                            modifier = Modifier
                                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                                .background(color = Color(0xffebedff))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "DES 201",
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
                                                                .background(color = Color(0xffd0e1fb))
                                                                .padding(horizontal = 8.dp,
                                                                    vertical = 2.dp)
                                                        ) {
                                                            Text(
                                                                text = "Quiz Prep",
                                                                color = Color(0xff54647a),
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
                                        Box(
                                            modifier = Modifier
                                                .fillMaxHeight()
                                                .requiredWidth(width = 6.dp)
                                                .background(color = Color(0xffacc7ff)))
                                    }
                                }
                            }
                            item {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(16.dp))
                                        .background(color = Color(0xfff3f2ff))
                                        .padding(all = 16.dp)
                                        .shadow(elevation = 2.dp,
                                            shape = RoundedCornerShape(16.dp))
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .requiredSize(size = 40.dp)
                                                .clip(shape = RoundedCornerShape(12.dp))
                                                .background(color = Color(0xff1171e3))
                                                .shadow(elevation = 2.dp,
                                                    shape = RoundedCornerShape(12.dp))
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color.White))
                                        }
                                        Column(
                                            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(48.97.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Column() {
                                                    Text(
                                                        text = "Welcome to StudyTrack!",
                                                        color = Color(0xff071747),
                                                        lineHeight = 1.38.em,
                                                        style = TextStyle(
                                                            fontSize = 16.sp),
                                                        modifier = Modifier
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                                Column() {
                                                    Text(
                                                        text = "3d ago",
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
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Enjoy your study journey. Set up your\nsemester courses to get personalized…",
                                                    color = Color(0xff414753),
                                                    lineHeight = 1.43.em,
                                                    style = TextStyle(
                                                        fontSize = 14.sp),
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(top = 4.dp)
                                            ) {
                                                Column(
                                                    modifier = Modifier
                                                        .clip(shape = RoundedCornerShape(9999.dp))
                                                        .background(color = Color(0xffdce1ff))
                                                        .padding(horizontal = 8.dp,
                                                            vertical = 2.dp)
                                                ) {
                                                    Text(
                                                        text = "System Onboarding",
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
                        }
                    }
                    item {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.container),
                                contentDescription = "Container",
                                colorFilter = ColorFilter.tint(Color(0xff414753)))
                            Column() {
                                Text(
                                    text = "Synced with Google Classroom & Canvas",
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
                                    text = "Notifications",
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

@Preview(widthDp = 390, heightDp = 928)
@Composable
private fun NotificationScreenPreview() {
    NotificationScreen(Modifier)
}