package com.android.secureSMS.secureSMSContacts

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import com.android.secureSMS.secureSMSAppCore.Encryption
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec

@Composable
fun ContactTab(navController: NavHostController) {
    Column() {
        var textFieldText by remember { mutableStateOf(TextFieldValue()) }
        var textFieldPassword by remember { mutableStateOf(TextFieldValue()) }

        var encoded by remember { mutableStateOf("") }

        var text by remember { mutableStateOf("") }
        var pass by remember { mutableStateOf("") }

        Text("Key")
        Column() {
            TextField(
                value = textFieldText,
                onValueChange = { newValue ->
                    textFieldText = newValue
                    text = newValue.text // Access the current value of the text field
                }
            )
            Text("Password:")
            TextField(
                value = textFieldPassword,
                onValueChange = { newValue ->
                    textFieldPassword = newValue
                    pass = newValue.text // Access the current value of the text field
                }
            )
            Button(onClick = {
                val plaintext = text.toByteArray(Charsets.UTF_8)
                val cipher = Cipher.getInstance("AES/GCM/NoPadding")
                val eTools = Encryption()
                val key = eTools.generateAESKey()
                cipher.init(Cipher.ENCRYPT_MODE, key)

                val ivSize = cipher.getParameters().getParameterSpec(IvParameterSpec::class.java).iv.size
                val iv = ByteArray(ivSize)
                SecureRandom().nextBytes(iv)


                val encoded = cipher.doFinal(plaintext)

            }) {
                Text("Encrypt")
            }

            Text(encoded)
        }
    }
}


//@Composable
//fun ContactRow() {
//    for (i in 1..10) {
//        Row() {
//            Text("FIRST, LAST")
//        }
//    }
//}