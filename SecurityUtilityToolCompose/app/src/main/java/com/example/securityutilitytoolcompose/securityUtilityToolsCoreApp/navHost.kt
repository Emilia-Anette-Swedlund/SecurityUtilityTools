package com.example.securityutilitytoolcompose.securityUtilityToolsCoreApp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.securityutilitytoolcompose.securityUtilityToolsSettings.SettingsEncryption
import com.example.securityutilitytoolcompose.securityUtilityToolsSettings.SettingsTheme
import com.example.securityutilitytoolcompose.securityUtilityToolsSettings.SettingsVault

@Composable
fun SetNavHost(): NavHostController {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "appCore") {
        composable("appCore") {
            Core(navController)
        }
        composable("settingsVault") { backStackEntry ->
            SettingsVault(navController)
        }
        composable("settingsEncryption") { backStackEntry ->
            SettingsEncryption(navController)
        }
        composable("settingsTheme") { backStackEntry ->
            SettingsTheme(navController)
        }
    }

    return navController
}
