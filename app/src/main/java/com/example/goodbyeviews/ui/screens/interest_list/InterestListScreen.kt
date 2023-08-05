package com.example.goodbyeviews.ui.screens.interest_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.views.ButtonWithTitle
import com.example.goodbyeviews.ui.views.HorizontalProgressIndicator
import com.example.goodbyeviews.ui.views.HorizontalSpacer
import com.example.goodbyeviews.ui.views.InterestList
import com.example.goodbyeviews.ui.views.Title

@Composable
fun InterestListScreen() {
    val viewModel: InterestListViewModel = viewModel()
    val interests by viewModel.itemsState.collectAsState()
    val progress by viewModel.progressState.collectAsState()
    val buttonNextEnabled by viewModel.buttonState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        HorizontalSpacer()

        HorizontalProgressIndicator(
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        HorizontalSpacer()

        Title(
            modifier = Modifier.align(Alignment.Start),
            textId = R.string.personalise_title,
            textStyle = GoodbyeViewsTheme.typography.h1
        )

        HorizontalSpacer(16)

        Title(
            modifier = Modifier.align(Alignment.Start),
            textId = R.string.personalise_text,
            textStyle = GoodbyeViewsTheme.typography.bodyL
        )

        HorizontalSpacer()

        InterestList(
            interests = interests,
            onInterestSelected = viewModel::onInterestSelected,
            modifier = Modifier.weight(1F)
        )

        ButtonWithTitle(
            modifier = Modifier.fillMaxWidth(),
            text = R.string.next,
            isButtonEnabled = buttonNextEnabled,
            onClick = { }
        )

        HorizontalSpacer(16)
    }
}

@Preview(showBackground = true)
@Composable
fun InterestListScreenPreview() {
    GoodbyeViewsTheme {
        InterestListScreen()
    }
}