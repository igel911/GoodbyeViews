package com.example.goodbyeviews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.goodbyeviews.ui.screens.EnterCodeScreen
import com.example.goodbyeviews.ui.screens.login.LoginScreen
import com.example.goodbyeviews.ui.screens.SignUpScreen
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

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
                    var emailValue = ""

                    NavHost(navController = navController, startDestination = "login") {
                        composable(route = "login") {
                            LoginScreen { email ->
                                emailValue = email
                                navController.navigate("signUp/$emailValue")
                            }
                        }

                        composable(
                            route = "signUp/{userEmail}",
                            arguments = getSignUpArgs()
                        ) { backStackEntry ->
                            SignUpScreen(
                                backStackEntry.arguments?.getString("userEmail"),
                                navigateBack = { navController.navigateUp() },
                                navigateForward = { navController.navigate("enterCode/$emailValue") }
                            )
                        }

                        composable(
                            route = "enterCode/{userEmail}",
                            arguments = getEnterCodeArgs()
                        ) { backStackEntry ->
                            EnterCodeScreen(
                                backStackEntry.arguments?.getString("userEmail"),
                                navigateBack = { navController.navigateUp() },
                                navigateForward = { navController.navigate("") }
                            )
                        }
                    }
                }
            }
        }
    }

    private fun getSignUpArgs() = listOf(navArgument("userEmail") { type = NavType.StringType })

    private fun getEnterCodeArgs() = listOf(navArgument("userEmail") { type = NavType.StringType })
}