package com.example.materialepladsen.viewmodel

import java.util.*


data class KøbHistorikUIState (
    val customerID: Long,
    val orders: List<Order>,
)

val Købshistorikliste = mutableListOf<Order>()


data class Order (
    val materiale: String,
    val vægt: Float,
    val dato: Date,
    val pris: Float,
    val ordrenr: Int,
)



