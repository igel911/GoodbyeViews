package com.example.goodbyeviews.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.ui.screens.interest_list.InterestItem
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun InterestSelectedItemView(
    item: InterestItem,
    onClick: (InterestItem) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable { onClick(item) },
        colors = CardDefaults.cardColors(containerColor = GoodbyeViewsTheme.colors.highlight.medium)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Title(
                text = item.name,
                modifier = Modifier
                    .weight(1F)
                    .padding(start = 12.dp)
            )

            Icon(
                modifier = Modifier
                    .padding(end = 12.dp),
                imageVector = Icons.Filled.Check,
                contentDescription = null,
                tint = Color.Blue
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InterestSelectedItemPreview() {
    GoodbyeViewsTheme {
        InterestSelectedItemView(item = InterestItem(1, "Item 1")) { }
    }
}