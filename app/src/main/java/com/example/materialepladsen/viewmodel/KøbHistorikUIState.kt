package com.example.materialepladsen.viewmodel

import androidx.navigation.NavController


data class KøbHistorikUIState (
    val customerID: Long,
    val orders: List<Order>,
)

val Købshistorikliste = mutableListOf<Order>()


data class Order (
    val materiale: String,
    val vægt: Float,
    val dato: String,
    val pris: Double,
    val ordrenr: Int,
)

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

