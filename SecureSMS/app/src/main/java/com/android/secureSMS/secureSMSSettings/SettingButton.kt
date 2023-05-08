package com.android.secureSMS.secureSMSSettings

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingButton(buttonName: String, onButtonSelected: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { onButtonSelected() },
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .height(48.dp)
        ) {
            Text(text = buttonName)
        }
    }
}