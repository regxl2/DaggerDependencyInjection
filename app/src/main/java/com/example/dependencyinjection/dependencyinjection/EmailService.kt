package com.example.dependencyinjection.dependencyinjection

import android.util.Log
import com.example.dependencyinjection.TAG
import javax.inject.Inject

class EmailService @Inject constructor(){
    fun send(sender: String, receiver: String, body: String) {
        Log.d(TAG, "Email is sent from $sender to $receiver and message is :- $body")
    }
}