package com.example.portablequiz.domain.repository

interface TopicRepository {
    fun getCurrentTopic(): String
    fun setCurrentTopic(topic: String)
}