package com.example.dependencyinjection.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.DeleteTable
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dependencyinjection.models.Product

@Dao
interface FakeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(list: List<Product>)

    @Query("SELECT * FROM Product")
    suspend fun getProducts(): List<Product>

    @Query("DELETE FROM Product")
    suspend fun deleteAll()
}