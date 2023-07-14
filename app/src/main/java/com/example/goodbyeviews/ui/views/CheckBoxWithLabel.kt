package com.example.goodbyeviews.ui.views

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun CheckBoxWithLabel(
    checked: Boolean = false,
    onCheckedChange: ((Boolean) -> Unit) = {},
    @StringRes firstRegularText: Int = R.string.empty,
    @StringRes firstClickableText: Int = R.string.empty,
    onFirstTextClick: (String) -> Unit = { },
    @StringRes secondRegularText: Int = R.string.empty,
    @StringRes secondClickableText: Int = R.string.empty,
    onSecondTextClick: (String) -> Unit = { }
) {
    Row() {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier,
            enabled = true,
            colors = CheckboxDefaults.colors()
        )

        Column() {
            TextWithClickablePart(
                regularText = firstRegularText,
                clickableText = firstClickableText,
                onClick = onFirstTextClick
            )

            TextWithClickablePart(
                regularText = secondRegularText,
                clickableText = secondClickableText,
                onClick = onSecondTextClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxWithLabelPreview() {
    GoodbyeViewsTheme {
        CheckBoxWithLabel(
            firstRegularText = R.string.i_read,
            firstClickableText = R.string.terms_conditions,
            onFirstTextClick = { text -> Log.d("taggg", "clickedText = $text") },
            secondRegularText = R.string.and_the,
            secondClickableText = R.string.privacy_policy,
            onSecondTextClick = { text -> Log.d("taggg", "clickedText = $text") }
        )
    }
}