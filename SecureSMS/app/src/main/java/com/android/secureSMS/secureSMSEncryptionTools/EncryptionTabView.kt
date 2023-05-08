package com.android.secureSMS.secureSMSEncryptionTools

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.secureSMS.R

@Composable
fun EncryptionTab(navController: NavHostController) {
    LazyColumn() {
        item {
            for(i in 0..2) {
                EncryptionRow()
            }
        }
    }
}

@Composable
fun EncryptionRow() {
    Row( modifier = Modifier
        //.background(MaterialTheme.colors.primary)
        .fillMaxSize()
        .wrapContentSize(align = Alignment.Center)) {
        Image(
            modifier = Modifier.padding(50.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = ""
        )
        Image(
            modifier = Modifier.padding(50.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = ""
        )
    }
}