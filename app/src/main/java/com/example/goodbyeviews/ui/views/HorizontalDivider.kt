package com.example.goodbyeviews.ui.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun HorizontalDivider(
    paddingHorizontal: Int = 0,
    paddingVertical: Int = 24,
    thickness: Int = 1
    ) {
    Divider(
        modifier = Modifier.padding(paddingHorizontal.dp, paddingVertical.dp),
        thickness = thickness.dp,
        color = Color.Gray
    )
}

@Preview(showBackground = true)
@Composable
fun HorizontalDividerPreview() {
    GoodbyeViewsTheme {
        HorizontalDivider()
    }
}
