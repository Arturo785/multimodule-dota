package com.example.ui_herolist.di


import com.example.core.Logger
import com.example.hero_interactors.FilterHeros
import com.example.hero_interactors.GetHeros
import com.example.hero_interactors.HeroInteractors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // takes the singleton scope which lives the entire lifeCycle of the app
object HeroListModule {


    // this provides the use case getHeroes
    /**
     * @param interactors is provided in app module.
     */
    @Provides
    @Singleton
    fun provideGetHeros(
        interactors: HeroInteractors
    ): GetHeros {
        return interactors.getHeros
    }

    /**
     * @param interactors is provided in app module.
     */
    @Provides
    @Singleton
    fun provideFilterHeroes(
        interactors: HeroInteractors
    ): FilterHeros {
        return interactors.filterHeros
    }


    // Each module could have it's own logger injected
    @Provides
    @Singleton
    @Named("heroListLogger")
    fun provideLogger(): Logger {
        return Logger.buildDebug(
            className = "HeroList",
        )
    }
}