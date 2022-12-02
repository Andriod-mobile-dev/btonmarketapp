package com.example.btonmarket.feature_btonmarket.presentation.sell

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.btonmarket.feature_btonmarket.data.data_source.remote.onSellItem
import com.example.btonmarket.feature_btonmarket.domain.model.SellViewModel


@Composable
fun SellScreen(sellVm: SellViewModel){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        sell(sellVm)
    }
}

@Composable
fun sell(sellVm: SellViewModel){
    var name by remember {
        mutableStateOf("Injera test")
    }
    var seller by remember {
        mutableStateOf("Zemeta")
    }
    var condition by remember {
        mutableStateOf("Excellent")
    }
    var price by remember {
        mutableStateOf(10f)
    }
    var negotiable by remember {
        mutableStateOf(false)
    }
    // boolean sold: not needed here
    val sold by remember {
        mutableStateOf(false)
    }
    var img by remember {
        mutableStateOf("https://cdn.shopify.com/s/files/1/0148/1945/9126/articles/Injera_720x.jpg?v=1589810405")
    }
    var sending by remember {
        mutableStateOf(false)
    }
    // state to call the suspend function
    if (sending){
        Log.d("Debug Tesfa", "Launching effect")
        LaunchedEffect(key1 = Unit, block = {
            //Todo: view model call goes here
            sellVm.postSellItem(onSellItem(100,name, seller, condition, price, negotiable,sold, img))
        })
        sending = false // todo: not sure about this
    }

    Button(onClick = {
        sending=true
    }) {
        Text(text = "Put on sell")
    }
}


@Composable
@Preview
fun SellScreenPreview(){
    //SellScreen()
}