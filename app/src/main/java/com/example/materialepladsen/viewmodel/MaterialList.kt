package com.example.materialepladsen.viewmodel

enum class MaterialList : List<String> {

}

data class Material(
    val material_name: String,
    val material_info: String,
    val material_price: String,
)

val Material_list = listOf(
    listOf(
        Material("15Kg ask i stammer", "1,5 år gammelt", "789,00"),
        Material("25kg bøgestammer","0,5 år gammelt","1200,00")
    ),

    listOf(
        Material("Sølvplade 0,4mm", "Fast bredde 14,0 cm\\n(14 x 10 cm = ca. 58g)", "8,84"),
        Material("Argentium Sølvplade 1,0mm","Fast bredde 14,0 cm\\n(14 x 10 cm = ca. 174g)","9,16")
    ),

    listOf(
        Material("Hvide granitskærver", "1 ton, 11–16mm", "1.545,50"),
        Material("Røde granitskærver","1 ton, 8–11mm","1.195,00")
    )
)