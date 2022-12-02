package com.example.btonmarket.feature_btonmarket.presentation.sell

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.btonmarket.feature_btonmarket.data.data_source.remote.onSellItem
import com.example.btonmarket.feature_btonmarket.domain.model.SellViewModel


@Composable
fun SellScreen(sellVm: SellViewModel){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ){
        sell(sellVm)
//        Text(
//            text = "Sell",
//            fontSize = MaterialTheme.typography.h3.fontSize,
//            fontWeight = FontWeight.Bold,
//            color = Color.Gray
//        )
    }
}
//var id: Int,
//var name: String,
//var seller: String,
//var condition: String,
//var price : Float, // may be wrong
//var negotiable : Boolean,
//var sold: Boolean,
//var img: String,
@Composable
fun sell(sellVm: SellViewModel){
    var name by remember {
        mutableStateOf("Jebena")
    }
    var seller by remember {
        mutableStateOf("Merry")
    }
    var condition by remember {
        mutableStateOf("Good")
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
        mutableStateOf("http://static1.squarespace.com/static/5cccefb965a707021ea7c5e0/5ce8b9f4fa0d602415d5bc74/5eddda3adf6d132badf4d5f5/1607903256113/?format=1500w")
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