package com.example.projectmanagment.presentation.navigation.bottomBar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController

@Composable
fun BottomBar(navController: NavHostController) {
    val items = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Search,
        BottomNavigationItem.Profile
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selectedItemIndex,
                onClick = {
                    if (navController.currentDestination?.route != item.route) {
                        selectedItemIndex = index
                        navController.navigate(item.route) {
                            launchSingleTop = true
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(item.selectedIcon),
                        contentDescription = item.route,
                        tint = if (index == selectedItemIndex) Color(0xFF3D3BFF)
                        else Color(0xFF272727)
                    )
                }
            )
        }
    }
}