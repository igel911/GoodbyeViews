package com.example.goodbyeviews.ui.views

import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.theme.textFieldColors

@Composable
fun OutlinedPasswordInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    @StringRes placeholderText: Int = R.string.empty,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Password,
        imeAction = ImeAction.None
    ),
    textFieldColors: TextFieldColors = textFieldColors()
) {
    var showPassword by remember { mutableStateOf(false) }

    OutlinedTextInput(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        placeholderText = placeholderText,
        visualTransformation = getCorrectPasswordTransformation(showPassword),
        icon = getCorrectPasswordImage(showPassword),
        contentDescription = getCorrectPasswordDescription(showPassword),
        onIconClick = { showPassword = !showPassword },
        singleLine = singleLine,
        maxLines = maxLines,
        keyboardOptions = keyboardOptions,
        textFieldColors = textFieldColors
    )
}

@Composable
private fun getCorrectPasswordTransformation(showPassword: Boolean) =
    if (showPassword) VisualTransformation.None else PasswordVisualTransformation()

@Composable
private fun getCorrectPasswordDescription(showPassword: Boolean) =
    if (showPassword) R.string.show_password else R.string.hide_password

@Composable
private fun getCorrectPasswordImage(showPassword: Boolean) = if (showPassword) {
    Icons.Outlined.VisibilityOff
} else {
    Icons.Outlined.Visibility
}

@Preview(showBackground = true)
@Composable
fun OutlinedPasswordInputPreview() {
    GoodbyeViewsTheme {
        OutlinedPasswordInput(
            value = "abc",
            onValueChange = { }
        )
    }
}
