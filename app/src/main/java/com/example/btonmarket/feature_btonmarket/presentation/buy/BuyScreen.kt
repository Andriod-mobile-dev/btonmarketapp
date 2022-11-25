package com.example.btonmarket.feature_btonmarket.presentation.buy

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.btonmarket.feature_btonmarket.domain.model.OnSellItemsViewModel
import com.example.btonmarket.feature_btonmarket.presentation.buy.components.BuyCardView


@Composable
fun BuyScreen(OnSellItemsVm: OnSellItemsViewModel){
    // Lazy column goes here
    // make sure to put the card at the center of the screen horizontally

    LaunchedEffect(key1 = Unit, block = {
        OnSellItemsVm.getOnSellItems()
    })

    //Log.d("Tesfa", OnSellItemsVm.onSellItemsList.toString())

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BuyCardView(
            itemName = "Some",
            price = 3000f,
            sold = true,
            seller = "Tesfatsion",
            negotiable = false,
            condition = "Very good"
        )
    }

}



@Composable
@Preview
fun BuyScreenPreview(){
    //BuyScreen(OnSellItemsVm: OnSellItemsViewModel)
}