package com.example.materialepladsen.viewmodel

import com.example.materialepladsen.Database.Product
import com.example.materialepladsen.Database.getProducts
import com.example.materialepladsen.Database.getProducts2




data class ProductListUistate(

    var Productslist: List<Product>? = null,
    val Hello: String = "LOL"
)   {
    fun setProductsList(newProductList: List<Product>) {
    this.Productslist = newProductList
    }
}