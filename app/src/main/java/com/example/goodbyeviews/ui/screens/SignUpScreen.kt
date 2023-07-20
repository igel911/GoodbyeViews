package com.example.goodbyeviews.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.views.CheckBoxAgreement
import com.example.goodbyeviews.ui.views.HorizontalSpacer
import com.example.goodbyeviews.ui.views.NavigationControls
import com.example.goodbyeviews.ui.views.OutlinedPasswordInput
import com.example.goodbyeviews.ui.views.OutlinedPasswordInputWithTitle
import com.example.goodbyeviews.ui.views.OutlinedTextInputWithTitle
import com.example.goodbyeviews.ui.views.Title

@Composable
fun SignUpScreen(
    userEmail: String? = null,
    navigateBack: () -> Unit,
    navigateForward: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(PaddingValues(start = 16.dp, end = 16.dp))
    ) {
        var nameValue by remember { mutableStateOf("") }
        var emailValue by remember { mutableStateOf("") }
        var passwordValue by remember { mutableStateOf("") }
        var confirmPasswordValue by remember { mutableStateOf("") }
        var checkBoxValue by remember { mutableStateOf(false) }

        HorizontalSpacer()

        Title(
            textId = R.string.sign_up,
            fontSize = 16,
            fontWeight = FontWeight.Bold
        )

        HorizontalSpacer()

        Title(
            textId = R.string.create_account
        )

        HorizontalSpacer()

        OutlinedTextInputWithTitle(
            labelText = R.string.name,
            labelFontWeight = FontWeight.Bold,
            value = nameValue,
            onValueChange = { value ->
                nameValue = value
            },
            placeholderText = R.string.name
        )

        HorizontalSpacer()

        OutlinedTextInputWithTitle(
            labelText = R.string.email,
            labelFontWeight = FontWeight.Bold,
            value = emailValue,
            onValueChange = { value ->
                emailValue = value
            },
            placeholderText = R.string.email_hint
        )

        HorizontalSpacer()

        OutlinedPasswordInputWithTitle(
            titleText = R.string.password,
            titleFontWeight = FontWeight.Bold,
            value = passwordValue,
            onValueChange = { value ->
                passwordValue = value
            },
            placeholderText = R.string.password_hint
        )

        HorizontalSpacer()

        OutlinedPasswordInput(
            modifier = Modifier.fillMaxWidth(),
            value = confirmPasswordValue,
            onValueChange = { newText ->
                confirmPasswordValue = newText
            },
            placeholderText = R.string.password_confirm_hint
        )

        HorizontalSpacer()

        CheckBoxAgreement(
            checked = checkBoxValue,
            onCheckedChange = { value ->
                checkBoxValue = value
            },
            onTermsAndConditionClick = { Log.d("taggg", "onTermsAndConditionClick") },
            onPrivacyPolicyClick = { Log.d("taggg", "onPrivacyPolicyClick") }
        )

        HorizontalSpacer()

        NavigationControls(
            navigateBack = navigateBack,
            navigateForward = navigateForward
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    GoodbyeViewsTheme {
        SignUpScreen(
            navigateBack = { },
        navigateForward = { }
        )
    }
}