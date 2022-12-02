package com.example.btonmarket.feature_btonmarket.presentation.sell

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.btonmarket.feature_btonmarket.data.data_source.remote.sellItem
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
        mutableStateOf("Beyaynet")
    }
    var seller by remember {
        mutableStateOf("Abysinia")
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
        mutableStateOf("https://mediaim.expedia.com/localexpert/2151202/1cc000c0-2eb2-4511-89e4-a117f6656f64.jpg")
    }
    var sending by remember {
        mutableStateOf(false)
    }
    // state to call the suspend function
    if (sending){
        Log.d("Debug Tesfa", "Launching effect")
        LaunchedEffect(key1 = Unit, block = {
            //Todo: view model call goes here
            sellVm.postSellItem(sellItem(name, seller, condition, price, negotiable,sold, img))
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