package com.example.materialepladsen.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.RoundingMode

class PriceCalculatorViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PriceCalculatorUiState())
    val uiState: StateFlow<PriceCalculatorUiState> = _uiState.asStateFlow()

    fun setVolume(volume: Float) {
        _uiState.update { currentState ->
            currentState.copy(
                volume = volume // Also update weight here
            )
        }
    }

    companion object {
        // Volume is one of the 35 options, the float represents the sliders position
        // Volume goes from 0.5m^3 to 18 m^3
        fun getVolumeFromSlider(sliderValue: Float): Float {
            val maxVolume = 18f
            return (maxVolume * sliderValue).toBigDecimal().setScale(1, RoundingMode.HALF_DOWN).toFloat()
        }

        fun verifyPostcode(code: String): Boolean {
            return cities.map { city -> city.postalCode }.contains(code)
        }
    }

    fun setMaterial(material: String, pricePerKg: Float) {
        _uiState.update { currentState ->
            currentState.copy(
                materialName = material,
                pricePrKg = pricePerKg
            )
        }
    }

    fun setCity(city: String) {
        _uiState.update { currentState ->
            currentState.copy(
                city = city
            )
        }
    }

    fun setAll(pricePrKg: Float, volume: Float, city: String, postalCode: String, deliveryMethod: DeliveryMethod, material: String) {
        _uiState.update { currentState ->
            currentState.copy(
                volume = volume,
                pricePrKg = pricePrKg,
                city = city,
                postalCode = postalCode,
                deliveryMethod = deliveryMethod,
                materialName = material
            )
        }
    }

    fun setPostalCode(code: String) {
        _uiState.update { currentState ->
            currentState.copy(
                postalCode = code
            )
        }
    }

    fun updatePrice() {
        if (!allValuesSetNeededForPriceSet())
            return

        val deliveryCost = 50f // Should be based on postalcode and delivery method, but let it just be constant for now as we dont know how its calculated

        _uiState.update { currentState ->
            currentState.copy(
                totalPrice = _uiState.value.pricePrKg * _uiState.value.volume + deliveryCost // use weight eventually for now volume just as an example
            )
        }
    }

    private fun allValuesSetNeededForPriceSet(): Boolean {
        return true
        /*
        return _uiState.value.pricePrKg != 0f &&
                _uiState.value.city     != "" &&
                _uiState.value.postalCode != "" &&
                _uiState.value.totalPrice != 0f &&
                _uiState.value.deliveryMethod != DeliveryMethod.NONE &&
                _uiState.value.materialName != "" &&
                _uiState.value.volume != 0f

         */
    }
}