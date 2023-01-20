package com.example.materialepladsen

import com.example.materialepladsen.Data.Material
import com.example.materialepladsen.viewmodel.FlowViewModel
import com.example.materialepladsen.viewmodel.StateOfStart
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class FlowViewModelUnitTest {

    private lateinit var flowViewModel: FlowViewModel

    @Before
    fun setUp() {
        flowViewModel = FlowViewModel()
    }

    @Test
    fun testFejlstart() {
        flowViewModel.Fejlstart()
        Assert.assertEquals(StateOfStart.FejlStart, flowViewModel.uiState.value.state)
    }

    @Test
    fun testWeighIn() {
        flowViewModel.weighIn()
        Assert.assertEquals(1850.00f, flowViewModel.uiState.value.weighInWeight)
        Assert.assertEquals(1850.00f, flowViewModel.uiState.value.middleWeight)
        Assert.assertEquals(StateOfStart.KorrektStart, flowViewModel.uiState.value.state)
    }

    @Test
    fun testMiddleWeight() {
        flowViewModel.middleWeight()
        Assert.assertEquals(1975.00f, flowViewModel.uiState.value.middleWeight)
        Assert.assertEquals(1975.00f - 1850.00f, flowViewModel.uiState.value.weighToPay)
    }

    @Test
    fun testWeighOutAndPay() {
        flowViewModel.weighOutAndPay()
        Assert.assertEquals(1975.00f, flowViewModel.uiState.value.outWeight)
        Assert.assertEquals(StateOfStart.Betal, flowViewModel.uiState.value.state)
    }

    @Test
    fun testChooseMaterial() {
        val material = Material(materialName = "Granit rød", productSize ="11-16 mm" , materialPrice =0.80F , picture = "https://www.materialepladsen.dk/images/productimages/Granitrød11-16mm_76209b39-4244-4fb6-a91f-8c082f4d98e7.jpg")
        flowViewModel.chooseMaterial(material)
        Assert.assertEquals(material, flowViewModel.uiState.value.chosenMaterial)
    }

    @Test
    fun testCalculatePrice() {
        flowViewModel.calculatePrice()
        Assert.assertEquals(
            flowViewModel.uiState.value.chosenMaterial.materialPrice * flowViewModel.uiState.value.weighToPay,
            flowViewModel.uiState.value.price
        )
    }

    @Test
    fun testResetBuy() {
        flowViewModel.resetBuy()
        Assert.assertEquals(0.0f, flowViewModel.uiState.value.weighInWeight)
        Assert.assertEquals(StateOfStart.Start, flowViewModel.uiState.value.state)
        Assert.assertEquals(0.0f, flowViewModel.uiState.value.middleWeight)
        Assert.assertEquals(0.0f, flowViewModel.uiState.value.outWeight)
        Assert.assertEquals(0.0f, flowViewModel.uiState.value.weighToPay)
        Assert.assertEquals(0.0f, flowViewModel.uiState.value.price)
    }
}
