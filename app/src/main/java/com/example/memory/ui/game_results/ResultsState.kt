package com.example.memory.ui.game_results

import com.example.memory.domain.GameResult

data class ResultsState(
    val result: GameResult = GameResult(moves = 0, elapsedTime = 0L),
    val playAgain: Boolean = false
)