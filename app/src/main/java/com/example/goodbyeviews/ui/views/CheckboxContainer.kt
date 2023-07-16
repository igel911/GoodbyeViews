package com.example.goodbyeviews.ui.views

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme

@Composable
fun CheckboxContainer(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    onCheckedChange: ((Boolean) -> Unit) = {},
    enabled: Boolean = true,
    colors: CheckboxColors = CheckboxDefaults.colors(),
    content: @Composable () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = modifier,
            enabled = enabled,
            colors = colors
        )

        content()
    }
}

@Preview(showBackground = true)
@Composable
fun CheckboxContainerPreview() {
    GoodbyeViewsTheme {
        CheckboxContainer(
            content = { Text(text = "bla-bla-bla") }
        )
    }
}