package com.example.dependencyinjection.dependencyinjection

import android.util.Log
import com.example.dependencyinjection.TAG

interface AnalyticsService {
    fun trackEvent(eventName: String, eventType: String)
}

class MixPanel:AnalyticsService{
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d(TAG, "MixPanel - $eventName - $eventType")
    }
}

class FirebaseAnalytics: AnalyticsService{
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d(TAG, "FirebaseAnalytics - $eventName - $eventType")
    }
}