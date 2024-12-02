package com.example.projectmanagment.presentation.navigation.bottomBar

import com.example.projectmanagment.R

sealed class BottomNavigationItem(
    val route: String,
    val selectedIcon: Int
) {
    object Home : BottomNavigationItem("home", R.drawable.home_icon)
    object Search : BottomNavigationItem("search", R.drawable.search_icon)
    object Profile : BottomNavigationItem("profile", R.drawable.profile_icon)
}