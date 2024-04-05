package com.example.portablequiz.domain.usecases

import com.example.portablequiz.domain.repository.ResultRepository
import javax.inject.Inject

class SaveScoreUseCase @Inject constructor(
    private val resultRepository: ResultRepository
){

    fun execute(score: Int) {
        resultRepository.saveResult(score)
    }
}