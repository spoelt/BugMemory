package com.example.memory.ui.memory_game

import com.example.memory.domain.AnimationState
import com.example.memory.domain.MemoryCard

data class MemoryGameState(
    val cards: List<MemoryCard> = listOf(),
    val confettiRainState: AnimationState = AnimationState.Idle,
    val moves: Int = 0,
    val elapsedTime: Long = 0L
)