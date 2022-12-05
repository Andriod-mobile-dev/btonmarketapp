package com.example.btonmarket.feature_btonmarket.presentation.categoriesDetail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btonmarket.feature_btonmarket.domain.model.CategoryViewModel
import com.example.btonmarket.feature_btonmarket.domain.model.SearchItemsViewModel
import com.example.btonmarket.feature_btonmarket.presentation.buy.components.BuyCardView
import com.example.btonmarket.feature_btonmarket.presentation.sell.pageTitle

@Composable
fun CategoriesDetailScreenUI(categoryVm: CategoryViewModel, categorypath:String){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                pageTitle(title = categorypath)
            }
            Row{
                CategoryItems(categoryVm, categorypath)
            }
        }
    }
}

@Composable
fun CategoryItems(categoryVm: CategoryViewModel, categorypath: String){
    LaunchedEffect(key1 = Unit, block = {
        Log.d("category path", categorypath)
        categoryVm.searchItems(categorypath)
    })

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 0.dp, 0.dp, 60.dp)
    ) {
        if (categoryVm.errorMessage.isEmpty()) {
            items(categoryVm.searchedSellItemsList) { onSellItems ->
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
                        category = onSellItems.categories,
                        imgUrl = onSellItems.img,
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun CategoriesScreenPreview(){
    //CategoriesDetailScreenUI()
}