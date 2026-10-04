package com.kelompok8.studytrack.regulation

import com.kelompok8.studytrack.data.models.UserProfile

object UserRegulation {

    fun validateLoginCredentials(email: String, password: String): Boolean {
        return email.isNotBlank() && email.contains("@") && password.length >= 4
    }

    fun validateRegistrationData(name: String, email: String, password: String): Boolean {
        return name.isNotBlank() && email.isNotBlank() && email.contains("@") && password.length >= 6
    }

    fun validateProfileUpdate(
        name: String,
        email: String,
        major: String,
        year: String
    ): Boolean {
        return name.isNotBlank() &&
                email.isNotBlank() && email.contains("@") &&
                major.isNotBlank() &&
                year.isNotBlank()
    }

    fun getStudentBio(user: UserProfile): String {
        return "${user.major} • ${user.year}"
    }

    fun isEligibleForAcademicHonor(gpa: Double): Boolean {
        return gpa >= 3.5
    }
}
