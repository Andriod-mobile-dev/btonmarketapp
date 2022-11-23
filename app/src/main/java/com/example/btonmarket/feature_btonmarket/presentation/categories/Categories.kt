package com.example.btonmarket.feature_btonmarket.presentation.categories


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.btonmarket.ui.theme.Purple200


@Composable
fun CategoriesScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CategoryText(category = "Home Equipment")
    }
}


@Composable
fun CategoryText(category: String){
    val GradientColors = listOf(Cyan, Color.Blue, Color.Yellow)

    Text(category, fontWeight = FontWeight.Bold, color=Color.Blue)


}

@Composable
@Preview
fun CategoriesScreenPreview(){
    CategoriesScreen()
}