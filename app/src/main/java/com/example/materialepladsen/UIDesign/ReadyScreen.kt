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
fun ReadyScreen(navController: NavController,
                flowViewModel: FlowViewModel = viewModel(),


){
    val uiState = flowViewModel.uiState.collectAsState()


    Column() {
        Text(text = stringResource(id = R.string.Readytopickmaterials))

        TextButton(onClick = { flowViewModel.mellemVægt() }) {
            Text(text = stringResource(id = R.string.vejigen))

        }

        TextButton(onClick = { flowViewModel.weighOutAndPay() }) {
            Text(text = stringResource(id = R.string.vejigenogbetal))

        }

        Text(text = stringResource(id = R.string.dinindvejning)+uiState.value.weighInWeight+" Kg" )
        Text(text = stringResource(id = R.string.dinvejning)+uiState.value.middleWeight+" Kg" )
        Text(text = stringResource(id = R.string.Differens)+uiState.value.weighToPay+" Kg" )
        Text(text = uiState.value.State )
    }
}
