package com.example.goodbyeviews.ui.screens.paging

import androidx.lifecycle.ViewModel
import com.example.goodbyeviews.ui.navigation.AppNavigator
import com.example.goodbyeviews.ui.navigation.AppNavigatorImpl
import com.example.goodbyeviews.ui.navigation.Destination

class InterestPagingViewModel: ViewModel() {
    private val appNavigator: AppNavigator = AppNavigatorImpl

    fun navigateToInterestsScreen() {
        appNavigator.tryNavigateTo(Destination.InterestsScreen())
    }
}