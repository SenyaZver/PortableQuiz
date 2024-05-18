package com.example.portablequiz.presentation.quiz_screen

import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.portablequiz.data.entity.Question
import com.example.portablequiz.domain.usecases.GetCurrentTopicUseCase
import com.example.portablequiz.domain.usecases.GetQuestionUseCase
import com.example.portablequiz.domain.usecases.LoadQuestionsUseCase
import com.example.portablequiz.domain.usecases.SaveScoreUseCase
import com.example.portablequiz.presentation.theme.Primary
import com.example.portablequiz.utils.Constants.questionsAmount
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.update
import com.example.portablequiz.utils.Result


@HiltViewModel
class QuizScreenViewModel @Inject constructor(
    private val loadQuestionsUseCase: LoadQuestionsUseCase,
    private val getQuestionUseCase: GetQuestionUseCase,
    private val saveScoreUseCase: SaveScoreUseCase,
    private val getCurrentTopicUseCase: GetCurrentTopicUseCase
): ViewModel() {
    private val _state = MutableStateFlow(QuizScreenData())
    val state = _state.asStateFlow()


    init {
        viewModelScope.launch {
            val currentTopic = getCurrentTopicUseCase.execute()
            loadQuestionsUseCase.execute(currentTopic)

            loadQuestion(0)
        }

    }

    fun changeQuestion() {
        if (state.value.currentQuestionNumber == questionsAmount - 1) {
            _state.update {
                it.copy(
                    gameOver = true
                )
            }
            return
        }

        val currentQuestionNumber = _state.value.currentQuestionNumber + 1

        if (currentQuestionNumber >= questionsAmount) {
            return
        }

        loadQuestion(currentQuestionNumber)

    }

    private fun loadQuestion(index: Int) {
        viewModelScope.launch {
            getQuestionUseCase.execute(index = index).collect {result ->
                when (result) {
                    is Result.Error -> {
                        Log.d("debug", result.message.toString())
                    }
                    is Result.Loading -> {

                    }
                    is Result.Success -> {
                        val data: Question = result.data!!

                        val allAnswers = mutableListOf(data.correctAnswer)
                        allAnswers.addAll(data.incorrectAnswers)
                        allAnswers.shuffle()

                        val correctAnswerIndex = allAnswers.indexOf(data.correctAnswer)


                        _state.update {
                            it.copy(
                                question = data.question,
                                answers = allAnswers,
                                correctAnswer = correctAnswerIndex,
                                currentQuestionNumber = index,
                                answerIsChosen = false,
                                colors = listOf(Primary, Primary, Primary, Primary)
                            )
                        }
                    }
                }

            }
        }

    }

    fun chooseAnswer(index: Int) {
        if (_state.value.answerIsChosen) {
            return
        }

        var correctAnswers = _state.value.correctAnswersAmount
        if (index == _state.value.correctAnswer) {
            correctAnswers++
        }

        val newColors = mutableListOf(
            Color.Red, Color.Red, Color.Red, Color.Red
        )
        newColors[state.value.correctAnswer] = Color.Green

        _state.update {
            it.copy(
                correctAnswersAmount = correctAnswers,
                colors = newColors,
                answerIsChosen = true
            )
        }


    }

    fun saveScore() {
        saveScoreUseCase.execute(_state.value.correctAnswersAmount)
    }
}