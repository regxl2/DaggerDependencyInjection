package com.example.dependencyinjection.dependencyinjection

import android.util.Log
import com.example.dependencyinjection.TAG
import javax.inject.Inject
import javax.inject.Singleton

interface UserRepository{
    fun saveUser(name: String, password: String)
}

@ActivityScope
class SQLRepository @Inject constructor(private val analyticsService: AnalyticsService): UserRepository{
    override fun saveUser(name: String, password: String) {
        Log.d(TAG, "SQLRepository: saved the user")
        analyticsService.trackEvent("save user", "CREATE")
    }

}

class FirebaseRepository @Inject constructor(private val analyticsService: AnalyticsService): UserRepository{
    override fun saveUser(name: String, password: String) {
        Log.d(TAG, "FirebaseRepository: saved the user")
        analyticsService.trackEvent("save user", "CREATE")
    }
}