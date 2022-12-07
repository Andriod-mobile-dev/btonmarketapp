package com.example.btonmarket.feature_btonmarket.presentation.bottomNavBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.btonmarket.core.constants.CATEGORY_DETAIL_ARG_KEY
import com.example.btonmarket.core.constants.ITEM_DETAIL_ARG_KEY

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object BuyScreen : BottomBarScreen(
        route = "buy",
        title = "Buy",
        icon = Icons.Default.ShoppingCart
    )
    object CategoriesScreen : BottomBarScreen(
        route = "list",
        title = "Category",
        icon = Icons.Default.List
    )

    object CategoriesDetailScreen: BottomBarScreen(
        route = "categories-detail/{$CATEGORY_DETAIL_ARG_KEY}",
        title = "Detail Category",
        icon = Icons.Default.LocationOn
    )

    object ItemDetailScreen: BottomBarScreen(
        route = "item-detail/{$ITEM_DETAIL_ARG_KEY}",
        title = "Item Detail",
        icon = Icons.Default.Person
    )

    object SellScreen : BottomBarScreen(
        route = "sell",
        title = "Sell",
        icon = Icons.Default.Send
    )

}
