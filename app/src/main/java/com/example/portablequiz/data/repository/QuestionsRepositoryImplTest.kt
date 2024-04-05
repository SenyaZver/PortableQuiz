package com.example.portablequiz.data.repository

import com.example.portablequiz.data.entity.Question
import com.example.portablequiz.domain.repository.QuestionsRepository
import com.example.portablequiz.utils.Constants.questionsAmount
import kotlinx.coroutines.delay

class QuestionsRepositoryImplTest: QuestionsRepository {
    private val questionsList: MutableList<Question> = mutableListOf()



    override suspend fun loadQuestions() {
        delay(1000L)

        for (i in 0 until questionsAmount) {
            questionsList.add(
                Question(
                    question = "Question ${i+1}?",
                    correctAnswer = "Answer 1",
                    incorrectAnswers = listOf(
                        "Answer 2", "Answer 3", "Answer 4"
                    )
                ),
            )
        }

    }

    override suspend fun getQuestion(index: Int): Question? {
        return questionsList[index]
    }

    override fun clear() {
        questionsList.clear()
    }

}