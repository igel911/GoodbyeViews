package com.example.goodbyeviews.ui.views

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun OutlinedPasswordInputWithTitle(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    @StringRes titleText: Int = R.string.empty,
    @StringRes placeholderText: Int = R.string.empty
) {
    Column(modifier = modifier) {
        Title(
            textId = titleText,
            textStyle = MaterialTheme.typography.titleSmall
        )

        HorizontalSpacer()

        OutlinedPasswordInput(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            placeholderText = placeholderText
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