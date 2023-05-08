package com.android.secureSMS.secureSMSAppCore

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.android.secureSMS.secureSMSContacts.ContactTab
import com.android.secureSMS.secureSMSMessaging.MessageTab
import com.android.secureSMS.secureSMSSettings.SettingsTab
import com.android.secureSMS.ui.builtin_functions.SecureSMS_TabRow
import com.android.secureSMS.R

@Composable
fun Core(navController: NavHostController) {
    val tabNames = listOf("Message", "Contacts", "Settings")
    var selectedTabIndex by remember { mutableStateOf(0) }


    // Tab to show based on which tab is selected.
    when (tabNames[selectedTabIndex]) {
        "Message" -> MessageTab(navController)
        "Contacts" -> ContactTab(navController)
        "Settings" -> SettingsTab(navController)
    }

    SecureSMS_TabRow(
        tabTitles = tabNames,
        tabImages = listOf(R.drawable.ic_message, R.drawable.ic_address_book, R.drawable.ic_gear),
        tabDescriptions = listOf("Massage Tab", "Contacts Tab", "Settings Tab"),
        initiallySelectedTab = selectedTabIndex,
        OnTabSelected = { index ->
            selectedTabIndex = index // Update the selectedTabIndex variable
        }
    )
}