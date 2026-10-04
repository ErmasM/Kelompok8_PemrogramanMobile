package com.kelompok8.studytrack.data.security

import android.content.Context
import android.content.SharedPreferences

/**
 * Pengelola sesi pengguna persisten menggunakan SharedPreferences.
 * Memastikan pengguna tidak perlu login ulang setiap kali membuka aplikasi kembali.
 */
object SessionManager {
    private const val PREF_NAME = "studytrack_session"
    private const val KEY_USER_ID = "saved_user_id"
    private const val KEY_USER_EMAIL = "saved_user_email"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveSession(context: Context, userId: String, email: String) {
        getPreferences(context).edit()
            .putString(KEY_USER_ID, userId)
            .putString(KEY_USER_EMAIL, email)
            .apply()
    }

    fun getSavedUserId(context: Context): String? {
        return getPreferences(context).getString(KEY_USER_ID, null)
    }

    fun getSavedUserEmail(context: Context): String? {
        return getPreferences(context).getString(KEY_USER_EMAIL, null)
    }

    fun clearSession(context: Context) {
        getPreferences(context).edit().clear().apply()
    }
}
