package com.example.memory.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.memory.constants.ANIMATION_DURATION
import com.example.memory.domain.AnimationState
import com.example.memory.domain.MemoryCard
import com.example.memory.ui.memory_game.MemoryGameEvents
import kotlinx.coroutines.delay

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun GameSection(
    modifier: Modifier = Modifier,
    cards: List<MemoryCard>,
    onTriggerEvent: (MemoryGameEvents) -> Unit,
    confettiRainState: AnimationState,
    onAnimationDone: () -> Unit
) {
    LaunchedEffect(confettiRainState) {
        if (confettiRainState is AnimationState.Start) {
            delay(ANIMATION_DURATION)
            onAnimationDone()
        }
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        MemoryCardGrid(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            cards = cards,
            onTriggerEvent = onTriggerEvent
        )

        if (confettiRainState is AnimationState.Start) {
            Confetti(
                modifier = Modifier.matchParentSize()
            )
        }
    }
}