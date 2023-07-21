package com.example.goodbyeviews.ui.screens.enter_code

data class EnterCodeValidator(
    val isFirstValid: Boolean = false,
    val isSecondValid: Boolean = false,
    val isThirdValid: Boolean = false,
    val isFourthValid: Boolean = false
) {
    fun isValid(): Boolean =
        listOf(
            isFirstValid,
            isSecondValid,
            isThirdValid,
            isFourthValid
        ).all { it }
}
