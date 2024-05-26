package com.example.dependencyinjection.di

import com.example.dependencyinjection.retrofit.FakeAPI
import com.example.dependencyinjection.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    // we are using provides annotation because we cannot directly create the
    // object of the Retrofit because retrofit uses builder pattern to create the object.
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getFakeAPI(retrofit: Retrofit): FakeAPI{
        return retrofit.create(FakeAPI::class.java)
    }
}