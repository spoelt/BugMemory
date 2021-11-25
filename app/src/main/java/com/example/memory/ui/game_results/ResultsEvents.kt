package com.example.memory.ui.game_results

import com.example.memory.domain.GameResult

sealed class ResultsEvents {

    data class GetParams(val result: GameResult) : ResultsEvents()

    object RestartGame : ResultsEvents()

}