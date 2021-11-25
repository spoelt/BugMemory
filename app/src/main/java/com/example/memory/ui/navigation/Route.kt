package com.example.memory.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.navArgument
import com.example.memory.domain.GameResult

sealed class Route(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object Game : Route(
        route = "gameScreen",
        arguments = emptyList()
    )

    object Results : Route(
        route = "results",
        arguments = listOf(
            navArgument("moves") {
                type = NavType.IntType
            },
            navArgument("elapsedTime") {
                type = NavType.LongType
            }
        )
    )
}
