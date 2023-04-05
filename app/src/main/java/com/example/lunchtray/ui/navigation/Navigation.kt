package com.example.lunchtray.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lunchtray.datasource.DataSource.accompanimentMenuItems
import com.example.lunchtray.datasource.DataSource.entreeMenuItems
import com.example.lunchtray.datasource.DataSource.sideDishMenuItems
import com.example.lunchtray.model.OrderUiState
import com.example.lunchtray.ui.*

@Composable
fun Navigation(
    uiState: OrderUiState,
    navController: NavHostController,
    orderViewModel: OrderViewModel,
    modifier: Modifier
){

    fun cancelOrderAndNavigateToStart(){
        orderViewModel.resetOrder()
        navController.popBackStack(Routes.Start.name, inclusive = false)
    }

    NavHost(navController = navController, startDestination = Routes.Start.name, modifier = modifier){
        composable(route = Routes.Start.name){
            StartOrderScreen(onStartOrderButtonClicked = { navController.navigate(Routes.EntreeMenu.name) })
        }
        
        composable(route = Routes.EntreeMenu.name){
            EntreeMenuScreen(
                options = entreeMenuItems,
                onCancelButtonClicked = { cancelOrderAndNavigateToStart()},
                onNextButtonClicked = { navController.navigate(Routes.SideDishMenu.name) },
                onSelectionChanged = {orderViewModel.updateEntree(it)}
            )
        }
        
        composable(route = Routes.SideDishMenu.name){
            SideDishMenuScreen(
                options = sideDishMenuItems,
                onCancelButtonClicked = { cancelOrderAndNavigateToStart() },
                onNextButtonClicked = { navController.navigate(Routes.AccompanimentMenu.name)},
                onSelectionChanged = {orderViewModel.updateSideDish(it)}
            )
        }
        
        composable(route = Routes.AccompanimentMenu.name){
            AccompanimentMenuScreen(
                options = accompanimentMenuItems,
                onCancelButtonClicked = { cancelOrderAndNavigateToStart() },
                onNextButtonClicked = { navController.navigate(Routes.Checkout.name)},
                onSelectionChanged = {orderViewModel.updateAccompaniment(it)}
            )
        }
        
        composable(route = Routes.Checkout.name){
            CheckoutScreen(
                orderUiState = uiState,
                onNextButtonClicked = { println(uiState) },
                onCancelButtonClicked = { cancelOrderAndNavigateToStart() })
        }
    }




}