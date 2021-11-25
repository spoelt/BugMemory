package com.example.memory.memory_interactors

data class MemoryInteractors(
    val getCards: GetCards,
    val openCard: OpenCard,
    val matchCards: MatchCards,
    val closeCards: CloseCards
) {
    companion object Factory {
        fun build(): MemoryInteractors {
            return MemoryInteractors(
                getCards = GetCards(),
                openCard = OpenCard(),
                matchCards = MatchCards(),
                closeCards = CloseCards()
            )
        }
    }
}
