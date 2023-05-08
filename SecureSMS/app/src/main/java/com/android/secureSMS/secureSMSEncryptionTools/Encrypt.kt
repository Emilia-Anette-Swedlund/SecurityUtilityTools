package com.android.secureSMS.secureSMSEncryptionTools

import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import java.security.SecureRandom

fun encrypt(plainText: String, encryptionKey: ByteArray): ByteArray {
    // Generate a random initialization vector (IV)
    val iv = ByteArray(16)
    SecureRandom().nextBytes(iv)

    // Create the key and initialization vector specs
    val keySpec = SecretKeySpec(encryptionKey, "AES")
    val ivSpec = IvParameterSpec(iv)

    // Create the cipher and initialize it for encryption
    val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec)

    // Encrypt the plaintext and combine it with the IV
    val cipherText = cipher.doFinal(plainText.toByteArray(Charsets.UTF_8))
    return iv + cipherText
}