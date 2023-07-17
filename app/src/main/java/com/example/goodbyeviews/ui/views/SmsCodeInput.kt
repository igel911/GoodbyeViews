package com.example.goodbyeviews.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun SmsCodeInput() {
    var valueFirst by remember { mutableStateOf("") }
    var valueSecond by remember { mutableStateOf("") }
    var valueThird by remember { mutableStateOf("") }
    var valueFourth by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            val keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
            OutlinedTextInput(
                modifier = Modifier.requiredWidth(48.dp),
                value = valueFirst,
                onValueChange = { value ->
                    valueFirst = value
                    if (value.length == 1) {
                        //onNextAction()
                    }
                },
                keyboardOptions = keyboardOptions,
                textStyle = TextStyle(textAlign = TextAlign.Center)
            )

            OutlinedTextInput(
                modifier = Modifier.requiredWidth(48.dp),
                value = valueSecond,
                onValueChange = { value -> valueSecond = value },
                keyboardOptions = keyboardOptions
            )

            OutlinedTextInput(
                modifier = Modifier.requiredWidth(48.dp),
                value = valueThird,
                onValueChange = { value -> valueThird = value },
                keyboardOptions = keyboardOptions
            )

            OutlinedTextInput(
                modifier = Modifier.requiredWidth(48.dp),
                value = valueFourth,
                onValueChange = { value -> valueFourth = value },
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