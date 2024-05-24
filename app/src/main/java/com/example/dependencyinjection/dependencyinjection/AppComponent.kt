package com.example.dependencyinjection.dependencyinjection

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticsModule::class])
interface AppComponent {
    fun getAnalyticsService(): AnalyticsService
}