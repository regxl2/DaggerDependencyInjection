package com.example.dependencyinjection.dependencyinjection

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticsModule::class])
interface AppComponent {
//    fun getAnalyticsService(): AnalyticsService
//     here, we are explicitly  exposing the getAnalyticsService() method.
//     because UserRegistrationComponent is dependent on the AppComponent.
//     Suppose, If UserRegistrationComponent want to use many methods of the AppComponent.
//     then the we have to explicitly many methods.
//     Another approach could be making the UserRegistrationComponent the SubComponent of the
//     AppComponent and we now child can access the objects of the parent component.



//    Since, Factory is used to make the objects of the UserRegistrationComponent. So, we have to expose the
//    factory of the UserRegistrationComponent to the AppComponent, otherwise we could have used this given
//    approach: - fun getUserRegistrationComponent(): UserRegistrationComponent
    fun getUserRegistrationComponentFactory(): UserRegistrationComponent.Factory

}