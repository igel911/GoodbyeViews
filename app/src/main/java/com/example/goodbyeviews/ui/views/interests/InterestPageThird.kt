package com.example.goodbyeviews.ui.views.interests

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun InterestPageThird(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painterResource(R.drawable.face_with_tongue),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.align(Alignment.Center).size(300.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InterestPageThirdPreview() {
    GoodbyeViewsTheme {
        InterestPageThird()
    }
}