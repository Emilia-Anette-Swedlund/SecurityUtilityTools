package com.android.secureSMS.secureSMSAppCore

import android.app.AlertDialog
import android.view.Gravity
import android.view.WindowManager
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LocalPasswordView(navController: NavHostController) {
    var showAlert by remember { mutableStateOf(BooleanWrapper(false)) }

    Column( modifier = Modifier.fillMaxSize().wrapContentSize(align = Alignment.Center)) {
        var password by remember { mutableStateOf(TextFieldValue()) }

        Text("Secure SMS")
        Row() {
            TextField(
                value = password,
                onValueChange = { newValue ->
                    password = newValue
                    val currentText = newValue.text // Access the current value of the text field
                }
            )
            Button(modifier = Modifier.height(55.dp), onClick = {
                if (password.text == "password") {
                    navController.navigate("appCore")
                    print("CORRECT")
                }
                else {
                    showAlert = BooleanWrapper(true)
                    print("INCORRECT")
                }
            }) {
                Text("Submit")
            }
            showBadPasswordAlert(showAlert, navController)
        }
    }
//    val focusRequester = FocusRequester()
//    DisposableEffect(Unit) {
//        focusRequester.requestFocus()
//        onDispose { }
//    }
}

class BooleanWrapper(var value: Boolean)

@Composable
fun showBadPasswordAlert(showAlert: BooleanWrapper, navController: NavHostController) {
    val builder = AlertDialog.Builder(LocalContext.current)
    builder.setTitle("Incorrect Password")
    builder.setMessage("Would you like to make a new profile? This will generate a new set of public/private keys, which will only be accessible with the password you just typed in. Your other passwords will not be deleted and can still be accessed by logging in with older passwords .")

    // Set up the OK button
    builder.setPositiveButton(android.R.string.ok) { dialog, which ->
        // Do something when OK button is clicked
        navController.navigate("appCore")
        showAlert.value = false
        dialog.dismiss() // Close the popup
    }
    builder.setNegativeButton(android.R.string.cancel) { dialog, which ->
        // Do something when OK button is clicked
        showAlert.value = false
        dialog.dismiss() // Close the popup
    }
    // Create and show the popup
    val dialog = builder.create()
    if(showAlert.value) {
        dialog.show()
    }

    // Set the size and position of the popup
    val window = dialog.window
    window?.setLayout(
        WindowManager.LayoutParams.WRAP_CONTENT,
        WindowManager.LayoutParams.WRAP_CONTENT
    )
    window?.setGravity(Gravity.CENTER)
}