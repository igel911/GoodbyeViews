package com.example.goodbyeviews.ui.views

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun Title(
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    @StringRes textId: Int = R.string.empty,
    text: String? = null,
    fontSize: Int,
    fontWeight: FontWeight = FontWeight.Medium,
    textColor: Color = Color.Black,
    onClick: () -> Unit = {}
) {
    Title(
        modifier = modifier,
        textAlign = textAlign,
        textId = textId,
        text = text,
        fontSize = fontSize.dp,
        fontWeight = fontWeight,
        textColor = textColor,
        onClick = onClick
    )
}

@Composable
fun Title(
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    @StringRes textId: Int = R.string.empty,
    text: String? = null,
    fontSize: Dp = 12.dp,
    fontWeight: FontWeight = FontWeight.Medium,
    textColor: Color = Color.Black,
    onClick: () -> Unit = {}
) {
    Text(
        modifier = modifier.clickable(onClick = onClick),
        textAlign = textAlign,
        text = getText(textId = textId, text = text),
        fontSize = fontSize.value.sp,
        fontWeight = fontWeight,
        color = textColor
    )
}

@Composable
private fun getText(
    @StringRes textId: Int,
    text: String?
): String =
    if (text.isNullOrBlank()) stringResource(textId) else text

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    GoodbyeViewsTheme {
        Title(
            textId = R.string.welcome
        )
    }
}