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
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Key
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyBlueLight
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyNavy
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary
import androidx.compose.material.icons.outlined.Storage

// ============================================================
// DATA CLASS
// ============================================================

private data class Course(
    val code: String,
    val name: String,
    val room: String,
    val lecturer: String,
    val progress: Int,
    val completedTasks: Int,
    val totalTasks: Int,
    val nextTask: String,
    val deadline: String,
    val icon: ImageVector,
    val iconBackground: Color,
    val codeBackground: Color,
    val isActive: Boolean = true
)


// ============================================================
// COURSES SCREEN
// ============================================================

@Composable
fun CoursesScreen(
    onBackClick: () -> Unit = {}
) {

    var selectedFilter by rememberSaveable {
        mutableStateOf("Semua")
    }

    val courses = listOf(

        Course(
            code = "INF-438",
            name = "Kriptografi",
            room = "Ruang 304B",
            lecturer = "Dr. Sarah Jenkins",
            progress = 75,
            completedTasks = 3,
            totalTasks = 4,
            nextTask = "Tugas Kriptografi",
            deadline = "Besok",
            icon = Icons.Outlined.Key,
            iconBackground = Color(0xFFDCE7FF),
            codeBackground = Color(0xFFDCE7FF)
        ),

        Course(
            code = "INF-350",
            name = "Sistem Operasi",
            room = "Gedung Kuliah A",
            lecturer = "Prof. Robert Davis",
            progress = 50,
            completedTasks = 2,
            totalTasks = 4,
            nextTask = "Lab 3: Kernel Locks",
            deadline = "2 hari lagi",
            icon = Icons.Outlined.Code,
            iconBackground = Color(0xFFDCE7FF),
            codeBackground = Color(0xFFDCE7FF)
        ),

        Course(
            code = "INF-340",
            name = "Basis Data",
            room = "Lab 12",
            lecturer = "Dr. Michael Chang",
            progress = 33,
            completedTasks = 1,
            totalTasks = 3,
            nextTask = "Normalisasi Database",
            deadline = "4 hari lagi",
            icon = Icons.Outlined.Storage,
            iconBackground = Color(0xFFB9F8DF),
            codeBackground = Color(0xFFB9F8DF)
        ),

        Course(
            code = "INF-320",
            name = "Pemrograman Web",
            room = "Online / Sinkron",
            lecturer = "Maya Lin, M.Sc.",
            progress = 0,
            completedTasks = 0,
            totalTasks = 4,
            nextTask = "Membuat Website E-Commerce",
            deadline = "6 hari lagi",
            icon = Icons.Outlined.Code,
            iconBackground = Color(0xFFDCE7FF),
            codeBackground = Color(0xFFDCE7FF)
        ),

        Course(
            code = "IMK-201",
            name = "UI/UX Design",
            room = "Studio Desain 4",
            lecturer = "Elena Rostova",
            progress = 0,
            completedTasks = 0,
            totalTasks = 3,
            nextTask = "Tidak ada deadline minggu ini",
            deadline = "3 tugas mendatang",
            icon = Icons.Outlined.School,
            iconBackground = Color(0xFFC9D9FF),
            codeBackground = Color(0xFFDCE7FF),
            isActive = false
        )
    )


    val filteredCourses = when (selectedFilter) {

        "Segera" ->
            courses.filter {
                it.deadline == "Besok" ||
                        it.deadline == "2 hari lagi" ||
                        it.deadline == "4 hari lagi"
            }

        "Dikerjakan" ->
            courses.filter {
                it.progress > 0 &&
                        it.progress < 100
            }

        else ->
            courses
    }


    // ========================================================
    // MAIN
    // ========================================================

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFF9F8FF)
            ),
        contentPadding = PaddingValues(
            bottom = 30.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // ====================================================
        // HEADER
        // ====================================================

        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(
                        horizontal = 20.dp,
                        vertical = 16.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.size(44.dp)
                ) {

                    Icon(
                        imageVector =
                            Icons.Outlined.ArrowBack,
                        contentDescription =
                            "Kembali",
                        tint = StudyNavy,
                        modifier = Modifier.size(29.dp)
                    )
                }

                Spacer(
                    modifier = Modifier.width(8.dp)
                )


                Card(
                    modifier = Modifier.size(46.dp),
                    shape = RoundedCornerShape(13.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = StudyBlue
                    ),
                    elevation =
                        CardDefaults.cardElevation(
                            defaultElevation = 0.dp
                        )
                ) {

                    Column(
                        modifier =
                            Modifier.fillMaxSize(),
                        horizontalAlignment =
                            Alignment.CenterHorizontally,
                        verticalArrangement =
                            Arrangement.Center
                    ) {

                        Icon(
                            imageVector =
                                Icons.Outlined.School,
                            contentDescription =
                                "StudyTrack",
                            tint = Color.White,
                            modifier =
                                Modifier.size(29.dp)
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.width(12.dp)
                )

                Text(
                    text = "Mata Kuliah",
                    modifier = Modifier.weight(1f),
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    color = StudyNavy
                )


                Icon(
                    imageVector =
                        Icons.Outlined.Person,
                    contentDescription =
                        "Profil",
                    tint = StudyBlue,
                    modifier = Modifier.size(32.dp)
                )
            }
        }


        // ====================================================
        // SUMMARY
        // ====================================================

        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement =
                    Arrangement.spacedBy(10.dp)
            ) {

                SummaryCard(
                    value = "60%",
                    label = "RATA-RATA PROGRES",
                    valueColor = StudyBlue,
                    modifier = Modifier.weight(1f)
                )

                SummaryCard(
                    value = "6",
                    label = "DEADLINE",
                    valueColor = StudyNavy,
                    modifier = Modifier.weight(1f)
                )

                SummaryCard(
                    value = "3.88",
                    label = "EST. IPK",
                    valueColor = StudyGreen,
                    modifier = Modifier.weight(1f)
                )
            }
        }


        // ====================================================
        // FILTER
        // ====================================================

        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement =
                    Arrangement.spacedBy(8.dp)
            ) {

                CourseFilter(
                    text = "Semua",
                    selected =
                        selectedFilter == "Semua",
                    onClick = {
                        selectedFilter = "Semua"
                    }
                )

                CourseFilter(
                    text = "Segera",
                    selected =
                        selectedFilter == "Segera",
                    onClick = {
                        selectedFilter = "Segera"
                    }
                )

                CourseFilter(
                    text = "Dikerjakan",
                    selected =
                        selectedFilter == "Dikerjakan",
                    onClick = {
                        selectedFilter = "Dikerjakan"
                    }
                )
            }
        }


        // ====================================================
        // COURSE LIST
        // ====================================================

        items(
            count = filteredCourses.size
        ) { index ->

            CourseCard(
                course = filteredCourses[index]
            )
        }
    }
}


