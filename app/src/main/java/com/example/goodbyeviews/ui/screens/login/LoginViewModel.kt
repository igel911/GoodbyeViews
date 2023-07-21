package com.example.goodbyeviews.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
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
}