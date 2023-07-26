package com.example.goodbyeviews.ui

import androidx.lifecycle.ViewModel
import com.example.goodbyeviews.ui.navigation.AppNavigator
import com.example.goodbyeviews.ui.navigation.AppNavigatorImpl

class MainViewModel: ViewModel() {
    private val appNavigator: AppNavigator = AppNavigatorImpl
    val navigationChannel = appNavigator.navigationChannel
}