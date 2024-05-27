package com.example.dependencyinjection

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.dependencyinjection.ui.theme.DependencyInjectionTheme
import com.example.dependencyinjection.viewmodels.MainViewModel
import com.example.dependencyinjection.viewmodels.MainViewModelFactory
import com.example.dependencyinjection.viewmodels.ProductUiState
import javax.inject.Inject

const val TAG = "DependencyInjection"
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val applicationComponent = (application as MyApplication).applicationComponent
        applicationComponent.inject(this)
        viewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)
        setContent {
            DependencyInjectionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    when (val productUiState = viewModel.productUiState.value){
                        is ProductUiState.Loading -> Greeting(name = "Loading...", modifier = Modifier.padding(it))
                        is ProductUiState.Success -> Greeting(name = productUiState.productList.toString(),modifier = Modifier.padding(it))
                        is ProductUiState.Error -> Greeting(name = "Something went wrong", modifier = Modifier.padding(it))
                    }
                }
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier.verticalScroll(rememberScrollState())
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DependencyInjectionTheme {
        Greeting("Android")
    }
}