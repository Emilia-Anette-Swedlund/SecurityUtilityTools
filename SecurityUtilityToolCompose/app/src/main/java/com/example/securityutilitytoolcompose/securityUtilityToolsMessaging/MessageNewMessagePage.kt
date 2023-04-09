package com.example.securityutilitytoolcompose.securityUtilityToolsMessaging

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun newMessagePage(navController: NavHostController) {
    Column() {
        Text(
            text = "New Message",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        var messageNumber by remember { mutableStateOf("") }
        var messageText by remember { mutableStateOf("") }

        TextField (
            value = messageNumber,
            onValueChange = { messageNumber = it },
            placeholder = { Text("Number or Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .background(
                    MaterialTheme.colors.secondary,
                    shape = RoundedCornerShape(8.dp)
                )
        )
        TextField (
            value = messageText,
            onValueChange = { messageText = it },
            placeholder = { Text("new message here") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .fillMaxHeight(0.3F)
        )

    }
}