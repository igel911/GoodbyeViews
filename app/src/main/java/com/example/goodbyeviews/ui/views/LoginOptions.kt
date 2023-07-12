package com.example.goodbyeviews.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme


@Composable
fun LoginOptions() {
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues(start = 16.dp, end = 16.dp))
    ) {
        HorizontalSpacer()

        TextLabel(
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
            showPassword = showPassword,
            placeholderText = R.string.password,
            onIconClick = { showPassword = !showPassword }
        )

        HorizontalSpacer()

        TextLabel(
            textId = R.string.forgot_password,
            fontWeight = FontWeight.Bold,
            textColor = Color.Blue
        )

        HorizontalSpacer()

        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = CutCornerShape(10),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            ),
            onClick = { }) {
            Text(text = stringResource(R.string.login))
        }

        HorizontalSpacer()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextLabel(
                textId = R.string.not_a_member,
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextLabel(
                textId = R.string.register_now,
                fontWeight = FontWeight.Bold,
                textColor = Color.Blue
            )
        }

        HorizontalDivider()

        TextLabel(
            modifier = Modifier.fillMaxWidth(),
            textId = R.string.continue_with
        )

        HorizontalSpacer()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.buttongoogle),
                contentDescription = stringResource(R.string.google)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.buttonapple),
                contentDescription = stringResource(R.string.apple)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.buttonfacebook),
                contentDescription = stringResource(R.string.facebook)
            )

        }

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