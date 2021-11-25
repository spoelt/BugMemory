package com.example.memory.memory_interactors

import com.example.memory.data.MatchCardsOpenCardsMatching
import com.example.memory.data.MatchCardsOpenCardsNotMatching
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Test

class MatchCardsTest {
    // system in test
    private lateinit var matchCards: MatchCards

    // data
    private val cardsNotMatching = MatchCardsOpenCardsNotMatching.data
    private val cardsMatching = MatchCardsOpenCardsMatching.data

    @Test
    fun matchCards_cardsNotMatching_noMatchesInCardSet() = runBlocking {
        matchCards = MatchCards()

        // execute the use case
        val emissions = matchCards.execute(cards = cardsNotMatching).toList()

        assert(emissions[0].all { !it.isMatched })
    }

    @Test
    fun matchCards_twoCardsMatching_isMatchedFlagChanged() = runBlocking {
        matchCards = MatchCards()

        // execute the use case
        val emissions = matchCards.execute(cards = cardsMatching).toList()

        assert(emissions[0].count { it.isMatched } == 2)
    }
}