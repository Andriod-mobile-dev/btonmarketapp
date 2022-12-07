package com.example.btonmarket.feature_btonmarket.presentation.itemDetailView

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btonmarket.feature_btonmarket.domain.model.CategoryViewModel
import com.example.btonmarket.feature_btonmarket.domain.model.ItemDetailViewModel
import com.example.btonmarket.feature_btonmarket.presentation.categoriesDetail.CategoryItems
import com.example.btonmarket.feature_btonmarket.presentation.sell.pageTitle

@Composable
fun ItemDetailScreenUI(itemDetailVM: ItemDetailViewModel){
    LaunchedEffect(key1 = Unit, block = {
        Log.d("on search item", "1")
        itemDetailVM.getitemDetailInfo(1)
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
                pageTitle(title = "Lamp")
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