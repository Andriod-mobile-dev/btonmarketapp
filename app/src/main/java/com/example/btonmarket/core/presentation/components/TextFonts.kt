package com.example.btonmarket.core.presentation.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun DetailLabel(text: String, align: TextAlign){
    Text(
        text = text,
        fontSize = 20.sp,
        fontFamily = FontFamily.Serif,
        textAlign = align
    )
}

@Composable
fun DetailSuccess(text: String, align: TextAlign){
    Text(
        text = text,
        fontSize = 20.sp,
        fontFamily = FontFamily.Serif,
        textAlign = align,
        color = Color.Blue
    )
}

@Composable
fun DetailWarning(text: String, align: TextAlign){
    Text(
        text = text,
        fontSize = 20.sp,
        fontFamily = FontFamily.Serif,
        textAlign = align,
        color = Color.Red
    )
}

@Composable
fun DetailItem(text: String, align: TextAlign){
    Text(
        text=text,
        fontSize = 15.sp,
        textAlign = align
    )
}