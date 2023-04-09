package com.example.securityutilitytoolcompose.securityUtilityToolsContacts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ContactTab(navController: NavHostController) {
    Column() {
        Text(
            text = "Contacts",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn {
            item {
                for (i in 0..100)
                    Row() {
                        Text("L")
                    }
            }
        }
    }
}


@Composable
fun ContactRow() {
//    for (i in 1..10) {
//        Row() {
//            Text("FIRST, LAST")
//        }
//    }
}