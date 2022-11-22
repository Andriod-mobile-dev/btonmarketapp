package com.example.btonmarket.feature_btonmarket.presentation.buy.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

import com.example.btonmarket.R

@Composable
fun BuyCardView(itemName: String,
             price: Float,
             sold: Boolean,
             seller: String,
             negotiable: Boolean,
             condition: String,
) {
    Card(
        modifier = Modifier
            //.fillMaxWidth()
            .width(340.dp)
            .padding(10.dp)
            .clickable { },
        elevation = 10.dp
    ) {

        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
            ,
            //horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row( modifier = Modifier.fillMaxWidth()){
                OnSaleItemImage()
                //Text(text = "Image Goes here")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                //Text(text = "Hey")
                ItemDetailColumn(itemName, price, negotiable)
                SellerDetailColumn(seller)
            }

        }
    }
}

@Composable
fun ItemDetailColumn(itemName: String, price: Float, negotiable: Boolean){
    Column() {
        Text(
            buildAnnotatedString {
                //append("Item name: ")
                withStyle(
                    style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                ) {
                    append(itemName)
                }
            }
        )
        Text(
            buildAnnotatedString {

                withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                    append(price.toString())
                }
                append(" USD")
            }
        )

        if (negotiable) {
            //append("Negotiable")
            //Text(text = "Negotiable", color = Color.Green)
            Text(
                buildAnnotatedString {
                    //append("Seller: ")
                    withStyle(
                        style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
                    ) {
                        append("Negotiable")
                    }
                }
            )
        } else {
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(fontWeight = FontWeight.SemiBold, color = Color.LightGray)
                    ) {
                        append("Non-negotiable")
                    }
                }
            )
        }
    }
}

@Composable
fun SellerDetailColumn(seller: String){
    Column() {
        Text(
            buildAnnotatedString {
                //append("Seller: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                ) {
                    append(seller)
                }
            }
        )
    }
}

@Composable
fun OnSaleItemImage(){
    // resourceimageID: R.id
    Column(
        modifier= Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "On sell item",
            modifier = Modifier
                .size(100.dp)
                .padding(20.dp)
        )
    }
}