package com.nebsan.roverchallenge.di

import android.content.Context
import com.nebsan.roverchallenge.data.repository.RoverParser
import com.nebsan.roverchallenge.data.repository.RoverRepositoryImpl
import com.nebsan.roverchallenge.domain.repository.RoverRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRoverRepository(
        @ApplicationContext appContext: Context,
        roverParser: RoverParser,
    ): RoverRepository {
        return RoverRepositoryImpl(appContext, roverParser)
    }

    @Provides
    fun provideRoverParser(): RoverParser = RoverParser()
}