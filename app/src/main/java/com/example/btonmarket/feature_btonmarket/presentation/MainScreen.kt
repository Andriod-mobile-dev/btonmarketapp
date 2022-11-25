package com.example.btonmarket.feature_btonmarket.presentation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.rememberNavController
import com.example.btonmarket.feature_btonmarket.presentation.bottomNavBar.components.BottomNavGraph
import  com.example.btonmarket.R
import com.example.btonmarket.feature_btonmarket.domain.model.OnSellItemsViewModel
import com.example.btonmarket.feature_btonmarket.presentation.bottomNavBar.components.BottomBar

@Composable
fun MainScreen(OnSellItemsVm: OnSellItemsViewModel){
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopBar() },
        bottomBar = {  BottomBar(navController = navController) }
    ) {
        BottomNavGraph(navController = navController, OnSellItemsVm)
    }
}

@Composable
fun TopBar(){
    TopAppBar{
        Text(text = stringResource(id = R.string.bton_market_title), color = Color.White)
    }
}