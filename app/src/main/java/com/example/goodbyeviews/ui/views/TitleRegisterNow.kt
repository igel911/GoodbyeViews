package com.example.goodbyeviews.ui.views

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

@Composable
fun TitleRegisterNow(
    modifier: Modifier = Modifier,
    regularColor: Color = Color.Black,
    clickableColor: Color = Color.Blue,
    fontSize: Int = 12,
    onRegisterNowClick: () -> Unit = { }
) {
    val notAMember = stringResource(id = R.string.not_a_member)
    val registerNow = stringResource(id = R.string.register_now)

    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(color = regularColor, fontSize = fontSize.sp)
        ) {
            append(notAMember)
            append(" ")
        }

        withStyle(
            style = SpanStyle(
                color = clickableColor,
                fontSize = fontSize.sp,
                fontWeight = FontWeight.Bold
            )
        ) {
            pushStringAnnotation(
                tag = registerNow,
                annotation = registerNow
            )
            append(registerNow)
        }
    }

    ClickableText(
        modifier = modifier,
        text = annotatedText,
        style = TextStyle(textAlign = TextAlign.Center),
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = registerNow,
                start = offset,
                end = offset
            ).firstOrNull()?.let { onRegisterNowClick() }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TitleRegisterNowPreview() {
    GoodbyeViewsTheme {
        TitleRegisterNow()
    }
}