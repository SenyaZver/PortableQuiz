package com.example.portablequiz.domain.repository

import com.example.portablequiz.data.entity.Question

interface QuestionsRepository {
    suspend fun loadQuestions()

    suspend fun getQuestion(index: Int): Question?

    fun clear()
}