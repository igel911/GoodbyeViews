package com.example.goodbyeviews.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SmsCodeInput() {
    var valueFirst by remember { mutableStateOf("") }
    var valueSecond by remember { mutableStateOf("") }
    var valueThird by remember { mutableStateOf("") }
    var valueFourth by remember { mutableStateOf("") }
    val (secondFocus, thirdFocus, fourthFocus) = remember {
        FocusRequester.createRefs()
    }

    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            val keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
            val colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Gray
            )

            OutlinedTextField(
                modifier = Modifier.requiredWidth(48.dp),
                singleLine = true,
                value = valueFirst,
                onValueChange = { value ->
                    valueFirst = value
                    if (value.length == 1) {
                        secondFocus.requestFocus()
                    }
                },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = keyboardOptions,
                textStyle = TextStyle(textAlign = TextAlign.Center),
                colors = colors
            )

            OutlinedTextField(
                modifier = Modifier
                    .requiredWidth(48.dp)
                    .focusRequester(secondFocus),
                singleLine = true,
                value = valueSecond,
                onValueChange = { value ->
                    valueSecond = value
                    if (value.length == 1) {
                        thirdFocus.requestFocus()
                    }
                },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = keyboardOptions,
                textStyle = TextStyle(textAlign = TextAlign.Center),
                colors = colors
            )

            OutlinedTextField(
                modifier = Modifier
                    .requiredWidth(48.dp)
                    .focusRequester(thirdFocus),
                singleLine = true,
                value = valueThird,
                onValueChange = { value ->
                    valueThird = value
                    if (value.length == 1) {
                        fourthFocus.requestFocus()
                    }
                },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = keyboardOptions,
                textStyle = TextStyle(textAlign = TextAlign.Center),
                colors = colors
            )

            OutlinedTextField(
                modifier = Modifier
                    .requiredWidth(48.dp)
                    .focusRequester(fourthFocus),
                singleLine = true,
                value = valueFourth,
                onValueChange = { value ->
                    valueFourth = value
                },
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(textAlign = TextAlign.Center),
                colors = colors,
                keyboardOptions = keyboardOptions.copy(imeAction = ImeAction.Done)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SmsCodeInputPreview() {
    GoodbyeViewsTheme {
        SmsCodeInput()
    }
}