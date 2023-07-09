package com.example.goodbyeviews.ui.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalSpacer(spacerHeight: Int = 24) {
    Spacer(modifier = Modifier.height(spacerHeight.dp))
}