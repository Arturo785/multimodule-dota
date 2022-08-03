package com.codingwithmitch.dotainfo.di

import com.example.core.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // takes the singleton scope which lives the entire lifeCycle of the app
object AppModule {

    @Provides
    @Singleton
    fun provideLogger(): Logger {
        return Logger.buildDebug(
            className = "AppDebug"
        )
    }

}