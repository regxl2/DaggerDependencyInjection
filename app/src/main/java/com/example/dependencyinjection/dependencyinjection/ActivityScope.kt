package com.example.dependencyinjection.dependencyinjection

import javax.inject.Scope

// scope:- It tells us the class wil be singleton
@Scope
@MustBeDocumented
@Retention(value= AnnotationRetention.RUNTIME)
annotation class ActivityScope()
