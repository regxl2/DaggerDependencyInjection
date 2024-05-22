package com.example.dependencyinjection.dependencyinjection

import android.util.Log
import com.example.dependencyinjection.TAG
import javax.inject.Inject


interface NotificationService{
    fun send(sender: String, receiver: String, body: String)
}

class EmailService @Inject constructor(): NotificationService{
    override fun send(sender: String, receiver: String, body: String) {
        Log.d(TAG, "Email is sent from $sender to $receiver and message is :- $body")
    }
}

class MessageService: NotificationService{
    override fun send(sender: String, receiver: String, body: String) {
        Log.d(TAG, "Message is sent from $sender to $receiver and message is :- $body")
    }

}