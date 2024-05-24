package com.example.dependencyinjection

import android.app.Application
import com.example.dependencyinjection.dependencyinjection.AppComponent
import com.example.dependencyinjection.dependencyinjection.DaggerAppComponent

class MyApplication: Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}