package com.example.goodbyeviews.ui.views

import androidx.annotation.StringRes
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.theme.buttonColors
import com.example.goodbyeviews.ui.theme.buttonElevation


@Composable
fun ButtonWithTitle(
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = GoodbyeViewsTheme.shapes.medium,
    elevation: ButtonElevation = buttonElevation(),
    colors: ButtonColors = buttonColors(),
    isButtonEnabled: Boolean = true,
    onClick: () -> Unit = { }
) {
    Button(
        modifier = modifier,
        shape = shape,
        elevation = elevation,
        colors = colors,
        enabled = isButtonEnabled,
        onClick = onClick
    ) {
        Text(text = text)
    }
}

@Composable
fun ButtonWithTitle(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    shape: Shape = GoodbyeViewsTheme.shapes.medium,
    elevation: ButtonElevation = buttonElevation(),
    colors: ButtonColors = buttonColors(),
    isButtonEnabled: Boolean = true,
    onClick: () -> Unit = { }
) {
    ButtonWithTitle(
        modifier = modifier,
        text = stringResource(text),
        shape = shape,
        elevation = elevation,
        colors = colors,
        isButtonEnabled = isButtonEnabled,
        onClick = onClick
    )
}

@Preview(showBackground = true)
@Composable
fun ButtonWithTitlePreview() {
    GoodbyeViewsTheme {
        ButtonWithTitle(text = "click me")
    }
}