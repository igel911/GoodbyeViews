package com.example.goodbyeviews.ui.views

import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.theme.textFieldColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    @StringRes placeholderText: Int = R.string.empty,
    placeholderTextStyle: TextStyle = GoodbyeViewsTheme.typography.bodyS,
    shape: Shape = GoodbyeViewsTheme.shapes.medium,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    icon: ImageVector? = null,
    onIconClick: () -> Unit = {},
    @StringRes contentDescription: Int = R.string.empty,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.None
    ),
    textStyle: TextStyle = TextStyle(textAlign = TextAlign.Start),
    textFieldColors: TextFieldColors = textFieldColors()
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(
            text = stringResource(placeholderText),
            style = placeholderTextStyle

        ) },
        shape = shape,
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (icon != null) {
                IconButton(onClick = onIconClick) {
                    Icon(
                        imageVector = icon,
                        contentDescription = stringResource(contentDescription)
                    )
                }
            }
        },
        singleLine = singleLine,
        maxLines = maxLines,
        keyboardOptions = keyboardOptions,
        textStyle = textStyle,
        colors = textFieldColors
    )
}

@Preview(showBackground = true)
@Composable
fun OutlinedTextInputPreview() {
    GoodbyeViewsTheme {
        OutlinedTextInput(
            value = "abc",
            onValueChange = { }
        )
    }
}