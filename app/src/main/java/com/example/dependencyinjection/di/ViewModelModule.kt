package com.example.dependencyinjection.di

import androidx.lifecycle.ViewModel
import com.example.dependencyinjection.viewmodels.MainViewModel
import com.example.dependencyinjection.viewmodels.MainViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @ClassKey(MainViewModel2::class)
    @IntoMap
    abstract fun provideMainViewModel2(mainViewModel2: MainViewModel2): ViewModel
}