// ============================================================
// SUMMARY CARD
// ============================================================

@Composable
private fun SummaryCard(
    value: String,
    label: String,
    valueColor: Color,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier.height(94.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment =
                Alignment.CenterHorizontally,
            verticalArrangement =
                Arrangement.Center
        ) {

            Text(
                text = value,
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                color = valueColor
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = label,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = StudyTextSecondary
            )
        }
    }
}


// ============================================================
// FILTER CHIP
// ============================================================

@Composable
private fun CourseFilter(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) {
                Color(0xFFD7E6FF)
            } else {
                Color.White
            }
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {

        Row(
            modifier = Modifier.padding(
                horizontal = 17.dp,
                vertical = 8.dp
            ),
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            if (selected) {

                Icon(
                    imageVector =
                        Icons.Outlined.Check,
                    contentDescription = null,
                    tint = StudyNavy,
                    modifier = Modifier.size(16.dp)
                )

                Spacer(
                    modifier = Modifier.width(4.dp)
                )
            }

            Text(
                text = text,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = StudyNavy
            )
        }
    }
}


// ============================================================
// COURSE CARD
// ============================================================

@Composable
private fun CourseCard(
    course: Course
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            // ------------------------------------------------
            // LEFT ACCENT
            // ------------------------------------------------

            Spacer(
                modifier = Modifier
                    .width(6.dp)
                    .height(300.dp)
                    .background(
                        color = if (course.isActive) {
                            StudyBlue
                        } else {
                            Color(0xFFC9CED8)
                        }
                    )
            )


            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {

                // ============================================
                // TOP
                // ============================================

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment =
                        Alignment.Top
                ) {

                    Card(
                        modifier = Modifier.size(60.dp),
                        shape = RoundedCornerShape(15.dp),
                        colors = CardDefaults.cardColors(
                            containerColor =
                                course.iconBackground
                        ),
                        elevation =
                            CardDefaults.cardElevation(
                                defaultElevation = 0.dp
                            )
                    ) {

                        Column(
                            modifier =
                                Modifier.fillMaxSize(),
                            horizontalAlignment =
                                Alignment.CenterHorizontally,
                            verticalArrangement =
                                Arrangement.Center
                        ) {

                            Icon(
                                imageVector = course.icon,
                                contentDescription =
                                    course.name,
                                tint = if (
                                    course.iconBackground ==
                                    Color(0xFFB9F8DF)
                                ) {
                                    StudyGreen
                                } else {
                                    StudyBlue
                                },
                                modifier =
                                    Modifier.size(31.dp)
                            )
                        }
                    }


                    Spacer(
                        modifier = Modifier.width(12.dp)
                    )


                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Row(
                            verticalAlignment =
                                Alignment.CenterVertically
                        ) {

                            Text(
                                text = course.code,
                                modifier = Modifier
                                    .background(
                                        color =
                                            course.codeBackground,
                                        shape =
                                            RoundedCornerShape(5.dp)
                                    )
                                    .padding(
                                        horizontal = 8.dp,
                                        vertical = 4.dp
                                    ),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = StudyNavy
                            )

                            Spacer(
                                modifier =
                                    Modifier.width(6.dp)
                            )

                            Text(
                                text = course.room,
                                fontSize = 11.sp,
                                color =
                                    StudyTextSecondary
                            )
                        }


                        Spacer(
                            modifier =
                                Modifier.height(4.dp)
                        )


                        Text(
                            text = course.name,
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyNavy
                        )
                    }


                    Text(
                        text = "⋮",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = StudyTextSecondary
                    )
                }


                Spacer(
                    modifier = Modifier.height(15.dp)
                )


                // ============================================
                // LECTURER
                // ============================================

                Row(
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector =
                            Icons.Outlined.Person,
                        contentDescription =
                            "Dosen",
                        tint = StudyBlue,
                        modifier =
                            Modifier.size(21.dp)
                    )

                    Spacer(
                        modifier =
                            Modifier.width(8.dp)
                    )

                    Text(
                        text = course.lecturer,
                        fontSize = 16.sp,
                        color = StudyTextSecondary
                    )
                }


                Spacer(
                    modifier = Modifier.height(17.dp)
                )


                // ============================================
                // PROGRESS
                // ============================================

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape =
                        RoundedCornerShape(16.dp),
                    colors =
                        CardDefaults.cardColors(
                            containerColor =
                                Color(0xFFF5F4FF)
                        ),
                    elevation =
                        CardDefaults.cardElevation(
                            defaultElevation = 0.dp
                        )
                ) {

                    Column(
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 12.dp
                        )
                    ) {

                        Row(
                            modifier =
                                Modifier.fillMaxWidth(),
                            verticalAlignment =
                                Alignment.CenterVertically
                        ) {

                            Text(
                                text =
                                    "Progres Mata Kuliah",
                                modifier =
                                    Modifier.weight(1f),
                                fontSize = 14.sp,
                                color =
                                    StudyTextSecondary
                            )

                            Text(
                                text =
                                    "${course.progress}%",
                                fontSize = 16.sp,
                                fontWeight =
                                    FontWeight.Bold,
                                color =
                                    if (course.progress > 0) {
                                        StudyBlue
                                    } else {
                                        StudyTextSecondary
                                    }
                            )

                            Spacer(
                                modifier =
                                    Modifier.width(4.dp)
                            )

                            Text(
                                text =
                                    "(${course.completedTasks} dari ${course.totalTasks} tugas)",
                                fontSize = 11.sp,
                                color =
                                    StudyTextSecondary
                            )
                        }


                        Spacer(
                            modifier =
                                Modifier.height(8.dp)
                        )


                        ProgressBar(
                            progress =
                                course.progress
                        )
                    }
                }


                Spacer(
                    modifier = Modifier.height(17.dp)
                )


                // ============================================
                // NEXT TASK
                // ============================================

                Row(
                    modifier =
                        Modifier.fillMaxWidth(),
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector =
                            if (
                                course.isActive
                            ) {
                                Icons.Outlined.Timer
                            } else {
                                Icons.Outlined.CalendarMonth
                            },
                        contentDescription =
                            "Deadline",
                        tint =
                            if (course.deadline == "Besok") {
                                Color(0xFFD32F2F)
                            } else {
                                StudyBlue
                            },
                        modifier =
                            Modifier.size(21.dp)
                    )

                    Spacer(
                        modifier =
                            Modifier.width(7.dp)
                    )

                    Text(
                        text = course.nextTask,
                        modifier =
                            Modifier.weight(1f),
                        fontSize = 14.sp,
                        color = StudyTextSecondary
                    )

                    DeadlineBadge(
                        text = course.deadline,
                        urgent =
                            course.deadline == "Besok"
                    )
                }
            }
        }
    }
}


