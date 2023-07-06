package com.example.goodbyeviews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)) {
            Text(modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center,
                text = "Here should be a picture but I messed up :("
            )
        }
        LoginOptions()
        /*Text(modifier = Modifier.fillMaxWidth().weight(1.0f),
            text = "There"
        )*/
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    GoodbyeViewsTheme {
        MainScreen()
    }
}