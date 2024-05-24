package com.example.dependencyinjection

import android.app.Application
import com.example.dependencyinjection.dependencyinjection.DaggerUserRegistrationComponent
import com.example.dependencyinjection.dependencyinjection.UserRegistrationComponent

class MyApplication: Application() {
    lateinit var userRegistrationComponent: UserRegistrationComponent
    override fun onCreate() {
        super.onCreate()
        userRegistrationComponent = DaggerUserRegistrationComponent.factory().create(3)
    }
}