package com.example.memory.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.memory.ui.game_results.ResultsScreen
import com.example.memory.ui.memory_game.GameScreen
import com.example.memory.ui.navigation.Route
import com.example.memory.ui.theme.MemoryTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MemoryTheme {
                val navController = rememberAnimatedNavController()
                BoxWithConstraints {
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Route.Game.route
                    ) {
                        composable(
                            route = Route.Game.route,
                            exitTransition = { _, _ ->
                                slideOutHorizontally(
                                    targetOffsetX = { -constraints.maxWidth / 2 },
                                    animationSpec = tween(
                                        durationMillis = 300
                                    )
                                ) + fadeOut(
                                    animationSpec = tween(
                                        durationMillis = 300
                                    )
                                )
                            },
                            popEnterTransition = { _, _ ->
                                slideInHorizontally(
                                    initialOffsetX = { -constraints.maxWidth / 2 },
                                    animationSpec = tween(
                                        durationMillis = 300
                                    )
                                ) + fadeIn(
                                    animationSpec = tween(
                                        durationMillis = 300
                                    )
                                )
                            }
                        ) {
                            GameScreen(
                                modifier = Modifier.fillMaxSize(),
                                navigateToResults = { result ->
                                    navController.apply {
                                        popBackStack(Route.Game.route, true)
                                        navigate("${Route.Results.route}/${result.moves}&${result.elapsedTime}")
                                    }
                                }
                            )
                        }
                        composable(
                            route = Route.Results.route + "/{moves}&{elapsedTime}",
                            arguments = Route.Results.arguments,
                            enterTransition = { _, _ ->
                                slideInHorizontally(
                                    initialOffsetX = { constraints.maxWidth / 2 },
                                    animationSpec = tween(
                                        durationMillis = 300
                                    )
                                ) + fadeIn(
                                    animationSpec = tween(
                                        durationMillis = 300
                                    )
                                )
                            },
                            popExitTransition = { _, _ ->
                                slideOutHorizontally(
                                    targetOffsetX = { constraints.maxWidth / 2 },
                                    animationSpec = tween(
                                        durationMillis = 300
                                    )
                                ) + fadeOut(
                                    animationSpec = tween(
                                        durationMillis = 300
                                    )
                                )
                            }
                        ) {
                            ResultsScreen(
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
                                    )
                                    .padding(36.dp),
                                onExit = { finish() },
                                onRestartGame = {
                                    navController.navigate(Route.Game.route)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}