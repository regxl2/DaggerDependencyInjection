package com.example.dependencyinjection.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjection.db.FakeDB
import com.example.dependencyinjection.models.Product
import com.example.dependencyinjection.repository.ProductRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


sealed interface ProductUiState{
    data class Success(val productList: List<Product>): ProductUiState
    data object Error: ProductUiState
    data object Loading: ProductUiState
}

class MainViewModel(private val productRepository: ProductRepository): ViewModel() {

    var productUiState: MutableState<ProductUiState> = mutableStateOf(ProductUiState.Loading)
        private set

    init {
        getProducts()
    }
    fun getProducts(){
        viewModelScope.launch {
            delay(2000)
            val response = productRepository.getProducts()
            if(response.isSuccessful && response.body()!=null){
                productUiState.value = ProductUiState.Success(response.body()!!)
            }
            else{
                productUiState.value = ProductUiState.Error
            }
        }
    }
}

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory @Inject constructor(private val productRepository: ProductRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(productRepository) as T
    }
}