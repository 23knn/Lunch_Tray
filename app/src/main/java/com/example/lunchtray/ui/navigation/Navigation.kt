package com.example.lunchtray.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lunchtray.ui.*

@Composable
fun Navigation(navController: NavHostController, navGraph: NavGraph){
    NavHost(navController = navController, startDestination = Routes.Start.name){
        composable(route = Routes.Start.name){
            StartOrderScreen(onStartOrderButtonClicked = { /*TODO*/ })
        }
        
        composable(route = Routes.EntreeMenu.name){
            EntreeMenuScreen(
                options = ,
                onCancelButtonClicked = { /*TODO*/ },
                onNextButtonClicked = { /*TODO*/ },
                onSelectionChanged = 
            )
        }
        
        composable(route = Routes.SideDishMenu.name){
            SideDishMenuScreen(
                options = ,
                onCancelButtonClicked = { /*TODO*/ },
                onNextButtonClicked = { /*TODO*/ },
                onSelectionChanged = 
            )
        }
        
        composable(route = Routes.AccompanimentMenu.name){
            AccompanimentMenuScreen(
                options = ,
                onCancelButtonClicked = { /*TODO*/ },
                onNextButtonClicked = { /*TODO*/ },
                onSelectionChanged = 
            )
        }
        
        composable(route = Routes.Checkout.name){
            CheckoutScreen(
                orderUiState = ,
                onNextButtonClicked = { /*TODO*/ },
                onCancelButtonClicked = { /*TODO*/ })
        }
        
    }
}