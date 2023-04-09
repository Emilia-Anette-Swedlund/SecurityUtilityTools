package com.example.securityutilitytoolcompose.securityUtilityToolsMessaging

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MessageTab(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column() {
            Text(
                text = "Messaging",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(top = 8.dp)
                    .padding(bottom = 66.dp)
            ) {
                for (i in 0..30) {
                    item {
                        MessageRow(
                            sender = "John Smith",
                            message = "Hey, what's up?",
                            timestamp = "2:30 PM",
                            hasBeenViewed = false,
                            onClick = { /* do something when the row is clicked */ }
                        )
                    }
                }
            }
        }
        FloatingActionButton(
            onClick = {navController.navigate("newMessage")},
            modifier = Modifier
                .padding(16.dp)
                .padding(bottom = 64.dp)
                .align(Alignment.BottomEnd)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }
}

@Composable
fun MessageRow(
    sender: String,
    message: String,
    timestamp: String,
    hasBeenViewed: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .clickable(onClick = onClick)
            .background(
                if (hasBeenViewed) MaterialTheme.colors.secondary else MaterialTheme.colors.primary,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = sender,
                style = MaterialTheme.typography.subtitle1,
                color = if (hasBeenViewed) MaterialTheme.colors.onSecondary else MaterialTheme.colors.onPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = message,
                style = MaterialTheme.typography.body2,
                color = if (hasBeenViewed) MaterialTheme.colors.onSecondary else MaterialTheme.colors.onPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = timestamp,
            style = MaterialTheme.typography.caption,
            color = if (hasBeenViewed) MaterialTheme.colors.onSecondary else MaterialTheme.colors.onPrimary
        )
    }
    Spacer(modifier = Modifier.height(4.dp))
}
