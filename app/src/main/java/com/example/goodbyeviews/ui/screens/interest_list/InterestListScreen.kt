package com.example.goodbyeviews.ui.screens.interest_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.views.ButtonWithTitle
import com.example.goodbyeviews.ui.views.HorizontalSpacer
import com.example.goodbyeviews.ui.views.Title

@Composable
fun InterestListScreen() {
    val viewModel: InterestListViewModel = viewModel()
    val interests = viewModel.itemsState.collectAsState()
    val progress = viewModel.progressState.collectAsState(0.0F)
    val buttonNextEnabled = viewModel.buttonState.collectAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        HorizontalSpacer()

        LinearProgressIndicator(
            progress = progress.value,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(8.dp)),
            trackColor = GoodbyeViewsTheme.colors.neutralLight.darkest,
            color = GoodbyeViewsTheme.colors.highlight.darkest
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

        LazyColumn(
            modifier = Modifier.weight(1F),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            itemsIndexed(interests.value) { _, item ->
                InterestItemView(item = item, onClick = viewModel::onInterestSelected)
            }
        }

        ButtonWithTitle(
            modifier = Modifier.fillMaxWidth(),
            text = R.string.next,
            isButtonEnabled = buttonNextEnabled.value,
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