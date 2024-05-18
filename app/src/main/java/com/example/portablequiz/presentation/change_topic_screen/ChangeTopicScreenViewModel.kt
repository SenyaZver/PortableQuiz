package com.example.portablequiz.presentation.change_topic_screen

import androidx.lifecycle.ViewModel
import com.example.portablequiz.domain.usecases.GetCurrentTopicUseCase
import com.example.portablequiz.domain.usecases.SetCurrentTopicUseCase
import com.example.portablequiz.utils.Constants.topics
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class ChangeTopicScreenViewModel @Inject constructor(
    private val setCurrentTopicUseCase: SetCurrentTopicUseCase,
    private val getCurrentTopicUseCase: GetCurrentTopicUseCase
): ViewModel(){
    private val _state = MutableStateFlow(ChangeTopicScreenData())
    val state = _state.asStateFlow()
    init {
        val currentTopic = getCurrentTopicUseCase.execute()

        _state.update {
            it.copy(
                chosenTopicIndex = topics.indexOf(currentTopic)
            )
        }
    }

    fun setTopic(index: Int) {
        val topic = topics[index]
        setCurrentTopicUseCase.execute(topic)

        _state.update {
            it.copy(
                chosenTopicIndex = index
            )
        }
    }
}