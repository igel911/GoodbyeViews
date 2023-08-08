package com.example.goodbyeviews.ui.screens.interest_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goodbyeviews.ui.extention.stateIn
import com.example.goodbyeviews.ui.navigation.AppNavigator
import com.example.goodbyeviews.ui.navigation.AppNavigatorImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class InterestListViewModel : ViewModel() {
    private val appNavigator: AppNavigator = AppNavigatorImpl

    private val _itemsState: MutableStateFlow<List<InterestItem>> =
        MutableStateFlow(loadInterests())
    val itemsState = _itemsState.asStateFlow()

    val progressState = itemsState.map { items ->
        val selectedItemQuantity = items.filter { it.isSelected }.size
        selectedItemQuantity / 5.0F
    }.stateIn(
        scope = viewModelScope,
        initialValue = 0.0F
    )

    val buttonState = progressState.map {
        it >= 1.0F
    }.stateIn(
        scope = viewModelScope,
        initialValue = false
    )

    private fun loadInterests(): List<InterestItem> =
        mutableListOf<InterestItem>().apply {
            for (i in 0..15) {
                add(InterestItem(i, "Some item $i"))
            }
        }

    fun onInterestSelected(selectedItem: InterestItem) {
        viewModelScope.launch {
            val items = _itemsState.value.map { item ->
                if (selectedItem.id == item.id) {
                    item.copy(isSelected = !selectedItem.isSelected)
                } else item
            }
            _itemsState.emit(items)
        }
    }

    fun navigateTo() {

    }
}