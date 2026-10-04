package com.kelompok8.studytrack.data.database

/**
 * Konfigurasi koneksi SurrealDB Cloud.
 *
 * Endpoint: wss://vivid-river-06ggen8549sh72uk51dbgo182s.aws-use1.surreal.cloud
 *
 * Keamanan:
 * - Tidak menyimpan root credentials (root/root) di APK.
 * - Menggunakan SurrealDB Record Authentication / Scope Access untuk autentikasi user.
 */
object SurrealDbConfig {

    // =========================================================
    // SERVER CONNECTION
    // =========================================================

    /** URL server SurrealDB Cloud terenkripsi (wss://) */
    const val SURREAL_URL = "wss://vivid-river-06ggen8549sh72uk51dbgo182s.aws-use1.surreal.cloud"

    // =========================================================
    // NAMESPACE, DATABASE & SCOPE ACCESS
    // =========================================================
    const val NAMESPACE = "studytrack"
    const val DATABASE = "studytrack_db"
    const val ACCESS_SCOPE = "user_scope"

    // =========================================================
    // TABLES
    // =========================================================
    const val TABLE_USERS         = "users"
    const val TABLE_TASKS         = "tasks"
    const val TABLE_COURSES       = "courses"
    const val TABLE_NOTIFICATIONS = "notifications"

    // =========================================================
    // TIMEOUT
    // =========================================================
    /** Timeout (ms) untuk upaya koneksi ke SurrealDB Cloud */
    const val CONNECTION_TIMEOUT_MS = 5_000L
}

