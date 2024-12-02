package com.example.projectmanagment.presentation.navigation.bottomBar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectmanagment.presentation.auth.AuthViewModel
import com.example.projectmanagment.presentation.home.HomePage
import com.example.projectmanagment.presentation.profile.ProfilePage
import com.example.projectmanagment.presentation.search.SearchPage

@Composable
fun BottomBarNavigation(authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavigationItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavigationItem.Home.route) {
                HomePage(navController, authViewModel)
            }
            composable(BottomNavigationItem.Search.route) {
                SearchPage(navController)
            }
            composable(BottomNavigationItem.Profile.route) {
                ProfilePage(navController,authViewModel)
            }
        }
    }
}