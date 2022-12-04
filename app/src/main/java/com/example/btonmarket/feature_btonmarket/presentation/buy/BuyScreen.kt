package com.example.btonmarket.feature_btonmarket.presentation.buy

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btonmarket.feature_btonmarket.domain.model.OnSellViewModel
import com.example.btonmarket.feature_btonmarket.domain.model.SearchItemsViewModel
import com.example.btonmarket.feature_btonmarket.presentation.buy.components.BuyCardView
import com.example.btonmarket.feature_btonmarket.presentation.buy.components.SearchView


@Composable
fun BuyScreen(onSellVm: OnSellViewModel,searchVm:SearchItemsViewModel){
    // Test input here
    LaunchedEffect(key1 = Unit, block = {
        onSellVm.getOnSellItemsList()
    })

    Log.d("Buy Items: ", onSellVm.onSellItemsList.size.toString())
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Log.d("Search input text", textState.value.text)
    val search =  remember {
        mutableStateOf(false)
    }
    Column {
        Row {
            SearchView(textState, searchVm, search)
        }
        if (onSellVm.errorMessage.isEmpty() || searchVm.errorMessage.isEmpty()) {
            Row {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 60.dp)
                ) {
                    if (textState.value.text.isNotEmpty()) {
                        items(searchVm.searchedSellItemsList) { onSellItems ->
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
                                    condition = onSellItems.condition,
                                    imgUrl = onSellItems.img,
                                )
                            }
                        }
                    } else if (textState.value.text.isEmpty()) {
                        items(onSellVm.onSellItemsList) { onSellItems ->
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
                                    condition = onSellItems.condition,
                                    imgUrl = onSellItems.img,
                                )
                            }
                        }
                    }
                }
            }
        } else {
            Text(text = onSellVm.errorMessage + searchVm.errorMessage)
        }
    }

}



@Composable
@Preview
fun BuyScreenPreview(){
    //BuyScreen()
}