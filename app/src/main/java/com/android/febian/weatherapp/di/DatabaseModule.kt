package com.android.febian.weatherapp.di

import android.app.Application
import com.android.febian.weatherapp.data.source.local.room.WeatherDao
import com.android.febian.weatherapp.data.source.local.room.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(application: Application): WeatherDatabase {
        return WeatherDatabase.getInstance(application)
    }

    @Provides
    fun provideDao(catalogDatabase: WeatherDatabase): WeatherDao {
        return catalogDatabase.weatherDao()
    }
}