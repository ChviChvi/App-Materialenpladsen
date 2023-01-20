package com.example.materialepladsen.SERVER.Network.unusedfiles.Database


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.example.materialepladsen.Database.getProducts2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

private val _uiState = MutableStateFlow(ProductListUistate())

class ProductListViewModel : ViewModel() {

    val uiState = MutableLiveData<ProductListUistate>().apply { value = ProductListUistate() }


    fun fetchProducts() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val products = withContext(Dispatchers.IO) {
//                getProducts2()
//            }
//            uiState.postValue(ProductListUistate(products))
//        }
        try {
            viewModelScope.launch(Dispatchers.IO) {
                uiState.postValue(ProductListUistate(getProducts2()))
            }
        } finally {

        }
    }
}













//class ProductListViewModel : ViewModel() {
//    val productListUiState = MutableStateFlow(ProductListUistate())
//
////    fun updateProductList() {
////        val newProductList = getProducts2() // call your method here to get the new list of products
////        if(newProductList!=null){
////            val currentState = productListUiState.value
////            currentState.setProductsList(newProductList)
////            productListUiState.value = currentState
////        }
////    }
//
//    val productsList = MutableStateFlow(listOf<Product>())
//    init {
//        viewModelScope.launch {
//            productsList.value = getProducts2()
//        }
//    }
//}


//class ProductListViewModel : ViewModel() {
//    private val productListUiState = ProductListUistate()
//
//    fun getProductList(): ProductListUistate {
//        return productListUiState
//    }
//
//    fun updateProductList() {
//        val newProductList = getProducts2() // call your method here to get the new list of products
//        productListUiState.setProductsList(newProductList)
//    }
//}




//    val uiState: StateFlow<ProductListUistate> = _uiState.asStateFlow()
//
//    fun fetchData() {
//        viewModelScope.launch {
//            //val results: List<Product> = getProducts2()
//            val results = getProducts2()
//
//            _uiState.value = _uiState.value.copy(Productslist = results)
//
//            fun sendresults():List<Product>{
//                return results
//            }
//        }
//    }
//
//
//
//    init {
//        _uiState.value = _uiState.value.copy(Productslist = 'HERE')
//    }

