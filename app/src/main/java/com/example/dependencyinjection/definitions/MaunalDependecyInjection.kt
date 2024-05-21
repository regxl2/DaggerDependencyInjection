package com.example.dependencyinjection.definitions

class UserRepositoryM {
    fun saveUser(name: String, password: String) {
        println("saved the user")
    }
}

class EmailServiceM {
    fun send(sender: String, receiver: String, body: String) {
        println("Email is sent from $sender to $receiver and message is :- $body")
    }
}

class UserRegistrationServiceM(
    private val userRepository: UserRepositoryM,
    private val emailService: EmailServiceM
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "no-reply@gmail.com", "User Registered")
    }
}

fun main() {
    val userRepository = UserRepositoryM()
    val emailService = EmailServiceM()
    // here, in this example we are manually injecting the classes in the constructor of the
    // userRegistrationService class.
    val userRegistrationService = UserRegistrationServiceM(userRepository, emailService)
    userRegistrationService.registerUser("abhi@gmail.com", "dependencyInjection")
}