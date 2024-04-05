package com.example.portablequiz.domain.usecases

import com.example.portablequiz.domain.repository.ResultRepository
import javax.inject.Inject

class LoadResultUseCase  @Inject constructor(
    private val resultRepository: ResultRepository
){
    fun execute(): Int = resultRepository.getResult()
}