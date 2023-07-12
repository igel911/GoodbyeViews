package com.example.goodbyeviews.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun LoginVariants() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.buttongoogle),
                contentDescription = stringResource(R.string.google)
            )

            Image(
                painter = painterResource(id = R.drawable.buttonapple),
                contentDescription = stringResource(R.string.apple)
            )

            Image(
                painter = painterResource(id = R.drawable.buttonfacebook),
                contentDescription = stringResource(R.string.facebook)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginVariantsPreview() {
    GoodbyeViewsTheme {
        LoginVariants()
    }
}