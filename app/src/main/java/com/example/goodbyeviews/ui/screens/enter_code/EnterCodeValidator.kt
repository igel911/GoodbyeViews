package com.example.goodbyeviews.ui.screens.enter_code

data class EnterCodeValidator(
    val enterCodeState: EnterCodeState
) {
    fun isValid(): Boolean =
        listOf(
            enterCodeState.firstValue.isNotEmpty(),
            enterCodeState.secondValue.isNotEmpty(),
            enterCodeState.thirdValue.isNotEmpty(),
            enterCodeState.fourthValue.isNotEmpty()
        ).all { it }
}
