package com.example.goodbyeviews.ui.screens.interest_list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
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
    onClick: (selectedItem: InterestItem) -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .clickable { onClick(item) },
        border = BorderStroke(2.dp, GoodbyeViewsTheme.colors.highlight.medium),
        colors = CardDefaults.cardColors(containerColor = getContainerColor(item))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Title(
                text = item.name,
                modifier = Modifier.weight(1F).padding(start = 12.dp)
            )

            Checkbox(
                checked = item.isSelected,
                enabled = false,
                onCheckedChange = { }
            )
        }
    }
}

@Composable
private fun getContainerColor(item: InterestItem) =
    if (item.isSelected) GoodbyeViewsTheme.colors.highlight.medium else Color.White

@Preview(showBackground = true)
@Composable
fun InterestItemPreview() {
    GoodbyeViewsTheme {
        InterestItemView(item = InterestItem(1, "Item 1")) {  }
    }
}