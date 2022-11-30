package com.example.btonmarket.feature_btonmarket.presentation.buy

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btonmarket.feature_btonmarket.domain.model.OnSellViewModel
import com.example.btonmarket.feature_btonmarket.presentation.buy.components.BuyCardView


@Composable
fun BuyScreen(onSellVm: OnSellViewModel){
    // Test input here
    LaunchedEffect(key1 = Unit, block = {
        onSellVm.getOnSellItemsList()
    })

    Log.d("Buy Items: ", onSellVm.onSellItemsList.size.toString())

    if(onSellVm.errorMessage.isEmpty()){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp,0.dp,0.dp, 60.dp)
        ){
            items(onSellVm.onSellItemsList){ onSellItems ->
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
        Text(text = onSellVm.errorMessage)
    }

}



@Composable
@Preview
fun BuyScreenPreview(){
    //BuyScreen()
}