package com.example.dependencyinjection.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dependencyinjection.models.Product

@Database(entities = [Product::class], version = 1)
abstract class FakeDB: RoomDatabase(){
    abstract fun getFakeDAO(): FakeDAO
}