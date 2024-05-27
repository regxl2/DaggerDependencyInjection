package com.example.dependencyinjection.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.dependencyinjection.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Component.Factory
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun getMap(): Map<Class<*>, ViewModel>

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}