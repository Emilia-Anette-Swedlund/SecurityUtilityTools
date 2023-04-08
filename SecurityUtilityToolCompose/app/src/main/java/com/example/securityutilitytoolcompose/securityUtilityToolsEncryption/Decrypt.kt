package com.example.securityutilitytoolcompose.securityUtilityToolsEncryption

import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

fun decrypt(encryptedData: ByteArray, encryptionKey: ByteArray): String {
    // Extract the IV from the encrypted data
    val iv = encryptedData.sliceArray(0..15)

    // Create the key and initialization vector specs
    val keySpec = SecretKeySpec(encryptionKey, "AES")
    val ivSpec = IvParameterSpec(iv)

    // Create the cipher and initialize it for decryption
    val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec)

    // Decrypt the data and convert it to a string
    val decryptedData = cipher.doFinal(encryptedData.sliceArray(16 until encryptedData.size))
    return String(decryptedData, Charsets.UTF_8)
}