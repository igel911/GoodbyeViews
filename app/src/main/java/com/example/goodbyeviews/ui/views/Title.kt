package com.example.goodbyeviews.ui.views

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun Title(
    @StringRes textId: Int,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = GoodbyeViewsTheme.typography.bodyM,
    textColor: Color = Color.Black
) {
    Title(
        modifier = modifier,
        text = stringResource(textId),
        textStyle = textStyle,
        textColor = textColor
    )
}

@Composable
fun Title(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = GoodbyeViewsTheme.typography.bodyM,
    textColor: Color = Color.Black
) {
    Text(
        modifier = modifier,
        text = text,
        color = textColor,
        style = textStyle
    )
}

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    GoodbyeViewsTheme {
        Title(
            textId = R.string.welcome
        )
    }
}