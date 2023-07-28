package com.example.goodbyeviews.ui.screens.enter_code

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.goodbyeviews.ui.navigation.AppNavigator
import com.example.goodbyeviews.ui.navigation.AppNavigatorImpl
import com.example.goodbyeviews.ui.navigation.EMAIL_KEY

class EnterCodeViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val appNavigator: AppNavigator = AppNavigatorImpl
    val email = savedStateHandle.get<String>(EMAIL_KEY).orEmpty()

    var firstValue by mutableStateOf("")
        private set
    var secondValue by mutableStateOf("")
        private set
    var thirdValue by mutableStateOf("")
        private set
    var fourthValue by mutableStateOf("")
        private set

    var validationState by mutableStateOf(EnterCodeValidator())
        private set

    fun updateFirstValue(value: String) {
        firstValue = value
        validationState = validationState.copy(isFirstValid = value.isNotEmpty())
    }

    fun updateSecondValue(value: String) {
        secondValue = value
        validationState = validationState.copy(isSecondValid = value.isNotEmpty())
    }

    fun updateThirdValue(value: String) {
        thirdValue = value
        validationState = validationState.copy(isThirdValid = value.isNotEmpty())
    }

    fun updateFourthValue(value: String) {
        fourthValue = value
        validationState = validationState.copy(isFourthValid = value.isNotEmpty())
    }

    fun navigateBack() {
        appNavigator.tryNavigateBack()
    }
}