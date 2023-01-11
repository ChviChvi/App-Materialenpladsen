package com.example.materialepladsen.viewmodel

data class FlowUiState(
    var weighInWeight: Float=0.0f,
    var State: String="Start",
    var userFound:Boolean = true,
    var middleWeight: Float=0.0f,
    var outWeight: Float=0.0f,
    var weighToPay: Float=0.0f,

)