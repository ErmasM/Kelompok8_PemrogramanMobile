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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import com.kelompok8.studytrack.data.CourseData
import com.kelompok8.studytrack.data.models.Course
import com.kelompok8.studytrack.regulation.CourseRegulation
import com.kelompok8.studytrack.ui.components.CourseCard
import com.kelompok8.studytrack.ui.components.StudyTrackHeader
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyNavy
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

@Composable
fun CoursesScreen(
    onBackClick: () -> Unit = {},
    courses: List<Course> = CourseData.initialCourses
) {
    var selectedFilter by rememberSaveable { mutableStateOf("Semua") }

    val filteredCourses = CourseRegulation.filterCourses(courses, selectedFilter)
    val avgProgress = CourseRegulation.calculateAverageProgress(courses)
    val pendingDeadlines = CourseRegulation.getTotalPendingDeadlines(courses)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F8FF)),
        contentPadding = PaddingValues(bottom = 30.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // ====================================================
        // HEADER
        // ====================================================

        item {
            StudyTrackHeader(
                title = "Mata Kuliah",
                onBackClick = onBackClick,
                onProfileClick = {},
                backgroundColor = Color.White,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
            )
        }

        // ====================================================
        // SUMMARY
        // ====================================================

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                SummaryCard(
                    value = "$avgProgress%",
                    label = "RATA-RATA PROGRES",
                    valueColor = StudyBlue,
                    modifier = Modifier.weight(1f)
                )

                SummaryCard(
                    value = "$pendingDeadlines",
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
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CourseFilter(
                    text = "Semua",
                    selected = selectedFilter == "Semua",
                    onClick = { selectedFilter = "Semua" }
                )

                CourseFilter(
                    text = "Segera",
                    selected = selectedFilter == "Segera",
                    onClick = { selectedFilter = "Segera" }
                )

                CourseFilter(
                    text = "Dikerjakan",
                    selected = selectedFilter == "Dikerjakan",
                    onClick = { selectedFilter = "Dikerjakan" }
                )
            }
        }

        // ====================================================
        // COURSE LIST
        // ====================================================

        items(
            items = filteredCourses,
            key = { it.id }
        ) { course ->
            CourseCard(course = course)
        }
    }
}

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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = value,
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                color = valueColor
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = label,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = StudyTextSecondary
            )
        }
    }
}

@Composable
private fun CourseFilter(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.clickable { onClick() },
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) Color(0xFFD7E6FF) else Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 17.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (selected) {
                Icon(
                    imageVector = Icons.Outlined.Check,
                    contentDescription = null,
                    tint = StudyNavy,
                    modifier = Modifier.size(16.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
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