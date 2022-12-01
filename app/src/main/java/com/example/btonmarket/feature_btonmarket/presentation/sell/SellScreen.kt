package com.example.btonmarket.feature_btonmarket.presentation.sell

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SellScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ){
        sell()
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
fun sell(){
    var name by remember {
        mutableStateOf("")
    }
    var seller by remember {
        mutableStateOf("")
    }
    var condition by remember {
        mutableStateOf("")
    }
    var price by remember {
        mutableStateOf(0.0)
    }
    var negotiable by remember {
        mutableStateOf(false)
    }
    // boolean sold: not needed here
    var img by remember {
        mutableStateOf("")
    }
}

@Composable
@Preview
fun SellScreenPreview(){
    SellScreen()
}