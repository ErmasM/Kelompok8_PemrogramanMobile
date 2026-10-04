package com.kelompok8.studytrack.data.security

import java.security.SecureRandom
import java.util.Base64
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

object PasswordHasher {

    private const val ITERATIONS = 100_000
    private const val KEY_LENGTH = 256
    private const val SALT_SIZE = 16

    fun hashPassword(password: String): String {
        val random = SecureRandom()
        val salt = ByteArray(SALT_SIZE)
        random.nextBytes(salt)

        val hash = pbkdf2(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH)
        val encodedSalt = Base64.getEncoder().encodeToString(salt)
        val encodedHash = Base64.getEncoder().encodeToString(hash)

        return "$encodedSalt:$encodedHash"
    }

    fun verifyPassword(password: String, storedHash: String): Boolean {
        if (storedHash.isBlank() || !storedHash.contains(":")) return false
        val parts = storedHash.split(":")
        if (parts.size != 2) return false

        val salt = Base64.getDecoder().decode(parts[0])
        val hash = Base64.getDecoder().decode(parts[1])

        val testHash = pbkdf2(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH)
        if (testHash.size != hash.size) return false

        var diff = 0
        for (i in hash.indices) {
            diff = diff or (hash[i].toInt() xor testHash[i].toInt())
        }
        return diff == 0
    }

    private fun pbkdf2(
        password: CharArray,
        salt: ByteArray,
        iterations: Int,
        keyLength: Int
    ): ByteArray {
        val spec = PBEKeySpec(password, salt, iterations, keyLength)
        val skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
        return skf.generateSecret(spec).encoded
    }
}

