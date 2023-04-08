package com.example.securityutilitytoolcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SetNavHost(): NavHostController {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Core(navController)
        }
        composable("settingsVault") { backStackEntry ->
            // SettingsVault()
        }
        composable("settingsEncryption") { backStackEntry ->
            // SettingsEncryption()
        }
        composable("settingsTheme") { backStackEntry ->
            SettingsTheme()
        }
    }

    return navController
}
