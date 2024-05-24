package com.example.dependencyinjection.dependencyinjection

import com.example.dependencyinjection.MainActivity
import dagger.BindsInstance
import dagger.Component

//We want Dagger to create the graph of dependencies of our project, manage them for us and be able
//to get dependencies from the graph. To make Dagger do it, we need to create an interface and annotate it
//with @Component. Dagger will create a Container as we would have done with manual dependency injection.
//An interface annotated with @Component will make Dagger generate code with all the dependencies required
//to satisfy the parameters of the methods it exposes.

@Component(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory{
        // here, name of the create function could be anything but it is standard to have name create.
        fun create(@BindsInstance retryCount: Int): UserRegistrationComponent
    }
}