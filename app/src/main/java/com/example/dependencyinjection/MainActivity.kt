package com.example.dependencyinjection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dependencyinjection.dependencyinjection.DaggerUserRegistrationComponent
import com.example.dependencyinjection.dependencyinjection.NotificationServiceModule
import com.example.dependencyinjection.dependencyinjection.UserRegistrationService
import com.example.dependencyinjection.ui.theme.DependencyInjectionTheme
import javax.inject.Inject

const val TAG = "DependencyInjection"

class MainActivity : ComponentActivity() {
//    Inject annotation tells Dagger to inject the UserRegistrationService object in the field
    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DependencyInjectionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        // method1:- by passing the values in the constructor of the notification module.
        // There is one con of this approach is that if developer forget to call the
        // notificationService module in the component. This could be avoided by using Factories approach.
//        val component = DaggerUserRegistrationComponent.builder().notificationServiceModule(
//            NotificationServiceModule(3)
//        ).build()

        //method2:- by using component.factory and bindsInstance, in constructor we can only pass the value
        // of only one instance of a type not more than that otherwise it will give error.
        val component = DaggerUserRegistrationComponent.factory().create(3)
        component.inject(this)
        userRegistrationService.registerUser("abhi@gmail.com", "user registered")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DependencyInjectionTheme {
        Greeting("Android")
    }
}