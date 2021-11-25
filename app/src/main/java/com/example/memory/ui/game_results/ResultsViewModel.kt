package com.example.memory.ui.game_results

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.memory.domain.GameResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val state = mutableStateOf(ResultsState())

    init {
        savedStateHandle.get<Int>("moves")?.let { moves ->
            savedStateHandle.get<Long>("elapsedTime")?.let { time ->
                onTriggerEvent(ResultsEvents.GetParams(GameResult(moves, time)))
            }
        }
    }

    private fun onTriggerEvent(event: ResultsEvents) {
        when (event) {
            ResultsEvents.RestartGame -> restartGame()
            is ResultsEvents.GetParams -> updateParams(event.result)
        }
    }

    private fun restartGame() {
        state.value = state.value.copy(playAgain = true)
    }

    private fun updateParams(result: GameResult) {
        state.value = state.value.copy(result = result)
    }
}