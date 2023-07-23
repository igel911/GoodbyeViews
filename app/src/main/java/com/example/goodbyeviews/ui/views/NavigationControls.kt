package com.example.goodbyeviews.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.R
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun NavigationControls(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
    navigateForward: () -> Unit,
    isButtonNextEnabled: Boolean = true
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ImageButton(
            modifier = Modifier.size(height = 40.dp, width = 70.dp),
            icon = Icons.Filled.ArrowBack,
            onClick = { navigateBack() }
        )

        ButtonWithTitle(
            modifier = Modifier.height(40.dp).weight(1F),
            text = R.string.continue_title,
            isButtonEnabled = isButtonNextEnabled,
            onClick = { navigateForward() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationControlsPreview() {
    GoodbyeViewsTheme {
        NavigationControls(
            navigateBack = {},
            navigateForward = {}
        )
    }
}