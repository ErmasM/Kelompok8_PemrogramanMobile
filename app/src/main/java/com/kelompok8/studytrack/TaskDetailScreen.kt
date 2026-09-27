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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Frame(modifier: Modifier = Modifier, badgeNumber: String) {
    Box(
        modifier = modifier
            .requiredWidth(width = 390.dp)
            .requiredHeight(height = 1347.dp)
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
                        .requiredHeight(height = 1323.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(93.64.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.container),
                                contentDescription = "Container",
                                colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                            Column() {
                                Text(
                                    text = "Assignments",
                                    color = Color(0xff414753),
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
                                colorFilter = ColorFilter.tint(Color(0xff414753)))
                            Column() {
                                Text(
                                    text = "CS-402",
                                    color = Color(0xff071747),
                                    lineHeight = 1.33.em,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        letterSpacing = 0.24.sp),
                                    modifier = Modifier
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .requiredSize(size = 36.dp)
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .background(color = Color(0xffebedff))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.container),
                                    contentDescription = "Container",
                                    colorFilter = ColorFilter.tint(Color(0xff071747)))
                            }
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .requiredSize(size = 36.dp)
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .background(color = Color(0xffebedff))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.container),
                                    contentDescription = "Container",
                                    colorFilter = ColorFilter.tint(Color(0xff071747)))
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 0.dp,
                                y = 44.dp)
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = Color.White,
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(12.dp))
                                .shadow(elevation = 2.dp,
                                    shape = RoundedCornerShape(12.dp))
                        ) {
                            Box(
                                modifier = Modifier
                                    .requiredWidth(width = 358.dp)
                                    .requiredHeight(height = 244.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .requiredWidth(width = 358.dp)
                                        .padding(all = 20.dp)
                                ) {
                                    Column(
                                        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 8.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .requiredHeight(height = 44.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .align(alignment = Alignment.CenterStart)
                                                    .offset(x = 0.dp,
                                                        y = (-13).dp)
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                                    .background(color = Color(0xffd0e1fb))
                                                    .padding(horizontal = 8.dp,
                                                        vertical = 2.dp)
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff54647a)))
                                                Text(
                                                    text = "Cryptography • CS-402",
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
                                                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .align(alignment = Alignment.CenterStart)
                                                    .offset(x = 167.39.dp,
                                                        y = (-13).dp)
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                                    .background(color = Color(0xffffdad6))
                                                    .padding(horizontal = 8.dp,
                                                        vertical = 2.dp)
                                            ) {
                                                Badge(
                                                    containerColor = Color(0xffba1a1a))
                                                Text(
                                                    text = "High Priority",
                                                    color = Color(0xff93000a),
                                                    lineHeight = 1.4.em,
                                                    style = TextStyle(
                                                        fontSize = 10.sp,
                                                        letterSpacing = 0.4.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .align(alignment = Alignment.CenterStart)
                                                    .offset(x = 0.dp,
                                                        y = 13.dp)
                                                    .clip(shape = RoundedCornerShape(9999.dp))
                                                    .background(color = Color(0xffd7e2ff))
                                                    .padding(horizontal = 8.dp,
                                                        vertical = 2.dp)
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff004591)))
                                                Text(
                                                    text = "In Progress",
                                                    color = Color(0xff004591),
                                                    lineHeight = 1.4.em,
                                                    style = TextStyle(
                                                        fontSize = 10.sp,
                                                        letterSpacing = 0.4.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 4.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "Cryptography Assignment 2",
                                                    color = Color(0xff071747),
                                                    lineHeight = 1.27.em,
                                                    style = TextStyle(
                                                        fontSize = 22.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        letterSpacing = (-0.55).sp),
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Text(
                                                text = "Lab Exercise: Symmetric & Asymmetric\nImplementations",
                                                color = Color(0xff414753),
                                                lineHeight = 1.43.em,
                                                style = TextStyle(
                                                    fontSize = 14.sp),
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                    }
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(87.2.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(shape = RoundedCornerShape(8.dp))
                                            .background(color = Color(0xfff3f2ff))
                                            .padding(all = 12.dp)
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
                                                    .background(color = Color(0xff1171e3))
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xfffefcff)))
                                            }
                                            Column() {
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Text(
                                                        text = "Tomorrow, 11:59 PM",
                                                        color = Color(0xff071747),
                                                        lineHeight = 1.33.em,
                                                        style = TextStyle(
                                                            fontSize = 12.sp,
                                                            letterSpacing = 0.24.sp),
                                                        modifier = Modifier
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.container),
                                                        contentDescription = "Container",
                                                        colorFilter = ColorFilter.tint(Color(0xffba1a1a)))
                                                    Text(
                                                        text = "23 hours left",
                                                        color = Color(0xffba1a1a),
                                                        lineHeight = 1.4.em,
                                                        style = TextStyle(
                                                            fontSize = 10.sp,
                                                            fontWeight = FontWeight.Medium,
                                                            letterSpacing = 0.4.sp),
                                                        modifier = Modifier
                                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                                }
                                            }
                                        }
                                        Column(
                                            horizontalAlignment = Alignment.End
                                        ) {
                                            Column(
                                                horizontalAlignment = Alignment.End
                                            ) {
                                                Text(
                                                    text = "Weight",
                                                    color = Color(0xff414753),
                                                    textAlign = TextAlign.End,
                                                    lineHeight = 1.4.em,
                                                    style = TextStyle(
                                                        fontSize = 10.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        letterSpacing = 0.4.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Text(
                                                text = "15%",
                                                color = Color(0xff0059b8),
                                                textAlign = TextAlign.End,
                                                lineHeight = 1.38.em,
                                                style = TextStyle(
                                                    fontSize = 16.sp,
                                                    fontWeight = FontWeight.Bold),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
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
                    Column(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 0.dp,
                                y = 308.dp)
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(12.dp))
                                .background(color = Color.White)
                                .padding(all = 16.dp)
                                .shadow(elevation = 2.dp,
                                    shape = RoundedCornerShape(12.dp))
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(127.52.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff006947)))
                                    Text(
                                        text = "Checklist Progress",
                                        color = Color(0xff071747),
                                        lineHeight = 1.38.em,
                                        style = TextStyle(
                                            fontSize = 16.sp),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                                Badge(
                                    contentColor = Color(0xff006947)
                                ) {
                                    Text(
                                        text = badgeNumber)
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 8.dp)
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .background(color = Color(0xffebedff))
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color(0xff006947)))
                            }
                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(8.dp))
                                        .padding(all = 8.dp)
                                ) {
                                    val checkedState = remember { mutableStateOf(true) }
                                    Checkbox(
                                        checked = checkedState.value,
                                        onCheckedChange = { checkedState.value = it })
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "Implement AES-128 Encryption &\nDecryption",
                                            color = Color(0xff414753),
                                            textDecoration = TextDecoration.LineThrough,
                                            lineHeight = 1.43.em,
                                            style = TextStyle(
                                                fontSize = 14.sp),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(8.dp))
                                        .padding(all = 8.dp)
                                ) {
                                    val checkedState = remember { mutableStateOf(true) }
                                    Checkbox(
                                        checked = checkedState.value,
                                        onCheckedChange = { checkedState.value = it })
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "Implement RSA Key Generation (2048-\nbit)",
                                            color = Color(0xff414753),
                                            textDecoration = TextDecoration.LineThrough,
                                            lineHeight = 1.43.em,
                                            style = TextStyle(
                                                fontSize = 14.sp),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                                TextField(
                                    value = "",
                                    onValueChange = {},
                                    label = {
                                        Text(
                                            text = "Generate benchmark time graphs & final\nPDF report",
                                            color = Color(0xff071747),
                                            lineHeight = 1.43.em,
                                            style = TextStyle(
                                                fontSize = 14.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(8.dp))
                                        .padding(all = 8.dp))
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 0.dp,
                                y = 602.dp)
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(12.dp))
                                .background(color = Color.White)
                                .padding(all = 20.dp)
                                .shadow(elevation = 2.dp,
                                    shape = RoundedCornerShape(12.dp))
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
                                    colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                Text(
                                    text = "Description",
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
                                    text = "Mengerjakan soal latihan dan membuat laporan\nsesuai dengan format yang diberikan. Pastikan\nmengimplementasikan algoritma AES dan RSA\ndengan benchmark waktu eksekusi.",
                                    color = Color(0xff414753),
                                    lineHeight = 1.63.em,
                                    style = TextStyle(
                                        fontSize = 14.sp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(8.dp))
                                        .background(color = Color(0xfff3f2ff))
                                        .padding(all = 12.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.margin),
                                        contentDescription = "Margin",
                                        colorFilter = ColorFilter.tint(Color(0xff0059b8)),
                                        modifier = Modifier
                                            .padding(top = 2.dp))
                                    Column(
                                        modifier = Modifier
                                            .padding(end = 3.9700000286102295.dp)
                                    ) {
                                        Text(
                                            text = "Laporan dikumpulkan dalam format PDF disertai\nsource code (C++ / Python / Go) dalam file archive\n.ZIP.",
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
                    Column(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 0.dp,
                                y = 867.dp)
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(12.dp))
                                .background(color = Color.White)
                                .padding(all = 20.dp)
                                .shadow(elevation = 2.dp,
                                    shape = RoundedCornerShape(12.dp))
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(95.55.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                    Text(
                                        text = "Attachments (1)",
                                        color = Color(0xff071747),
                                        lineHeight = 1.33.em,
                                        style = TextStyle(
                                            fontSize = 18.sp),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "+ Add File",
                                        color = Color(0xff0059b8),
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
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .background(color = Color(0xfff3f2ff))
                                    .padding(all = 12.dp)
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
                                            .clip(shape = RoundedCornerShape(8.dp))
                                            .background(color = Color(0xffffdad6))
                                            .shadow(elevation = 2.dp,
                                                shape = RoundedCornerShape(8.dp))
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.container),
                                            contentDescription = "Container",
                                            colorFilter = ColorFilter.tint(Color(0xff93000a)))
                                    }
                                    Column() {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Text(
                                                text = "tugas-kriptografi.pdf",
                                                color = Color(0xff071747),
                                                lineHeight = 1.38.em,
                                                style = TextStyle(
                                                    fontSize = 16.sp,
                                                    fontWeight = FontWeight.Medium),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Text(
                                                text = "2.4 MB • Uploaded Sep 14",
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
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .requiredSize(size = 36.dp)
                                            .clip(shape = RoundedCornerShape(9999.dp))
                                            .background(color = Color.White)
                                            .shadow(elevation = 2.dp,
                                                shape = RoundedCornerShape(9999.dp))
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.container),
                                            contentDescription = "Container",
                                            colorFilter = ColorFilter.tint(Color(0xff071747)))
                                    }
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .requiredSize(size = 36.dp)
                                            .clip(shape = RoundedCornerShape(9999.dp))
                                            .background(color = Color.White)
                                            .shadow(elevation = 2.dp,
                                                shape = RoundedCornerShape(9999.dp))
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.container),
                                            contentDescription = "Container",
                                            colorFilter = ColorFilter.tint(Color(0xff071747)))
                                    }
                                }
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 0.dp,
                                y = 1031.dp)
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(12.dp))
                                .background(color = Color.White)
                                .padding(all = 16.dp)
                                .shadow(elevation = 2.dp,
                                    shape = RoundedCornerShape(12.dp))
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.container),
                                contentDescription = "AB6AXuBBCTl9J90jPkfW7X6WwfJaZd1yNaciQZQAUz6RjmEWPc8OC9jvmfq9rjHVCKO3iIfrBbePcvBB28UWHk-BYe91OvYS-6ADcnFIFYU_3uEleeYpMoCgXSqO_7IYS5-xQJ5U_J8O6HwdCk0nwEPi9dx0aJdmGP5tHjEOhVLuxq4VJ5ORRIt4jaG_vHSBjh1JUxug9fOGIfVPAeGWSXN1OuSq2xgGrJNI-QVHU4aKjgTyiGwxHO-XfYGn3g",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .requiredSize(size = 64.dp)
                                    .clip(shape = RoundedCornerShape(8.dp)))
                            Column() {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        text = "Prof. Dr. Ir. H. Wardhana",
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
                                        text = "Dept. of Computer Science • Office Hours: Thu\n2-4 PM",
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
                                        .fillMaxWidth()
                                        .padding(top = 4.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.container),
                                            contentDescription = "Container",
                                            colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                        Text(
                                            text = "Contact Lecturer",
                                            color = Color(0xff0059b8),
                                            lineHeight = 1.4.em,
                                            style = TextStyle(
                                                fontSize = 10.sp,
                                                letterSpacing = 0.4.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 0.dp,
                                y = 1151.dp)
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                        ) {
                            Surface(
                                shape = RoundedCornerShape(9999.dp),
                                color = Color(0xff006947),
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .shadow(elevation = 4.dp,
                                        shape = RoundedCornerShape(9999.dp))
                            ) {
                                Box(
                                    modifier = Modifier
                                        .requiredWidth(width = 358.dp)
                                        .requiredHeight(height = 48.dp)
                                        .shadow(elevation = 4.dp)
                                ) {
                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier
                                            .requiredWidth(width = 358.dp)
                                            .requiredHeight(height = 48.dp)
                                    ) {
                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                text = "Mark as Completed",
                                                color = Color.White,
                                                textAlign = TextAlign.Center,
                                                lineHeight = 1.43.em,
                                                style = TextStyle(
                                                    fontSize = 14.sp,
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
                                            .requiredHeight(height = 48.dp)
                                            .clip(shape = RoundedCornerShape(9999.dp))
                                            .background(color = Color.White)
                                            .shadow(elevation = 4.dp,
                                                shape = RoundedCornerShape(9999.dp)))
                                }
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .requiredHeight(height = 44.dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color(0xffebedff))
                                        .padding(horizontal = 49.060001373291016.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff071747)))
                                    Text(
                                        text = "Edit Task",
                                        color = Color(0xff071747),
                                        textAlign = TextAlign.Center,
                                        lineHeight = 1.33.em,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            letterSpacing = 0.24.sp),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .requiredHeight(height = 44.dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color(0xffffdad6))
                                        .padding(start = 55.45000076293945.dp,
                                            end = 55.459999084472656.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff93000a)))
                                    Text(
                                        text = "Delete",
                                        color = Color(0xff93000a),
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
                                    text = "Task Detail",
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

@Preview(widthDp = 390, heightDp = 1347)
@Composable
private fun FramePreview() {
    Frame(Modifier, "66%")
}