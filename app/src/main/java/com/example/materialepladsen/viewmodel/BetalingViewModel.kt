package com.example.materialepladsen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BetalingViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(BetalingsUiState())
    val uiState: StateFlow<BetalingsUiState> = _uiState.asStateFlow()

    //skal kunne modtage data fra udvejning og indsætte det i betalingsuistaten
    fun getDataFromUdvejning(
        weigIn: Float,
        weighOut: Float,
        totalWeight: Float,
        material: String,
        materialPicture: Int,
        price: Double,


    ){
        _uiState.update { currentState ->
            currentState.copy(
                weigIn=weigIn,
                weighOut=weighOut,
                totalWeight=totalWeight,
                material = material,
                materialPicture = materialPicture,
                price = price
            )
        }


    }
    //tilføjer købet til købshistoriklisten
    fun addToBuyHistory(
        materiale:String,
        vægt: Float,
        dato: String,
        pris: Double,
        ordrenr: Int,
        navController: NavController
    ){
        Købshistorikliste.add(Order(materiale,vægt,dato,pris,ordrenr))
        navController.navigate("Købshistorik")
    }


}