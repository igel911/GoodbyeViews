package com.example.goodbyeviews.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.dp

val MyShapes = ComposeShapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(10.dp),
    large = RoundedCornerShape(15.dp)
)

@Immutable
data class ComposeShapes(
    val small: RoundedCornerShape = RoundedCornerShape(0),
    val medium: RoundedCornerShape = RoundedCornerShape(0),
    val large: RoundedCornerShape = RoundedCornerShape(0)
)
