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
fun CheckBoxAgreement(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    onCheckedChange: ((Boolean) -> Unit) = {},
    onTermsAndConditionClick: () -> Unit = { },
    onPrivacyPolicyClick: () -> Unit = { },
    regularColor: Color = Color.Black,
    clickableColor: Color = Color.Blue,
    fontSize: Int = 12
) {
    CheckboxContainer(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier
    ) {

        val termsAndCondition = stringResource(R.string.terms_conditions)
        val privacyPolicy = stringResource(R.string.privacy_policy)

        val annotatedText = buildAnnotatedString {
            val regularStyle = SpanStyle(color = regularColor, fontSize = fontSize.sp)
            val clickableStyle = SpanStyle(
                color = clickableColor,
                fontSize = fontSize.sp,
                fontWeight = FontWeight.Bold
            )

            withStyle(style = regularStyle) {
                append(stringResource(R.string.i_read))
                append(" ")
            }

            withStyle(style = clickableStyle) {
                pushStringAnnotation(
                    tag = termsAndCondition,
                    annotation = termsAndCondition
                )
                append(termsAndCondition)
            }
            withStyle(style = regularStyle) {
                append(" ")
                append(stringResource(R.string.and_the))
                append(" ")
            }

            withStyle(style = clickableStyle) {
                pushStringAnnotation(
                    tag = privacyPolicy,
                    annotation = privacyPolicy
                )
                append(privacyPolicy)
            }
        }

        ClickableText(
            modifier = modifier,
            text = annotatedText,
            style = TextStyle(textAlign = TextAlign.Start),
            onClick = { offset ->
                annotatedText.getStringAnnotations(
                    start = offset,
                    end = offset
                ).firstOrNull()?.let { range ->
                    when (range.tag) {
                        termsAndCondition -> onTermsAndConditionClick()
                        privacyPolicy -> onPrivacyPolicyClick()
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxAgreementPreview() {
    GoodbyeViewsTheme {
        CheckBoxAgreement()
    }
}