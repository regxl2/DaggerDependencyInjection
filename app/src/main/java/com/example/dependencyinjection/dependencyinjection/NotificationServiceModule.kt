package com.example.dependencyinjection.dependencyinjection

import dagger.Module
import dagger.Provides

@Module
class NotificationModule {
    @Provides
    fun getEmailService(): NotificationService{
        return EmailService()
    }
}