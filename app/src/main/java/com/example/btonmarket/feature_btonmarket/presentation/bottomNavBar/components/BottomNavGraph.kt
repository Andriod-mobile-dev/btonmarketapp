package com.example.btonmarket.feature_btonmarket.presentation.bottomNavBar.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.btonmarket.feature_btonmarket.domain.model.OnSellViewModel
import com.example.btonmarket.feature_btonmarket.presentation.bottomNavBar.BottomBarScreen
import com.example.btonmarket.feature_btonmarket.presentation.categories.CategoriesScreen
import com.example.btonmarket.feature_btonmarket.presentation.buy.BuyScreen
import com.example.btonmarket.feature_btonmarket.presentation.buy.SellScreen

@Composable
fun BottomNavGraph(navController: NavHostController, onSellVm: OnSellViewModel){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.BuyScreen.route
    ){
        composable(route = BottomBarScreen.BuyScreen.route){
            BuyScreen(onSellVm)
        }

        composable(route = BottomBarScreen.SellScreen.route){
            SellScreen()
        }

        composable(route = BottomBarScreen.CategoriesScreen.route){
            CategoriesScreen()
        }
    }
}