package com.android.secureSMS.secureSMSMessaging

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MessageStartNew(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = { navController.navigate("contacts") },
            modifier = Modifier
                .padding(16.dp)
                .padding(bottom = 64.dp)
                .align(Alignment.BottomEnd)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }
}