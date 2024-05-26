package com.example.dependencyinjection.dependencyinjection

import com.example.dependencyinjection.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

//We want Dagger to create the graph of dependencies of our project, manage them for us and be able
//to get dependencies from the graph. To make Dagger do it, we need to create an interface and annotate it
//with @Component. Dagger will create a Container as we would have done with manual dependency injection.
//An interface annotated with @Component will make Dagger generate code with all the dependencies required
//to satisfy the parameters of the methods it exposes.


// For each component use different scope otherwise it will create error.
// Since, i used @Singleton annotation for AppComponent, then i cannot
// use @Singleton annotation for the UserRegistrationComponent. For that
// You have make custom annotation.
@ActivityScope
@Subcomponent(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {
    fun inject(mainActivity: MainActivity)

//    @Subcomponent.Factory
//    interface Factory{
//        // here, name of the create function could be anything but it is standard to have name create.
//        fun create(@BindsInstance retryCount: Int): UserRegistrationComponent
//    }

//    Alternative of the factory is the builder
    @Subcomponent.Builder
    interface Builder{
        // In Builder, interface it is necessary to have build() function which will
        // return UserRegistrationComponent.
        fun build(): UserRegistrationComponent

        //All other function will return should return Builder.
        fun retryCount(@BindsInstance retryCount: Int): Builder
    }
}