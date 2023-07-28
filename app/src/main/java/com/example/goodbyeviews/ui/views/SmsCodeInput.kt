package com.example.goodbyeviews.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.ui.screens.enter_code.EnterCodeState
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.theme.smsTextStyle
import com.example.goodbyeviews.ui.theme.textFieldColors

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SmsCodeInput(
    enterCodeState: EnterCodeState,
    onStateChanged: (EnterCodeState) -> Unit,
    modifier: Modifier = Modifier
) {
    val (firstFocus, secondFocus, thirdFocus, fourthFocus) = remember {
        FocusRequester.createRefs()
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        val keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        )

        OutlinedTextField(
            modifier = modifier
                .requiredWidth(48.dp)
                .focusRequester(firstFocus),
            singleLine = true,
            value = enterCodeState.firstValue,
            onValueChange = { value ->
                onStateChanged(enterCodeState.copy(firstValue = value))
                if (value.isNotEmpty()) {
                    secondFocus.requestFocus()
                } else if (value.isEmpty()) {
                    firstFocus.requestFocus()
                }
            },
            shape = MaterialTheme.shapes.medium,
            keyboardOptions = keyboardOptions,
            textStyle = smsTextStyle,
            colors = textFieldColors()
        )

        OutlinedTextField(
            modifier = modifier
                .requiredWidth(48.dp)
                .focusRequester(secondFocus),
            singleLine = true,
            value = enterCodeState.secondValue,
            onValueChange = { value ->
                onStateChanged(enterCodeState.copy(secondValue = value))
                if (value.isNotEmpty()) {
                    thirdFocus.requestFocus()
                } else if (value.isEmpty()) {
                    firstFocus.requestFocus()
                }
            },
            shape = MaterialTheme.shapes.medium,
            keyboardOptions = keyboardOptions,
            textStyle = smsTextStyle,
            colors = textFieldColors()
        )

        OutlinedTextField(
            modifier = modifier
                .requiredWidth(48.dp)
                .focusRequester(thirdFocus),
            singleLine = true,
            value = enterCodeState.thirdValue,
            onValueChange = { value ->
                onStateChanged(enterCodeState.copy(thirdValue = value))
                if (value.isNotEmpty()) {
                    fourthFocus.requestFocus()
                } else if (value.isEmpty()) {
                    secondFocus.requestFocus()
                }
            },
            shape = MaterialTheme.shapes.medium,
            keyboardOptions = keyboardOptions,
            textStyle = smsTextStyle,
            colors = textFieldColors()
        )

        OutlinedTextField(
            modifier = modifier
                .requiredWidth(48.dp)
                .focusRequester(fourthFocus),
            singleLine = true,
            value = enterCodeState.fourthValue,
            onValueChange = { value ->
                onStateChanged(enterCodeState.copy(fourthValue = value))
                if (value.isNotEmpty()) {
                    keyboardController?.hide()
                } else if (value.isEmpty()) {
                    thirdFocus.requestFocus()
                }
            },
            shape = MaterialTheme.shapes.medium,
            textStyle = smsTextStyle,
            colors = textFieldColors(),
            keyboardOptions = keyboardOptions.copy(imeAction = ImeAction.Done)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SmsCodeInputPreview() {
    GoodbyeViewsTheme {
        SmsCodeInput(
            EnterCodeState("1", "2", "3", "4"),
            { }
        )
    }
}