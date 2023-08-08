package com.example.goodbyeviews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.goodbyeviews.ui.MainViewModel
import com.example.goodbyeviews.ui.navigation.Destination
import com.example.goodbyeviews.ui.navigation.MyNavHost
import com.example.goodbyeviews.ui.navigation.NavigationEffects
import com.example.goodbyeviews.ui.navigation.composable
import com.example.goodbyeviews.ui.screens.enter_code.EnterCodeScreen
import com.example.goodbyeviews.ui.screens.interest_list.InterestListScreen
import com.example.goodbyeviews.ui.screens.login.LoginScreen
import com.example.goodbyeviews.ui.screens.paging.InterestPagingScreen
import com.example.goodbyeviews.ui.screens.sign_up.SignUpScreen
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val viewModel = viewModel { MainViewModel() }
    val navController = rememberNavController()

    NavigationEffects(
        navigationChannel = viewModel.navigationChannel,
        navHostController = navController
    )
    GoodbyeViewsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MyNavHost(
                navController = navController,
                startDestination = Destination.LoginScreen
            ) {
                composable(destination = Destination.LoginScreen) {
                    LoginScreen()
                }
                composable(destination = Destination.SignUpScreen) {
                    SignUpScreen()
                }
                composable(destination = Destination.EnterCodeScreen) {
                    EnterCodeScreen()
                }
                composable(destination = Destination.InterestsScreen) {
                    InterestListScreen()
                }
                composable(destination = Destination.InterestsPagingScreen) {
                    InterestPagingScreen()
                }
            }
        }
    }
}