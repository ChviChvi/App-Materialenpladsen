package com.example.materialepladsen.viewmodel

import com.example.materialepladsen.R

data class KøbHistorikUIState (
    val customerID: Long,
    val orders: List<Order>,
)


data class Order (
    val materiale: String,
    val vægt: Float,
    val dato: String,
    val pris: Double,
    val ordrenr: Int,
)
