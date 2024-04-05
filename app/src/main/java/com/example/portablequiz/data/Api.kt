package com.example.portablequiz.data

import com.example.portablequiz.data.entity.Question
import com.example.portablequiz.utils.Constants.questionsAmount
import com.example.portablequiz.utils.Constants.topic
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/api/questions")
    suspend fun getQuestions(
        @Query("categories") category: String = topic,
        @Query("difficulty") difficulty: String = "easy",
        @Query("limit") limit: Int = questionsAmount
    ): List<Question>
}