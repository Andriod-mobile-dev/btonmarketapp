package com.example.btonmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.btonmarket.feature_auth.domain.model.AuthViewModel
import com.example.btonmarket.feature_btonmarket.presentation.MainScreen
import com.example.btonmarket.feature_btonmarket.presentation.bottomNavBar.BottomBarScreen
import com.example.btonmarket.feature_btonmarket.presentation.profile.ProfileScreen
import com.example.btonmarket.ui.theme.BtonmarketTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    private  lateinit var navController: NavHostController
    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BtonmarketTheme {
                MainScreen()
                checkAuthState()
            }
        }
    }
    private fun checkAuthState(){
        if(viewModel.isUserAuthenticated){
            navigateToProfileScreen()
        }
    }

    private fun navigateToProfileScreen() = navController.navigate(BottomBarScreen.ProfileScreen.route)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BtonmarketTheme {
    }
}