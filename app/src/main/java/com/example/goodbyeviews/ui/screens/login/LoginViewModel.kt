package com.example.goodbyeviews.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    var emailValue by mutableStateOf("")
        private set
    var passwordValue by mutableStateOf("")
        private set

    fun updateEmailValue(email: String) {
        emailValue = email
    }

    fun updatePasswordValue(email: String) {
        passwordValue = email
    }
}