package com.example.goodbyeviews.ui.views

import androidx.annotation.StringRes
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

const val TAG = "TAG"

@Composable
fun TextWithClickablePart(
    modifier: Modifier = Modifier,
    @StringRes regularText: Int,
    regularColor: Color = Color.Black,
    @StringRes clickableText: Int,
    clickableColor: Color = Color.Blue,
    fontSize: Int = 12,
    textAlign: TextAlign = TextAlign.Center,
    onClick: (String) -> Unit = { }
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(color = regularColor, fontSize = fontSize.sp)
        ) {
            append(stringResource(regularText))
            append(" ")
        }

        pushStringAnnotation(
            tag = TAG,
            annotation = stringResource(clickableText)
        )

        withStyle(
            style = SpanStyle(
                color = clickableColor,
                fontSize = fontSize.sp,
                fontWeight = FontWeight.Bold
            )
        ) {
            append(stringResource(clickableText))
        }

        pop()
    }

    ClickableText(
        modifier = modifier,
        text = annotatedText,
        style = TextStyle(textAlign = textAlign),
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = TAG,
                start = offset,
                end = offset
            ).firstOrNull()?.let { annotation ->
                onClick.invoke(annotation.item)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TextWithClickablePartPreview() {
    GoodbyeViewsTheme {
        TextWithClickablePart(
            regularText = R.string.not_a_member,
            clickableText = R.string.register_now
        )
    }
}