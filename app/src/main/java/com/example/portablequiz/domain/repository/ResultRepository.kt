package com.example.portablequiz.domain.repository

interface ResultRepository {

    fun getResult(): Int

    fun saveResult(correctAnswers: Int)


}