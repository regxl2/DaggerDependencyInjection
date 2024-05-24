package com.example.dependencyinjection.dependencyinjection

import dagger.Module
import dagger.Provides
import javax.inject.Named


//Named annotations and Qualifiers are useful when you want to add
//different implementations of the same type to the Dagger graph.
//for example, in this example we need both FirebaseRepository and SQLRepository
//implementation.

// Problems of the using Named annotations are the typos developer can
// make mistakes by using named annotations, for solving the typos
// problem we can use of qualifiers

@Module
class UserRepositoryModule {
//     Whenever Dagger needs to provide an instance of type UserRepository,
//     this code (the one inside the @Provides method) will be run.
    @Named("firebase")
    @Provides
    fun getFirebaseRepository(analyticsService: AnalyticsService): UserRepository{
        return FirebaseRepository(analyticsService)
    }

//    Bind annotation simulation using Provide annotation
//    You can we made custom annotation that is Qualifier which will solve the problem
//    of typos.
    @SQLQualifier
    @Provides
    fun getSQLRepository(sqlRepository: SQLRepository): UserRepository{
        return sqlRepository
    }
}