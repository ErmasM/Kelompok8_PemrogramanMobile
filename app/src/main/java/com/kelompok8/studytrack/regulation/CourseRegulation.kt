package com.kelompok8.studytrack.regulation

import com.kelompok8.studytrack.data.models.Course

object CourseRegulation {

    fun filterCourses(
        courses: List<Course>,
        selectedFilter: String
    ): List<Course> {
        return when (selectedFilter) {
            "Segera" -> courses.filter {
                it.deadlineText == "Besok" ||
                        it.deadlineText == "2 hari lagi" ||
                        it.deadlineText == "4 hari lagi" ||
                        it.deadlineText.contains("Besok", ignoreCase = true)
            }

            "Dikerjakan" -> courses.filter {
                it.progressPercentage > 0 && it.progressPercentage < 100
            }

            else -> courses
        }
    }

    fun calculateAverageProgress(courses: List<Course>): Int {
        if (courses.isEmpty()) return 0
        val sum = courses.sumOf { it.progressPercentage }
        return sum / courses.size
    }

    fun getTotalPendingDeadlines(courses: List<Course>): Int {
        return courses.sumOf { course -> course.totalTasks - course.completedTasks }
    }
}
