package com.example.goodbyeviews.ui.screens.interest_list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.views.Title

@Composable
fun InterestItemView(
    item: InterestItem,
    onClick: (InterestItem) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable { onClick(item) },
        border = BorderStroke(2.dp, GoodbyeViewsTheme.colors.highlight.medium),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Title(
                text = item.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InterestItemPreview() {
    GoodbyeViewsTheme {
        InterestItemView(item = InterestItem(1, "Item 1")) { }
    }
}