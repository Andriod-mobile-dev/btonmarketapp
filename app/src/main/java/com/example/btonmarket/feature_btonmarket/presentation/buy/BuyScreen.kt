package com.example.btonmarket.feature_btonmarket.presentation.buy

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.btonmarket.feature_btonmarket.presentation.buy.components.BuyCardView


@Composable
fun BuyScreen(){
    // Lazy column goes here
    // make sure to put the card at the center of the screen horizontally
    BuyCardView(
        itemName = "Some",
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