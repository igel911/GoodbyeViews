package com.example.goodbyeviews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.goodbyeviews.ui.screens.EnterCodeScreen
import com.example.goodbyeviews.ui.screens.LoginScreen
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.screens.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoodbyeViewsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable(route = "login") {
                            LoginScreen { navController.navigate("signUp") }
                        }
                        composable(route = "signUp") {
                            SignUpScreen(
                                navigateBack = { navController.navigateUp() },
                                navigateForward = { navController.navigate("enterCode") }
                            )
                        }
                        composable(route = "enterCode") {
                            EnterCodeScreen(
                                navigateBack = { navController.navigateUp() },
                                navigateForward = { navController.navigate("") }
                            )
                        }
                    }
                }
            }
        }
    }
}