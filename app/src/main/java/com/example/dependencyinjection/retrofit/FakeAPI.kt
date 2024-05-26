package com.example.dependencyinjection.retrofit

import com.example.dependencyinjection.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakeAPI {
    @GET(value = "products")
    suspend fun getProducts(): Response<List<Product>>
}