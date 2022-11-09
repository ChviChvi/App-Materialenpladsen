package com.example.materialepladsen.viewmodel

import com.example.materialepladsen.R

data class BetalingsUiState (
    val weigIn: Float=200.00f,
    val weighOut: Float=400.00f,
    val totalWeight: Float = 200.00f,
    val material: String="Sølvplade",
    val materialPicture: Int= R.drawable.s_lvplade,
    val price: Double=500.00,
    val date: String="31/10",
    val ordernr: Int=432,
)