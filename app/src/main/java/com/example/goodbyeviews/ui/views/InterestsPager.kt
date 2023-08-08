package com.example.goodbyeviews.ui.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.views.interests.InterestPageFirst
import com.example.goodbyeviews.ui.views.interests.InterestPageSecond
import com.example.goodbyeviews.ui.views.interests.InterestPageThird
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InterestsPager(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        val pageCount = 3
        val pagerState = rememberPagerState { pageCount }
        val coroutineScope = rememberCoroutineScope()

        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F),
            state = pagerState
        ) { page ->
            when (page) {
                0 -> {
                    InterestPageFirst(modifier = Modifier.fillMaxSize())
                }
                1 -> {
                    InterestPageSecond(modifier = Modifier.fillMaxSize())
                }
                else -> {
                    InterestPageThird(modifier = Modifier.fillMaxSize())
                }
            }
        }

        HorizontalSpacer()

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.Blue else Color.LightGray
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color)
                        .size(12.dp)
                        .clickable {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(iteration)
                            }

                        }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InterestsPagerPreview() {
    GoodbyeViewsTheme {
        InterestsPager()
    }
}