// ============================================================
// PROGRESS BAR
// ============================================================

@Composable
private fun ProgressBar(
    progress: Int
) {

    val progressWidth =
        when {
            progress >= 100 -> 1f
            progress <= 0 -> 0f
            else -> progress / 100f
        }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(10.dp)
            .background(
                color = Color(0xFFDDE4FF),
                shape = RoundedCornerShape(50.dp)
            )
    ) {

        if (progressWidth > 0f) {

            Spacer(
                modifier = Modifier
                    .fillMaxWidth(progressWidth)
                    .height(10.dp)
                    .background(
                        color = StudyBlue,
                        shape = RoundedCornerShape(50.dp)
                    )
            )
        }
    }
}


// ============================================================
// DEADLINE BADGE
// ============================================================

@Composable
private fun DeadlineBadge(
    text: String,
    urgent: Boolean
) {

    Text(
        text = text,
        modifier = Modifier
            .background(
                color = if (urgent) {
                    Color(0xFFFFD9D5)
                } else {
                    StudyBlueLight
                },
                shape = RoundedCornerShape(20.dp)
            )
            .padding(
                horizontal = 12.dp,
                vertical = 6.dp
            ),
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        color = if (urgent) {
            Color(0xFFB71C1C)
        } else {
            StudyTextSecondary
        }
    )
}