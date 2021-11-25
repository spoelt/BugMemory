package com.example.memory.ui.memory_game

sealed class MemoryGameEvents {

    object GetCards : MemoryGameEvents()

    data class HandleClickedCard(val index: Int) : MemoryGameEvents()

}
