package com.example.dependencyinjection.dependencyinjection

import android.util.Log
import com.example.dependencyinjection.TAG
import javax.inject.Inject
import javax.inject.Singleton


interface NotificationService{
    fun send(sender: String, receiver: String, body: String)
}

class EmailService @Inject constructor(): NotificationService{
    override fun send(sender: String, receiver: String, body: String) {
        Log.d(TAG, "Email is sent from $sender to $receiver and message is :- $body")
    }
}

// @Singleton:- It ensures only one object is created of the Class.
// and we have to also annotate its calling component with singleton.
// this is the way to annotate in the @provides and @Binds
// Sometime, we don't have access to class in that case,
// we have to add @Singleton annotation to the method in module which creates the object
// of the class.
@ActivityScope
class MessageService @Inject constructor(private val retryCount: Int): NotificationService{
    override fun send(sender: String, receiver: String, body: String) {
        Log.d(TAG, "Message is sent from $sender to $receiver and message is :- $body and retry count is $retryCount")
    }

}