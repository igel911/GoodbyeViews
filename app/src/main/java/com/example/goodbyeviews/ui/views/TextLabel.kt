package com.example.goodbyeviews.ui.views

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TextLabel(
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    @StringRes textId: Int,
    fontSize: Int = 12,
    fontWeight: FontWeight = FontWeight.Medium,
    textColor: Color = Color.Black
) {
    Text(
        modifier = modifier,
        textAlign = textAlign,
        text = stringResource(textId),
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        color = textColor
    )
}