package com.example.goodbyeviews.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

fun regularStyle(
    regularColor: Color = Color.Black,
    fontSize: Int = 12
) = SpanStyle(color = regularColor, fontSize = fontSize.sp)

fun clickableStyle(
    clickableColor: Color = Color.Blue,
    fontSize: Int = 12
) = SpanStyle(
    color = clickableColor,
    fontSize = fontSize.sp,
    fontWeight = FontWeight.Bold
)