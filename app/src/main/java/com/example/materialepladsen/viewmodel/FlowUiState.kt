package com.example.materialepladsen.viewmodel



data class FlowUiState(
    var weighInWeight: Float=0.0f,
    var state: StateOfStart=StateOfStart.Start,
    var userFound:Boolean = true,
    var middleWeight: Float=0.0f,
    var outWeight: Float=0.0f,
    var weighToPay: Float=0.0f,

    )

enum class StateOfStart(){
    Start,
    FejlStart,
    KorrektStart,
    Betal
}



