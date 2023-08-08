package com.example.goodbyeviews.ui.screens.paging

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.views.ButtonWithTitle
import com.example.goodbyeviews.ui.views.HorizontalSpacer
import com.example.goodbyeviews.ui.views.InterestsPager
import com.example.goodbyeviews.ui.views.Title

@Composable
fun InterestPagingScreen() {
    val viewModel = viewModel { InterestPagingViewModel() }

    Column(Modifier.fillMaxSize()) {

        InterestsPager(modifier = Modifier
            .fillMaxWidth()
            .weight(1F))

        HorizontalSpacer()

        Title(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 16.dp),
            textId = R.string.create_prototype_title,
            textStyle = GoodbyeViewsTheme.typography.h2
        )

        HorizontalSpacer()

        Title(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 16.dp),
            textId = R.string.create_prototype_text,
            textStyle = GoodbyeViewsTheme.typography.bodyM
        )

        HorizontalSpacer()

        ButtonWithTitle(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = R.string.next,
            onClick = viewModel::navigateToInterestsScreen
        )

        HorizontalSpacer()
    }
}

@Preview(showBackground = true)
@Composable
fun InterestPagingScreenPreview() {
    GoodbyeViewsTheme {
        InterestPagingScreen()
    }
}