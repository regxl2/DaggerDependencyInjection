package com.example.dependencyinjection

import android.app.Application
import com.example.dependencyinjection.di.ApplicationComponent
import com.example.dependencyinjection.di.DaggerApplicationComponent

class MyApplication: Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}