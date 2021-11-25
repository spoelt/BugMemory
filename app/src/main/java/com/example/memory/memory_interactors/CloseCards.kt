package com.example.memory.memory_interactors

import com.example.memory.domain.MemoryCard
import com.example.memory.ui.components.CardFace
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CloseCards {
    /*
     * @param index is the index of the card that should not be closed
     */
    fun execute(index: Int, cards: List<MemoryCard>): Flow<List<MemoryCard>> = flow {
        val updatedCards = cards.toMutableList().apply {
            onEachIndexed { idx, _ ->
                this[idx] = this[idx].copy(
                    cardFace = if (idx != index && !this[idx].isMatched && this[idx].cardFace == CardFace.Front) {
                        this[idx].cardFace.next
                    } else {
                        this[idx].cardFace
                    }
                )
            }
        }
        emit(updatedCards)
    }

}