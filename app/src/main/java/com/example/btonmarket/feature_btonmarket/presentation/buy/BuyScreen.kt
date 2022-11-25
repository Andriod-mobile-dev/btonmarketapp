package com.example.btonmarket.feature_btonmarket.presentation.buy

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.btonmarket.feature_btonmarket.data.data_source.remote.OnSellItems
import com.example.btonmarket.feature_btonmarket.domain.model.OnSellItemsViewModel
import com.example.btonmarket.feature_btonmarket.presentation.buy.components.BuyCardView


@Composable
fun BuyScreen(OnSellItemsVm: OnSellItemsViewModel){
    // Lazy column goes here
    // make sure to put the card at the center of the screen horizontally

    LaunchedEffect(key1 = Unit, block = {
        OnSellItemsVm.getOnSellItems()
    })

    Log.d("onSellItem", OnSellItemsVm.onSellItemsList.toString())

//    Column(
//        modifier = Modifier
//            .fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        BuyCardView(
//            itemName = "Some",
//            price = 3000f,
//            sold = true,
//            seller = "Tesfatsion",
//            negotiable = false,
//            condition = "Very good"
//        )
//    }

    if(OnSellItemsVm.errorMessage.isEmpty()){
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(OnSellItemsVm.onSellItemsList){ onSellItems ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BuyCardView(
                        itemName = onSellItems.name,
                        price = onSellItems.price,
                        sold = onSellItems.sold,
                        seller = onSellItems.seller,
                        negotiable = onSellItems.negotiable,
                        condition = onSellItems.condition
                    )
                }
            }
        }
    }else{
        Text(text = OnSellItemsVm.errorMessage)
    }

}



@Composable
@Preview
fun BuyScreenPreview(){
    //BuyScreen(OnSellItemsVm: OnSellItemsViewModel)
}