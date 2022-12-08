package com.example.btonmarket.core.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun GetItemSmallButton(name:String){
    Button(onClick = { /*TODO*/ }) {
        // cart icon goes here
        Text(text = "GET", fontWeight = FontWeight.Bold)
        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Shopping cart icon", modifier = Modifier.size(12.dp))
    }
}

@Composable
fun GetItemBigButton(name: String){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.width(200.dp)
    ) {
        // cart icon goes here
        Text(text = "GET", fontWeight = FontWeight.Bold)
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Shopping cart icon",
            modifier = Modifier.size(32.dp))
    }
}