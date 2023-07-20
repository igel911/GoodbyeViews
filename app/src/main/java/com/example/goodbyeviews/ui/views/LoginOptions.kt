package com.example.goodbyeviews.ui.views

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.screens.login.LoginViewModel
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme


@Composable
fun LoginOptions(
    navigateForward: (String) -> Unit
) {
    val viewModel = viewModel { LoginViewModel() }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues(start = 16.dp, end = 16.dp))
    ) {
        HorizontalSpacer()

        Title(
            textId = R.string.welcome,
            fontSize = 24,
            fontWeight = FontWeight.Bold
        )

        HorizontalSpacer()

        OutlinedTextInput(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.emailValue,
            onValueChange = viewModel::updateEmailValue,
            placeholderText = R.string.email
        )

        HorizontalSpacer()

        OutlinedPasswordInput(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.passwordValue,
            onValueChange = viewModel::updatePasswordValue,
            placeholderText = R.string.password
        )

        HorizontalSpacer()

        Title(
            textId = R.string.forgot_password,
            fontWeight = FontWeight.Bold,
            textColor = Color.Blue
        )

        HorizontalSpacer()

        ButtonWithTitle(
            modifier = Modifier.fillMaxWidth(),
            text = R.string.login,
            onClick = { navigateForward(viewModel.emailValue) }
        )

        HorizontalSpacer()

        TitleRegisterNow(
            modifier = Modifier.fillMaxWidth(),
            onRegisterNowClick = { Log.d("taggg", "onRegisterNowClick") }
        )

        HorizontalDivider()

        Title(
            modifier = Modifier.fillMaxWidth(),
            textId = R.string.continue_with
        )

        HorizontalSpacer()

        LoginVariants()

        HorizontalSpacer()
    }
}

@Preview(showBackground = true)
@Composable
fun LoginOptionsPreview() {
    GoodbyeViewsTheme {
        LoginOptions { }
    }
}