package com.example.btonmarket.feature_btonmarket.presentation

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.example.btonmarket.feature_btonmarket.presentation.bottomNavBar.components.BottomNavGraph
import  com.example.btonmarket.R
import com.example.btonmarket.feature_btonmarket.domain.model.CategoryViewModel
import com.example.btonmarket.feature_btonmarket.domain.model.OnSellViewModel
import com.example.btonmarket.feature_btonmarket.domain.model.SearchItemsViewModel
import com.example.btonmarket.feature_btonmarket.domain.model.SellViewModel
import com.example.btonmarket.feature_btonmarket.presentation.bottomNavBar.components.BottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(onSellVm: OnSellViewModel,
               sellVm: SellViewModel,
               searchVm:SearchItemsViewModel,
               categoryVm: CategoryViewModel,
){
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopBar() },
        bottomBar = {  BottomBar(navController = navController) }
    ) {
        BottomNavGraph(navController = navController, onSellVm, sellVm, searchVm,categoryVm)
    }
}

@Composable
fun TopBar(){
    TopAppBar{
        Text(text = stringResource(id = R.string.bton_market_title), color = Color.White)
    }
}