package com.kelompok8.studytrack

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import java.util.UUID

class TaskViewModel : ViewModel() {

    // Initial Hardcoded List (Data awal untuk simulasi Front-End)
    val tasks = mutableStateListOf(
        TaskItem(
            id = "1",
            title = "Cryptography Assignment 2",
            course = "Cryptography • CS-402",
            description = "Mengerjakan soal latihan dan membuat laporan sesuai dengan format yang diberikan. Pastikan mengimplementasikan algoritma AES dan RSA dengan benchmark waktu eksekusi.",
            dueDate = "Tomorrow",
            dueTime = "11:59 PM",
            priority = Priority.HIGH,
            status = TaskStatus.IN_PROGRESS,
            attachmentName = "tugas-kriptografi.pdf",
            lecturerName = "Prof. Dr. Ir. H. Wardhana"
        ),
        TaskItem(
            id = "2",
            title = "Operating Systems Lab 3: Kernel Locks",
            course = "Operating Systems • CS-301",
            description = "Implementasi spinlocks dan semaphores pada kernel OS.",
            dueDate = "In 2 days",
            dueTime = "5:00 PM",
            priority = Priority.HIGH,
            status = TaskStatus.IN_PROGRESS,
            lecturerName = "Prof. Robert Davis"
        ),
        TaskItem(
            id = "3",
            title = "Database Normalization & Constraints",
            course = "Database Systems • CS-202",
            description = "Soal ERD ke 3NF beserta penentuan Primary Key & Foreign Key.",
            dueDate = "In 4 days",
            dueTime = "11:00 PM",
            priority = Priority.MEDIUM,
            status = TaskStatus.NOT_STARTED,
            lecturerName = "Dr. Michael Chang"
        ),
        TaskItem(
            id = "4",
            title = "Build E-Commerce Website",
            course = "Web Programming • CS-205",
            description = "Integrasi keranjang belanja dan payment gateway.",
            dueDate = "In 6 days",
            dueTime = "11:59 PM",
            priority = Priority.LOW,
            status = TaskStatus.IN_PROGRESS,
            lecturerName = "Maya Lin, M.Sc."
        ),
        TaskItem(
            id = "5",
            title = "UI/UX Heuristic Evaluation",
            course = "UI/UX Design • CS-104",
            description = "Evaluasi 10 prinsip Nielsen pada aplikasi mobile.",
            dueDate = "Sep 12",
            dueTime = "2:00 PM",
            priority = Priority.MEDIUM,
            status = TaskStatus.COMPLETED,
            lecturerName = "Elena Rostova"
        ),
        TaskItem(
            id = "6",
            title = "Algorithm Complexity Problem Set",
            course = "Algorithms • CS-201",
            description = "Analisis Big-O, Big-Omega, dan Big-Theta untuk sorting algorithms.",
            dueDate = "Sep 8",
            dueTime = "11:59 PM",
            priority = Priority.HIGH,
            status = TaskStatus.COMPLETED,
            lecturerName = "Dr. Sarah Jenkins"
        )
    )

    // ========================================================
    // C - CREATE (Tambah Tugas Baru)
    // ========================================================
    fun addTask(
        title: String,
        course: String,
        description: String = "",
        dueDate: String = "",
        dueTime: String = "",
        priority: Priority = Priority.MEDIUM,
        status: TaskStatus = TaskStatus.NOT_STARTED,
        attachmentName: String? = null,
        lecturerName: String? = null
    ) {
        val newTask = TaskItem(
            id = UUID.randomUUID().toString(),
            title = title,
            course = course,
            description = description,
            dueDate = dueDate,
            dueTime = dueTime,
            priority = priority,
            status = status,
            attachmentName = attachmentName,
            lecturerName = lecturerName
        )
        tasks.add(0, newTask) // Menambahkan ke bagian paling atas list
    }

    // ========================================================
    // R - READ (Ambil detail tugas berdasarkan ID)
    // ========================================================
    fun getTaskById(id: String): TaskItem? {
        return tasks.find { it.id == id }
    }

    // ========================================================
    // U - UPDATE (Memperbarui data tugas)
    // ========================================================
    fun updateTask(updatedTask: TaskItem) {
        val index = tasks.indexOfFirst { it.id == updatedTask.id }
        if (index != -1) {
            tasks[index] = updatedTask
        }
    }

    // U - UPDATE STATUS (Ubah status: Not Started -> In Progress -> Completed)
    fun updateTaskStatus(id: String, newStatus: TaskStatus) {
        val index = tasks.indexOfFirst { it.id == id }
        if (index != -1) {
            tasks[index] = tasks[index].copy(status = newStatus)
        }
    }

    // ========================================================
    // D - DELETE (Hapus tugas berdasarkan ID)
    // ========================================================
    fun deleteTask(id: String) {
        tasks.removeIf { it.id == id }
    }
}
