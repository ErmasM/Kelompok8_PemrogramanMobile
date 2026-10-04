package com.kelompok8.studytrack.data.database

import android.util.Log
import com.surrealdb.Surreal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import android.content.Context
import java.io.File

/**
 * Singleton penanganan koneksi SurrealDB Cloud menggunakan Java/Kotlin SDK resmi (com.surrealdb.Surreal).
 */
object SurrealDbClient {

    private const val TAG = "SurrealDbClient"

    @Volatile
    private var _client: Surreal? = null

    @Volatile
    private var _isConnected: Boolean = false

    /** Status keaktifan koneksi ke SurrealDB Cloud */
    val isConnected: Boolean get() = _isConnected

    /** Client instance (null jika tidak terhubung) */
    val client: Surreal? get() = _client

    /**
     * Inisialisasi koneksi SurrealDB secara asinkron di IO Dispatcher.
     * @return true jika berhasil terkoneksi, false jika offline/timeout
     */

    private var appContext: Context? = null

    fun init(context: Context) {
        appContext = context.applicationContext
    }
    suspend fun initialize(): Boolean = withContext(Dispatchers.IO) {
        if (_isConnected && _client != null) return@withContext true

        try {
            val result = withTimeoutOrNull(SurrealDbConfig.CONNECTION_TIMEOUT_MS) {

                val context = appContext
                    ?: throw IllegalStateException("SurrealDbClient.init() belum dipanggil")

                val result = withTimeoutOrNull(
                    SurrealDbConfig.CONNECTION_TIMEOUT_MS
                ) {
                    val nativeFile = File(context.filesDir, "libsurrealdb.so")

                    if (!nativeFile.exists()) {
                        context.assets.open(
                            "natives/android_arm64/libsurrealdb.so"
                        ).use { input ->
                            nativeFile.outputStream().use { output ->
                                input.copyTo(output)
                            }
                        }
                    }

                    System.setProperty(
                        "surrealdb.native.path",
                        nativeFile.absolutePath
                    )

                    val db = Surreal()
                    db.connect(SurrealDbConfig.SURREAL_URL)
                    db.useNs(SurrealDbConfig.NAMESPACE)
                        .useDb(SurrealDbConfig.DATABASE)

                    db
                }

                val db = Surreal()
                db.connect(SurrealDbConfig.SURREAL_URL)
                db.useNs(SurrealDbConfig.NAMESPACE).useDb(SurrealDbConfig.DATABASE)
                db
            }

            if (result != null) {
                _client = result
                _isConnected = true
                Log.i(TAG, "✅ SurrealDB connected to ${SurrealDbConfig.SURREAL_URL}")
                true
            } else {
                Log.w(TAG, "⏱️ SurrealDB connection timeout (${SurrealDbConfig.CONNECTION_TIMEOUT_MS}ms). Running offline.")
                _isConnected = false
                false
            }
        } catch (e: Exception) {
            Log.w(TAG, "⚠️ SurrealDB connection error: ${e.message}. Fallback to local mode.")
            _isConnected = false
            false
        }
    }

    /**
     * Menutup koneksi SurrealDB.
     */
    suspend fun close() = withContext(Dispatchers.IO) {
        try {
            _client?.close()
            Log.i(TAG, "🔌 SurrealDB connection closed.")
        } catch (e: Exception) {
            Log.w(TAG, "Warning closing SurrealDB connection: ${e.message}")
        } finally {
            _client = null
            _isConnected = false
        }
    }
}

