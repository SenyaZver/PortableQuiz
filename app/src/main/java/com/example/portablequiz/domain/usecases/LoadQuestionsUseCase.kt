package com.example.portablequiz.domain.usecases

import com.example.portablequiz.domain.repository.QuestionsRepository
import javax.inject.Inject

class LoadQuestionsUseCase @Inject constructor(
    private val repository: QuestionsRepository
) {

    suspend fun execute() {
        repository.clear()
        repository.loadQuestions()
    }
}