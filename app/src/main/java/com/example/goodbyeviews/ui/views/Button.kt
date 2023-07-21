package com.example.goodbyeviews.ui.views

import androidx.annotation.StringRes
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme


@Composable
fun ButtonWithTitle(
    modifier: Modifier = Modifier,
    text: String = "",
    shape: CutCornerShape = CutCornerShape(10),
    elevation: ButtonElevation = ButtonDefaults.buttonElevation(
        defaultElevation = 10.dp,
        pressedElevation = 15.dp,
        disabledElevation = 0.dp
    ),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Blue
    ),
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
    modifier: Modifier = Modifier,
    @StringRes text: Int = R.string.empty,
    shape: CutCornerShape = CutCornerShape(10),
    elevation: ButtonElevation = ButtonDefaults.buttonElevation(
        defaultElevation = 10.dp,
        pressedElevation = 15.dp,
        disabledElevation = 0.dp
    ),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Blue
    ),
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