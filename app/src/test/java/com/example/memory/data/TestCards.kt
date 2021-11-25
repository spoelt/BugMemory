package com.example.memory.data

import com.example.memory.R
import com.example.memory.domain.BugType
import com.example.memory.domain.MemoryCard
import com.example.memory.ui.components.CardFace

object CloseCardsOpenCardsNotMatching {
    val data = listOf(
        MemoryCard(bugType = BugType.GREY_GARDEN_BUG, frontImageId = R.drawable.grey_garden_bug, cardFace = CardFace.Front),
        MemoryCard(bugType = BugType.GREY_GARDEN_BUG, frontImageId = R.drawable.grey_garden_bug),
        MemoryCard(bugType = BugType.LADY_BUG, frontImageId = R.drawable.lady_bug, cardFace = CardFace.Front),
        MemoryCard(bugType = BugType.LADY_BUG, frontImageId = R.drawable.lady_bug),
        MemoryCard(bugType = BugType.PURPLE_FRUIT_BUG, frontImageId = R.drawable.purple_fruit_bug),
        MemoryCard(bugType = BugType.PURPLE_FRUIT_BUG, frontImageId = R.drawable.purple_fruit_bug),
        MemoryCard(bugType = BugType.RANDOM_BUG, frontImageId = R.drawable.random_bug),
        MemoryCard(bugType = BugType.RANDOM_BUG, frontImageId = R.drawable.random_bug),
        MemoryCard(bugType = BugType.STRIPPED_BUG, frontImageId = R.drawable.striped_bug),
        MemoryCard(bugType = BugType.STRIPPED_BUG, frontImageId = R.drawable.striped_bug),
        MemoryCard(bugType = BugType.COCKROACH, frontImageId = R.drawable.cockroach),
        MemoryCard(bugType = BugType.COCKROACH, frontImageId = R.drawable.cockroach),
        MemoryCard(bugType = BugType.NETTLE, frontImageId = R.drawable.nettle),
        MemoryCard(bugType = BugType.NETTLE, frontImageId = R.drawable.nettle),
        MemoryCard(bugType = BugType.SPOTTED_LONGHORN, frontImageId = R.drawable.spotted_longhorn, cardFace = CardFace.Front),
        MemoryCard(bugType = BugType.SPOTTED_LONGHORN, frontImageId = R.drawable.spotted_longhorn)
    )
}

object CloseCardsOpenCardsMatching {
    val data = listOf(
        MemoryCard(bugType = BugType.GREY_GARDEN_BUG, frontImageId = R.drawable.grey_garden_bug, cardFace = CardFace.Front),
        MemoryCard(bugType = BugType.GREY_GARDEN_BUG, frontImageId = R.drawable.grey_garden_bug),
        MemoryCard(bugType = BugType.LADY_BUG, frontImageId = R.drawable.lady_bug),
        MemoryCard(bugType = BugType.LADY_BUG, frontImageId = R.drawable.lady_bug),
        MemoryCard(bugType = BugType.PURPLE_FRUIT_BUG, frontImageId = R.drawable.purple_fruit_bug, cardFace = CardFace.Front, isMatched = true),
        MemoryCard(bugType = BugType.PURPLE_FRUIT_BUG, frontImageId = R.drawable.purple_fruit_bug, cardFace = CardFace.Front, isMatched = true),
        MemoryCard(bugType = BugType.RANDOM_BUG, frontImageId = R.drawable.random_bug),
        MemoryCard(bugType = BugType.RANDOM_BUG, frontImageId = R.drawable.random_bug),
        MemoryCard(bugType = BugType.STRIPPED_BUG, frontImageId = R.drawable.striped_bug),
        MemoryCard(bugType = BugType.STRIPPED_BUG, frontImageId = R.drawable.striped_bug),
        MemoryCard(bugType = BugType.COCKROACH, frontImageId = R.drawable.cockroach),
        MemoryCard(bugType = BugType.COCKROACH, frontImageId = R.drawable.cockroach),
        MemoryCard(bugType = BugType.NETTLE, frontImageId = R.drawable.nettle),
        MemoryCard(bugType = BugType.NETTLE, frontImageId = R.drawable.nettle),
        MemoryCard(bugType = BugType.SPOTTED_LONGHORN, frontImageId = R.drawable.spotted_longhorn),
        MemoryCard(bugType = BugType.SPOTTED_LONGHORN, frontImageId = R.drawable.spotted_longhorn)
    )
}

