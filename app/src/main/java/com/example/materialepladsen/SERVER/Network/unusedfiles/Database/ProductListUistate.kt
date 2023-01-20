package com.example.materialepladsen.SERVER.Network.unusedfiles.Database

import com.example.materialepladsen.SERVER.Network.unusedfiles.Database.Product
import com.example.materialepladsen.SERVER.Network.unusedfiles.Database.getProducts
import com.example.materialepladsen.SERVER.Network.unusedfiles.Database.getProducts2




data class ProductListUistate(
    var Productslist: List<Product>? = null,
    val Hello: String = "LOL"
)   {
    fun setProductsList(newProductList: List<Product>) {
    this.Productslist = newProductList
    }
}