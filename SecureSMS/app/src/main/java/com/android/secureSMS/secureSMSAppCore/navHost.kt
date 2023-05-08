package com.android.secureSMS.secureSMSAppCore

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.secureSMS.secureSMSContacts.ContactTab
import com.android.secureSMS.secureSMSSettings.SettingsTheme
import com.android.secureSMS.secureSMSSettings.settingsSMS

@Composable
fun SetNavHost(): NavHostController {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "appCore") {
        composable("appCore") {
            Core(navController)
        }
        composable("localPassword") { backStackEntry ->
            LocalPasswordView(navController)
        }
        composable("settingsTheme") { backStackEntry ->
            SettingsTheme(navController)
        }
        composable("settingsSMS") { backStackEntry ->
            settingsSMS(navController)
        }
        composable("contacts") { navBackStackEntry ->
            ContactTab(navController)
        }

    }

    return navController
}
