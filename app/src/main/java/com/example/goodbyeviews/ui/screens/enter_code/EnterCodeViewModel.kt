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

    var enterCodeState by mutableStateOf(EnterCodeState())
        private set

    var validationState by mutableStateOf(EnterCodeValidator(EnterCodeState()))
        private set

    fun navigateBack() {
        appNavigator.tryNavigateBack()
    }

    fun updateEnterCodeState(newEnterCodeState: EnterCodeState) {
        enterCodeState = newEnterCodeState
        validationState = validationState.copy(enterCodeState = newEnterCodeState)
    }
}