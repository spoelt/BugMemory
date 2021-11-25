package com.example.memory.di

import com.example.memory.memory_interactors.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideInteractors(): MemoryInteractors = MemoryInteractors.build()

    @Singleton
    @Provides
    fun provideGetCards(interactors: MemoryInteractors): GetCards = interactors.getCards

    @Singleton
    @Provides
    fun provideOpenCard(interactors: MemoryInteractors): OpenCard = interactors.openCard

    @Singleton
    @Provides
    fun provideMatchCards(interactors: MemoryInteractors): MatchCards = interactors.matchCards

    @Singleton
    @Provides
    fun provideCloseCards(interactors: MemoryInteractors): CloseCards = interactors.closeCards
}