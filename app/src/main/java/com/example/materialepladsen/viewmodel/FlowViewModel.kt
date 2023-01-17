package com.example.materialepladsen.viewmodel


import androidx.lifecycle.ViewModel
import com.example.materialepladsen.API.NewOrderModel
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
                state = StateOfStart.FejlStart,
            )
        }
    }

    fun weighIn(){
        //matchLicensePlate()
        _uiState.update { currentState ->
            currentState.copy(
                weighInWeight = 1850.00f,
                middleWeight = 1850.00f,
                state = StateOfStart.KorrektStart,
            )
        }
    }


    fun matchLicensePlate(){
        //Simulate the picture taken of the cars license plate, by just having a string input instead
        val stringInput = readLine()!!
        val dataPlate = NewOrderModel().Licenseplate

        if(dataPlate == ""){
            println("No license plates!")
        }

        if(stringInput != dataPlate){
            println("The license plates are not matching!")
        } else {
            println("The license plates are matching!")
        }
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
        val outWeight=_uiState.value.middleWeight
        _uiState.update { currentState ->
            currentState.copy(
                state = StateOfStart.Betal,
                outWeight = outWeight
            )

        }
    }

    fun addToBuyHistory(){

    }


    fun chooseMaterial(material:Material1){
        _uiState.update { currentState ->
            currentState.copy(
                chosenMaterial=material
            )
        }
    }
    fun calculatePrice(){
        val price=_uiState.value.chosenMaterial.material_price*_uiState.value.weighToPay
        _uiState.update { currentState ->
            currentState.copy(
                price = price
            )
        }
    }



}