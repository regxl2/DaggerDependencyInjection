package com.example.dependencyinjection.dependencyinjection

import dagger.Module
import dagger.Provides
import javax.inject.Singleton


//sometimes, we need the values at the runtime. for example, for creating room database instance, we need applicationContext
//which only available at the runtime. {val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database-count").build() }
//For, solving this problem there are 2 ways:-
//1. passing values in constructor of the module.
//2. By using component factory and bindsInstance annotation.

// Method 1:- passing values in constructor of the module.
//@Module
//class NotificationServiceModule(private val retryCount: Int){
//    // Whenever Dagger needs to provide an instance of type Notification,
//    // this code (the one inside the @Provides method) will be run.
//    // by using @Provides we don't need to apply @Inject annotation in the construction
//    // of the class while in @Binds annotation we need to apply inject annotation.
//    @Provides
//    fun getMessageService(): NotificationService{
//        return MessageService(retryCount)
//    }
//}

//Method 2:- by using component factory and bindsInstance annotation.
@Module
class NotificationServiceModule(){
    // Whenever Dagger needs to provide an instance of type Notification,
    // this code (the one inside the @Provides method) will be run.
    // by using @Provides we don't need to apply @Inject annotation in the construction
    // of the class while in @Binds annotation we need to apply inject annotation.

    @Provides
    fun getMessageService(retryCount: Int): NotificationService{
        // even if retryCount variable name is different it will be passed here.
        return MessageService(retryCount)
    }
}