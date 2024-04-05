package com.example.portablequiz.domain.usecases

import com.example.portablequiz.data.entity.Question
import com.example.portablequiz.domain.repository.QuestionsRepository
import com.example.portablequiz.utils.Result
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetQuestionUseCase @Inject constructor(
    private val repository: QuestionsRepository
) {
    fun execute(index: Int) = flow<Result<Question>> {
        emit(Result.Loading<Question>())

        val question = repository.getQuestion(index)

        if (question == null) {
            emit(
                Result.Error<Question>(
                    message = "No question found"
                )
            )
            return@flow
        }

        emit(
            Result.Success<Question>(
                data = question
            )
        )
    }
}