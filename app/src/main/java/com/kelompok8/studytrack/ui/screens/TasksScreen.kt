package com.kelompok8.studytrack.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyBlueLight
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary
import com.kelompok8.studytrack.data.Task
// ============================================================
// DATA CLASS TASK
// ============================================================




// ============================================================
// TASKS SCREEN
// ============================================================

@Composable
fun TasksScreen(
    tasks: List<Task>,
    onNavigate: (String) -> Unit,
    onNotificationClick: () -> Unit,
    onTaskClick: (String) -> Unit,
    onAddTaskClick: () -> Unit
) {
    var searchText by rememberSaveable {
        mutableStateOf("")
    }

    var selectedFilter by rememberSaveable {
        mutableStateOf("Semua")
    }

    val filteredTasks = tasks.filter { task ->

        val matchesSearch =
            task.title.contains(searchText, ignoreCase = true) ||
                    task.subject.contains(searchText, ignoreCase = true)

        val matchesFilter = when (selectedFilter) {

            "Semua" -> true

            "Belum Dimulai" ->
                task.status == "Belum Dimulai"

            "Sedang Dikerjakan" ->
                task.status == "Sedang Dikerjakan"

            "Selesai" ->
                task.status == "Selesai"

            else -> true
        }

        matchesSearch && matchesFilter
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
    ) {

        // ====================================================
        // HEADER
        // ====================================================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 20.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Outlined.School,
                contentDescription = "StudyTrack",
                modifier = Modifier.size(44.dp),
                tint = StudyBlue
            )

            Spacer(
                modifier = Modifier.size(12.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "STUDYTRACK",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = StudyBlue
                )

                Text(
                    text = "Tugas",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Notifikasi",
                modifier = Modifier
                    .size(28.dp)
                    .clickable {
                        onNotificationClick()
                    },
                tint = MaterialTheme.colorScheme.onBackground
            )

            Spacer(
                modifier = Modifier.size(16.dp)
            )

            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Profil",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        onNavigate("profile")
                    },
                tint = StudyBlue
            )
        }


        // ====================================================
        // SEARCH
        // ====================================================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                },
                modifier = Modifier.weight(1f),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "Cari tugas, mata kuliah, tag..."
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Cari"
                    )
                },
                shape = RoundedCornerShape(16.dp)
            )

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            IconButton(
                onClick = {
                    selectedFilter = "Semua"
                },
                modifier = Modifier
                    .size(56.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {

                Icon(
                    imageVector = Icons.Outlined.FilterList,
                    contentDescription = "Filter",
                    tint = StudyBlue
                )
            }
        }


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // ====================================================
        // FILTER
        // ====================================================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(
                    rememberScrollState()
                )
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            FilterChip(
                selected = selectedFilter == "Semua",
                onClick = {
                    selectedFilter = "Semua"
                },
                label = {
                    Text(
                        "Semua ${tasks.size}"
                    )
                }
            )

            FilterChip(
                selected = selectedFilter == "Belum Dimulai",
                onClick = {
                    selectedFilter = "Belum Dimulai"
                },
                label = {
                    Text(
                        "Belum Dimulai ${
                            tasks.count {
                                it.status == "Belum Dimulai"
                            }
                        }"
                    )
                }
            )

            FilterChip(
                selected = selectedFilter == "Sedang Dikerjakan",
                onClick = {
                    selectedFilter = "Sedang Dikerjakan"
                },
                label = {
                    Text(
                        "Sedang Dikerjakan ${
                            tasks.count {
                                it.status == "Sedang Dikerjakan"
                            }
                        }"
                    )
                }
            )

            FilterChip(
                selected = selectedFilter == "Selesai",
                onClick = {
                    selectedFilter = "Selesai"
                },
                label = {
                    Text(
                        "Selesai ${
                            tasks.count {
                                it.status == "Selesai"
                            }
                        }"
                    )
                }
            )
        }


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // ====================================================
        // TASK LIST
        // ====================================================

        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(
                horizontal = 20.dp,
                vertical = 4.dp
            ),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            // ------------------------------------------------
            // SECTION HEADER
            // ------------------------------------------------

            item {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Tugas Aktif & Segera Jatuh Tempo",
                        modifier = Modifier.weight(1f),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    IconButton(
                        onClick = onAddTaskClick,
                        modifier = Modifier
                            .size(42.dp)
                            .background(
                                color = StudyBlue,
                                shape = RoundedCornerShape(14.dp)
                            )
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.Add,
                            contentDescription = "Tambah Tugas",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }


                Spacer(
                    modifier = Modifier.height(4.dp)
                )


                Text(
                    text = "${filteredTasks.size} tugas",
                    fontSize = 14.sp,
                    color = StudyTextSecondary
                )
            }


            // ------------------------------------------------
            // TASK ITEMS
            // ------------------------------------------------

            items(
                items = filteredTasks,
                key = {
                    it.title
                }
            ) { task ->

                TaskCard(
                    task = task,
                    onClick = {
                        onTaskClick(task.title)
                    }
                )
            }


            // ------------------------------------------------
            // EMPTY STATE
            // ------------------------------------------------

            if (filteredTasks.isEmpty()) {

                item {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 50.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "Tidak ada tugas",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground
                        )

                        Spacer(
                            modifier = Modifier.height(6.dp)
                        )

                        Text(
                            text = "Coba ubah pencarian atau filter.",
                            fontSize = 14.sp,
                            color = StudyTextSecondary
                        )
                    }
                }
            }
        }
    }
}


