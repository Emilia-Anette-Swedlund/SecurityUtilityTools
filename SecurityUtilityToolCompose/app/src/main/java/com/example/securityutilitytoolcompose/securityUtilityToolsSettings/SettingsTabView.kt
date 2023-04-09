package com.example.securityutilitytoolcompose.securityUtilityToolsSettings

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SettingsTab(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Settings",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        SettingButton( "Messaging/Contacts") {
            navController.navigate("settingsSMS")
        }
        SettingButton( "Encryption") {
            navController.navigate("settingsEncryption")
        }
        SettingButton( "Appearance") {
            navController.navigate("settingsTheme")
        }

        Spacer(modifier = Modifier.height(100.dp))

        SettingButton( "Donate") {

        }

        SettingButton( "Source Code") {

        }
    }
}

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