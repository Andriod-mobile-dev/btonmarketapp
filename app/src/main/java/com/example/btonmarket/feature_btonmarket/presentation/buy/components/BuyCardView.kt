package com.example.btonmarket.feature_btonmarket.presentation.buy.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btonmarket.R
import com.example.btonmarket.core.presentation.components.ImageThumbnail
import com.example.btonmarket.feature_btonmarket.presentation.buy.BuyScreen

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
        border = BorderStroke(1.dp, Color.Blue),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp, 6.dp)
                .fillMaxWidth()
            ,
            //horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                ImageThumbnail(R.drawable.ic_launcher_background)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                ItemDetailColumn(itemName, price, condition, negotiable, sold)
                SellerDetailColumn(seller)
            }

        }
    }
}

@Composable
fun ItemAndSellStatus(itemName: String, sold: Boolean){
    Row{
        Text(text = itemName,fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
        Spacer(modifier = Modifier.size(3.dp))
        if (sold){
            Text(text = "sold",color=Color.Red, modifier = Modifier.border(BorderStroke(1.dp, Color.Red)).padding(4.dp, 0.dp))
        }
        else{
            Text(text = "on-sell", color=Color.Blue, modifier = Modifier
                .border(BorderStroke(0.4.dp, Color.Blue))
                .padding(4.dp, 0.dp))
        }
    }
}

@Composable
fun ItemDetailColumn(itemName: String, price: Float, condition: String, negotiable: Boolean, sold: Boolean){
    Column{
        //Text(text = itemName, fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
        ItemAndSellStatus(itemName = itemName, sold = sold)
        Text(text = "$condition  condition")
        Text(
            buildAnnotatedString {

                withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                    append(price.toString())
                }
                append(" USD, ")

                if (negotiable) {
                    append(stringResource(id = R.string.NEGOTIABLE))
                    //Text(text = stringResource(id = R.string.NEGOTIABLE), fontWeight = FontWeight.Bold, color=Color.DarkGray)
                } else {
                    append(stringResource(id = R.string.NEGOTIABLE))
                    //Text(text = stringResource(id = R.string.NON_NEGOTIABLE), fontWeight = FontWeight.Bold, color=Color.LightGray)
                }
            }
        )

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
        Button(onClick = { /*TODO*/ }) {
            // cart icon goes here
            Text(text = "GET", fontWeight = FontWeight.Bold)
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Shopping cart icon", modifier = Modifier.size(12.dp))
        }
    }
}


@Composable
@Preview
fun BuyScreenPreview(){
    //BuyScreen()
}