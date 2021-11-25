package com.example.memory.memory_interactors

import com.example.memory.R
import com.example.memory.domain.BugType.*
import com.example.memory.domain.MemoryCard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCards {

    fun execute(): Flow<List<MemoryCard>> = flow {
        val shuffledCards = listOf(
            MemoryCard(bugType = GREY_GARDEN_BUG, frontImageId = R.drawable.grey_garden_bug),
            MemoryCard(bugType = GREY_GARDEN_BUG, frontImageId = R.drawable.grey_garden_bug),
            MemoryCard(bugType = LADY_BUG, frontImageId = R.drawable.lady_bug),
            MemoryCard(bugType = LADY_BUG, frontImageId = R.drawable.lady_bug),
            MemoryCard(bugType = PURPLE_FRUIT_BUG, frontImageId = R.drawable.purple_fruit_bug),
            MemoryCard(bugType = PURPLE_FRUIT_BUG, frontImageId = R.drawable.purple_fruit_bug),
            MemoryCard(bugType = RANDOM_BUG, frontImageId = R.drawable.random_bug),
            MemoryCard(bugType = RANDOM_BUG, frontImageId = R.drawable.random_bug),
            MemoryCard(bugType = STRIPPED_BUG, frontImageId = R.drawable.striped_bug),
            MemoryCard(bugType = STRIPPED_BUG, frontImageId = R.drawable.striped_bug),
            MemoryCard(bugType = COCKROACH, frontImageId = R.drawable.cockroach),
            MemoryCard(bugType = COCKROACH, frontImageId = R.drawable.cockroach),
            MemoryCard(bugType = NETTLE, frontImageId = R.drawable.nettle),
            MemoryCard(bugType = NETTLE, frontImageId = R.drawable.nettle),
            MemoryCard(bugType = SPOTTED_LONGHORN, frontImageId = R.drawable.spotted_longhorn),
            MemoryCard(bugType = SPOTTED_LONGHORN, frontImageId = R.drawable.spotted_longhorn)
        ).shuffled()

        emit(shuffledCards)
    }

}