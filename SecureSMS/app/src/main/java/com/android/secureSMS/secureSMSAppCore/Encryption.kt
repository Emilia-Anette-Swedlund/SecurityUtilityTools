package com.android.secureSMS.secureSMSAppCore

import org.bouncycastle.crypto.AsymmetricCipherKeyPair
import org.bouncycastle.crypto.digests.KeccakDigest
import org.bouncycastle.pqc.crypto.sphincs.SPHINCS256KeyGenerationParameters
import org.bouncycastle.pqc.crypto.sphincs.SPHINCS256KeyPairGenerator
import org.bouncycastle.pqc.legacy.crypto.ntru.NTRUEncryptionKeyGenerationParameters
import org.bouncycastle.pqc.legacy.crypto.ntru.NTRUEncryptionKeyPairGenerator
import org.bouncycastle.pqc.legacy.crypto.ntru.NTRUEncryptionPublicKeyParameters
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.security.SecureRandom
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

class Encryption {

    private val keyStore = KeyStore.getInstance("AndroidKeyStore").apply {
        load(null)
    }


    fun generateNTRUKeyPairs(): AsymmetricCipherKeyPair {
        val ntruKeyPairGenerator = NTRUEncryptionKeyPairGenerator().apply {
            init(NTRUEncryptionKeyGenerationParameters.APR2011_743)
        }
        return ntruKeyPairGenerator.generateKeyPair()
    }

    fun generateSPHINCS256KeyPair(): AsymmetricCipherKeyPair {
        val random = SecureRandom()
        val treeDigest = KeccakDigest(256)
        val params = SPHINCS256KeyGenerationParameters(random, treeDigest)

        val keyPairGenerator = SPHINCS256KeyPairGenerator()
        keyPairGenerator.init(params)

        return keyPairGenerator.generateKeyPair()
    }

    suspend fun generateRSAKeyPairs(): KeyPair? {
        val keyPairGenerator = KeyPairGenerator.getInstance("RSA")
        keyPairGenerator.initialize(4096)
        return keyPairGenerator.generateKeyPair()
    }

    fun EncryptString() {
        val keyPair = generateNTRUKeyPairs()

        // Get the NTRUEncryptionPublicKeyParameters from the key pair
        val publicKey = keyPair.public as NTRUEncryptionPublicKeyParameters

        // Convert the string to a byte array
        val plaintext = "Hello, World!".toByteArray()

        // Encrypt the plaintext using the public key
//        val cipher = NTRUEngine()
//        cipher.init(true, publicKey)
//        val ciphertext = ByteArray(cipher.outputBlockSize)
//        val len = cipher.(plaintext, 0, plaintext.size, ciphertext, 0)
//        cipher.doFinal(ciphertext, len)

    }


    fun generateAESKey(): SecretKey? {
        val keyGenerator: KeyGenerator = KeyGenerator.getInstance("AES")
        keyGenerator.init(256)
        return keyGenerator.generateKey()
    }

}