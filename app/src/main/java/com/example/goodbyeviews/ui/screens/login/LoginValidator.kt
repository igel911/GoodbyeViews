package com.example.goodbyeviews.ui.screens.login

data class LoginValidator(
    val isLoginValid: Boolean = false,
    val isPasswordValid: Boolean = false
) {
    fun isValid(): Boolean =
        listOf(
            isLoginValid,
            isPasswordValid
        ).all { it }
}
