package com.example.btonmarket

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.example.btonmarket.feature_btonmarket.domain.model.OnSellViewModel
import com.example.btonmarket.feature_btonmarket.presentation.MainScreen
import com.example.btonmarket.ui.theme.BtonmarketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val vm = OnSellViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            BtonmarketTheme {
                //Test(vm)
                MainScreen(vm)
            }
        }
    }
}

@Composable
fun Test(vm: OnSellViewModel){
    LaunchedEffect(key1 = Unit, block = {
        vm.getOnSellItemsList()
    })

    Log.d("Test items: ", vm.onSellItemsList.size.toString())
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BtonmarketTheme {
    }
}