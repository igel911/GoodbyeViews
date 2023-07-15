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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun OutlinedPasswordInputWithTitle(
    modifier: Modifier = Modifier,
    @StringRes titleText: Int = R.string.empty,
    titleTextSize: Int = 12,
    titleFontWeight: FontWeight = FontWeight.Medium,
    titleTextColor: Color = Color.Black,
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes placeholderText: Int = R.string.empty,
    shape: Shape = RoundedCornerShape(10.dp)
) {
    Column(modifier = modifier) {
        Title(
            textId = titleText,
            fontSize = titleTextSize,
            fontWeight = titleFontWeight,
            textColor = titleTextColor
        )

        HorizontalSpacer()

        OutlinedPasswordInput(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            placeholderText = placeholderText,
            shape = shape
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OutlinedPasswordInputWithTitlePreview() {
    GoodbyeViewsTheme {
        OutlinedPasswordInputWithTitle(
            value = "abc",
            onValueChange = { }
        )
    }
}