package com.example.goodbyeviews.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.goodbyeviews.ui.navigation.AppNavigator
import com.example.goodbyeviews.ui.navigation.AppNavigatorImpl
import com.example.goodbyeviews.ui.navigation.Destination

class LoginViewModel : ViewModel() {
    private val appNavigator: AppNavigator = AppNavigatorImpl
    var emailValue by mutableStateOf("")
        private set
    var passwordValue by mutableStateOf("")
        private set

    var validationState by mutableStateOf(LoginValidator())
        private set

    fun updateLoginValue(login: String) {
        emailValue = login
        validationState = validationState.copy(isLoginValid = login.isNotEmpty())
    }

    fun updatePasswordValue(password: String) {
        passwordValue = password
        validationState = validationState.copy(isPasswordValid = password.isNotEmpty())
    }

    fun navigateToSignUpScreen() {
        appNavigator.tryNavigateTo(Destination.SignUpScreen())
    }

    fun navigateToInterestsScreen() {
        appNavigator.tryNavigateTo(Destination.InterestsScreen())
    }
}