package com.example.btonmarket.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageThumbnail(resource_imageID: Int){
    Image(painter = painterResource(id = resource_imageID),
        contentDescription = "On sell item",
        modifier = Modifier
            //.size(150.dp)
            .requiredWidth(150.dp)
            .requiredHeight(200.dp)
//            .width(150.dp)
//            .height(200.dp)
    )
}