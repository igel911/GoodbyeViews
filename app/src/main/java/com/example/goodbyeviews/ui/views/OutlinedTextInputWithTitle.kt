package com.example.goodbyeviews.ui.views

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun OutlinedTextInputWithTitle(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    @StringRes labelText: Int = R.string.empty,
    @StringRes placeholderText: Int = R.string.empty,
    shape: Shape = GoodbyeViewsTheme.shapes.medium
) {
    Column(modifier = modifier) {
        Title(
            textId = labelText,
            textStyle = MaterialTheme.typography.titleSmall
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

@Preview(showBackground = true)
@Composable
fun OutlinedTextInputWithTitlePreview() {
    GoodbyeViewsTheme {
        OutlinedTextInputWithTitle(
            value = "abc",
            onValueChange = { }
        )
    }
}