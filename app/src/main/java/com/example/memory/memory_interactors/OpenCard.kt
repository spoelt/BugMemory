package com.example.memory.memory_interactors

import com.example.memory.domain.MemoryCard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OpenCard {

    fun execute(index: Int, cards: List<MemoryCard>): Flow<List<MemoryCard>> = flow {
        val updatedCards = cards.toMutableList().apply {
            this[index] = this[index].copy(
                cardFace = this[index].cardFace.next
            )
        }
        emit(updatedCards)
    }

}