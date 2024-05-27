package com.example.dependencyinjection.di

import android.content.Context
import androidx.room.Room
import com.example.dependencyinjection.db.FakeDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun getDatabase(context: Context): FakeDB {
        return Room.databaseBuilder(
            context = context,
            klass = FakeDB::class.java,
            name = "Fake Room Database"
        ).build()
    }
}