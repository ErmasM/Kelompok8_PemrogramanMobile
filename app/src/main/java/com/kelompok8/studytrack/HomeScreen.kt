package com.kelompok8.studytrack

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.QueryStats
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// ============================================================
// COLORS
// ============================================================

private val Background = Color(0xFFFAF8FF)
private val Navy = Color(0xFF071747)
private val Blue = Color(0xFF0059B8)
private val BrightBlue = Color(0xFF1171E3)
private val Gray = Color(0xFF414753)
private val LightBlue = Color(0xFFD0E1FB)
private val LightPurple = Color(0xFFEBEDFF)
private val Green = Color(0xFF006947)
private val LightGreen = Color(0xFF6FFBBE)
private val Red = Color(0xFFBA1A1A)
private val LightRed = Color(0xFFFFDAD6)


// ============================================================
// DATA
// ============================================================

data class Task(
    val category: String,
    val title: String,
    val priority: String,
    val status: String,
    val deadline: String
)

private val tasks = listOf(
    Task(
        category = "Cryptography",
        title = "Cryptography Assignment 2",
        priority = "High",
        status = "In Progress",
        deadline = "Due tomorrow • 11:59 PM"
    ),
    Task(
        category = "Operating Systems",
        title = "Operating Systems Lab 3: Kernel Locks",
        priority = "High",
        status = "In Progress",
        deadline = "Due in 2 days • 5:00 PM"
    ),
    Task(
        category = "Database Systems",
        title = "Database Normalization & Constraints",
        priority = "Medium",
        status = "Not Started",
        deadline = "Due in 4 days • 11:00 PM"
    ),
    Task(
        category = "Web Programming",
        title = "Build E-Commerce Website",
        priority = "Low",
        status = "In Progress",
        deadline = "Due in 6 days • 11:59 PM"
    )
)


// ============================================================
// HOME SCREEN
// ============================================================

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onAddTaskClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onTasksClick: () -> Unit = {},
    onCalendarClick: () -> Unit = {},
    onAnalyticsClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {}
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
    ) {

        // ====================================================
        // MAIN CONTENT
        // ====================================================

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),

            verticalArrangement = Arrangement.spacedBy(16.dp),

            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                top = 20.dp,
                bottom = 150.dp
            )
        ) {

            // ------------------------------------------------
            // HEADER
            // ------------------------------------------------

            item {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Good morning, Alex 👋",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy
                        )

                        Spacer(
                            modifier = Modifier.height(2.dp)
                        )

                        Text(
                            text = "Here's your study progress today.",
                            fontSize = 14.sp,
                            color = Gray
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(LightPurple)
                            .clickable { onNotificationClick() }
                    ) {

                        Icon(
                            imageVector = Icons.Default.NotificationsNone,
                            contentDescription = "Notifications",
                            tint = Gray,
                            modifier = Modifier
                                .size(25.dp)
                                .align(Alignment.Center)
                        )

                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(Red)
                                .align(Alignment.TopEnd)
                        )
                    }
                }
            }


            // ------------------------------------------------
            // DAILY MINDSET
            // ------------------------------------------------

            item {

                DailyMindsetCard()
            }


            // ------------------------------------------------
            // YOUR PROGRESS
            // ------------------------------------------------

            item {

                ProgressCard()
            }


            // ------------------------------------------------
            // STUDY ROOM
            // ------------------------------------------------

            item {

                StudyRoomCard()
            }


            // ------------------------------------------------
            // UPCOMING DEADLINES TITLE
            // ------------------------------------------------

            item {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Upcoming Deadlines",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy,
                        modifier = Modifier.weight(1f)
                    )

                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(LightBlue),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = "4",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Blue
                        )
                    }

                    Spacer(
                        modifier = Modifier.width(12.dp)
                    )

                    Text(
                        text = "See all ›",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Blue,
                        modifier = Modifier.clickable {
                            onTasksClick()
                        }
                    )
                }
            }


            // ------------------------------------------------
            // TASK LIST
            // ------------------------------------------------

            items(tasks) { task ->

                TaskCard(
                    task = task
                )
            }
        }


        // ====================================================
        // FLOATING ADD TASK BUTTON
        // ====================================================

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    end = 20.dp,
                    bottom = 105.dp
                )
        ) {

            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Blue)
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clickable {
                        onAddTaskClick()
                    }
                    .padding(
                        horizontal = 18.dp,
                        vertical = 14.dp
                    ),

                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Task",
                    tint = Color.White,
                    modifier = Modifier.size(22.dp)
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text(
                    text = "Add Task",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }


        // ====================================================
        // BOTTOM NAVIGATION
        // ====================================================

        HomeBottomNavigation(
            modifier = Modifier.align(Alignment.BottomCenter),
            onTasksClick = onTasksClick,
            onCalendarClick = onCalendarClick,
            onAnalyticsClick = onAnalyticsClick,
            onProfileClick = onProfileClick,
        )
    }
}


