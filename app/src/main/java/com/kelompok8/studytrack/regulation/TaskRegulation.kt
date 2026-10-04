package com.kelompok8.studytrack.regulation

import com.kelompok8.studytrack.data.models.Task
import com.kelompok8.studytrack.data.models.TaskAttachment
import com.kelompok8.studytrack.data.models.TaskPriority
import com.kelompok8.studytrack.data.models.TaskStatus

object TaskRegulation {

    fun filterTasks(
        tasks: List<Task>,
        searchText: String,
        selectedFilter: String
    ): List<Task> {
        return tasks.filter { task ->
            val matchesSearch = searchText.isBlank() ||
                    task.title.contains(searchText, ignoreCase = true) ||
                    task.subject.contains(searchText, ignoreCase = true) ||
                    task.courseCode.contains(searchText, ignoreCase = true)

            val matchesFilter = when (selectedFilter) {
                "Semua" -> true
                "Belum Dimulai" -> task.status == TaskStatus.NOT_STARTED
                "Sedang Dikerjakan" -> task.status == TaskStatus.IN_PROGRESS
                "Selesai" -> task.status == TaskStatus.COMPLETED
                else -> true
            }

            matchesSearch && matchesFilter
        }
    }

    fun countTasksByStatus(tasks: List<Task>, status: TaskStatus): Int {
        return tasks.count { it.status == status }
    }

    fun calculateCompletionPercentage(tasks: List<Task>): Int {
        if (tasks.isEmpty()) return 0
        val completed = countTasksByStatus(tasks, TaskStatus.COMPLETED)
        return (completed * 100) / tasks.size
    }

    fun getUpcomingDeadlines(tasks: List<Task>): List<Task> {
        return tasks.filter { it.status != TaskStatus.COMPLETED }
    }

    fun getTasksForDay(tasks: List<Task>, dayOfMonth: Int): List<Task> {
        return tasks.filter { it.dayOfMonth == dayOfMonth }
    }

    fun toggleTaskStatus(task: Task): Task {
        val newStatus = if (task.status == TaskStatus.COMPLETED) {
            TaskStatus.IN_PROGRESS
        } else {
            TaskStatus.COMPLETED
        }
        return task.copy(
            status = newStatus,
            hoursRemainingText = if (newStatus == TaskStatus.COMPLETED) "Selesai" else "Dalam proses"
        )
    }

    fun toggleChecklistItem(task: Task, itemId: String): Task {
        val updatedChecklist = task.checklist.map { item ->
            if (item.id == itemId) {
                item.copy(isChecked = !item.isChecked)
            } else {
                item
            }
        }
        val allChecked = updatedChecklist.isNotEmpty() && updatedChecklist.all { it.isChecked }
        val newStatus = if (allChecked) TaskStatus.COMPLETED else task.status
        return task.copy(
            checklist = updatedChecklist,
            status = newStatus
        )
    }

    fun addAttachmentToTask(
        task: Task,
        fileName: String,
        fileSize: String = "2.4 MB",
        fileType: String = "PDF"
    ): Task {
        val newAttachment = TaskAttachment(
            id = "att_${System.currentTimeMillis()}",
            fileName = fileName,
            fileSize = fileSize,
            uploadDate = "Baru saja",
            fileType = fileType
        )
        return task.copy(
            attachments = task.attachments + newAttachment
        )
    }

    fun deleteTask(tasks: List<Task>, taskId: String): List<Task> {
        return tasks.filter { it.id != taskId && it.title != taskId }
    }
}
