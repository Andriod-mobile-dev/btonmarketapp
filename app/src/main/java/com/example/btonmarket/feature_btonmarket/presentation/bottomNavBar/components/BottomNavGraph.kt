package com.example.btonmarket.feature_btonmarket.presentation.bottomNavBar.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.btonmarket.core.constants.CATEGORY_DETAIL_ARG_KEY
import com.example.btonmarket.feature_btonmarket.domain.model.OnSellViewModel
import com.example.btonmarket.feature_btonmarket.domain.model.SearchItemsViewModel
import com.example.btonmarket.feature_btonmarket.domain.model.SellViewModel
import com.example.btonmarket.feature_btonmarket.presentation.bottomNavBar.BottomBarScreen
import com.example.btonmarket.feature_btonmarket.presentation.categories.CategoriesScreen
import com.example.btonmarket.feature_btonmarket.presentation.buy.BuyScreen
import com.example.btonmarket.feature_btonmarket.presentation.buy.BuyScreenPreview
import com.example.btonmarket.feature_btonmarket.presentation.categoriesDetail.CategoriesDetailScreenUI
import com.example.btonmarket.feature_btonmarket.presentation.sell.SellScreen

@Composable
fun BottomNavGraph(navController: NavHostController, onSellVm: OnSellViewModel, sellvm: SellViewModel,searchVm:SearchItemsViewModel){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.BuyScreen.route
    ){
        composable(route = BottomBarScreen.BuyScreen.route){
            BuyScreen(onSellVm, searchVm)
        }

        composable(route = BottomBarScreen.SellScreen.route){
            SellScreen(sellvm)
        }

        composable(route = BottomBarScreen.CategoriesScreen.route){
            CategoriesScreen(navController)
        }

        composable(
            route = BottomBarScreen.CategoriesDetailScreen.route,
            arguments = listOf(navArgument(CATEGORY_DETAIL_ARG_KEY){
                type = NavType.StringType
            })
        ){
            Log.d("Debug params", it.arguments?.getString(CATEGORY_DETAIL_ARG_KEY).toString())
            CategoriesDetailScreenUI(searchVm, it.arguments?.getString(CATEGORY_DETAIL_ARG_KEY).toString())
        }

    }
}