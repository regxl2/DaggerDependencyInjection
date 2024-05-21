package com.example.dependencyinjection.dependencyinjection

import com.example.dependencyinjection.MainActivity
import dagger.Component

@Component
interface UserRegistrationComponent {
//    Chapter2:- construction injection
//    fun getUserRegistrationService() : UserRegistrationService


//    Chapter3:- field injection
//    for field injection, in function we pass the consumer as a parameter.
//    Name of the function could be anything.
    fun inject(mainActivity: MainActivity)
}