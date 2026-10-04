package com.kelompok8.studytrack.data

import com.kelompok8.studytrack.data.models.Lecturer

object LecturerData {
    val wardhana = Lecturer(
        id = "lec_1",
        name = "Prof. Dr. Ir. H. Wardhana",
        department = "Dept. of Computer Science",
        officeHours = "Thu 2–4 PM"
    )

    val sarahJenkins = Lecturer(
        id = "lec_2",
        name = "Dr. Sarah Jenkins",
        department = "Dept. of Computer Science",
        officeHours = "Mon 10–12 AM"
    )

    val robertDavis = Lecturer(
        id = "lec_3",
        name = "Prof. Robert Davis",
        department = "Dept. of Computer Science",
        officeHours = "Wed 1–3 PM"
    )

    val michaelChang = Lecturer(
        id = "lec_4",
        name = "Dr. Michael Chang",
        department = "Dept. of Information Systems",
        officeHours = "Tue 9–11 AM"
    )

    val mayaLin = Lecturer(
        id = "lec_5",
        name = "Maya Lin, M.Sc.",
        department = "Dept. of Informatics",
        officeHours = "Fri 2–4 PM"
    )

    val elenaRostova = Lecturer(
        id = "lec_6",
        name = "Elena Rostova",
        department = "Dept. of Interactive Media",
        officeHours = "Wed 10–12 AM"
    )

    val defaultLecturer = wardhana
}
