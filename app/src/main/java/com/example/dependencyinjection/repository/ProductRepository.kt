package com.example.dependencyinjection.repository

import com.example.dependencyinjection.models.Product
import com.example.dependencyinjection.retrofit.FakeAPI
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakeAPI: FakeAPI) {
    suspend fun getProducts(): Response<List<Product>> {
        return fakeAPI.getProducts()
    }
}