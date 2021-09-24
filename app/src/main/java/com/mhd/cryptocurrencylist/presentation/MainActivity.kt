package com.mhd.cryptocurrencylist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mhd.cryptocurrencylist.common.Constants
import com.mhd.cryptocurrencylist.presentation.coin_detail.CoinDetailScreen
import com.mhd.cryptocurrencylist.presentation.coin_list.CoinListScreen
import com.mhd.cryptocurrencylist.presentation.ui.theme.CryptoCurrencyListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrencyListTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainActivityContent()
                }
            }
        }
    }
}

@Composable
fun MainActivityContent() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {

        composable(
            route = Screen.CoinListScreen.route
        ) {
            CoinListScreen { coin ->
                navController.navigate("${Screen.CoinDetailScreen.route}/${coin.id}")
            }
        }

        composable(
            route = "${Screen.CoinDetailScreen.route}/{${Constants.PARAM_COIN_ID}}"
        ) {
            CoinDetailScreen()
        }

    }

}