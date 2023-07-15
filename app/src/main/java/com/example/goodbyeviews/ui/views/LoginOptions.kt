package com.example.goodbyeviews.ui.views

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme


@Composable
fun LoginOptions() {
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }

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
            value = emailValue,
            onValueChange = { newText ->
                emailValue = newText
            },
            placeholderText = R.string.email
        )

        HorizontalSpacer()

        OutlinedPasswordInput(
            modifier = Modifier.fillMaxWidth(),
            value = passwordValue,
            onValueChange = { newText ->
                passwordValue = newText
            },
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
            onClick = { }
        )

        HorizontalSpacer()

        TextWithClickablePart(
            modifier = Modifier.fillMaxWidth(),
            regularText = R.string.not_a_member,
            clickableText = R.string.register_now,
            onClick = { text -> Log.d("taggg", "clickedText = $text") }
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
        LoginOptions()
    }
}