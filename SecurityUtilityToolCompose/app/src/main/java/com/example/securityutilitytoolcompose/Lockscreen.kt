package com.example.securityutilitytoolcompose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun Lockscreen() {
    Column( modifier = Modifier.fillMaxSize().wrapContentSize(align = Alignment.Center)) {
        var textFieldValue by remember { mutableStateOf(TextFieldValue()) }

        Text("Security Utility Tools")
        Row() {
            TextField(
                value = textFieldValue,
                onValueChange = { newValue ->
                    textFieldValue = newValue
                    val currentText = newValue.text // Access the current value of the text field
                }
            )
            Button(modifier = Modifier.height(55.dp), onClick = { }) {
                Text("Submit")
            }
        }
    }
}