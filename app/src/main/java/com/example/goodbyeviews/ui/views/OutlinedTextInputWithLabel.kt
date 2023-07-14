package com.example.goodbyeviews.ui.views

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.R

@Composable
fun OutlinedTextInputWithLabel(
    modifier: Modifier = Modifier,
    @StringRes labelText: Int = R.string.empty,
    labelTextSize: Int = 12,
    labelFontWeight: FontWeight = FontWeight.Medium,
    labelTextColor: Color = Color.Black,
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes placeholderText: Int = R.string.empty,
    shape: Shape = RoundedCornerShape(10.dp)
) {
    Column(modifier = modifier) {
        TextLabel(
            textId = labelText,
            fontSize = labelTextSize,
            fontWeight = labelFontWeight,
            textColor = labelTextColor
        )

        HorizontalSpacer()

        OutlinedTextInput(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            placeholderText = placeholderText,
            shape = shape
        )
    }
}