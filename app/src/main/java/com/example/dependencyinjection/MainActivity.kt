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
        // By initializing the component at the application. We made the singleton
        // scope at the application level.
        val appComponent = (application as MyApplication).appComponent
        val userRegistrationComponent = appComponent.getUserRegistrationComponentFactory().create(3)
        userRegistrationComponent.inject(this)
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