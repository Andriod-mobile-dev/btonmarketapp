package com.example.btonmarket.feature_btonmarket.presentation.itemDetailView

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btonmarket.core.presentation.components.*
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
                                Row{
                                    pageTitle(title = it.name)
                                    if(it.sold){
                                        Text(text = "sold",color= Color.Red, modifier = Modifier
                                            .border(BorderStroke(1.dp, Color.Red))
                                            .padding(4.dp, 0.dp))
                                    }
                                    else{
                                        Text(text = "onsell", color=Color.Blue, modifier = Modifier
                                            .border(BorderStroke(0.4.dp, Color.Blue))
                                            .padding(4.dp, 0.dp))
                                    }
                                }
                                BigImageField(url = it.img)
                                ItemDetailInfo(price = it.price, negotiable = it.negotiable)
                                getItemButton()

                                //ImageThumbnailFromURL(url = "https://media.istockphoto.com/id/1150425295/photo/3d-illustration-of-generic-hatchback-car-perspective-view.jpg?s=612x612&w=0&k=20&c=vws8oDFjcfGpqNAybWPxsA9XROdcBh2MXW2PGEDgk-8=")
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
fun ItemDetailInfo(price:Float, negotiable: Boolean){
    Row{
        //DetailLabel(text = "Price: ", align = TextAlign.Start)
        DetailLabel(text = "$ ${price.toString()},  ", align = TextAlign.End)
        if(negotiable){
            DetailSuccess(text = "Negotiable", align = TextAlign.End)
        }else{
            DetailWarning(text = "Non-Negotiable", align = TextAlign.End)
        }
    }
    
    GetItemBigButton(name = "GET ITEM")
}

@Composable
fun getItemButton(){

}


@Composable
fun ItemDetasilInfo() {
    var list = listOf<onSellItem>(
        onSellItem(
            2,
            "Sell name",
            "Tes",
            "great",
            2.3f,
            false,
            false,
            "category",
            "https://images.pexels.com/photos/170811/pexels-photo-170811.jpeg?cs=srgb&dl=pexels-mike-b-170811.jpg&fm=jpg"
        )
    )
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
            if (true) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 60.dp)
                ) {
                    items(list) { it ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            pageTitle(title = it.name)
                            ImageThumbnailFromURL(url = "https://media.istockphoto.com/id/1150425295/photo/3d-illustration-of-generic-hatchback-car-perspective-view.jpg?s=612x612&w=0&k=20&c=vws8oDFjcfGpqNAybWPxsA9XROdcBh2MXW2PGEDgk-8=")
                        }
                    }
                }
            }
        }
        Row {
            //Todo: other details can go here
        }
    }
}

@Composable
@Preview
fun ItemDetailScreenUIPreview(){
    //ItemDetailInfo()
    //ItemDetailScreenUI()
}