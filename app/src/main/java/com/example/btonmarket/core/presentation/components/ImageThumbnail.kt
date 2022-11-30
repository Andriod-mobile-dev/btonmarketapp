package com.example.btonmarket.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.btonmarket.R
import com.skydoves.landscapist.glide.GlideImage
import java.net.URL

@Composable
fun ImageThumbnail(resource_imageID: Int= R.drawable.ic_launcher_background){
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

@Composable
fun ImageThumbnailFromURL(url: String){
    GlideImage(
        imageModel = { url },
        modifier = Modifier
            .requiredWidth(150.dp)
            .width(200.dp)
            .requiredHeight(150.dp)
    )
}