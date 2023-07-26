package com.example.goodbyeviews.ui.screens.sign_up

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
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
fun SignUpScreen() {
    val viewModel = viewModel { SignUpViewModel() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(PaddingValues(horizontal = 16.dp))
    ) {

        HorizontalSpacer()

        Title(
            textId = R.string.sign_up,
            textStyle = MaterialTheme.typography.titleSmall
        )

        HorizontalSpacer()

        Title(
            textId = R.string.create_account
        )

        HorizontalSpacer()

        OutlinedTextInputWithTitle(
            labelText = R.string.name,
            value = viewModel.nameValue,
            onValueChange = viewModel::updateNameValue,
            placeholderText = R.string.name
        )

        HorizontalSpacer()

        OutlinedTextInputWithTitle(
            labelText = R.string.email,
            value = viewModel.emailValue,
            onValueChange = viewModel::updateEmailValue,
            placeholderText = R.string.email_hint
        )

        HorizontalSpacer()

        OutlinedPasswordInputWithTitle(
            titleText = R.string.password,
            value = viewModel.passwordValue,
            onValueChange = viewModel::updatePasswordValue,
            placeholderText = R.string.password_hint
        )

        HorizontalSpacer()

        OutlinedPasswordInput(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.confirmPasswordValue,
            onValueChange = viewModel::updateConfirmPasswordValue,
            placeholderText = R.string.password_confirm_hint
        )

        HorizontalSpacer()

        CheckBoxAgreement(
            checked = viewModel.checkBoxValue,
            onCheckedChange = viewModel::updateCheckBoxValue,
            onTermsAndConditionClick = { Log.d("taggg", "onTermsAndConditionClick") },
            onPrivacyPolicyClick = { Log.d("taggg", "onPrivacyPolicyClick") }
        )

        HorizontalSpacer()

        NavigationControls(
            modifier = Modifier.fillMaxWidth(),
            navigateBack = { viewModel.navigateBack() },
            navigateForward = { viewModel.navigateToEnterCodeScreen() },
            isButtonNextEnabled = viewModel.validationState.isValid()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    GoodbyeViewsTheme {
        SignUpScreen()
    }
}