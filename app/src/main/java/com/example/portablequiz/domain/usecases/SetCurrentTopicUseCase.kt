package com.example.portablequiz.domain.usecases

import com.example.portablequiz.domain.repository.TopicRepository
import javax.inject.Inject

class SetCurrentTopicUseCase @Inject constructor(
    private val topicRepository: TopicRepository
) {
    fun execute(topic: String) {
        topicRepository.setCurrentTopic(topic)
    }
}