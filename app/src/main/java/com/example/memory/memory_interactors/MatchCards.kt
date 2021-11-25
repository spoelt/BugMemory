package com.example.memory.memory_interactors

import com.example.memory.constants.EMPTY_STRING
import com.example.memory.domain.MemoryCard
import com.example.memory.ui.components.CardFace
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MatchCards {

    fun execute(cards: List<MemoryCard>): Flow<List<MemoryCard>> = flow {
        val openCards = cards.filter { it.cardFace == CardFace.Front && !it.isMatched }
        val firstCard = openCards.firstOrNull()
        val secondCard = openCards.lastOrNull()
        val isMatched = firstCard?.bugType == secondCard?.bugType

        val updatedCards = cards.toMutableList().apply {
            onEachIndexed { idx, _ ->
                this[idx] = this[idx].copy(
                    isMatched = if (shouldCurrentCardBeChecked(
                            index = idx,
                            firstId = firstCard?.id ?: EMPTY_STRING,
                            secondId = secondCard?.id ?: EMPTY_STRING,
                            cards = cards
                        )
                    ) {
                        isMatched
                    } else {
                        this[idx].isMatched
                    }
                )
            }
        }

        emit(updatedCards)
    }

    private fun shouldCurrentCardBeChecked(
        index: Int,
        firstId: String,
        secondId: String,
        cards: List<MemoryCard>
    ): Boolean {
        return index == getIndexOfCard(firstId, cards) || index == getIndexOfCard(secondId, cards)
    }

    private fun getIndexOfCard(cardId: String, cards: List<MemoryCard>): Int =
        cards.indexOfFirst { it.id == cardId }

}