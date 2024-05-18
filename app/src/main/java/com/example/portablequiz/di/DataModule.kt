package com.example.portablequiz.di

import com.example.portablequiz.data.Api
import com.example.portablequiz.data.repository.QuestionsRepositoryImpl
import com.example.portablequiz.data.repository.ResultRepositoryImpl
import com.example.portablequiz.data.repository.TopicRepositoryImpl
import com.example.portablequiz.domain.repository.QuestionsRepository
import com.example.portablequiz.domain.repository.ResultRepository
import com.example.portablequiz.domain.repository.TopicRepository
import com.example.portablequiz.utils.Constants.baseURL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    @Singleton
    fun getApi(): Api {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }


    @Provides
    @Singleton
    fun getResultRepository(): ResultRepository {
        return ResultRepositoryImpl()
    }

    @Provides
    @Singleton
    fun getQuestionsRepository(api : Api): QuestionsRepository {
        return QuestionsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun getTopicRepository(): TopicRepository {
        return TopicRepositoryImpl()
    }
}