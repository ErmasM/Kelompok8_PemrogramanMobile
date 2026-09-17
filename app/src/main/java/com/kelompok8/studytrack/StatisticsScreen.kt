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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
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
            .requiredHeight(height = 1734.dp)
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
                ) {
                    item {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(9999.dp))
                                .background(color = Color(0xfff3f2ff))
                                .padding(all = 6.dp)
                                .shadow(elevation = 2.dp,
                                    shape = RoundedCornerShape(9999.dp))
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .weight(weight = 0.5f)
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .background(color = Color.White)
                                    .padding(vertical = 10.dp)
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(9999.dp))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.container),
                                    contentDescription = "Container",
                                    colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Overview",
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
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .weight(weight = 0.5f)
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .padding(vertical = 10.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.container),
                                    contentDescription = "Container",
                                    colorFilter = ColorFilter.tint(Color(0xff414753)))
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "By Subject",
                                        color = Color(0xff414753),
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
                                    .requiredHeight(height = 598.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .align(alignment = Alignment.TopEnd)
                                        .offset(x = 64.dp,
                                            y = (-64).dp)
                                        .requiredSize(size = 144.dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .blur(radius = 40.dp)
                                        .background(color = Color(0xffd0e1fb).copy(alpha = 0.4f)))
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(68.41.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .align(alignment = Alignment.TopStart)
                                        .offset(x = 0.dp,
                                            y = 20.dp)
                                        .fillMaxWidth()
                                ) {
                                    Column() {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Text(
                                                text = "ACADEMIC PERFORMANCE",
                                                color = Color(0xff505f76),
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
                                                text = "Overall Completion",
                                                color = Color(0xff071747),
                                                lineHeight = 1.33.em,
                                                style = TextStyle(
                                                    fontSize = 18.sp),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                    }
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .clip(shape = RoundedCornerShape(9999.dp))
                                            .background(color = Color(0xfff3f2ff))
                                            .padding(horizontal = 12.dp,
                                                vertical = 4.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.container),
                                            contentDescription = "Container",
                                            colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                        Column() {
                                            Text(
                                                text = "Term 1",
                                                color = Color(0xff0059b8),
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
                                    verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .align(alignment = Alignment.TopStart)
                                        .offset(x = 0.dp,
                                            y = 78.dp)
                                        .fillMaxWidth()
                                        .padding(vertical = 8.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .requiredSize(size = 144.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            modifier = Modifier
                                                .requiredSize(size = 144.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.svggauge),
                                                contentDescription = "SVG Gauge",
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .requiredHeight(height = 144.dp)
                                                    .rotate(degrees = 90f))
                                        }
                                        Column(
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            modifier = Modifier
                                                .fillMaxSize()
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .requiredWidth(width = 56.dp)
                                                    .requiredHeight(height = 34.dp)
                                            ) {
                                                Text(
                                                    text = "58",
                                                    color = Color(0xff071747),
                                                    textAlign = TextAlign.Center,
                                                    lineHeight = 1.em,
                                                    style = TextStyle(
                                                        fontSize = 32.sp,
                                                        letterSpacing = (-0.8).sp),
                                                    modifier = Modifier
                                                        .align(alignment = Alignment.TopCenter)
                                                        .offset(x = (-8.8).dp,
                                                            y = 0.dp)
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                                Text(
                                                    text = "%",
                                                    color = Color(0xff0059b8),
                                                    textAlign = TextAlign.Center,
                                                    lineHeight = 1.33.em,
                                                    style = TextStyle(
                                                        fontSize = 18.sp,
                                                        letterSpacing = (-0.8).sp),
                                                    modifier = Modifier
                                                        .align(alignment = Alignment.TopCenter)
                                                        .offset(x = 19.16.dp,
                                                            y = 9.5.dp)
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Column(
                                                modifier = Modifier
                                                    .padding(top = 2.dp)
                                            ) {
                                                Column(
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Text(
                                                        text = "Finished",
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
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterVertically)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally),
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.container),
                                                contentDescription = "Container",
                                                colorFilter = ColorFilter.tint(Color(0xff006947)))
                                            Column(
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Text(
                                                    text = "Ahead of schedule",
                                                    color = Color(0xff006947),
                                                    textAlign = TextAlign.Center,
                                                    lineHeight = 1.33.em,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        letterSpacing = 0.24.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Text(
                                                text = "Semester Completion Rate is tracking 12%\nhigher than midterm targets. Keep momentum\ngoing!",
                                                color = Color(0xff414753),
                                                textAlign = TextAlign.Center,
                                                lineHeight = 1.43.em,
                                                style = TextStyle(
                                                    fontSize = 14.sp),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                    }
                                }
                                Box(
                                    modifier = Modifier
                                        .align(alignment = Alignment.TopStart)
                                        .offset(x = 0.dp,
                                            y = 362.dp)
                                        .fillMaxWidth()
                                        .requiredHeight(height = 216.dp)
                                        .padding(top = 8.dp)
                                ) {
                                    Column(
                                        verticalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 155.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .background(color = Color(0xfff3f2ff))
                                            .padding(all = 12.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(bottom = 8.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(103.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .requiredSize(size = 10.dp)
                                                        .clip(shape = RoundedCornerShape(9999.dp))
                                                        .background(color = Color(0xff006947)))
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff006947)))
                                            }
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(bottom = 4.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "7",
                                                    color = Color(0xff071747),
                                                    lineHeight = 1.em,
                                                    style = TextStyle(
                                                        fontSize = 32.sp,
                                                        letterSpacing = (-0.32).sp),
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
                                                text = "Completed",
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
                                        verticalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 155.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .background(color = Color(0xfff3f2ff))
                                            .padding(all = 12.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(bottom = 8.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(103.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .requiredSize(size = 10.dp)
                                                        .clip(shape = RoundedCornerShape(9999.dp))
                                                        .background(color = Color(0xff0059b8)))
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                            }
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(bottom = 4.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "4",
                                                    color = Color(0xff071747),
                                                    lineHeight = 1.em,
                                                    style = TextStyle(
                                                        fontSize = 32.sp,
                                                        letterSpacing = (-0.32).sp),
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
                                                text = "In Progress",
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
                                        verticalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 155.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .background(color = Color(0xfff3f2ff))
                                            .padding(all = 12.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(bottom = 8.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(103.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .requiredSize(size = 10.dp)
                                                        .clip(shape = RoundedCornerShape(9999.dp))
                                                        .background(color = Color(0xff727785)))
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff505f76)))
                                            }
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(bottom = 4.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "1",
                                                    color = Color(0xff071747),
                                                    lineHeight = 1.em,
                                                    style = TextStyle(
                                                        fontSize = 32.sp,
                                                        letterSpacing = (-0.32).sp),
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
                                                text = "Not Started",
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
                                        verticalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 155.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .background(color = Color(0xfff3f2ff))
                                            .padding(all = 12.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(bottom = 8.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(103.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .requiredSize(size = 10.dp)
                                                        .clip(shape = RoundedCornerShape(9999.dp))
                                                        .background(color = Color(0xff006947)))
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff006947)))
                                            }
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(bottom = 4.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = "0",
                                                    color = Color(0xff006947),
                                                    lineHeight = 1.em,
                                                    style = TextStyle(
                                                        fontSize = 32.sp,
                                                        letterSpacing = (-0.32).sp),
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
                                                text = "All caught up!",
                                                color = Color(0xff006947),
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
                                }
                            }
                        }
                    }
                    item {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(16.dp))
                                .background(color = Color.White)
                                .padding(all = 20.dp)
                                .shadow(elevation = 2.dp,
                                    shape = RoundedCornerShape(16.dp))
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(35.67.dp, Alignment.Start),
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
                                    Column() {
                                        Text(
                                            text = "Study & Task Activity",
                                            color = Color(0xff071747),
                                            lineHeight = 1.33.em,
                                            style = TextStyle(
                                                fontSize = 18.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                                Column(
                                    modifier = Modifier
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color(0xffd0e1fb))
                                        .padding(horizontal = 10.dp,
                                            vertical = 4.dp)
                                ) {
                                    Text(
                                        text = "This Week",
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
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 16.dp,
                                        bottom = 4.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                    verticalAlignment = Alignment.Bottom,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .requiredHeight(height = 160.dp)
                                        .padding(horizontal = 4.dp)
                                ) {
                                    Column(
                                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 37.dp)
                                    ) {
                                        Column() {
                                            Text(
                                                text = "2",
                                                color = Color(0xff414753),
                                                lineHeight = 1.4.em,
                                                style = TextStyle(
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    letterSpacing = 0.4.sp),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                        Box(
                                            modifier = Modifier
                                                .requiredWidth(width = 28.dp)
                                                .requiredHeight(height = 64.dp)
                                                .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                                                .background(color = Color(0xffd0e1fb)))
                                        Column() {
                                            Text(
                                                text = "M",
                                                color = Color(0xff414753),
                                                lineHeight = 1.33.em,
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    letterSpacing = 0.24.sp),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 37.dp)
                                    ) {
                                        Column() {
                                            Text(
                                                text = "3",
                                                color = Color(0xff414753),
                                                lineHeight = 1.4.em,
                                                style = TextStyle(
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    letterSpacing = 0.4.sp),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                        Box(
                                            modifier = Modifier
                                                .requiredWidth(width = 28.dp)
                                                .requiredHeight(height = 96.dp)
                                                .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                                                .background(color = Color(0xffd0e1fb)))
                                        Column() {
                                            Text(
                                                text = "T",
                                                color = Color(0xff414753),
                                                lineHeight = 1.33.em,
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    letterSpacing = 0.24.sp),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 37.dp)
                                    ) {
                                        Column(
                                            verticalArrangement = Arrangement.Bottom,
                                            modifier = Modifier
                                                .requiredWidth(width = 37.dp)
                                                .requiredHeight(height = 160.dp)
                                        ) {
                                            Column() {
                                                Text(
                                                    text = "5",
                                                    color = Color(0xff0059b8),
                                                    lineHeight = 1.4.em,
                                                    style = TextStyle(
                                                        fontSize = 10.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        letterSpacing = 0.4.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Surface(
                                                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
                                                color = Color(0xff0059b8),
                                                modifier = Modifier
                                                    .weight(weight = 1f)
                                                    .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                                                    .shadow(elevation = 4.dp,
                                                        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .requiredWidth(width = 28.dp)
                                                        .requiredHeight(height = 114.dp)
                                                        .shadow(elevation = 4.dp)
                                                ) {
                                                    Box(
                                                        modifier = Modifier
                                                            .fillMaxSize()
                                                            .background(color = Color.White)
                                                            .shadow(elevation = 4.dp))
                                                }
                                            }
                                            Column() {
                                                Text(
                                                    text = "W",
                                                    color = Color(0xff0059b8),
                                                    lineHeight = 1.33.em,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        letterSpacing = 0.24.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                        }
                                        Column(
                                            modifier = Modifier
                                                .align(alignment = Alignment.TopStart)
                                                .offset(x = 0.72.dp,
                                                    y = (-12).dp)
                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                .background(color = Color(0xff0059b8))
                                                .padding(horizontal = 6.dp,
                                                    vertical = 2.dp)
                                                .shadow(elevation = 2.dp,
                                                    shape = RoundedCornerShape(9999.dp))
                                        ) {
                                            Text(
                                                text = "Peak",
                                                color = Color.White,
                                                lineHeight = 2.em,
                                                style = TextStyle(
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 37.dp)
                                    ) {
                                        Column() {
                                            Text(
                                                text = "3",
                                                color = Color(0xff414753),
                                                lineHeight = 1.4.em,
                                                style = TextStyle(
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    letterSpacing = 0.4.sp),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                        Box(
                                            modifier = Modifier
                                                .requiredWidth(width = 28.dp)
                                                .requiredHeight(height = 88.dp)
                                                .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                                                .background(color = Color(0xffd0e1fb)))
                                        Column() {
                                            Text(
                                                text = "T",
                                                color = Color(0xff414753),
                                                lineHeight = 1.33.em,
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    letterSpacing = 0.24.sp),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 37.dp)
                                    ) {
                                        Column() {
                                            Text(
                                                text = "4",
                                                color = Color(0xff414753),
                                                lineHeight = 1.4.em,
                                                style = TextStyle(
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    letterSpacing = 0.4.sp),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxHeight()
                                                .requiredWidth(width = 28.dp)
                                                .weight(weight = 1f)
                                                .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                                                .background(color = Color(0xffd0e1fb)))
                                        Column() {
                                            Text(
                                                text = "F",
                                                color = Color(0xff414753),
                                                lineHeight = 1.33.em,
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    letterSpacing = 0.24.sp),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 37.dp)
                                    ) {
                                        Column() {
                                            Text(
                                                text = "1",
                                                color = Color(0xff414753),
                                                lineHeight = 1.4.em,
                                                style = TextStyle(
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    letterSpacing = 0.4.sp),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                        Box(
                                            modifier = Modifier
                                                .requiredWidth(width = 28.dp)
                                                .requiredHeight(height = 32.dp)
                                                .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                                                .background(color = Color(0xffe4e7ff)))
                                        Column() {
                                            Text(
                                                text = "S",
                                                color = Color(0xff414753),
                                                lineHeight = 1.33.em,
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    letterSpacing = 0.24.sp),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .requiredWidth(width = 37.dp)
                                    ) {
                                        Column() {
                                            Text(
                                                text = "2",
                                                color = Color(0xff414753),
                                                lineHeight = 1.4.em,
                                                style = TextStyle(
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    letterSpacing = 0.4.sp),
                                                modifier = Modifier
                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                        }
                                        Box(
                                            modifier = Modifier
                                                .requiredWidth(width = 28.dp)
                                                .requiredHeight(height = 56.dp)
                                                .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                                                .background(color = Color(0xffe4e7ff)))
                                        Column() {
                                            Text(
                                                text = "S",
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
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(84.48.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff006947)))
                                    Text(
                                        text = "20 tasks recorded this week",
                                        color = Color(0xff414753),
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
                                        text = "Detailed Log",
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
                    item {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(16.dp))
                                        .background(color = Color.White)
                                        .padding(all = 16.dp)
                                        .shadow(elevation = 2.dp,
                                            shape = RoundedCornerShape(16.dp))
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(102.97.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .requiredSize(size = 36.dp)
                                                    .clip(shape = RoundedCornerShape(12.dp))
                                                    .background(color = Color(0xffd7e2ff))
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
                                                        text = "Cryptography",
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
                                                        text = "3 of 4 tasks completed",
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
                                        Column(
                                            horizontalAlignment = Alignment.End
                                        ) {
                                            Column() {
                                                Text(
                                                    text = "75%",
                                                    color = Color(0xff0059b8),
                                                    lineHeight = 1.38.em,
                                                    style = TextStyle(
                                                        fontSize = 16.sp,
                                                        fontWeight = FontWeight.Bold),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(1.99.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff006947)))
                                                Text(
                                                    text = "On Track",
                                                    color = Color(0xff006947),
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
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .requiredHeight(height = 10.dp)
                                            .clip(shape = RoundedCornerShape(9999.dp))
                                            .background(color = Color(0xffe4e7ff))
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                .background(color = Color(0xff0059b8)))
                                    }
                                }
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(16.dp))
                                        .background(color = Color.White)
                                        .padding(all = 16.dp)
                                        .shadow(elevation = 2.dp,
                                            shape = RoundedCornerShape(16.dp))
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(101.74.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .requiredSize(size = 36.dp)
                                                    .clip(shape = RoundedCornerShape(12.dp))
                                                    .background(color = Color(0xff6ffbbe))
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff006947)))
                                            }
                                            Column() {
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Text(
                                                        text = "UI/UX Design",
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
                                                        text = "4 of 5 tasks completed",
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
                                        Column(
                                            horizontalAlignment = Alignment.End
                                        ) {
                                            Column() {
                                                Text(
                                                    text = "80%",
                                                    color = Color(0xff006947),
                                                    lineHeight = 1.38.em,
                                                    style = TextStyle(
                                                        fontSize = 16.sp,
                                                        fontWeight = FontWeight.Bold),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(1.99.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff006947)))
                                                Text(
                                                    text = "Top Pace",
                                                    color = Color(0xff006947),
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
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .requiredHeight(height = 10.dp)
                                            .clip(shape = RoundedCornerShape(9999.dp))
                                            .background(color = Color(0xffe4e7ff))
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                .background(color = Color(0xff006947)))
                                    }
                                }
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(16.dp))
                                        .background(color = Color.White)
                                        .padding(all = 16.dp)
                                        .shadow(elevation = 2.dp,
                                            shape = RoundedCornerShape(16.dp))
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(86.6.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .requiredSize(size = 36.dp)
                                                    .clip(shape = RoundedCornerShape(12.dp))
                                                    .background(color = Color(0xffd0e1fb))
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff54647a)))
                                            }
                                            Column() {
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Text(
                                                        text = "Database Systems",
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
                                                        text = "3 of 5 tasks completed",
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
                                        Column(
                                            horizontalAlignment = Alignment.End
                                        ) {
                                            Column() {
                                                Text(
                                                    text = "60%",
                                                    color = Color(0xff0059b8),
                                                    lineHeight = 1.38.em,
                                                    style = TextStyle(
                                                        fontSize = 16.sp,
                                                        fontWeight = FontWeight.Bold),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            }
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(1.99.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff505f76)))
                                                Text(
                                                    text = "Steady",
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
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .requiredHeight(height = 10.dp)
                                            .clip(shape = RoundedCornerShape(9999.dp))
                                            .background(color = Color(0xffe4e7ff))
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                .background(color = Color(0xff0059b8)))
                                    }
                                }
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(16.dp))
                                        .background(color = Color.White)
                                        .padding(all = 16.dp)
                                        .shadow(elevation = 2.dp,
                                            shape = RoundedCornerShape(16.dp))
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(75.98.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .requiredSize(size = 36.dp)
                                                    .clip(shape = RoundedCornerShape(12.dp))
                                                    .background(color = Color(0xffebedff))
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff414753)))
                                            }
                                            Column() {
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Text(
                                                        text = "Operating Systems",
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
                                                        text = "2 of 4 tasks completed",
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
                                        Column(
                                            horizontalAlignment = Alignment.End
                                        ) {
                                            Column() {
                                                Text(
                                                    text = "50%",
                                                    color = Color(0xff0059b8),
                                                    lineHeight = 1.38.em,
                                                    style = TextStyle(
                                                        fontSize = 16.sp,
                                                        fontWeight = FontWeight.Bold),
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
                                                    colorFilter = ColorFilter.tint(Color(0xff505f76)))
                                                Text(
                                                    text = "Halfway",
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
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .requiredHeight(height = 10.dp)
                                            .clip(shape = RoundedCornerShape(9999.dp))
                                            .background(color = Color(0xffe4e7ff))
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                .background(color = Color(0xff0059b8)))
                                    }
                                }
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(16.dp))
                                        .background(color = Color.White)
                                        .padding(all = 16.dp)
                                        .shadow(elevation = 2.dp,
                                            shape = RoundedCornerShape(16.dp))
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(82.17.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .requiredSize(size = 36.dp)
                                                    .clip(shape = RoundedCornerShape(12.dp))
                                                    .background(color = Color(0xffd3e4fe))
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.container),
                                                    contentDescription = "Container",
                                                    colorFilter = ColorFilter.tint(Color(0xff38485d)))
                                            }
                                            Column() {
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                ) {
                                                    Text(
                                                        text = "Web Programming",
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
                                                        text = "2 of 5 tasks completed",
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
                                        Column(
                                            horizontalAlignment = Alignment.End
                                        ) {
                                            Column() {
                                                Text(
                                                    text = "40%",
                                                    color = Color(0xff0059b8),
                                                    lineHeight = 1.38.em,
                                                    style = TextStyle(
                                                        fontSize = 16.sp,
                                                        fontWeight = FontWeight.Bold),
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
                                                    colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                                Text(
                                                    text = "Next Up",
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
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .requiredHeight(height = 10.dp)
                                            .clip(shape = RoundedCornerShape(9999.dp))
                                            .background(color = Color(0xffe4e7ff))
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                .background(color = Color(0xff0059b8)))
                                    }
                                }
                            }
                        }
                    }
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .background(color = Color(0xffd0e1fb))
                                    .padding(all = 16.dp)
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(16.dp))
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .requiredSize(size = 40.dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color.White)
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
                                            text = "Study Milestone Reached!",
                                            color = Color(0xff54647a),
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
                                            text = "You completed 3 quizzes with a score\nabove 90% this month.",
                                            color = Color(0xff54647a),
                                            lineHeight = 1.43.em,
                                            style = TextStyle(
                                                fontSize = 14.sp),
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
        Column(
            modifier = Modifier
                .requiredWidth(width = 390.dp)
                .background(color = Color(0xfffaf8ff).copy(alpha = 0.8f))
                .shadow(elevation = 8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(152.19.dp, Alignment.Start),
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
                                text = "Statistics",
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
                            .background(color = Color(0xffd0e1fb))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.container),
                            contentDescription = "Container",
                            colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                    }
                    Column() {
                        Text(
                            text = "Analytics",
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
                            text = "Profile",
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

@Preview(widthDp = 390, heightDp = 1734)
@Composable
private fun FramePreview() {
    Frame(Modifier)
}