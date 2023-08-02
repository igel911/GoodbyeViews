package com.example.goodbyeviews.ui.theme

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun regularStyle(
    regularColor: Color = GoodbyeViewsTheme.colors.neutralDark.darkest,
    fontSize: Int = 12
) = SpanStyle(color = regularColor, fontSize = fontSize.sp)

@Composable
fun clickableStyle(
    clickableColor: Color = GoodbyeViewsTheme.colors.highlight.darkest,
    fontSize: Int = 12
) = SpanStyle(
    color = clickableColor,
    fontSize = fontSize.sp,
    fontWeight = FontWeight.Bold
)

@Composable
fun buttonElevation(): ButtonElevation = ButtonDefaults.buttonElevation(
    defaultElevation = 10.dp,
    pressedElevation = 15.dp,
    disabledElevation = 0.dp
)

@Composable
fun buttonColors(): ButtonColors = ButtonDefaults.buttonColors(
    containerColor = GoodbyeViewsTheme.colors.highlight.darkest
)

@Composable
fun buttonBackColors(): ButtonColors = ButtonDefaults.buttonColors(
    containerColor = Color.White,
    contentColor = GoodbyeViewsTheme.colors.highlight.darkest
)