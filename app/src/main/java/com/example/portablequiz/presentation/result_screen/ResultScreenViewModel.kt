package com.example.portablequiz.presentation.result_screen

import androidx.lifecycle.ViewModel
import com.example.portablequiz.domain.usecases.LoadResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ResultScreenViewModel @Inject constructor(
    private val loadResultUseCase: LoadResultUseCase
): ViewModel() {
    private val _state = MutableStateFlow(ResultData())
    val state = _state.asStateFlow()


    init {
        val correctAnswers = loadResultUseCase.execute()
        _state.update {
            it.copy(
                correctAnswersAmount = correctAnswers
            )
        }
    }
}