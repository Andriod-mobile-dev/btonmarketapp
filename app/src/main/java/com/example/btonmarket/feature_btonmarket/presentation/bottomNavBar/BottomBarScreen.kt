package com.example.btonmarket.feature_btonmarket.presentation.bottomNavBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object HomeScreen : BottomBarScreen(
        route = "buy",
        title = "Buy",
        icon = Icons.Default.ShoppingCart
    )
    object CategoriesScreen : BottomBarScreen(
        route = "list",
        title = "Category",
        icon = Icons.Default.List
    )

    object SellScreen : BottomBarScreen(
        route = "sell",
        title = "Sell",
        icon = Icons.Default.Send
    )

}
