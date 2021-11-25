package com.example.memory.ui.components

import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import nl.dionsegijn.konfetti.KonfettiView
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size


@Composable
fun Confetti(modifier: Modifier = Modifier) {

    val screenWidth = LocalContext.current.resources.displayMetrics.widthPixels.dp
    val screenHeight = LocalContext.current.resources.displayMetrics.heightPixels.dp

    AndroidView(
        modifier = modifier,
        factory = { c ->
            KonfettiView(c).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        },
        update = {
            it.build()
                .addColors(Color.Yellow.toArgb(), Color.Green.toArgb(), Color.Magenta.toArgb())
                .setDirection(45.0)
                .setSpeed(0f, 1f)
                .setFadeOutEnabled(true)
                .setTimeToLive(3000L)
                .addShapes(Shape.Square, Shape.Circle)
                .addSizes(Size(12), Size(8), Size(10), Size(6))
                .setPosition(
                    0f,
                    screenWidth.value,
                    0f,
                    screenHeight.value
                )
                .streamFor(600, 3000L)
        }
    )
}