package com.example.goodbyeviews.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun GoodbyeViewsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTypography provides Typography,
        LocalColors provides Colors,
        LocalShapes provides MyShapes,
        content = content
    )
}

object GoodbyeViewsTheme {

    val colors: ComposeColors
        @Composable
        get() = LocalColors.current

    val typography: ComposeTypography
        @Composable
        get() = LocalTypography.current

    val shapes: ComposeShapes
        @Composable
        get() = LocalShapes.current
}