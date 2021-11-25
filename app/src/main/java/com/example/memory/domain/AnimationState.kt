package com.example.memory.domain

sealed class AnimationState {
    object Idle : AnimationState()
    object Start : AnimationState()
}
