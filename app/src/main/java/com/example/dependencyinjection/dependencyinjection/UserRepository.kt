package com.example.dependencyinjection.dependencyinjection

import android.util.Log
import com.example.dependencyinjection.TAG
import javax.inject.Inject

interface UserRepository{
    fun saveUser(name: String, password: String)
}

class SQLRepository @Inject constructor(): UserRepository{
    override fun saveUser(name: String, password: String) {
        Log.d(TAG, "SQLRepository: saved the user")
    }

}

class FirebaseRepository : UserRepository{
    override fun saveUser(name: String, password: String) {
        Log.d(TAG, "FirebaseRepository: saved the user")
    }

}