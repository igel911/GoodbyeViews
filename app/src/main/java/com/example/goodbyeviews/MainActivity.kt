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
import com.example.goodbyeviews.ui.screens.enter_code.EnterCodeScreen
import com.example.goodbyeviews.ui.screens.login.LoginScreen
import com.example.goodbyeviews.ui.screens.sign_up.SignUpScreen
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

                    NavHost(navController = navController, startDestination = "login") {
                        composable(route = "login") {
                            LoginScreen(
                                navigateForward = {},
                                navigateToSignUp = { navController.navigate("signUp") }
                            )
                        }

                        composable(
                            route = "signUp",
                        ) {
                            SignUpScreen(
                                navigateBack = { navController.navigateUp() },
                                navigateForward = { emailValue ->
                                    navController.navigate("enterCode/$emailValue")
                                }
                            )
                        }

                        composable(
                            route = "enterCode/{userEmail}",
                            arguments = getEnterCodeArgs()
                        ) { backStackEntry ->
                            EnterCodeScreen(
                                backStackEntry.arguments?.getString("userEmail"),
                                navigateBack = { navController.navigateUp() },
                                navigateForward = {  }
                            )
                        }
                    }
                }
            }
        }
    }

    private fun getEnterCodeArgs() = listOf(navArgument("userEmail") { type = NavType.StringType })
}