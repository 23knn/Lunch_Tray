package com.example.lunchtray

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lunchtray.ui.OrderViewModel
import com.example.lunchtray.ui.navigation.Navigation

// TODO: Screen enum

// TODO: AppBar

@Composable
fun LunchTrayApp(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()
    val viewModel: OrderViewModel = viewModel()

    Scaffold(
        topBar = {
            // TODO: AppBar
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
