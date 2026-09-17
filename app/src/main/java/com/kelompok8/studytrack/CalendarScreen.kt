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
import androidx.compose.material3.InputChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
            .requiredHeight(height = 1104.dp)
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                ) {
                    item {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(16.dp))
                                .background(color = Color(0xfff3f2ff))
                                .padding(all = 12.dp)
                                .shadow(elevation = 2.dp,
                                    shape = RoundedCornerShape(16.dp))
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .requiredWidth(width = 34.dp)
                                        .requiredHeight(height = 36.dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color.White)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff071747)))
                                }
                                Column(
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "September\n2026",
                                            color = Color(0xff071747),
                                            lineHeight = 1.em,
                                            style = TextStyle(
                                                fontSize = 22.sp,
                                                fontWeight = FontWeight.Bold,
                                                letterSpacing = (-0.55).sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
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
                                                text = "Fall Semester",
                                                color = Color(0xff0059b8),
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
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .requiredWidth(width = 34.dp)
                                        .requiredHeight(height = 36.dp)
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color.White)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff071747)))
                                }
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(9999.dp))
                                    .background(color = Color(0xffd0e1fb))
                                    .padding(horizontal = 12.dp,
                                        vertical = 6.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.container),
                                    contentDescription = "Container",
                                    colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Today",
                                        color = Color(0xff54647a),
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
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .background(color = Color.White)
                                    .padding(all = 16.dp)
                                    .shadow(elevation = 2.dp,
                                        shape = RoundedCornerShape(16.dp))
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .weight(weight = 0.14f)
                                            .padding(vertical = 4.dp)
                                    ) {
                                        Text(
                                            text = "S",
                                            color = Color(0xffba1a1a).copy(alpha = 0.8f),
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
                                            .weight(weight = 0.14f)
                                            .padding(vertical = 4.dp)
                                    ) {
                                        Text(
                                            text = "M",
                                            color = Color(0xff414753),
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
                                            .weight(weight = 0.14f)
                                            .padding(vertical = 4.dp)
                                    ) {
                                        Text(
                                            text = "T",
                                            color = Color(0xff414753),
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
                                            .weight(weight = 0.14f)
                                            .padding(vertical = 4.dp)
                                    ) {
                                        Text(
                                            text = "W",
                                            color = Color(0xff414753),
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
                                            .weight(weight = 0.14f)
                                            .padding(vertical = 4.dp)
                                    ) {
                                        Text(
                                            text = "T",
                                            color = Color(0xff414753),
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
                                            .weight(weight = 0.14f)
                                            .padding(vertical = 4.dp)
                                    ) {
                                        Text(
                                            text = "F",
                                            color = Color(0xff414753),
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
                                            .weight(weight = 0.14f)
                                            .padding(vertical = 4.dp)
                                    ) {
                                        Text(
                                            text = "S",
                                            color = Color(0xff414753).copy(alpha = 0.7f),
                                            textAlign = TextAlign.Center,
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
                                        .fillMaxWidth()
                                        .requiredHeight(height = 252.dp)
                                ) {
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xffc1c6d6)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xffc1c6d6)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xffba1a1a).copy(alpha = 0.8f)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xffba1a1a).copy(alpha = 0.8f)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                        Column(
                                            modifier = Modifier
                                                .padding(top = 4.dp)
                                        ) {
                                            Badge()
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                        Column(
                                            modifier = Modifier
                                                .padding(top = 4.dp)
                                        ) {
                                            Badge()
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                    ) {
                                        InputChip(
                                            label = {
                                                Text(
                                                    text = "16",
                                                    color = Color.White,
                                                    textAlign = TextAlign.Center,
                                                    lineHeight = 1.38.em,
                                                    style = TextStyle(
                                                        fontSize = 16.sp),
                                                    modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                            },
                                            shape = RoundedCornerShape(9999.dp),
                                            colors = FilterChipDefaults.filterChipColors(
                                                containerColor = Color(0xff1171e3)
                                            ),
                                            selected = true,
                                            onClick = { },
                                            modifier = Modifier
                                                .shadow(elevation = 2.dp))
                                        Column(
                                            modifier = Modifier
                                                .padding(top = 4.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Badge(
                                                    containerColor = Color(0xffba1a1a))
                                                Badge(
                                                    containerColor = Color(0xfffbbf24))
                                                Badge(
                                                    containerColor = Color(0xff006947))
                                            }
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                    ) {
                                        Badge(
                                            contentColor = Color(0xffba1a1a).copy(alpha = 0.8f)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                        Column(
                                            modifier = Modifier
                                                .padding(top = 4.dp)
                                        ) {
                                            Badge()
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                        Column(
                                            modifier = Modifier
                                                .padding(top = 4.dp)
                                        ) {
                                            Badge()
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xffba1a1a).copy(alpha = 0.8f)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .padding(top = 11.dp,
                                                bottom = 17.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xff071747)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xffc1c6d6)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xffc1c6d6)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .requiredWidth(width = 36.dp)
                                            .requiredHeight(height = 44.dp)
                                    ) {
                                        Badge(
                                            contentColor = Color(0xffc1c6d6)
                                        ) {
                                            Text(
                                                text = badgeNumber)
                                        }
                                    }
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 20.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .requiredSize(size = 8.dp)
                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                .background(color = Color(0xffba1a1a)))
                                        Column() {
                                            Text(
                                                text = "High Priority",
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
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .requiredSize(size = 8.dp)
                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                .background(color = Color(0xfffbbf24)))
                                        Column() {
                                            Text(
                                                text = "Medium",
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
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .requiredSize(size = 8.dp)
                                                .clip(shape = RoundedCornerShape(9999.dp))
                                                .background(color = Color(0xff006947)))
                                        Column() {
                                            Text(
                                                text = "Low / Normal",
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
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(26.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp)
                            ) {
                                Column() {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "Today, 16 September 2026",
                                            color = Color(0xff071747),
                                            lineHeight = 1.33.em,
                                            style = TextStyle(
                                                fontSize = 18.sp,
                                                letterSpacing = (-0.45).sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "Wednesday Agenda",
                                            color = Color(0xff414753),
                                            lineHeight = 1.43.em,
                                            style = TextStyle(
                                                fontSize = 14.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .clip(shape = RoundedCornerShape(9999.dp))
                                        .background(color = Color(0xff0059b8).copy(alpha = 0.1f))
                                        .padding(horizontal = 12.dp,
                                            vertical = 4.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.container),
                                        contentDescription = "Container",
                                        colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                                    Text(
                                        text = "3 Tasks Due",
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
                        }
                    }
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
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
                                            .requiredHeight(height = 106.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .requiredWidth(width = 358.dp)
                                                .padding(all = 16.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(start = 8.dp)
                                            ) {
                                                Column(
                                                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                                                    modifier = Modifier
                                                        .weight(weight = 1f)
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
                                                                color = Color(0xff38485d),
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
                                                            verticalAlignment = Alignment.CenterVertically
                                                        ) {
                                                            Image(
                                                                painter = painterResource(id = R.drawable.container),
                                                                contentDescription = "Container",
                                                                colorFilter = ColorFilter.tint(Color(0xff414753)))
                                                            Text(
                                                                text = "2:00 PM",
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
                                                            text = "UI/UX Design Heuristic Evaluation",
                                                            color = Color(0xff071747),
                                                            lineHeight = 1.38.em,
                                                            style = TextStyle(
                                                                fontSize = 16.sp),
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                                    }
                                                }
                                                Row(
                                                    horizontalArrangement = Arrangement.Center,
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .requiredSize(size = 28.dp)
                                                        .clip(shape = RoundedCornerShape(8.dp))
                                                        .background(color = Color(0xff006947).copy(alpha = 0.1f))
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.container),
                                                        contentDescription = "Container",
                                                        colorFilter = ColorFilter.tint(Color(0xff006947)))
                                                }
                                            }
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(149.22.dp, Alignment.Start),
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(start = 8.dp,
                                                        top = 4.dp)
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .clip(shape = RoundedCornerShape(9999.dp))
                                                        .background(color = Color(0xfffef3c7))
                                                        .padding(horizontal = 10.dp,
                                                            vertical = 2.dp)
                                                ) {
                                                    Badge(
                                                        containerColor = Color(0xfff59e0b))
                                                    Text(
                                                        text = "Medium",
                                                        color = Color(0xff92400e),
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
                                                        .clip(shape = RoundedCornerShape(9999.dp))
                                                        .background(color = Color(0xff6ffbbe))
                                                        .padding(horizontal = 10.dp,
                                                            vertical = 2.dp)
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.container),
                                                        contentDescription = "Container",
                                                        colorFilter = ColorFilter.tint(Color(0xff002113)))
                                                    Text(
                                                        text = "Completed",
                                                        color = Color(0xff002113),
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
                                                .fillMaxHeight()
                                                .requiredWidth(width = 4.dp)
                                                .background(color = Color(0xff006947)))
                                    }
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 12.dp)
                                ) {
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
                                                .requiredHeight(height = 128.dp)
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .requiredWidth(width = 358.dp)
                                                    .padding(all = 16.dp)
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(start = 8.dp)
                                                ) {
                                                    Column(
                                                        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                                                        modifier = Modifier
                                                            .weight(weight = 1f)
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
                                                                    color = Color(0xff38485d),
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
                                                                verticalAlignment = Alignment.CenterVertically
                                                            ) {
                                                                Image(
                                                                    painter = painterResource(id = R.drawable.container),
                                                                    contentDescription = "Container",
                                                                    colorFilter = ColorFilter.tint(Color(0xff414753)))
                                                                Text(
                                                                    text = "6:00 PM",
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
                                                                text = "Database Normalization & Constraints",
                                                                color = Color(0xff071747),
                                                                lineHeight = 1.38.em,
                                                                style = TextStyle(
                                                                    fontSize = 16.sp),
                                                                modifier = Modifier
                                                                    .fillMaxWidth()
                                                                    .wrapContentHeight(align = Alignment.CenterVertically))
                                                        }
                                                    }
                                                    Row(
                                                        horizontalArrangement = Arrangement.Center,
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .requiredSize(size = 28.dp)
                                                            .clip(shape = RoundedCornerShape(8.dp))
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.container),
                                                            contentDescription = "Container",
                                                            colorFilter = ColorFilter.tint(Color(0xff414753)))
                                                    }
                                                }
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(170.09.dp, Alignment.Start),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(start = 8.dp,
                                                            top = 4.dp)
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .clip(shape = RoundedCornerShape(9999.dp))
                                                            .background(color = Color(0xff006947).copy(alpha = 0.1f))
                                                            .padding(horizontal = 10.dp,
                                                                vertical = 2.dp)
                                                    ) {
                                                        Badge(
                                                            containerColor = Color(0xff006947))
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
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .clip(shape = RoundedCornerShape(9999.dp))
                                                            .background(color = Color(0xffd0e1fb))
                                                            .padding(horizontal = 10.dp,
                                                                vertical = 2.dp)
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.container),
                                                            contentDescription = "Container",
                                                            colorFilter = ColorFilter.tint(Color(0xff0059b8)))
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
                                                }
                                            }
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxHeight()
                                                    .requiredWidth(width = 4.dp)
                                                    .background(color = Color(0xff1171e3)))
                                        }
                                    }
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 12.dp)
                                ) {
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
                                                .requiredHeight(height = 106.dp)
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .requiredWidth(width = 358.dp)
                                                    .padding(all = 16.dp)
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(start = 8.dp)
                                                ) {
                                                    Column(
                                                        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                                                        modifier = Modifier
                                                            .weight(weight = 1f)
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
                                                                    text = "Cryptography",
                                                                    color = Color(0xff38485d),
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
                                                                verticalAlignment = Alignment.CenterVertically
                                                            ) {
                                                                Image(
                                                                    painter = painterResource(id = R.drawable.container),
                                                                    contentDescription = "Container",
                                                                    colorFilter = ColorFilter.tint(Color(0xffba1a1a)))
                                                                Text(
                                                                    text = "11:59 PM",
                                                                    color = Color(0xffba1a1a),
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
                                                    }
                                                    Row(
                                                        horizontalArrangement = Arrangement.Center,
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .requiredSize(size = 28.dp)
                                                            .clip(shape = RoundedCornerShape(8.dp))
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.container),
                                                            contentDescription = "Container",
                                                            colorFilter = ColorFilter.tint(Color(0xff414753)))
                                                    }
                                                }
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(167.86.dp, Alignment.Start),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(start = 8.dp,
                                                            top = 4.dp)
                                                ) {
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .clip(shape = RoundedCornerShape(9999.dp))
                                                            .background(color = Color(0xffffdad6))
                                                            .padding(horizontal = 10.dp,
                                                                vertical = 2.dp)
                                                    ) {
                                                        Badge(
                                                            containerColor = Color(0xffba1a1a))
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
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        modifier = Modifier
                                                            .clip(shape = RoundedCornerShape(9999.dp))
                                                            .background(color = Color(0xffd0e1fb))
                                                            .padding(horizontal = 10.dp,
                                                                vertical = 2.dp)
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.container),
                                                            contentDescription = "Container",
                                                            colorFilter = ColorFilter.tint(Color(0xff0059b8)))
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
                                                }
                                            }
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxHeight()
                                                    .requiredWidth(width = 4.dp)
                                                    .background(color = Color(0xffba1a1a)))
                                        }
                                    }
                                }
                            }
                        }
                    }
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .background(color = Color(0xfff3f2ff))
                                    .padding(all = 12.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .requiredSize(size = 40.dp)
                                        .clip(shape = RoundedCornerShape(12.dp))
                                        .background(color = Color(0xff0059b8).copy(alpha = 0.1f))
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
                                            text = "Crypto Sprint Recommended",
                                            color = Color(0xff071747),
                                            lineHeight = 1.33.em,
                                            style = TextStyle(
                                                fontSize = 12.sp),
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "You have 1 high-priority task due before midnight.",
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
                horizontalArrangement = Arrangement.spacedBy(154.81.dp, Alignment.Start),
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
                                text = "Calendar",
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
                            .background(color = Color(0xffd0e1fb))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.container),
                            contentDescription = "Container",
                            colorFilter = ColorFilter.tint(Color(0xff0059b8)))
                    }
                    Column() {
                        Text(
                            text = "Calendar",
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

@Preview(widthDp = 390, heightDp = 1104)
@Composable
private fun FramePreview() {
    Frame(Modifier)
}