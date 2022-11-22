package com.example.btonmarket.feature_btonmarket.presentation.bottomNavBar.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.btonmarket.feature_btonmarket.presentation.bottomNavBar.BottomBarScreen
import com.example.btonmarket.feature_btonmarket.presentation.categories.CategoriesScreen
import com.example.btonmarket.feature_btonmarket.presentation.home.HomeScreen
import com.example.btonmarket.feature_btonmarket.presentation.profile.ProfileScreen
import com.example.btonmarket.feature_btonmarket.presentation.home.SellScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.HomeScreen.route
    ){
        composable(route = BottomBarScreen.HomeScreen.route){
            HomeScreen()
        }

        composable(route = BottomBarScreen.SellScreen.route){
            SellScreen()
        }

        composable(route = BottomBarScreen.CategoriesScreen.route){
            CategoriesScreen()
        }
    }
}