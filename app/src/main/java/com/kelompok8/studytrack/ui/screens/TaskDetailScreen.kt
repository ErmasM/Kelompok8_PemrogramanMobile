package com.kelompok8.studytrack.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachFile
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelompok8.studytrack.data.LecturerData
import com.kelompok8.studytrack.data.models.Task
import com.kelompok8.studytrack.data.models.TaskAttachment
import com.kelompok8.studytrack.data.models.TaskChecklistItem
import com.kelompok8.studytrack.data.models.TaskPriority
import com.kelompok8.studytrack.data.models.TaskStatus
import com.kelompok8.studytrack.ui.components.StudyTrackHeader
import com.kelompok8.studytrack.ui.theme.StudyBlue
import com.kelompok8.studytrack.ui.theme.StudyBlueLight
import com.kelompok8.studytrack.ui.theme.StudyGreen
import com.kelompok8.studytrack.ui.theme.StudyNavy
import com.kelompok8.studytrack.ui.theme.StudyTextSecondary

import android.content.Intent
import android.provider.OpenableColumns
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.platform.LocalContext

@Composable
fun TaskDetailScreen(
    task: Task,
    onBackClick: () -> Unit,
    onToggleTaskStatus: (String) -> Unit = {},
    onToggleChecklistItem: (taskId: String, itemId: String) -> Unit = { _, _ -> },
    onAddAttachment: (taskId: String, fileName: String, fileType: String, fileSize: String, fileUri: String?) -> Unit = { _, _, _, _, _ -> },
    onSubmitAssignment: (taskId: String, note: String, attachmentUri: String?, attachmentName: String?) -> Unit = { _, _, _, _ -> },
    onDeleteTask: (String) -> Unit = {}
) {
    val context = LocalContext.current
    var showSubmitDialog by remember { mutableStateOf(false) }
    var submissionNoteInput by remember { mutableStateOf("") }

    val documentPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let { fileUri ->
            try {
                context.contentResolver.takePersistableUriPermission(
                    fileUri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
            } catch (e: Exception) {
                // Ignore if not persistable
            }

            var fileName = "Dokumen_Tugas.pdf"
            var fileSizeStr = "1.0 MB"
            var fileType = "PDF"

            context.contentResolver.query(fileUri, null, null, null, null)?.use { cursor ->
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                val sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE)
                if (cursor.moveToFirst()) {
                    if (nameIndex != -1) fileName = cursor.getString(nameIndex) ?: fileName
                    if (sizeIndex != -1) {
                        val bytes = cursor.getLong(sizeIndex)
                        fileSizeStr = when {
                            bytes >= 1024 * 1024 -> String.format("%.1f MB", bytes / (1024.0 * 1024.0))
                            bytes >= 1024 -> String.format("%d KB", bytes / 1024)
                            else -> "$bytes B"
                        }
                    }
                }
            }

            if (fileName.endsWith(".pdf", ignoreCase = true)) {
                fileType = "PDF"
            } else if (fileName.contains(".")) {
                fileType = fileName.substringAfterLast(".").uppercase()
            }

            onAddAttachment(task.id, fileName, fileType, fileSizeStr, fileUri.toString())
        }
    }
    val isDone = task.status == TaskStatus.COMPLETED

    val statusColor = if (isDone) StudyGreen else StudyBlue
    val priorityColor = when (task.priority) {
        TaskPriority.HIGH -> Color(0xFFD32F2F)
        TaskPriority.MEDIUM -> StudyBlue
        TaskPriority.LOW -> StudyGreen
    }
    val priorityBackground = when (task.priority) {
        TaskPriority.HIGH -> Color(0xFFFFE0E0)
        TaskPriority.MEDIUM -> Color(0xFFE8E9FF)
        TaskPriority.LOW -> Color(0xFFE2F8EF)
    }

    val completedChecklistCount = task.checklist.count { it.isChecked }
    val totalChecklistCount = task.checklist.size
    val checklistProgress = if (totalChecklistCount > 0) completedChecklistCount.toFloat() / totalChecklistCount else 1.0f
    val checklistPercentage = (checklistProgress * 100).toInt()

    val lecturer = LecturerData.defaultLecturer

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F8FF)),
        contentPadding = PaddingValues(bottom = 28.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        // =====================================================
        // HEADER
        // =====================================================

        item {
            StudyTrackHeader(
                title = "Task Detail",
                onBackClick = onBackClick,
                onProfileClick = {},
                backgroundColor = Color.White,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
            )
        }

        // =====================================================
        // TASK INFORMATION
        // =====================================================

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .width(7.dp)
                            .height(330.dp)
                            .background(
                                color = priorityColor,
                                shape = RoundedCornerShape(topStart = 22.dp, bottomStart = 22.dp)
                            )
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(20.dp)
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            DetailBadge(
                                text = "${task.subject} • ${if (task.courseCode.isNotBlank()) task.courseCode else "CS-402"}",
                                backgroundColor = StudyBlueLight,
                                textColor = StudyTextSecondary
                            )

                            DetailBadge(
                                text = "● ${task.priorityLabel} Priority",
                                backgroundColor = priorityBackground,
                                textColor = priorityColor
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        DetailBadge(
                            text = if (isDone) "✓ Completed" else "⊙ In Progress",
                            backgroundColor = if (isDone) Color(0xFFE2F8EF) else StudyBlueLight,
                            textColor = statusColor
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = task.title,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyNavy
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = if (task.exerciseSubtitle.isNotBlank()) task.exerciseSubtitle else "Lab Exercise & Implementations",
                            fontSize = 16.sp,
                            color = StudyTextSecondary,
                            lineHeight = 24.sp
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color(0xFFF0EFFF))
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(58.dp)
                                    .clip(CircleShape)
                                    .background(StudyBlue),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.CalendarMonth,
                                    contentDescription = "Deadline",
                                    tint = Color.White,
                                    modifier = Modifier.size(30.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(14.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = task.deadline,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = StudyNavy
                                )

                                Spacer(modifier = Modifier.height(3.dp))

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Outlined.Timer,
                                        contentDescription = null,
                                        tint = Color.Red,
                                        modifier = Modifier.size(17.dp)
                                    )

                                    Spacer(modifier = Modifier.width(4.dp))

                                    Text(
                                        text = if (task.hoursRemainingText.isNotBlank()) task.hoursRemainingText else "23 hours left",
                                        fontSize = 13.sp,
                                        color = Color.Red
                                    )
                                }
                            }

                            Column(horizontalAlignment = Alignment.End) {
                                Text(
                                    text = "Weight",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = StudyTextSecondary
                                )

                                Text(
                                    text = "${if (task.weightPercentage > 0) task.weightPercentage else 15}%",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = StudyBlue
                                )
                            }
                        }
                    }
                }
            }
        }

        // =====================================================
        // CHECKLIST
        // =====================================================

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.CheckCircle,
                            contentDescription = null,
                            tint = StudyGreen,
                            modifier = Modifier.size(27.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "Checklist Progress",
                            modifier = Modifier.weight(1f),
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Medium,
                            color = StudyNavy
                        )

                        Text(
                            text = "$checklistPercentage%",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyGreen
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    LinearProgressIndicator(
                        progress = { checklistProgress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(12.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        color = StudyGreen,
                        trackColor = Color(0xFFE8EBFF)
                    )

                    Spacer(modifier = Modifier.height(28.dp))

                    task.checklist.forEach { item ->
                        ChecklistItemView(
                            item = item,
                            onToggle = { onToggleChecklistItem(task.id, item.id) }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }

        // =====================================================
        // DESCRIPTION
        // =====================================================

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Outlined.Description,
                            contentDescription = null,
                            tint = StudyBlue,
                            modifier = Modifier.size(27.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "Description",
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyNavy
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = if (task.description.isNotBlank()) task.description else "Mengerjakan tugas sesuai instruksi yang diberikan.",
                        fontSize = 16.sp,
                        color = StudyTextSecondary,
                        lineHeight = 26.sp
                    )

                    if (task.submissionNote.isNotBlank()) {
                        Spacer(modifier = Modifier.height(18.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(14.dp))
                                .background(Color(0xFFF0EFFF))
                                .padding(16.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.ErrorOutline,
                                contentDescription = null,
                                tint = StudyBlue,
                                modifier = Modifier.size(22.dp)
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = task.submissionNote,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = StudyTextSecondary,
                                lineHeight = 19.sp
                            )
                        }
                    }
                }
            }
        }

        // =====================================================
        // ATTACHMENTS
        // =====================================================

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.AttachFile,
                            contentDescription = null,
                            tint = StudyBlue,
                            modifier = Modifier.size(27.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "Attachments (${task.attachments.size})",
                            modifier = Modifier.weight(1f),
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyNavy
                        )

                        Text(
                            text = "+ Add File",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = StudyBlue,
                            modifier = Modifier.clickable {
                                documentPickerLauncher.launch("*/*")
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    task.attachments.forEach { attachment ->
                        AttachmentItemView(attachment = attachment)
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }

        // =====================================================
        // DOSEN
        // =====================================================

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(72.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(Color(0xFFE8EBFF)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Dosen",
                            tint = StudyBlue,
                            modifier = Modifier.size(40.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = lecturer.name,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudyNavy
                        )

                        Text(
                            text = "${lecturer.department} • Office Hours: ${lecturer.officeHours}",
                            fontSize = 13.sp,
                            color = StudyTextSecondary
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "▣ Contact Lecturer",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = StudyBlue
                        )
                    }
                }
            }
        }

        // =====================================================
        // ACTION BUTTONS & SUBMISSION DIALOG
        // =====================================================

        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Button(
                    onClick = { onToggleTaskStatus(task.id) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isDone) StudyBlue else StudyGreen
                    )
                ) {
                    Icon(
                        imageVector = Icons.Outlined.CheckCircle,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = if (isDone) "Tandai Belum Selesai" else "Tandai Selesai",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    OutlinedButton(
                        onClick = { showSubmitDialog = true },
                        modifier = Modifier
                            .weight(1f)
                            .height(58.dp),
                        shape = RoundedCornerShape(30.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Edit,
                            contentDescription = null,
                            modifier = Modifier.size(21.dp)
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(text = if (task.submission != null) "Tugas Terkirim" else "Kirim Tugas", fontSize = 16.sp)
                    }

                    Button(
                        onClick = {
                            onDeleteTask(task.id)
                            onBackClick()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(58.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFD9D6),
                            contentColor = Color(0xFFB00020)
                        )
                    ) {
                        Text(
                            text = "Hapus",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }

    if (showSubmitDialog) {
        androidx.compose.material3.AlertDialog(
            onDismissRequest = { showSubmitDialog = false },
            title = {
                Text(
                    text = "Kirim Tugas / Submisi",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            },
            text = {
                Column {
                    Text(
                        text = "Masukkan catatan pengiriman tugas atau keterangan berkas:",
                        fontSize = 14.sp,
                        color = StudyTextSecondary
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    androidx.compose.material3.OutlinedTextField(
                        value = submissionNoteInput,
                        onValueChange = { submissionNoteInput = it },
                        label = { Text("Catatan Pengiriman") },
                        placeholder = { Text("misal: Laporan PDF beserta lampiran source code ZIP") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )
                }
            },
            confirmButton = {
                androidx.compose.material3.Button(
                    onClick = {
                        showSubmitDialog = false
                        onSubmitAssignment(task.id, submissionNoteInput, task.attachments.lastOrNull()?.fileUri, task.attachments.lastOrNull()?.fileName)
                        Toast.makeText(context, "Tugas berhasil dikirim!", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = StudyGreen)
                ) {
                    Text("Kirim Sekarang")
                }
            },
            dismissButton = {
                androidx.compose.material3.TextButton(
                    onClick = { showSubmitDialog = false }
                ) {
                    Text("Batal")
                }
            }
        )
    }
}

@Composable
private fun ChecklistItemView(
    item: TaskChecklistItem,
    onToggle: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onToggle),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(if (item.isChecked) StudyBlue else Color.Transparent),
            contentAlignment = Alignment.Center
        ) {
            if (!item.isChecked) {
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(Color.White)
                )
            }
        }

        Spacer(modifier = Modifier.width(14.dp))

        Text(
            text = item.text,
            fontSize = 16.sp,
            color = if (item.isChecked) StudyTextSecondary else StudyNavy,
            lineHeight = 24.sp
        )
    }
}

@Composable
private fun AttachmentItemView(attachment: TaskAttachment) {
    val context = LocalContext.current
    val openFileAction = {
        if (attachment.fileUri != null) {
            try {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    setDataAndType(
                        android.net.Uri.parse(attachment.fileUri),
                        if (attachment.fileType.equals("PDF", ignoreCase = true)) "application/pdf" else "*/*"
                    )
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                }
                context.startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(context, "Tidak ada aplikasi yang kompatibel untuk membuka file ini.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "File '${attachment.fileName}' adalah berkas bawaan.", Toast.LENGTH_SHORT).show()
        }
    }

    val downloadFileAction = {
        if (attachment.fileUri != null) {
            try {
                val uri = android.net.Uri.parse(attachment.fileUri)
                val inputStream = context.contentResolver.openInputStream(uri)
                if (inputStream != null) {
                    val downloadsDir = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS)
                    val destFile = java.io.File(downloadsDir, attachment.fileName)
                    destFile.outputStream().use { output ->
                        inputStream.copyTo(output)
                    }
                    inputStream.close()
                    Toast.makeText(context, "Berkas berhasil diunduh ke folder Downloads: ${attachment.fileName}", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Berkas siap diunduh.", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(context, "Berkas '${attachment.fileName}' tersimpan di penyimpanan aplikasi.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "Berkas '${attachment.fileName}' adalah berkas sistem.", Toast.LENGTH_SHORT).show()
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF0EFFF))
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFFFD9D6)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = attachment.fileType,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFB00020)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = attachment.fileName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = StudyNavy
            )

            Text(
                text = "${attachment.fileSize} • ${attachment.uploadDate}",
                fontSize = 13.sp,
                color = StudyTextSecondary
            )
        }

        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(Color.White)
                .clickable { downloadFileAction() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.Download,
                contentDescription = "Download",
                tint = StudyNavy,
                modifier = Modifier.size(22.dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(Color.White)
                .clickable { openFileAction() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.Visibility,
                contentDescription = "Lihat",
                tint = StudyNavy,
                modifier = Modifier.size(22.dp)
            )
        }
    }
}

@Composable
private fun DetailBadge(
    text: String,
    backgroundColor: Color,
    textColor: Color
) {
    Text(
        text = text,
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(backgroundColor)
            .padding(horizontal = 12.dp, vertical = 6.dp),
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        color = textColor
    )
}