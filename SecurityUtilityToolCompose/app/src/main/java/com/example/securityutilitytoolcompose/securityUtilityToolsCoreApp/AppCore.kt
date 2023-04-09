package com.example.securityutilitytoolcompose.securityUtilityToolsCoreApp

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.example.securityutilitytoolcompose.R
import com.example.securityutilitytoolcompose.securityUtilityToolsContacts.ContactTab
import com.example.securityutilitytoolcompose.securityUtilityToolsEncryption.EncryptionTab
import com.example.securityutilitytoolcompose.securityUtilityToolsMessaging.MessageTab
import com.example.securityutilitytoolcompose.securityUtilityToolsSettings.SecurityUtilityTools_Settings
import com.example.securityutilitytoolcompose.securityUtilityToolsSettings.SettingsTab
import com.example.securityutilitytoolcompose.ui.builtin_functions.SecurityUtilityToolTabRow


@Composable
fun Core(navController: NavHostController) {
    var appSettings = SecurityUtilityTools_Settings()
    if(appSettings.isLocked()) {
        Lockscreen()
    }
    else {
        val tabNames = listOf("Message", "Contacts", "Security", "Settings")
        var selectedTabIndex by remember { mutableStateOf(1) }


        // Tab to show based on which tab is selected.
        when (tabNames[selectedTabIndex]) {
            "Message" -> MessageTab(navController)
            "Contacts" -> ContactTab(navController)
            "Security" -> EncryptionTab(navController)
            "Settings" -> SettingsTab(navController)
        }

        SecurityUtilityToolTabRow(
            tabTitles = tabNames,
            tabImages = listOf(R.drawable.ic_message, R.drawable.ic_address_book, R.drawable.ic_lock_locked, R.drawable.ic_gear),
            tabDescriptions = listOf("Massage Tab", "Contacts Tab", "Security Tap", "Settings Tab"),
            initiallySelectedTab = selectedTabIndex,
            OnTabSelected = { index ->
                selectedTabIndex = index // Update the selectedTabIndex variable
            }
        )
    }
}