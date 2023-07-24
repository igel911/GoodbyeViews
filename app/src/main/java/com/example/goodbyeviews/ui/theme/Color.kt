package com.example.goodbyeviews.ui.theme

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val HighlightDarkest = Color(0xFF006FFD)
val HighlightDark = Color(0xFF2897FF)
val HighlightMedium = Color(0xFF6FBAFF)
val HighlightLight = Color(0xFFB4DBFF)
val HighlightLightest = Color(0xFFEAF2FF)

val NeutralLightDarkest = Color(0xFFC5C6CC)
val NeutralLightDark = Color(0xFFD4D6DD)
val NeutralLightMedium = Color(0xFFE8E9F1)
val NeutralLightLight = Color(0xFFF8F9FE)
val NeutralLightLightest = Color(0xFFFFFFFF)

val NeutralDarkDarkest = Color(0xFF1F2024)
val NeutralDarkDark = Color(0xFF2F3036)
val NeutralDarkMedium = Color(0xFF494A50)
val NeutralDarkLight = Color(0xFF71727A)
val NeutralDarkLightest = Color(0xFF8F9098)

val SuccessDark = Color(0xFF298267)
val SuccessMedium = Color(0xFF3AC0A0)
val SuccessLight = Color(0xFFE7F4E8)

val WarningDark = Color(0xFFE86339)
val WarningMedium = Color(0xFFFFB37C)
val WarningLight = Color(0xFFFFF4E4)

val ErrorDark = Color(0xFFED3241)
val ErrorMedium = Color(0xFFFF616D)
val ErrorLight = Color(0xFFFFE2E5)

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textFieldColors() = TextFieldDefaults.outlinedTextFieldColors(
    focusedBorderColor = Color.Blue,
    unfocusedBorderColor = Color.Gray
)