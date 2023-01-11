package com.example.materialepladsen.viewmodel


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FlowViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(FlowUiState())
    val uiState: StateFlow<FlowUiState> = _uiState.asStateFlow()

    fun Fejlstart(){
        _uiState.update { currentState ->
            currentState.copy(
                State = "FejlStart"
            )
        }
    }

    fun weighIn(){
        matchLicensePlate()
        _uiState.update { currentState ->
            currentState.copy(
                weighInWeight = 1850.00f,
                middleWeight = 1850.00f,
                State = "korrekt startet"
            )
        }

    }

    fun matchLicensePlate(){
        //TODO
    }

    fun middleWeight(){
        _uiState.update { currentState ->
            currentState.copy(
                weighInWeight = 1850.00f,
                middleWeight = 1975.00f,
            )
        }
        val weighToPay=_uiState.value.middleWeight-_uiState.value.weighInWeight
        _uiState.update { currentState ->
            currentState.copy(
                weighToPay = weighToPay
            )
        }


    }


    fun weighOutAndPay(){
        middleWeight()
        _uiState.update { currentState ->
            currentState.copy(
                State = "Betal"
            )
        }


    }



}