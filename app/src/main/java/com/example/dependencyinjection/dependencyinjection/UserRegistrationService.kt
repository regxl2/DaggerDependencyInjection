package com.example.dependencyinjection.dependencyinjection

import javax.inject.Inject

// by using Inject, Dagger able to know how to create the object of the class by using the constructor
// notice, on creating the object of the UserRegistrationService, we also need the object of the UserRepository
// and EmailService object. Therefore, we also need to annotate the Inject in EmailService and UserRepository class.
class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    private val emailService: EmailService
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "no-reply@gmail.com", "User Registered")
    }
}