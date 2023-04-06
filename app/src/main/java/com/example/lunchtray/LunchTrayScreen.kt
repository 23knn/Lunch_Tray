package com.example.lunchtray

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lunchtray.ui.OrderViewModel
import com.example.lunchtray.ui.navigation.LunchTrayAppBar
import com.example.lunchtray.ui.navigation.Navigation
import com.example.lunchtray.ui.navigation.Routes


@Composable
fun LunchTrayApp(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()
    val viewModel: OrderViewModel = viewModel()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Routes.valueOf(
        backStackEntry?.destination?.route ?: Routes.Start.name
    )
    /**
     * the current screen logic is: check the stack top, that's the previous screen. check its destination.
     * if stack top is empty, there was no previous screen so return start screen
     * **/

    Scaffold(
        topBar = {
            LunchTrayAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() })
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        Navigation(
            uiState = uiState,
            navController = navController,
            orderViewModel = viewModel,
            modifier = modifier.padding(innerPadding)
        )
    }
}
