package com.example.portablequiz.data.repository

import com.example.portablequiz.domain.repository.TopicRepository
import com.example.portablequiz.utils.Constants.topics

class TopicRepositoryImpl: TopicRepository {
    private var currentTopic = topics[0]
    override fun getCurrentTopic(): String {
        return currentTopic
    }

    override fun setCurrentTopic(topic: String) {
        this.currentTopic = topic
    }
}