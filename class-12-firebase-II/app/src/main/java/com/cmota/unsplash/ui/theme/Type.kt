package com.cmota.unsplash.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cmota.unsplash.R

private val IndianaJonesFontFamily = FontFamily(
  Font(R.font.adventure_regular, FontWeight.Normal),
)

val bigFontSize = 19.sp
val defaultFontSize = 15.sp
val smallFontSize = 12.sp

// Set of Material typography styles to start with
val Typography = Typography(
  titleLarge = TextStyle(
    fontFamily = IndianaJonesFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = bigFontSize
  ),

  bodyLarge = TextStyle(
    fontFamily = IndianaJonesFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = defaultFontSize,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  ),

  labelSmall = TextStyle(
    fontFamily = IndianaJonesFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = smallFontSize,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
  )
  /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)