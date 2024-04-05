package com.example.portablequiz.data.repository

import com.example.portablequiz.domain.repository.ResultRepository

class ResultRepositoryImpl: ResultRepository {
    private var rightAnswersAmount = 0


    override fun getResult(): Int {
        return rightAnswersAmount
    }

    override fun saveResult(correctAnswers: Int) {
        rightAnswersAmount = correctAnswers
    }

}