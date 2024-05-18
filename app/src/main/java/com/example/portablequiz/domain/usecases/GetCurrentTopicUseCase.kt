package com.example.portablequiz.domain.usecases

import com.example.portablequiz.domain.repository.TopicRepository
import javax.inject.Inject

class GetCurrentTopicUseCase @Inject constructor(
    private val topicRepository: TopicRepository
) {
    fun execute(): String {
        return topicRepository.getCurrentTopic()
    }
}