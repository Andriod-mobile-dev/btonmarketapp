package com.example.btonmarket.feature_btonmarket.presentation.buy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.btonmarket.feature_btonmarket.presentation.buy.components.BuyCardView


@Composable
fun BuyScreen(){
    BuyCardView(
        itemName = "Car",
        price = 3000f,
        sold = true,
        seller = "Tesfatsion",
        negotiable = false,
        condition = "Very good"
    )
}



@Composable
@Preview
fun BuyScreenPreview(){
    BuyScreen()
}