package com.example.dependencyinjection.dependencyinjection

import android.util.Log
import com.example.dependencyinjection.TAG
import javax.inject.Inject

class UserRepository @Inject constructor(){
    fun saveUser(name: String, password: String) {
        Log.d(TAG, "saved the user")
    }
}