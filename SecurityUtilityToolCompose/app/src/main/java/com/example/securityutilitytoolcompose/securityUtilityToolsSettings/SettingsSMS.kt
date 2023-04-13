package com.example.securityutilitytoolcompose.securityUtilityToolsSettings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.bouncycastle.crypto.AsymmetricCipherKeyPair
import org.bouncycastle.crypto.digests.KeccakDigest
import org.bouncycastle.pqc.crypto.sphincs.SPHINCS256KeyGenerationParameters
import org.bouncycastle.pqc.crypto.sphincs.SPHINCS256KeyPairGenerator
import org.bouncycastle.pqc.legacy.crypto.ntru.NTRUEncryptionKeyGenerationParameters.APR2011_743
import org.bouncycastle.pqc.legacy.crypto.ntru.NTRUEncryptionKeyPairGenerator
import org.bouncycastle.pqc.legacy.crypto.ntru.NTRUEncryptionPrivateKeyParameters
import org.bouncycastle.pqc.legacy.crypto.ntru.NTRUEncryptionPublicKeyParameters
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.SecureRandom

@Composable
fun settingsSMS(navController: NavHostController) {
    var publicKeyString by remember { mutableStateOf("publicKeyString") }
    var privateKeyString by remember { mutableStateOf("privateKeyString") }
    var buttonText by remember { mutableStateOf("Generate RSA key pair") }
    var buttonTextNTRU by remember { mutableStateOf("Generate NTRU key pair") }
    var buttonTextSPHINCS by remember { mutableStateOf("Generate SPHINCS+ key pair") }


    LazyColumn {
       item {
           Column() {
               Text("SMS Settings")
               Button(onClick = {
                   buttonText = startLoadingAnimation()
                   CoroutineScope(Dispatchers.IO).launch(Dispatchers.IO) {
                       val keyPair = generateRSAKeyPairs()
                       //delay(3000)
                       val publicKey = keyPair?.public
                       val privateKey = keyPair?.private
                       publicKeyString = publicKey.toString()
                       privateKeyString = privateKey.toString()
                       buttonText = "Generated."
                   }
               }) {
                   Text(text = buttonText)
               }
               Button(onClick = {
                   buttonTextNTRU = startLoadingAnimation()
                   CoroutineScope(Dispatchers.IO).launch(Dispatchers.IO) {
                       val keyPair: AsymmetricCipherKeyPair = generateNTRUKeyPairs()
                       val publicKey = keyPair.public as NTRUEncryptionPublicKeyParameters
                       val privateKey = keyPair.private as NTRUEncryptionPrivateKeyParameters
                       publicKeyString = "Public Key: ${publicKey.getEncoded().joinToString(separator = "") { "%02x".format(it) }}"
                       privateKeyString = "Private Key: ${privateKey.getEncoded().joinToString(separator = "") { "%02x".format(it) }}"

                       buttonTextNTRU = "Generated."
                   }
               }) {
                   Text(text = buttonTextNTRU)
               }
               Button(onClick = {
                   buttonTextSPHINCS = startLoadingAnimation()
                   CoroutineScope(Dispatchers.IO).launch(Dispatchers.IO) {
                       val keyPair = generateSPHINCS256KeyPair()
                       val publicKey = keyPair.public
                       val privateKey = keyPair.private
                       buttonTextSPHINCS = "Generated."
                   }
               }) {
                   Text(text = buttonTextSPHINCS)
               }
               Text("PUB")
               Text(text = publicKeyString)
               Text("PRIV")
               Text(text = privateKeyString)
           }
           }
       }

}

suspend fun generateRSAKeyPairs(): KeyPair? {
    val keyPairGenerator = KeyPairGenerator.getInstance("RSA")
    keyPairGenerator.initialize(4096)
    return keyPairGenerator.generateKeyPair()
}

fun startLoadingAnimation(): String {
    return "Loading"
}

fun generateNTRUKeyPairs(): AsymmetricCipherKeyPair {
    val ntruKeyPairGenerator = NTRUEncryptionKeyPairGenerator().apply {
        init(APR2011_743)
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