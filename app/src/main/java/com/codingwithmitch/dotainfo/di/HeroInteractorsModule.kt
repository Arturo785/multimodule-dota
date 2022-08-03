package com.codingwithmitch.dotainfo.di

import android.app.Application
import com.example.hero_interactors.HeroInteractors
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

// here goes the dependencies needed for this module in specific such as the driver

@Module
@InstallIn(SingletonComponent::class) // takes the singleton scope which lives the entire lifeCycle of the app
object HeroInteractorsModule {


    @Provides
    @Singleton
    @Named("heroAndroidSqlDriver") // in case you had another SQL Delight db
    fun provideAndroidDriver(app: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = HeroInteractors.schema,
            context = app,
            name = HeroInteractors.dbName
        )
    }

    /**
     * Provide all the interactors in hero-interactors module
     */
    @Provides
    @Singleton
    fun provideHeroInteractors(
        @Named("heroAndroidSqlDriver") sqlDriver: SqlDriver,
    ): HeroInteractors {
        return HeroInteractors.build(sqlDriver)
    }

}