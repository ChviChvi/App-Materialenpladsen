package com.example.materialepladsen.UIDesign

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.materialepladsen.R
import com.example.materialepladsen.viewmodel.FlowViewModel

@Composable
fun StartScreen(navController: NavController,
                flowViewModel: FlowViewModel = viewModel()
){
    val uiState = flowViewModel.uiState.collectAsState()

    Column {

       if (uiState.value.State=="FejlStart")
       {Text(text = stringResource(id = R.string.FejlStart))}

        if (uiState.value.State=="Start")
        {Text(text = stringResource(id = R.string.Start))}


        TextButton(
            onClick = {

                if (uiState.value.userFound){
                    navController.navigate("Ready Screen")
                flowViewModel.weighIn()
                }
                else {flowViewModel.Fejlstart()}
            })
        {
            Text(text = "Start")
        }

    }
}