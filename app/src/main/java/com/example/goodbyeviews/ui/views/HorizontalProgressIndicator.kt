package com.example.goodbyeviews.ui.views

import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun HorizontalProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    trackColor: Color = GoodbyeViewsTheme.colors.neutralLight.darkest,
    color: Color = GoodbyeViewsTheme.colors.highlight.darkest
) {
    LinearProgressIndicator(
        progress = progress,
        modifier = modifier,
        trackColor = trackColor,
        color = color
    )
}