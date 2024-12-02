package com.example.projectmanagment.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectmanagment.presentation.auth.AuthViewModel
import com.example.projectmanagment.presentation.auth.LoginPage
import com.example.projectmanagment.presentation.auth.SignUpPage
import com.example.projectmanagment.presentation.home.HomePage
import com.example.projectmanagment.presentation.navigation.bottomBar.BottomBarNavigation

@Composable
fun AuthNavigation(authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginPage(navController, authViewModel)
        }
        composable("signup") {
            SignUpPage(navController, authViewModel)
        }
        composable("main") {
            BottomBarNavigation(authViewModel)
        }
    }
}

object AuthRoutes {
    const val LOGIN = "login"
    const val SIGNUP = "signup"
    const val MAIN = "main"
}
