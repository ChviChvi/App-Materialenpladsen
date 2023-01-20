package com.example.materialepladsen.viewmodel

import com.example.materialepladsen.Data.Material
import com.example.materialepladsen.Data.MaterialList
import com.example.materialepladsen.Data.Order


data class FlowUiState(
    var weighInWeight: Float=0.0f,
    var state: StateOfStart=StateOfStart.Start,
    var userFound:Boolean = true,
    var middleWeight: Float=0.0f,
    var outWeight: Float=0.0f,
    var weighToPay: Float=0.0f,
    var price:Float=0.0F,
    var materialList:List<Material> = MaterialList,
    var chosenMaterial: Material = materialList[0],
    var orderhistory:List<Order> =listOf()
    )

enum class StateOfStart(){
    Start,
    FejlStart,
    KorrektStart,
    Betal
}



