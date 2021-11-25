package com.example.memory.ui.memory_game

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.memory.domain.GameResult
import com.example.memory.ui.components.GameSection
import com.example.memory.ui.components.GameStats
import com.example.memory.ui.components.observeAsSate
import com.example.memory.utils.convertTimestampToString

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun GameScreen(
    modifier: Modifier,
    viewModel: GameViewModel = hiltViewModel(),
    navigateToResults: (GameResult) -> Unit
) {
    val state by viewModel.state
    val lifeCycleState = LocalLifecycleOwner.current.lifecycle.observeAsSate()
    val lifeCycleEvent = lifeCycleState.value

    LaunchedEffect(lifeCycleEvent) {
        viewModel.handleTimerOnLifeCycleChange(lifeCycleEvent)
    }

    Column(modifier = modifier) {
        GameStats(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(12.dp)
                .fillMaxWidth(),
            moves = state.moves,
            elapsedTime = convertTimestampToString(state.elapsedTime)
        )
        GameSection(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.primary,
                            MaterialTheme.colors.primaryVariant,
                            MaterialTheme.colors.primary
                        )
                    )
                ),
            cards = state.cards,
            onTriggerEvent = viewModel::onTriggerEvent,
            confettiRainState = state.confettiRainState,
            onAnimationDone = { navigateToResults(GameResult(state.moves, state.elapsedTime)) }
        )
    }
}