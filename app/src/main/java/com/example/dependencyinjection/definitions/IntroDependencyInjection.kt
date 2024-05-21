package com.example.dependencyinjection.definitions

//Dependency Injection means providing the services to client from the outside

// There are three fundamental techniques of Dependency Injection
// 1. Constructor Injection
// 2. Method Injection
// 3. Field Injection ( property in kotlin )

class Service1
class Service2
class Service3

class Client(private val service1: Service1){
    private var service2: Service2? = null

    var service3: Service3? = null

    fun setService2(service2: Service2){
        this.service2 = service2
    }
}

fun main(){
    val service1 = Service1()
    val service2 = Service2()
    val service3 = Service3()
    val client  = Client(service1)// This is constructor injection
    client.setService2(service2) // This is Method Injection
    client.service3 = service3 // This is Field Injection
}