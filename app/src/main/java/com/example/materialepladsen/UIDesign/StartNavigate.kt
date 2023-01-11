package com.example.materialepladsen.UIDesign

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.materialepladsen.viewmodel.FlowViewModel

@Composable
fun StartNavigate(
    modifier: Modifier = Modifier,
    flowViewModel: FlowViewModel = viewModel(),
){
    val uiState = flowViewModel.uiState.collectAsState()
    val navController2 = rememberNavController()

    NavHost(
        navController = navController2,
        startDestination = "Start Screen" ,
         ){

        composable(route = "Start Screen") {
            StartScreen(
                state = uiState.value.State,
                userFound = uiState.value.userFound,
                navigateFunction = { navController2.navigate("Ready Screen")},
                setFailState = {flowViewModel.Fejlstart()},
                weighInFunction = {flowViewModel.weighIn()}


            )
        }
        composable(route = "Ready Screen") {
            ReadyScreen(
                onVejIgenButtonClicked = {flowViewModel.mellemVægt()},
                weighInWeight = uiState.value.weighInWeight,
                middleWeight = uiState.value.middleWeight,
                weighToPay = uiState.value.weighToPay,
                onVejIgenOgBetalButtonClicked = {flowViewModel.weighOutAndPay()}

            )
        }

    }

}