// ============================================================
// DAILY MINDSET CARD
// ============================================================

@Composable
private fun DailyMindsetCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = LightBlue.copy(alpha = 0.55f)
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "💪",
                    fontSize = 25.sp
                )
            }

            Spacer(
                modifier = Modifier.width(16.dp)
            )

            Column {

                Text(
                    text = "DAILY MINDSET",
                    color = Blue,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )

                Text(
                    text = "Keep going!",
                    color = Navy,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "“Small steps every day lead to big results.”",
                    color = Gray,
                    fontSize = 14.sp
                )
            }
        }
    }
}


// ============================================================
// PROGRESS CARD
// ============================================================

@Composable
private fun ProgressCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            // Header

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Your Progress",
                        color = Navy,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Semester 5 • Fall 2026",
                        color = Gray,
                        fontSize = 12.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(LightPurple)
                        .padding(
                            horizontal = 12.dp,
                            vertical = 6.dp
                        )
                ) {

                    Text(
                        text = "Term Goal",
                        color = Gray,
                        fontSize = 10.sp
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Circular progress

                Box(
                    modifier = Modifier.size(112.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Canvas(
                        modifier = Modifier.fillMaxSize()
                    ) {

                        drawArc(
                            color = Color(0xFFE4E7FF),
                            startAngle = -90f,
                            sweepAngle = 360f,
                            useCenter = false,
                            style = Stroke(
                                width = 12.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        )

                        drawArc(
                            color = Blue,
                            startAngle = -90f,
                            sweepAngle = 58f / 100f * 360f,
                            useCenter = false,
                            style = Stroke(
                                width = 12.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "58%",
                            color = Blue,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Done",
                            color = Gray,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }


                Spacer(
                    modifier = Modifier.width(20.dp)
                )


                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    ProgressRow(
                        title = "Total Tasks",
                        value = "12",
                        dotColor = Blue,
                        background = LightPurple
                    )

                    ProgressRow(
                        title = "Completed",
                        value = "7",
                        dotColor = Green,
                        background = LightGreen.copy(alpha = 0.35f)
                    )

                    ProgressRow(
                        title = "In Progress",
                        value = "4",
                        dotColor = BrightBlue,
                        background = LightBlue.copy(alpha = 0.6f)
                    )

                    ProgressRow(
                        title = "Not Started",
                        value = "1",
                        dotColor = Color(0xFF727785),
                        background = Color(0xFFE4E7FF).copy(alpha = 0.5f)
                    )
                }
            }
        }
    }
}


// ============================================================
// PROGRESS ROW
// ============================================================

@Composable
private fun ProgressRow(
    title: String,
    value: String,
    dotColor: Color,
    background: Color
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(background)
            .padding(
                horizontal = 10.dp,
                vertical = 8.dp
            ),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(dotColor)
        )

        Spacer(
            modifier = Modifier.width(8.dp)
        )

        Text(
            text = title,
            color = Navy,
            fontSize = 12.sp,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = value,
            color = Navy,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


// ============================================================
// STUDY ROOM CARD
// ============================================================

@Composable
private fun StudyRoomCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.FlashOn,
                        contentDescription = null,
                        tint = Green,
                        modifier = Modifier.size(18.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(6.dp)
                    )

                    Text(
                        text = "ON A 6-DAY STREAK!",
                        color = Green,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "Study Room • Active",
                    color = Navy,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "CS 401 study lounge is open",
                    color = Gray,
                    fontSize = 14.sp
                )
            }


            // Placeholder image area
            // Nanti bisa diganti gambar dari Figma

            Box(
                modifier = Modifier
                    .size(
                        width = 80.dp,
                        height = 64.dp
                    )
                    .clip(RoundedCornerShape(12.dp))
                    .background(LightBlue),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "📚",
                    fontSize = 30.sp
                )
            }
        }
    }
}


