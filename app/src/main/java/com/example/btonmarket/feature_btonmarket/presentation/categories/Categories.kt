package com.example.btonmarket.feature_btonmarket.presentation.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.btonmarket.feature_btonmarket.presentation.bottomNavBar.BottomBarScreen
import com.example.btonmarket.feature_btonmarket.presentation.sell.pageTitle


@Composable
fun CategoriesScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row (
                modifier = Modifier.padding(0.dp,10.dp,0.dp,20.dp)
                    ){
                pageTitle(title = "Categories")
            }
            Row {
                ToDetailCategory(navController, "eventtickets", "Event Tickets")
            }
            Row {
                ToDetailCategory(navController, "eventtickets", "Home Equipments")
            }
            Row {
                ToDetailCategory(navController, "eventtickets", "Services")
            }
            Row {
                ToDetailCategory(navController, "eventtickets", "Vehicles")
            }
            Row {
                ToDetailCategory(navController, "eventtickets", "Artifacts")
            }
            Row {
                ToDetailCategory(navController, "eventtickets", "Education Materials")
            }
        }
    }
}

@Composable
fun ToDetailCategory(navController: NavController, path: String, label:String){
    when (path){
        "eventtickets" -> ToDetailCategoryButton(navController = navController, label = label)
    }
}

@Composable
fun ToDetailCategoryButton(navController: NavController, label:String){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(20.dp, 7.dp),
        onClick = {
        navController.navigate(route = BottomBarScreen.CategoriesDetailScreen.route)
    }) {
        Text(text = label)
    }
}

@Composable
@Preview
fun CategoriesScreenPreview(){
    //CategoriesScreen()
}