// ============================================================
// TASK CARD
// ============================================================

@Composable
private fun TaskCard(
    task: Task,
    onClick: () -> Unit
) {

    val isDone = task.status == "Selesai"

    val statusColor =
        if (isDone) {
            StudyGreen
        } else {
            StudyBlue
        }

    val priorityColor = when (task.priority) {

        "Tinggi" ->
            Color(0xFFD32F2F)

        "Sedang" ->
            StudyBlue

        else ->
            StudyGreen
    }

    val priorityBackground = when (task.priority) {

        "Tinggi" ->
            Color(0xFFFFE0E0)

        "Sedang" ->
            Color(0xFFE8E9FF)

        else ->
            Color(0xFFE2F8EF)
    }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Spacer(
                modifier = Modifier
                    .width(6.dp)
                    .height(155.dp)
                    .background(
                        color = statusColor,
                        shape = RoundedCornerShape(
                            topStart = 20.dp,
                            bottomStart = 20.dp
                        )
                    )
            )


            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(18.dp)
            ) {

                // ==========================================
                // BADGES
                // ==========================================

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.spacedBy(8.dp),
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Badge(
                        text = task.subject,
                        backgroundColor = StudyBlueLight,
                        textColor =
                            MaterialTheme.colorScheme.onSurface
                    )

                    Badge(
                        text = task.priority,
                        backgroundColor =
                            priorityBackground,
                        textColor =
                            priorityColor
                    )

                    Spacer(
                        modifier = Modifier.weight(1f)
                    )

                    Badge(
                        text = task.status,
                        backgroundColor =
                            if (isDone) {
                                Color(0xFFD1FAE5)
                            } else {
                                StudyBlueLight
                            },
                        textColor =
                            statusColor
                    )
                }


                Spacer(
                    modifier = Modifier.height(18.dp)
                )


                // ==========================================
                // TITLE
                // ==========================================

                Text(
                    text = task.title,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color =
                        MaterialTheme.colorScheme.onSurface
                )


                Spacer(
                    modifier = Modifier.height(14.dp)
                )


                // ==========================================
                // DEADLINE
                // ==========================================

                Row(
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector =
                            if (isDone) {
                                Icons.Outlined.CheckCircle
                            } else {
                                Icons.Outlined.CalendarMonth
                            },
                        contentDescription = "Deadline",
                        modifier = Modifier.size(20.dp),
                        tint = statusColor
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Text(
                        text = task.deadline,
                        fontSize = 14.sp,
                        color =
                            if (isDone) {
                                StudyGreen
                            } else {
                                StudyTextSecondary
                            }
                    )
                }
            }
        }
    }
}


// ============================================================
// BADGE
// ============================================================

@Composable
private fun Badge(
    text: String,
    backgroundColor: Color,
    textColor: Color
) {

    Text(
        text = text,
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(50.dp)
            )
            .padding(
                horizontal = 10.dp,
                vertical = 6.dp
            ),
        fontSize = 11.sp,
        fontWeight = FontWeight.Medium,
        color = textColor
    )
}