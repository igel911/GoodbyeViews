package com.example.goodbyeviews.ui.screens.enter_code

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.views.HorizontalSpacer
import com.example.goodbyeviews.ui.views.NavigationControls
import com.example.goodbyeviews.ui.views.SmsCodeInput
import com.example.goodbyeviews.ui.views.Title

@Composable
fun EnterCodeScreen(
    userEmail: String? = null,
    navigateBack: () -> Unit,
    navigateForward: () -> Unit
) {
    val viewModel = viewModel { EnterCodeViewModel() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(PaddingValues(start = 16.dp, end = 16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalSpacer(spacerHeight = 88)

        Title(
            textId = R.string.enter_code,
            fontSize = 16,
            fontWeight = FontWeight.Bold
        )

        HorizontalSpacer(spacerHeight = 2)

        Title(
            text = stringResource(R.string.code_was_sent, userEmail.toString())
        )

        HorizontalSpacer(spacerHeight = 40)

        SmsCodeInput(
            firstValue = viewModel.firstValue,
            onFirstValueChanged = viewModel::updateFirstValue,
            secondValue = viewModel.secondValue,
            onSecondValueChanged = viewModel::updateSecondValue,
            thirdValue = viewModel.thirdValue,
            onThirdValueChanged = viewModel::updateThirdValue,
            fourthValue = viewModel.fourthValue,
            onFourthValueChanged = viewModel::updateFourthValue,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        HorizontalSpacer()

        Title(
            textId = R.string.resend_code,
            textColor = Color.Blue
        )

        Spacer(modifier = Modifier.weight(1f))

        NavigationControls(
            modifier = Modifier.fillMaxWidth(),
            navigateBack = navigateBack,
            navigateForward = navigateForward,
            isButtonNextEnabled = viewModel.validationState.isValid()
        )

        HorizontalSpacer()
    }
}

@Preview(showBackground = true)
@Composable
fun EnterCodeScreenPreview() {
    GoodbyeViewsTheme {
        EnterCodeScreen(
            navigateBack = { },
            navigateForward = { }
        )
    }
}