package com.example.dependencyinjection.repository

import com.example.dependencyinjection.db.FakeDB
import com.example.dependencyinjection.models.Product
import com.example.dependencyinjection.retrofit.FakeAPI
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakeAPI: FakeAPI, private val fakeDB: FakeDB) {
    suspend fun getProducts(): Response<List<Product>> {
        val response = fakeAPI.getProducts()
        if(response.isSuccessful){
            response.body()?.let {
                fakeDB.getFakeDAO().addProducts(it)
            }
        }
        return response
    }
}