package com.example.memory.memory_interactors

import com.example.memory.data.CloseCardsOpenCardsMatching
import com.example.memory.data.CloseCardsOpenCardsNotMatching
import com.example.memory.ui.components.CardFace
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CloseCardsTest {
    // system in test
    private lateinit var closeCards: CloseCards

    // data
    private val cardsNotMatching = CloseCardsOpenCardsNotMatching.data
    private val cardsMatching = CloseCardsOpenCardsMatching.data

    @Test
    fun close_NonMatchingCardsAreClosed() = runBlocking {
        closeCards = CloseCards()

        // execute the use case
        val emissions = closeCards.execute(index = 2, cards = cardsNotMatching).toList()

        assert(emissions[0].count { it.cardFace == CardFace.Front } == 1)
    }

    @Test
    fun close_KeepMatchingCardsOpen() = runBlocking {
        closeCards = CloseCards()

        // execute the use case
        val emissions = closeCards.execute(index = 0, cards = cardsMatching).toList()

        assert(emissions[0].count { it.cardFace == CardFace.Front } == 3)
    }
}