// ============================================================
// TASK CARD
// ============================================================

@Composable
private fun TaskCard(
    task: Task
) {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            // Top row

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Category

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(LightPurple)
                        .padding(
                            horizontal = 8.dp,
                            vertical = 4.dp
                        )
                ) {

                    Text(
                        text = task.category,
                        color = Gray,
                        fontSize = 10.sp
                    )
                }

                Spacer(
                    modifier = Modifier.weight(1f)
                )

                PriorityBadge(
                    priority = task.priority
                )

                Spacer(
                    modifier = Modifier.width(6.dp)
                )

                StatusBadge(
                    status = task.status
                )
            }


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            // Task title

            Text(
                text = task.title,
                color = Navy,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )


            Spacer(
                modifier = Modifier.height(14.dp)
            )


            // Deadline

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.Schedule,
                        contentDescription = null,
                        tint = if (task.priority == "High") Red else Gray,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(5.dp)
                    )

                    Text(
                        text = task.deadline,
                        color = if (task.priority == "High") Red else Gray,
                        fontSize = 12.sp
                    )
                }


                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(LightPurple),

                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Complete",
                        tint = Gray,
                        modifier = Modifier.size(19.dp)
                    )
                }
            }
        }
    }
}


// ============================================================
// PRIORITY BADGE
// ============================================================

@Composable
private fun PriorityBadge(
    priority: String
) {

    val background: Color
    val textColor: Color
    val dotColor: Color

    when (priority) {

        "High" -> {
            background = LightRed
            textColor = Color(0xFF93000A)
            dotColor = Red
        }

        "Medium" -> {
            background = Color(0xFFDCE1FF)
            textColor = Gray
            dotColor = Gray
        }

        else -> {
            background = LightGreen.copy(alpha = 0.4f)
            textColor = Color(0xFF002113)
            dotColor = Green
        }
    }

    Row(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .padding(
                horizontal = 10.dp,
                vertical = 4.dp
            ),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(7.dp)
                .clip(CircleShape)
                .background(dotColor)
        )

        Spacer(
            modifier = Modifier.width(5.dp)
        )

        Text(
            text = priority,
            color = textColor,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


// ============================================================
// STATUS BADGE
// ============================================================

@Composable
private fun StatusBadge(
    status: String
) {

    val background =
        if (status == "In Progress") {
            LightBlue
        } else {
            Color(0xFFE4E7FF)
        }

    val textColor =
        if (status == "In Progress") {
            Blue
        } else {
            Gray
        }

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .padding(
                horizontal = 10.dp,
                vertical = 4.dp
            )
    ) {

        Text(
            text = status,
            color = textColor,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


// ============================================================
// BOTTOM NAVIGATION
// ============================================================

@Composable
private fun HomeBottomNavigation(
    modifier: Modifier = Modifier,
    onTasksClick: () -> Unit,
    onCalendarClick: () -> Unit,
    onAnalyticsClick: () -> Unit,
    onProfileClick: () -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                Background.copy(alpha = 0.96f)
            )
            .shadow(8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 4.dp,
                    vertical = 10.dp
                ),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            BottomNavItem(
                icon = Icons.Default.GridView,
                label = "Home",
                selected = true,
                onClick = {}
            )

            BottomNavItem(
                icon = Icons.Default.List,
                label = "Tasks",
                selected = false,
                onClick = onTasksClick
            )

            BottomNavItem(
                icon = Icons.Default.CalendarMonth,
                label = "Calendar",
                selected = false,
                onClick = onCalendarClick
            )

            BottomNavItem(
                icon = Icons.Default.QueryStats,
                label = "Analytics",
                selected = false,
                onClick = onAnalyticsClick
            )

            BottomNavItem(
                icon = Icons.Default.PersonOutline,
                label = "Profile",
                selected = false,
                onClick = onProfileClick
            )
        }
    }
}


// ============================================================
// BOTTOM NAV ITEM
// ============================================================

@Composable
private fun BottomNavItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .width(64.dp)
            .clickable {
                onClick()
            },

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .width(64.dp)
                .height(32.dp)
                .clip(CircleShape)
                .background(
                    if (selected) {
                        LightBlue
                    } else {
                        Color.Transparent
                    }
                ),

            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (selected) Blue else Gray,
                modifier = Modifier.size(22.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = label,
            color = if (selected) Blue else Gray,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}