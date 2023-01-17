package com.example.materialepladsen.viewmodel



data class Material(
    val material_name: String,
    val material_price: Float,
    val picture:String
)

val Material_list = listOf(
    Material("Støbegrus",0.39F,"https://www.materialepladsen.dk/images/productimages/Støbegrus0-4mm_a7f26b5d-2266-4a01-a5fb-3ee2463f037a.jpg"),
    Material("Vejgrus",0.39F,"https://www.materialepladsen.dk/images/productimages/Vejgrus0-8mm_c33473d6-aefe-41a7-bf45-22c9dbc9b81e.jpg"),


    )