object MatchCardsOpenCardsNotMatching {
    val data = listOf(
        MemoryCard(bugType = BugType.GREY_GARDEN_BUG, frontImageId = R.drawable.grey_garden_bug),
        MemoryCard(bugType = BugType.GREY_GARDEN_BUG, frontImageId = R.drawable.grey_garden_bug),
        MemoryCard(bugType = BugType.LADY_BUG, frontImageId = R.drawable.lady_bug),
        MemoryCard(bugType = BugType.LADY_BUG, frontImageId = R.drawable.lady_bug),
        MemoryCard(bugType = BugType.PURPLE_FRUIT_BUG, frontImageId = R.drawable.purple_fruit_bug),
        MemoryCard(bugType = BugType.PURPLE_FRUIT_BUG, frontImageId = R.drawable.purple_fruit_bug),
        MemoryCard(bugType = BugType.RANDOM_BUG, frontImageId = R.drawable.random_bug),
        MemoryCard(bugType = BugType.RANDOM_BUG, frontImageId = R.drawable.random_bug),
        MemoryCard(bugType = BugType.STRIPPED_BUG, frontImageId = R.drawable.striped_bug),
        MemoryCard(bugType = BugType.STRIPPED_BUG, frontImageId = R.drawable.striped_bug),
        MemoryCard(bugType = BugType.COCKROACH, frontImageId = R.drawable.cockroach, cardFace = CardFace.Front),
        MemoryCard(bugType = BugType.COCKROACH, frontImageId = R.drawable.cockroach),
        MemoryCard(bugType = BugType.NETTLE, frontImageId = R.drawable.nettle, cardFace = CardFace.Front),
        MemoryCard(bugType = BugType.NETTLE, frontImageId = R.drawable.nettle),
        MemoryCard(bugType = BugType.SPOTTED_LONGHORN, frontImageId = R.drawable.spotted_longhorn),
        MemoryCard(bugType = BugType.SPOTTED_LONGHORN, frontImageId = R.drawable.spotted_longhorn)
    )
}

object MatchCardsOpenCardsMatching {
    val data = listOf(
        MemoryCard(bugType = BugType.GREY_GARDEN_BUG, frontImageId = R.drawable.grey_garden_bug),
        MemoryCard(bugType = BugType.GREY_GARDEN_BUG, frontImageId = R.drawable.grey_garden_bug),
        MemoryCard(bugType = BugType.LADY_BUG, frontImageId = R.drawable.lady_bug),
        MemoryCard(bugType = BugType.LADY_BUG, frontImageId = R.drawable.lady_bug),
        MemoryCard(bugType = BugType.PURPLE_FRUIT_BUG, frontImageId = R.drawable.purple_fruit_bug),
        MemoryCard(bugType = BugType.PURPLE_FRUIT_BUG, frontImageId = R.drawable.purple_fruit_bug),
        MemoryCard(bugType = BugType.RANDOM_BUG, frontImageId = R.drawable.random_bug),
        MemoryCard(bugType = BugType.RANDOM_BUG, frontImageId = R.drawable.random_bug),
        MemoryCard(bugType = BugType.STRIPPED_BUG, frontImageId = R.drawable.striped_bug),
        MemoryCard(bugType = BugType.STRIPPED_BUG, frontImageId = R.drawable.striped_bug),
        MemoryCard(bugType = BugType.COCKROACH, frontImageId = R.drawable.cockroach, cardFace = CardFace.Front),
        MemoryCard(bugType = BugType.COCKROACH, frontImageId = R.drawable.cockroach, cardFace = CardFace.Front),
        MemoryCard(bugType = BugType.NETTLE, frontImageId = R.drawable.nettle),
        MemoryCard(bugType = BugType.NETTLE, frontImageId = R.drawable.nettle),
        MemoryCard(bugType = BugType.SPOTTED_LONGHORN, frontImageId = R.drawable.spotted_longhorn),
        MemoryCard(bugType = BugType.SPOTTED_LONGHORN, frontImageId = R.drawable.spotted_longhorn)
    )
}

