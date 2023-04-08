package com.example.securityutilitytoolcompose

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.example.securityutilitytoolcompose.ui.builtin_functions.SecurityUtilityToolTabRow


@Composable
fun Core(navController: NavHostController) {
    var appSettings = SecurityUtilityTools_Settings()
    if(appSettings.isLocked()) {
        Lockscreen()
    }
    else {
        val tabNames = listOf("Vault", "Encryption", "Settings")
        var selectedTabIndex by remember { mutableStateOf(1) }


        // Tab to show based on which tab is selected.
        when (tabNames[selectedTabIndex]) {
            "Vault" -> VaultTab(navController)
            "Encryption" -> EncryptionTab(navController)
            "Settings" -> SettingsTab(navController)
        }

        SecurityUtilityToolTabRow(
            tabTitles = tabNames,
            tabImages = listOf(R.drawable.ic_vault, R.drawable.ic_lock_locked, R.drawable.ic_gear),
            tabDescriptions = listOf("Vault Tab", "Encryption Tap", "Settings Tab"),
            initallySelectedTab = selectedTabIndex,
            OnTabSelected = { index ->
                selectedTabIndex = index // Update the selectedTabIndex variable
            }
        )
    }
}