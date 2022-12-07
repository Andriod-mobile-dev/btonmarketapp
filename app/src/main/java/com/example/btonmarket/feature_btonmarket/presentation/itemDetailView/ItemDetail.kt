package com.example.btonmarket.feature_btonmarket.presentation.itemDetailView

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btonmarket.feature_btonmarket.data.data_source.remote.onSellItem
import com.example.btonmarket.feature_btonmarket.domain.model.CategoryViewModel
import com.example.btonmarket.feature_btonmarket.domain.model.ItemDetailViewModel
import com.example.btonmarket.feature_btonmarket.presentation.buy.components.BuyCardView
import com.example.btonmarket.feature_btonmarket.presentation.categoriesDetail.CategoryItems
import com.example.btonmarket.feature_btonmarket.presentation.sell.pageTitle

@Composable
fun ItemDetailScreenUI(itemId: Int, itemDetailVM: ItemDetailViewModel){
    LaunchedEffect(key1 = Unit, block = {
        Log.d("on search item", itemId.toString())
        itemDetailVM.getitemDetailInfo(itemId)
    })
    Log.d("item detail", itemDetailVM.itemDetail.size.toString())
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp, 0.dp, 0.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                if (itemDetailVM.errorMessage.isEmpty()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 60.dp)
                    ) {
                        items(itemDetailVM.itemDetail) { it ->
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                pageTitle(title = it.name)
                            }
                        }
                    }
                }
            }
            Row{
                //Todo: other details can go here
            }
        }
    }
}

@Composable
@Preview
fun ItemDetailScreenUIPreview(){
    //ItemDetailScreenUI()
}