package com.example.goodbyeviews.ui.views.interests

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.views.Title

@Composable
fun InterestPageSecond(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Title(
            text = "y",
            modifier = Modifier.align(Alignment.Center),
            textStyle = GoodbyeViewsTheme.typography.h2.copy(fontSize = 300.sp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InterestPageSecondPreview() {
    GoodbyeViewsTheme {
        InterestPageSecond()
    }
}