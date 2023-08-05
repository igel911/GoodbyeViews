package com.example.goodbyeviews.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.ui.screens.interest_list.InterestItem
import com.example.goodbyeviews.ui.screens.interest_list.InterestItemView

@Composable
fun InterestList(
    interests: List<InterestItem>,
    onInterestSelected: (InterestItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(interests) { _, item ->
            if (item.isSelected) {
                InterestSelectedItemView(item = item, onClick = onInterestSelected)
            } else {
                InterestItemView(item = item, onClick = onInterestSelected)
            }

        }
    }
}