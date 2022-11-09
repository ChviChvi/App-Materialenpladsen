package com.example.materialepladsen.viewmodel

import com.example.materialepladsen.R
import java.util.Date

data class BetalingsUiState (
    val weighIn: Float= 200.00f,
    val weighOut: Float=400.00f,
    val totalWeight: Float = 200.00f,
    val material: String="Sølvplade",
    val materialPicture: Int= R.drawable.s_lvplade,
    val price: Float=100.00f,
    val date: Date=Date(),
    val ordernr: Int=1,
)