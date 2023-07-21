package com.example.goodbyeviews.ui.screens.sign_up

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignUpViewModel: ViewModel() {
    var nameValue by mutableStateOf("")
        private set
    var emailValue by mutableStateOf("")
        private set
    var passwordValue by mutableStateOf("")
        private set
    var confirmPasswordValue by mutableStateOf("")
        private set
    var checkBoxValue by mutableStateOf(false)
        private set

    var validationState by mutableStateOf(SignUpValidator())
        private set

    fun updateNameValue(name: String) {
        nameValue = name
        validationState = validationState.copy(isNameValid = name.isNotEmpty())
    }

    fun updatePasswordValue(password: String) {
        passwordValue = password
        validationState = validationState.copy(isPasswordValid = password.isNotEmpty())
    }

    fun updateConfirmPasswordValue(confirmPassword: String) {
        confirmPasswordValue = confirmPassword
        validationState = validationState.copy(isConfirmPasswordValid = confirmPassword.isNotEmpty())
    }

    fun updateCheckBoxValue(isChecked: Boolean) {
        checkBoxValue = isChecked
        validationState = validationState.copy(isCheckBoxChecked = isChecked)
    }

    fun updateEmailValue(email: String) {
        emailValue = email
        validationState = validationState.copy(isEmailValid = email.isNotEmpty())
    }
}