package com.example.btonmarket

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.btonmarket.feature_btonmarket.data.data_source.remote.OnSellItems
import com.example.btonmarket.feature_btonmarket.domain.model.OnSellItemsViewModel
import com.example.btonmarket.feature_btonmarket.presentation.MainScreen
import com.example.btonmarket.ui.theme.BtonmarketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // get the OnSellItems view model here
        // which gets passed down to the home screen
        val onSellVm = OnSellItemsViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            BtonmarketTheme {
                Test(onSellVm)
                //MainScreen(onSellVm)
            }
        }
    }
}

@Composable
fun Test(viewModel: OnSellItemsViewModel){
    LaunchedEffect(key1 = Unit, block = {
        viewModel.getOnSellItems()
    })

    Log.d("New Item", viewModel.onSellItemsList.toString())
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BtonmarketTheme {
    }
}