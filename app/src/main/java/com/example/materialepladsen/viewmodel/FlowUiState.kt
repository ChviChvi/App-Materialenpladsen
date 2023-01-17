package com.example.materialepladsen.viewmodel





data class FlowUiState(
    var weighInWeight: Float=0.0f,
    var state: StateOfStart=StateOfStart.Start,
    var userFound:Boolean = true,
    var middleWeight: Float=0.0f,
    var outWeight: Float=0.0f,
    var weighToPay: Float=0.0f,
    var price:Float=200F,
    var materialList1:List<Material> = Material_list,
    var chosenMaterial: Material = materialList1[0],
    var orderhistory:List<Order> =listOf()
    )

enum class StateOfStart(){
    Start,
    FejlStart,
    KorrektStart,
    Betal
}



