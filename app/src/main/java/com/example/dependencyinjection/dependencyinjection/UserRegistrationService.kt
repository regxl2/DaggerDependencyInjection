package com.example.dependencyinjection.dependencyinjection

import javax.inject.Inject
import javax.inject.Named

//Suppose, In UserRegistrationService instead of EmailService, we want to pass MessageService
//to make it loosely coupled we will make interface and make EmailService and MessageService implement
//that interface. In the same way, if we want to pass the SQLRepository and FirebaseRepository in the
// UserRepository, we implement the interface

// By using the NotificationService Dagger will not be able to differentiate which object to
// use either MessageService or EmailService. Similarly, Dagger will not be able to differentiate
// which object to use. For that we need to use Modules, Provides and Binds

class UserRegistrationService @Inject constructor(
    @SQLQualifier private val userRepository: UserRepository,
     private val service: NotificationService
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        service.send(email, "no-reply@gmail.com", "User Registered")
    }
}