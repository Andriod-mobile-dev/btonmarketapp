package com.example.btonmarket.core.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun BigImageField(url: String){
    GlideImage(
        imageModel = { url },
        modifier = Modifier
            //.requiredWidth(150.dp)
            .requiredWidth(350.dp)
            .requiredHeight(300.dp),
        imageOptions = ImageOptions(contentScale = ContentScale.FillBounds),
        loading = {
            Box(modifier = Modifier.matchParentSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        },
        failure = {
            Text(text = "Image Request Failed")
        }
    )
}