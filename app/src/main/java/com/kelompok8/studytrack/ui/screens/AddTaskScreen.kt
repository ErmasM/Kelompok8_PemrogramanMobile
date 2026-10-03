package com.kelompok8.studytrack.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.AttachFile
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Save
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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

import com.kelompok8.studytrack.data.Task
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyNavy
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary


@Composable
fun AddTaskScreen(
    onBackClick: () -> Unit,
    onSaveTask: (Task) -> Unit
) {

    // =========================================================
    // FORM STATE
    // =========================================================

    var title by rememberSaveable {
        mutableStateOf("")
    }

    var course by rememberSaveable {
        mutableStateOf("")
    }

    var description by rememberSaveable {
        mutableStateOf("")
    }

    var priority by rememberSaveable {
        mutableStateOf("Sedang")
    }

    var dueDate by rememberSaveable {
        mutableStateOf("")
    }

    var dueTime by rememberSaveable {
        mutableStateOf("")
    }

    var status by rememberSaveable {
        mutableStateOf("Belum Dimulai")
    }

    val canSave =
        title.isNotBlank() &&
                course.isNotBlank() &&
                dueDate.isNotBlank() &&
                dueTime.isNotBlank()


    // =========================================================
    // MAIN CONTENT
    // =========================================================

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F8FF)),
        contentPadding = PaddingValues(
            bottom = 32.dp
        ),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        // =====================================================
        // HEADER
        // =====================================================

        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 10.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.size(44.dp)
                ) {

                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Kembali",
                        tint = StudyNavy,
                        modifier = Modifier.size(30.dp)
                    )
                }

                Spacer(
                    modifier = Modifier.width(4.dp)
                )

                // LOGO
                Card(
                    modifier = Modifier.size(48.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = StudyBlue
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 0.dp
                    )
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.School,
                            contentDescription = "StudyTrack",
                            tint = Color.White,
                            modifier = Modifier.size(29.dp)
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.width(12.dp)
                )

                Text(
                    text = "Tambah Tugas",
                    modifier = Modifier.weight(1f),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = StudyNavy
                )

                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Profil",
                    tint = StudyBlue,
                    modifier = Modifier.size(30.dp)
                )
            }
        }


        // =====================================================
        // JUDUL TUGAS
        // =====================================================

        item {

            FormLabel(
                text = "Judul Tugas",
                required = true
            )

            OutlinedTextField(
                value = title,
                onValueChange = {
                    title = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(64.dp),
                placeholder = {
                    Text(
                        text = "Masukkan judul tugas",
                        fontSize = 16.sp
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(18.dp)
            )
        }


        // =====================================================
        // MATA KULIAH
        // =====================================================

        item {

            FormLabel(
                text = "Mata Kuliah",
                required = true
            )

            OutlinedTextField(
                value = course,
                onValueChange = {
                    course = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(64.dp),
                placeholder = {
                    Text(
                        text = "Contoh: Pemrograman Mobile",
                        fontSize = 16.sp
                    )
                },
                leadingIcon = {

                    Icon(
                        imageVector = Icons.Outlined.School,
                        contentDescription = null,
                        tint = StudyBlue
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(18.dp)
            )
        }


        // =====================================================
        // DESKRIPSI
        // =====================================================

        item {

            FormLabel(
                text = "Deskripsi & Catatan"
            )

            OutlinedTextField(
                value = description,
                onValueChange = {
                    description = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(140.dp),
                placeholder = {
                    Text(
                        text = "Tuliskan deskripsi tugas...",
                        fontSize = 16.sp
                    )
                },
                leadingIcon = {

                    Icon(
                        imageVector = Icons.Outlined.Description,
                        contentDescription = null,
                        tint = StudyBlue
                    )
                },
                shape = RoundedCornerShape(18.dp)
            )
        }


        // =====================================================
        // PRIORITAS
        // =====================================================

        item {

            FormLabel(
                text = "Tingkat Prioritas"
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                PriorityButton(
                    modifier = Modifier.weight(1f),
                    text = "Rendah",
                    selected = priority == "Rendah",
                    color = StudyGreen,
                    onClick = {
                        priority = "Rendah"
                    }
                )

                PriorityButton(
                    modifier = Modifier.weight(1f),
                    text = "Sedang",
                    selected = priority == "Sedang",
                    color = Color(0xFFF59E0B),
                    onClick = {
                        priority = "Sedang"
                    }
                )

                PriorityButton(
                    modifier = Modifier.weight(1f),
                    text = "Tinggi",
                    selected = priority == "Tinggi",
                    color = Color(0xFFD32F2F),
                    onClick = {
                        priority = "Tinggi"
                    }
                )
            }
        }


        // =====================================================
        // TANGGAL & WAKTU
        // =====================================================

        item {

            FormLabel(
                text = "Tanggal & Waktu Deadline"
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                OutlinedTextField(
                    value = dueDate,
                    onValueChange = {
                        dueDate = it
                    },
                    modifier = Modifier
                        .weight(1.15f)
                        .height(62.dp),
                    placeholder = {
                        Text(
                            text = "17 Sep 2026",
                            fontSize = 14.sp
                        )
                    },
                    leadingIcon = {

                        Icon(
                            imageVector = Icons.Outlined.CalendarMonth,
                            contentDescription = null,
                            tint = StudyBlue
                        )
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(18.dp)
                )

                OutlinedTextField(
                    value = dueTime,
                    onValueChange = {
                        dueTime = it
                    },
                    modifier = Modifier
                        .weight(0.85f)
                        .height(62.dp),
                    placeholder = {
                        Text(
                            text = "23.59",
                            fontSize = 14.sp
                        )
                    },
                    leadingIcon = {

                        Icon(
                            imageVector = Icons.Outlined.Timer,
                            contentDescription = null,
                            tint = StudyBlue
                        )
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(18.dp)
                )
            }
        }


        // =====================================================
        // STATUS
        // =====================================================

        item {

            FormLabel(
                text = "Status"
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                StatusButton(
                    modifier = Modifier.weight(1f),
                    text = "Belum Dimulai",
                    selected = status == "Belum Dimulai",
                    onClick = {
                        status = "Belum Dimulai"
                    }
                )

                StatusButton(
                    modifier = Modifier.weight(1f),
                    text = "Dikerjakan",
                    selected = status == "Sedang Dikerjakan",
                    onClick = {
                        status = "Sedang Dikerjakan"
                    }
                )

                StatusButton(
                    modifier = Modifier.weight(1f),
                    text = "Selesai",
                    selected = status == "Selesai",
                    onClick = {
                        status = "Selesai"
                    }
                )
            }
        }


        // =====================================================
        // LAMPIRAN
        // =====================================================

        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Lampiran & Dokumen",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = StudyNavy,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "Tersimpan aman",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = StudyGreen
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .clickable { },
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF0EFFF)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 0.dp
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 20.dp,
                            vertical = 22.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Card(
                        modifier = Modifier.size(58.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFD9E7FF)
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 0.dp
                        )
                    ) {

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment =
                                Alignment.CenterHorizontally,
                            verticalArrangement =
                                Arrangement.Center
                        ) {

                            Icon(
                                imageVector =
                                    Icons.Outlined.AttachFile,
                                contentDescription =
                                    "Tambah lampiran",
                                tint = StudyBlue,
                                modifier = Modifier.size(29.dp)
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "Ketuk untuk menambahkan file",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = StudyNavy
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "PDF, PNG, DOCX hingga 10 MB",
                        fontSize = 13.sp,
                        color = StudyTextSecondary
                    )
                }
            }
        }


        // =====================================================
        // SIMPAN TUGAS
        // =====================================================

        item {

            Button(
                onClick = {

                    val newTask = Task(
                        subject = course,
                        title = title,
                        deadline = "$dueDate • $dueTime",
                        priority = priority,
                        status = status
                    )

                    onSaveTask(newTask)
                },
                enabled = canSave,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = StudyBlue,
                    disabledContainerColor = Color(0xFFB8C4D8)
                )
            ) {

                Icon(
                    imageVector = Icons.Outlined.Save,
                    contentDescription = null,
                    modifier = Modifier.size(21.dp)
                )

                Spacer(
                    modifier = Modifier.width(9.dp)
                )

                Text(
                    text = "Simpan Tugas",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


// =============================================================
// FORM LABEL
// =============================================================

@Composable
private fun FormLabel(
    text: String,
    required: Boolean = false
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = StudyNavy
        )

        if (required) {

            Text(
                text = " *",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD32F2F)
            )
        }
    }

    Spacer(
        modifier = Modifier.height(7.dp)
    )
}


// =============================================================
// PRIORITY BUTTON
// =============================================================

@Composable
private fun PriorityButton(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    color: Color,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .height(56.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) {
                color.copy(alpha = 0.12f)
            } else {
                Color.White
            }
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (selected) {
                2.dp
            } else {
                1.dp
            }
        )
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (selected) {

                Text(
                    text = "✓",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = color
                )

                Spacer(
                    modifier = Modifier.width(6.dp)
                )
            }

            Text(
                text = text,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (selected) {
                    color
                } else {
                    StudyNavy
                }
            )
        }
    }
}


// =============================================================
// STATUS BUTTON
// =============================================================

@Composable
private fun StatusButton(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .height(56.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) {
                StudyBlue
            } else {
                Color.White
            }
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (selected) {
                2.dp
            } else {
                1.dp
            }
        )
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (selected) {

                Text(
                    text = "✓",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(
                    modifier = Modifier.width(5.dp)
                )
            }

            Text(
                text = text,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (selected) {
                    Color.White
                } else {
                    StudyTextSecondary
                }
            )
        }
    }
}