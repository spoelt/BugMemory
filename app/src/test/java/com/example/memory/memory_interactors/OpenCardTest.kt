package com.example.memory.memory_interactors

import com.example.memory.data.OpenCardAllCardsClosed
import com.example.memory.data.OpenCardOneCardOpen
import com.example.memory.ui.components.CardFace
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Test

class OpenCardTest {
    // system in test
    private lateinit var openCard: OpenCard

    // data
    private val cardsAllClosed = OpenCardAllCardsClosed.data
    private val cardsOneCardOpen = OpenCardOneCardOpen.data

    @Test
    fun openCard_allCardsClosed_oneCardFaceFront() = runBlocking {
        openCard = OpenCard()

        // execute the use case
        val emissions = openCard.execute(index = 0, cards = cardsAllClosed).toList()

        assert(emissions[0].count { it.cardFace == CardFace.Front } == 1)
    }

    @Test
    fun openCard_oneCardOpen_twoCardFacesFront() = runBlocking {
        openCard = OpenCard()

        // execute the use case
        val emissions = openCard.execute(
            index = cardsOneCardOpen.size - 1,
            cards = cardsOneCardOpen
        ).toList()

        assert(emissions[0].count { it.cardFace == CardFace.Front } == 2)
    }
}