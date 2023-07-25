package com.example.goodbyeviews.ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goodbyeviews.ui.theme.GoodbyeViewsTheme
import com.example.goodbyeviews.ui.theme.buttonBackColors
import com.example.goodbyeviews.ui.theme.buttonElevation

@Composable
fun ImageButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    colors: ButtonColors = buttonBackColors(),
    onClick: () -> Unit = { }
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        border = BorderStroke(1.dp, Color.Blue),
        elevation = buttonElevation(),
        colors = colors,
        shape = RoundedCornerShape(10.dp)
    ) {
        Icon(
            modifier = Modifier.size(ButtonDefaults.IconSize),
            imageVector = icon,
            contentDescription = "contentDescription",
            tint = Color.Blue
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ImageButtonPreview() {
    GoodbyeViewsTheme {
        ImageButton(
            icon = Icons.Filled.ArrowBack
        )
    }
}