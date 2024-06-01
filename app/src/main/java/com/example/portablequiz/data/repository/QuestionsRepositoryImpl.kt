package com.example.portablequiz.data.repository

import com.example.portablequiz.data.Api
import com.example.portablequiz.data.entity.Question
import com.example.portablequiz.domain.repository.QuestionsRepository
import javax.inject.Inject

class QuestionsRepositoryImpl @Inject constructor(
    private val api: Api
) : QuestionsRepository {
    private val questionsList: MutableList<Question> = mutableListOf()

    override suspend fun loadQuestions(topic: String) {
        val questions = api.getQuestions(category = topic)

        questionsList.addAll(questions)

    }

    override suspend fun getQuestion(index: Int): Question? {
        if (index > questionsList.lastIndex) {
            return null
        }
        return questionsList[index]
    }

    override fun clear() {
        questionsList.clear()
    }
}