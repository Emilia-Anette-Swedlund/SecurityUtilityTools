package com.android.secureSMS.ui.builtin_functions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun SecureSMS_TabRow(tabTitles: List<String>? = null,
                              tabImages: List<Int>? = null,
                              tabDescriptions: List<String>? = null,
                              initiallySelectedTab: Int = 0,
                              OnTabSelected: (Int) -> Unit ) {

    requireNotNull(tabDescriptions) { "SecurityUtilityToolTabRows require a description list to be passed." }
    require(tabTitles != null || tabImages != null) { "SecurityUtilityToolTabRows requires at least one of the following lists: tabTitles, tabImages. Currently both are null." }
    require(tabTitles == null || tabImages == null || tabTitles.size == tabImages.size) { "SecurityUtilityToolTabRows requires lists tabTitles and tabImages must have the same length if they both exist. Currently both exist and are not the same length." }
    require(tabTitles == null || tabTitles.size == tabDescriptions.size) { "SecurityUtilityToolTabRows requires tabTitles to have the same length as tabDescriptions if both exist, Currently they both exist and have different lengths." }
    require(tabImages == null || tabImages.size == tabDescriptions.size) { "SecurityUtilityToolTabRows requires tabImages to have the same length as tabDescriptions if both exist, Currently they both exist and have different lengths."}

    val numberOfTabs = tabDescriptions.size - 1
    var selectedTabIndex by remember { mutableStateOf(initiallySelectedTab) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f))
        TabRow(
            selectedTabIndex = selectedTabIndex,
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onSurface,
            modifier = Modifier.fillMaxWidth()
        ) {
            for( i in 0..numberOfTabs ) {
                Tab(
                    selected = selectedTabIndex == i,
                    onClick = {
                        selectedTabIndex = i
                        OnTabSelected(i)
                    },
                    modifier = Modifier.semantics { tabDescriptions[i] }
                ) {

                    if (tabImages != null) {
                        Image(
                            modifier = Modifier.padding(top = 8.dp),
                            painter = painterResource(id = tabImages[i]),
                            contentDescription = ""
                        )
                    }
                    if (tabTitles != null) {
                        Text(
                            text = tabTitles[i],
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                }
            }
        }
    }
}