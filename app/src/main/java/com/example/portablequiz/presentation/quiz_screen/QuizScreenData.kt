package com.example.portablequiz.presentation.quiz_screen

import androidx.compose.ui.graphics.Color
import com.example.portablequiz.presentation.theme.Primary

data class QuizScreenData (
    val question: String = "",
    val answers: List<String>? = null,
    val correctAnswer: Int = 0,
    val currentQuestionNumber: Int = 0,

    val answerIsChosen: Boolean = false,
    val correctAnswersAmount: Int = 0,
    val colors: List<Color> = listOf(Primary, Primary, Primary, Primary),

    val gameOver: Boolean = false
)