object OpenCardAllCardsClosed {
    val data = listOf(
        MemoryCard(bugType = BugType.GREY_GARDEN_BUG, frontImageId = R.drawable.grey_garden_bug),
        MemoryCard(bugType = BugType.GREY_GARDEN_BUG, frontImageId = R.drawable.grey_garden_bug),
        MemoryCard(bugType = BugType.LADY_BUG, frontImageId = R.drawable.lady_bug),
        MemoryCard(bugType = BugType.LADY_BUG, frontImageId = R.drawable.lady_bug),
        MemoryCard(bugType = BugType.PURPLE_FRUIT_BUG, frontImageId = R.drawable.purple_fruit_bug),
        MemoryCard(bugType = BugType.PURPLE_FRUIT_BUG, frontImageId = R.drawable.purple_fruit_bug),
        MemoryCard(bugType = BugType.RANDOM_BUG, frontImageId = R.drawable.random_bug),
        MemoryCard(bugType = BugType.RANDOM_BUG, frontImageId = R.drawable.random_bug),
        MemoryCard(bugType = BugType.STRIPPED_BUG, frontImageId = R.drawable.striped_bug),
        MemoryCard(bugType = BugType.STRIPPED_BUG, frontImageId = R.drawable.striped_bug),
        MemoryCard(bugType = BugType.COCKROACH, frontImageId = R.drawable.cockroach),
        MemoryCard(bugType = BugType.COCKROACH, frontImageId = R.drawable.cockroach),
        MemoryCard(bugType = BugType.NETTLE, frontImageId = R.drawable.nettle),
        MemoryCard(bugType = BugType.NETTLE, frontImageId = R.drawable.nettle),
        MemoryCard(bugType = BugType.SPOTTED_LONGHORN, frontImageId = R.drawable.spotted_longhorn),
        MemoryCard(bugType = BugType.SPOTTED_LONGHORN, frontImageId = R.drawable.spotted_longhorn)
    )
}

object OpenCardOneCardOpen {
    val data = listOf(
        MemoryCard(bugType = BugType.GREY_GARDEN_BUG, frontImageId = R.drawable.grey_garden_bug, cardFace = CardFace.Front),
        MemoryCard(bugType = BugType.GREY_GARDEN_BUG, frontImageId = R.drawable.grey_garden_bug),
        MemoryCard(bugType = BugType.LADY_BUG, frontImageId = R.drawable.lady_bug),
        MemoryCard(bugType = BugType.LADY_BUG, frontImageId = R.drawable.lady_bug),
        MemoryCard(bugType = BugType.PURPLE_FRUIT_BUG, frontImageId = R.drawable.purple_fruit_bug),
        MemoryCard(bugType = BugType.PURPLE_FRUIT_BUG, frontImageId = R.drawable.purple_fruit_bug),
        MemoryCard(bugType = BugType.RANDOM_BUG, frontImageId = R.drawable.random_bug),
        MemoryCard(bugType = BugType.RANDOM_BUG, frontImageId = R.drawable.random_bug),
        MemoryCard(bugType = BugType.STRIPPED_BUG, frontImageId = R.drawable.striped_bug),
        MemoryCard(bugType = BugType.STRIPPED_BUG, frontImageId = R.drawable.striped_bug),
        MemoryCard(bugType = BugType.COCKROACH, frontImageId = R.drawable.cockroach),
        MemoryCard(bugType = BugType.COCKROACH, frontImageId = R.drawable.cockroach),
        MemoryCard(bugType = BugType.NETTLE, frontImageId = R.drawable.nettle),
        MemoryCard(bugType = BugType.NETTLE, frontImageId = R.drawable.nettle),
        MemoryCard(bugType = BugType.SPOTTED_LONGHORN, frontImageId = R.drawable.spotted_longhorn),
        MemoryCard(bugType = BugType.SPOTTED_LONGHORN, frontImageId = R.drawable.spotted_longhorn)
    )
}