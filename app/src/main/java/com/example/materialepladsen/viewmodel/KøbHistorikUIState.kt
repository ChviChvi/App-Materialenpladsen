package com.example.materialepladsen.viewmodel



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



