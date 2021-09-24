package com.plcoding.cryptocurrencyappyt.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = com.mhd.cryptocurrencylist.presentation.ui.theme.ColorPrimary,
    background = com.mhd.cryptocurrencylist.presentation.ui.theme.DarkGray,
    onBackground = com.mhd.cryptocurrencylist.presentation.ui.theme.TextWhite,
    onPrimary = com.mhd.cryptocurrencylist.presentation.ui.theme.DarkGray
)

private val LightColorPalette = lightColors(
    primary = com.mhd.cryptocurrencylist.presentation.ui.theme.ColorPrimary,
    background = Color.White,
    onBackground = com.mhd.cryptocurrencylist.presentation.ui.theme.MediumGray,
    onPrimary = com.mhd.cryptocurrencylist.presentation.ui.theme.DarkGray
)

@Composable
fun CryptocurrencyAppYTTheme(darkTheme: Boolean = true, content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = com.mhd.cryptocurrencylist.presentation.ui.theme.Typography,
        shapes = com.mhd.cryptocurrencylist.presentation.ui.theme.Shapes,
        content = content
    )
}