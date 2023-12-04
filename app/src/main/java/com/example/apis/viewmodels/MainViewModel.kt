package com.example.apis.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apis.data.remote.ProductResponse
import com.example.apis.data.remote.RetrofitServerClient
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _allProductResponse = MutableLiveData<ProductResponse>()
    val allProductResponse: MutableLiveData<ProductResponse> = _allProductResponse

    fun getAllProductFromResponse(){
        viewModelScope.launch {
            val dataFromResponse = RetrofitServerClient.getProductApi().getAllProducts().body()
            _allProductResponse.postValue(dataFromResponse)
        }
    }
}