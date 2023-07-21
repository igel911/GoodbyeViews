package com.example.goodbyeviews.ui.screens.sign_up

data class SignUpValidator(
    val isNameValid: Boolean = false,
    val isEmailValid: Boolean = false,
    val isPasswordValid: Boolean = false,
    val isConfirmPasswordValid: Boolean = false,
    val isCheckBoxChecked: Boolean = false
) {
    fun isValid(): Boolean =
        listOf(
            isNameValid,
            isEmailValid,
            isPasswordValid,
            isConfirmPasswordValid,
            isCheckBoxChecked
        ).all { it }
}
