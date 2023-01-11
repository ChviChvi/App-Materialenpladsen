package com.example.materialepladsen.UIDesign

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.materialepladsen.viewmodel.FlowUiState
import com.example.materialepladsen.viewmodel.FlowViewModel

@Composable
fun StartNavigate(
    modifier: Modifier = Modifier,
    flowViewModel: FlowViewModel = viewModel(),
    navController2: NavHostController = rememberNavController(),
    flowUiState: FlowUiState = FlowUiState()
){



    NavHost(
        navController = navController2,
        startDestination = "Start Screen" ,
         ){
        composable(route = "Start Screen") {
            StartScreen(navController = navController2,
            flowUiState = flowUiState,
            )
        }
        composable(route = "Ready Screen") {
            ReadyScreen(navController = navController2,
                flowUiState = flowUiState)
        }

    }

}