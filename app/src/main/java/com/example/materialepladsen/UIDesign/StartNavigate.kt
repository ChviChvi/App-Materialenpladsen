package com.example.materialepladsen.UIDesign

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.materialepladsen.R
import com.example.materialepladsen.viewmodel.FlowViewModel


enum class StartNavigateScreen(@StringRes val title: Int) {
    StartScreen(title = R.string.StartScreen),
    ReadyScreen(title = R.string.ReadyScreeen),
}

@Composable
fun StartNavigate(
    modifier: Modifier = Modifier,
    flowViewModel: FlowViewModel = viewModel(),
){
    val uiState = flowViewModel.uiState.collectAsState()
    val navController2 = rememberNavController()

    NavHost(
        navController = navController2,
        startDestination = StartNavigateScreen.StartScreen.name ,
         ){

        composable(route = StartNavigateScreen.StartScreen.name) {
            StartScreen(
                state = uiState.value.State,
                userFound = uiState.value.userFound,
                navigateFunction = { navController2.navigate(StartNavigateScreen.ReadyScreen.name) },
                setFailState = {flowViewModel.Fejlstart()},
                weighInFunction = {flowViewModel.weighIn()}


            )
        }
        composable(route = StartNavigateScreen.ReadyScreen.name) {
            ReadyScreen(
                onVejIgenButtonClicked = {flowViewModel.middleWeight()},
                weighInWeight = uiState.value.weighInWeight,
                middleWeight = uiState.value.middleWeight,
                weighToPay = uiState.value.weighToPay,
                onVejIgenOgBetalButtonClicked = {flowViewModel.weighOutAndPay()}

            )
        }

    }

}