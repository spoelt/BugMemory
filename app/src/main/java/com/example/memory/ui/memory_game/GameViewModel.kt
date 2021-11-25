package com.example.memory.ui.memory_game

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memory.constants.ONE_SECOND
import com.example.memory.domain.AnimationState
import com.example.memory.memory_interactors.CloseCards
import com.example.memory.memory_interactors.GetCards
import com.example.memory.memory_interactors.MatchCards
import com.example.memory.memory_interactors.OpenCard
import com.example.memory.ui.components.CardFace
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getCards: GetCards,
    private val openCard: OpenCard,
    private val matchCards: MatchCards,
    private val closeCards: CloseCards
) : ViewModel() {

    val state = mutableStateOf(MemoryGameState())

    var timerJob: Job? = null

    init {
        onTriggerEvent(MemoryGameEvents.GetCards)
    }

    fun onTriggerEvent(event: MemoryGameEvents) {
        when (event) {
            is MemoryGameEvents.GetCards -> getCards()
            is MemoryGameEvents.HandleClickedCard -> handleClickedCard(event.index)
        }
    }

    private fun getCards() {
        getCards.execute().onEach { cards ->
            state.value = state.value.copy(cards = cards)
        }.launchIn(viewModelScope)
    }

    private fun handleClickedCard(index: Int) {
        // 0. start timer when first card was clicked
        if (timerJob == null || timerJob?.isCancelled == true) startTimer()

        // 1. always open the card that was clicked
        openCard(index)

        // 2. if too many cards (> 2) are open, close the first two, but not the last opened card
        if (areTooManyCardsOpen()) closeCards(index)

        // 3. if 2 cards are open, match them
        if (areCardsReadyToBeMatched()) checkMatch()

        // 4. if all cards are matched, show confetti and stop timer
        if (isEndOfGameReached()) {
            cancelTimer()
            showConfettiAnimation()
        }
    }

    private fun startTimer() {
        timerJob = viewModelScope.launch {
            while (isActive) {
                delay(1000)
                state.value = state.value.copy(elapsedTime = state.value.elapsedTime + ONE_SECOND)
            }
        }
    }

    private fun cancelTimer() {
        timerJob?.cancel()
    }

    private fun openCard(index: Int) {
        openCard.execute(
            index = index,
            cards = state.value.cards
        ).onEach { cards ->
            state.value = state.value.copy(cards = cards, moves = state.value.moves.inc())
        }.launchIn(viewModelScope)
    }

    private fun areTooManyCardsOpen() =
        state.value.cards.count { it.cardFace == CardFace.Front && !it.isMatched } > 2

    private fun closeCards(index: Int) {
        closeCards.execute(
            index = index,
            cards = state.value.cards
        ).onEach { cards ->
            state.value = state.value.copy(cards = cards)
        }.launchIn(viewModelScope)
    }

    private fun areCardsReadyToBeMatched() =
        state.value.cards.count { it.cardFace == CardFace.Front && !it.isMatched } == 2

    private fun checkMatch() {
        matchCards.execute(
            cards = state.value.cards
        ).onEach { cards ->
            state.value = state.value.copy(cards = cards)
        }.launchIn(viewModelScope)
    }

    private fun isEndOfGameReached() = state.value.cards.all { it.isMatched }

    private fun showConfettiAnimation() {
        state.value = state.value.copy(confettiRainState = AnimationState.Start)
    }

    fun handleTimerOnLifeCycleChange(value: Lifecycle.Event) {
        when (value) {
            Lifecycle.Event.ON_RESUME -> if (isGameInProgress()) startTimer()
            Lifecycle.Event.ON_PAUSE -> cancelTimer()
            else -> Unit
        }
    }

    private fun isGameInProgress() = state.value.moves > 0
}