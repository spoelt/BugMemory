package com.example.memory.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.memory.domain.MemoryCard
import com.example.memory.ui.memory_game.MemoryGameEvents

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun MemoryCardGrid(
    modifier: Modifier = Modifier,
    cards: List<MemoryCard>,
    onTriggerEvent: (MemoryGameEvents) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier,
        cells = GridCells.Fixed(4)
    ) {
        itemsIndexed(items = cards) { idx, card ->
            FlipCard(
                modifier = Modifier.padding(6.dp),
                cardFace = card.cardFace,
                onClick = {
                    if (!card.isMatched && card.cardFace == CardFace.Back) {
                        onTriggerEvent(MemoryGameEvents.HandleClickedCard(idx))
                    }
                },
                back = {
                    Image(
                        modifier = Modifier.size(100.dp, 100.dp),
                        painter = painterResource(id = card.backImageId),
                        contentDescription = card.bugType.name,
                        contentScale = ContentScale.Crop
                    )
                },
                front = {
                    Image(
                        modifier = Modifier.size(100.dp, 100.dp),
                        painter = painterResource(id = card.frontImageId),
                        contentDescription = card.bugType.name,
                        contentScale = ContentScale.Crop
                    )
                }
            )
        }
    }
}