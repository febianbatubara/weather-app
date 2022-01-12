package com.android.febian.weatherapp.di

import android.app.Application
import com.android.febian.weatherapp.data.source.local.LocalRepository
import com.android.febian.weatherapp.data.source.local.room.WeatherDao
import com.android.febian.weatherapp.data.source.local.room.WeatherDatabase
import com.android.febian.weatherapp.data.source.remote.RemoteRepository
import com.android.febian.weatherapp.data.source.remote.endpoint.Endpoint
import com.android.febian.weatherapp.utils.AppExecutors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object WeatherModule {

    @Provides
    fun provideDatabase(application: Application): WeatherDatabase {
        return WeatherDatabase.getInstance(application)
    }

    @Provides
    fun provideDao(catalogDatabase: WeatherDatabase): WeatherDao {
        return catalogDatabase.weatherDao()
    }

    @Provides
    fun provideRemoteRepository(endpoint: Endpoint): RemoteRepository {
        return RemoteRepository(endpoint)
    }

    @Provides
    fun provideLocalRepository(weatherDao: WeatherDao): LocalRepository {
        return LocalRepository(weatherDao)
    }

    @Provides
    fun provideAppExecutor(): AppExecutors {
        return AppExecutors()
    }
}