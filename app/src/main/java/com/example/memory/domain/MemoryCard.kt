package com.example.memory.domain

import com.example.memory.R
import com.example.memory.ui.components.CardFace
import java.util.*

data class MemoryCard(
    val id: String = UUID.randomUUID().toString(),
    val bugType: BugType,
    val backImageId: Int = R.drawable.bamboo,
    val frontImageId: Int,
    val cardFace: CardFace = CardFace.Back,
    val isMatched: Boolean = false
)
