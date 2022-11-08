package com.example.materialepladsen.viewmodel

enum class DeliveryMethod {
    TIP,
    GRAB,
    BIGBAG,
    NONE
}

data class City(
    val postalCode: String,
    val city: String
    )

val cities = listOf(
    City("2000", "Frederiksberg"),
    City("2620", "Albertslund"),
    City("4140", "Borup"),
    City("3520", "Farum"),
    City("2670", "Greve")
)

data class PriceCalculatorUiState (
    val volume: Float = 0F,
    val totalWeight: Float = 0f,
    val pricePrKg: Float = 0.80f,
    val totalPrice: Float = 0f,
    val materialName: String = "Granit",
    val city: String = "",
    val postalCode: String = "",
    val deliveryMethod: DeliveryMethod = DeliveryMethod.NONE,
    val deliveryMethods: List<String> = listOf("TIP", "GRAB", "BIGBAG")
        )