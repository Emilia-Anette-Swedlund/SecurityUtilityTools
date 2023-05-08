package com.android.secureSMS.secureSMSMessaging

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

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