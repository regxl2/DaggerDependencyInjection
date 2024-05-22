package com.example.dependencyinjection.dependencyinjection

import dagger.Module
import dagger.Provides

@Module
class NotificationServiceModule {
    // Whenever Dagger needs to provide an instance of type Notification,
    // this code (the one inside the @Provides method) will be run.
    // by using @Provides we don't need to apply @Inject annotation in the construction
    // of the class while in @Binds annotation we need to apply inject annotation.
    @Provides
    fun getMessageService(): NotificationService{
        return MessageService()
    }
}