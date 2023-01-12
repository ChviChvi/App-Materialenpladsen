package com.example.materialepladsen.viewmodel


import com.example.materialepladsen.R


data class FlowUiState(
    var weighInWeight: Float=0.0f,
    var state: StateOfStart=StateOfStart.Start,
    var userFound:Boolean = true,
    var middleWeight: Float=0.0f,
    var outWeight: Float=0.0f,
    var weighToPay: Float=0.0f,
    var materialeBillede: Int = R.drawable.as_lvplade,
    var materiale:Int=  R.string.ASølvplade,
    var price:Float=200F,
    )

enum class StateOfStart(){
    Start,
    FejlStart,
    KorrektStart,
    Betal
}



