package com.example.portablequiz.data.entity

data class Question(
    val question: String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>,
)
