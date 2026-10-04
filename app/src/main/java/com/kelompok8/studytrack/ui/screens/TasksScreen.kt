package com.kelompok8.studytrack.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
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
import com.kelompok8.studytrack.data.models.Task
import com.kelompok8.studytrack.data.models.TaskStatus
import com.kelompok8.studytrack.regulation.TaskRegulation
import com.kelompok8.studytrack.ui.components.StudyTrackHeader
import com.kelompok8.studytrack.ui.components.TaskCard
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun TasksScreen(
    tasks: List<Task>,
    onNavigate: (String) -> Unit,
    onNotificationClick: () -> Unit,
    onTaskClick: (String) -> Unit
) {
    var searchText by rememberSaveable { mutableStateOf("") }
    var selectedFilter by rememberSaveable { mutableStateOf("Semua") }

    val filteredTasks = TaskRegulation.filterTasks(tasks, searchText, selectedFilter)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // ====================================================
            // HEADER
            // ====================================================

            StudyTrackHeader(
                title = "Tugas",
                onNotificationClick = onNotificationClick,
                onProfileClick = { onNavigate("profile") },
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
            )

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
                    onValueChange = { searchText = it },
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    placeholder = {
                        Text(text = "Cari tugas, mata kuliah, tag...")
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Cari"
                        )
                    },
                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    onClick = { selectedFilter = "Semua" },
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

            Spacer(modifier = Modifier.height(12.dp))

            // ====================================================
            // FILTER
            // ====================================================

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChip(
                    selected = selectedFilter == "Semua",
                    onClick = { selectedFilter = "Semua" },
                    label = { Text("Semua ${tasks.size}") }
                )

                FilterChip(
                    selected = selectedFilter == "Belum Dimulai",
                    onClick = { selectedFilter = "Belum Dimulai" },
                    label = { Text("Belum Dimulai ${TaskRegulation.countTasksByStatus(tasks, TaskStatus.NOT_STARTED)}") }
                )

                FilterChip(
                    selected = selectedFilter == "Sedang Dikerjakan",
                    onClick = { selectedFilter = "Sedang Dikerjakan" },
                    label = { Text("Sedang Dikerjakan ${TaskRegulation.countTasksByStatus(tasks, TaskStatus.IN_PROGRESS)}") }
                )

                FilterChip(
                    selected = selectedFilter == "Selesai",
                    onClick = { selectedFilter = "Selesai" },
                    label = { Text("Selesai ${TaskRegulation.countTasksByStatus(tasks, TaskStatus.COMPLETED)}") }
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ====================================================
            // TASK LIST
            // ====================================================

            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 4.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Tugas Aktif & Segera Jatuh Tempo",
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "${filteredTasks.size} tugas",
                            fontSize = 14.sp,
                            color = StudyTextSecondary
                        )
                    }
                }

                items(
                    items = filteredTasks,
                    key = { it.id }
                ) { task ->
                    TaskCard(
                        task = task,
                        onClick = { onTaskClick(task.id) }
                    )
                }

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

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "Coba ubah pencarian atau filter.",
                                fontSize = 14.sp,
                                color = StudyTextSecondary
                            )
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}