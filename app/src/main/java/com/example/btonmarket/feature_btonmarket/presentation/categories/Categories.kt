package com.example.btonmarket.feature_btonmarket.presentation.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.btonmarket.feature_btonmarket.presentation.buy.components.SearchView


@Composable
fun CategoriesScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Categories",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )
        val textState = remember { mutableStateOf(TextFieldValue("")) }
        SearchView(textState)
    }
}

@Composable
@Preview
fun CategoriesScreenPreview(){
    CategoriesScreen()
}