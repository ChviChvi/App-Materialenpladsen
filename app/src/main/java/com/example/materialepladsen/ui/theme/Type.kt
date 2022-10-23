package com.example.materialepladsen.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.materialepladsen.R


val Inter= FontFamily(
    Font(R.font.inter_bold,FontWeight.Bold),
    Font(R.font.inter_medium)
)
// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h2=TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h3=TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    h4=TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h5=TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Thin,
        fontSize = 16.sp
    ),
    h6=TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    caption  =TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Thin,
        fontSize = 12.sp
    ),
    body1  =TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Thin,
        fontSize = 12.sp
    ),
    body2 = TextStyle (
        fontFamily = Inter,
        fontWeight = FontWeight.Bold
    ),
    subtitle1 = TextStyle (
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),
    subtitle2 = TextStyle (
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle (
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)