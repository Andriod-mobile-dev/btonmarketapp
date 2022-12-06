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
import com.example.btonmarket.core.constants.CATEGORY_DETAIL_PATH
import com.example.btonmarket.core.constants.*
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
                ToDetailCategory(navController, CATEGORY_NAME_EVENT_TICKET, CATEGORY_EVENT_TICKET_LABEL)
            }
            Row {
                ToDetailCategory(navController, CATEGORY_NAME_HOME, CATEGORY_HOME_LABEL)
            }
            Row {
                ToDetailCategory(navController, CATEGORY_NAME_SERVICE, CATEGORY_SERVICE_LABEL)
            }
            Row {
                ToDetailCategory(navController, CATEGORY_NAME_VEHICLE, CATEGORY_VEHICLE_LABEL)
            }
            Row {
                ToDetailCategory(navController, CATEGORY_NAME_ART, CATEGORY_ART_LABEL)
            }
            Row {
                ToDetailCategory(navController, CATEGORY_NAME_EDUCATION, CATEGORY_EDUCATION_LABEL)
            }
        }
    }
}

@Composable
fun ToDetailCategory(navController: NavController, categoryname: String, label:String){
    ToDetailCategoryButton(navController = navController, path=categoryname, label = label)
//    when (path){
//        "car" -> ToDetailCategoryButton(navController = navController, path=path, label = label)
//        "eventtickets" -> ToDetailCategoryButton(navController = navController, path=path, label = label)
//    }
}

@Composable
fun ToDetailCategoryButton(navController: NavController,path: String, label:String){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(20.dp, 7.dp),
        onClick = {
            //BottomBarScreen.CategoriesDetailScreen.route+"/" + 1
        navController.navigate(route = CATEGORY_DETAIL_PATH + path)
    }) {
        Text(text = label)
    }
}

@Composable
@Preview
fun CategoriesScreenPreview(){
    //CategoriesScreen()
}