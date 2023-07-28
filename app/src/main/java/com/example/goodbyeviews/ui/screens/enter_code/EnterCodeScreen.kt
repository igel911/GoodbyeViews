package com.example.goodbyeviews.ui.screens.enter_code

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.views.NavigationControls
import com.example.goodbyeviews.ui.views.SmsCodeInput
import com.example.goodbyeviews.ui.views.Title

@Composable
fun EnterCodeScreen() {
    val viewModel: EnterCodeViewModel = viewModel()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(PaddingValues(horizontal = 16.dp))
    ) {
        val (titleEnterCode, titleWasSent, smsCodeInput, titleResend, navigationControl)
                = createRefs()

        createVerticalChain(
            titleEnterCode, titleWasSent, smsCodeInput, titleResend,
            chainStyle = ChainStyle.Packed
        )

        Title(
            textId = R.string.enter_code,
            textStyle = MaterialTheme.typography.titleMedium,
            modifier = Modifier.constrainAs(titleEnterCode) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(titleWasSent.top)
                height = Dimension.wrapContent
            }
        )

        Title(
            text = stringResource(R.string.code_was_sent, viewModel.email),
            textStyle = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = 4.dp)
                .constrainAs(titleWasSent) {
                    top.linkTo(titleEnterCode.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(smsCodeInput.top)
                    height = Dimension.wrapContent
                }
        )

        SmsCodeInput(
            firstValue = viewModel.firstValue,
            onFirstValueChanged = viewModel::updateFirstValue,
            secondValue = viewModel.secondValue,
            onSecondValueChanged = viewModel::updateSecondValue,
            thirdValue = viewModel.thirdValue,
            onThirdValueChanged = viewModel::updateThirdValue,
            fourthValue = viewModel.fourthValue,
            onFourthValueChanged = viewModel::updateFourthValue,
            modifier = Modifier
                .padding(top = 16.dp)
                .constrainAs(smsCodeInput) {
                    top.linkTo(titleWasSent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(titleResend.top)
                    height = Dimension.wrapContent
                }
        )

        Title(
            textId = R.string.resend_code,
            textStyle = MaterialTheme.typography.titleMedium,
            textColor = Color.Blue,
            modifier = Modifier
                .padding(top = 20.dp)
                .constrainAs(titleResend) {
                    top.linkTo(smsCodeInput.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(navigationControl.top)
                    height = Dimension.wrapContent
                }
        )

        NavigationControls(
            modifier = Modifier.constrainAs(navigationControl) {
                bottom.linkTo(parent.bottom, margin = 24.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                height = Dimension.wrapContent
            },
            navigateBack = { viewModel.navigateBack() },
            navigateForward = { },
            isButtonNextEnabled = viewModel.validationState.isValid()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EnterCodeScreenPreview() {
    GoodbyeViewsTheme {
        EnterCodeScreen()
    }
}