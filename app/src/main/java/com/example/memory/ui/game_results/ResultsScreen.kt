package com.example.memory.ui.game_results

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.memory.R
import com.example.memory.constants.TROPHY_HEIGHT
import com.example.memory.constants.TROPHY_WIDTH
import com.example.memory.utils.convertTimestampToString

@Composable
fun ResultsScreen(
    modifier: Modifier,
    viewModel: ResultsViewModel = hiltViewModel(),
    onExit: () -> Unit,
    onRestartGame: () -> Unit
) {
    val state by viewModel.state
    val result = state.result

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .height(TROPHY_HEIGHT.dp)
                .width(TROPHY_WIDTH.dp),
            painter = painterResource(id = R.drawable.trophy),
            contentDescription = stringResource(id = R.string.trophy),
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Inside
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(id = R.string.congratulations),
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(
                id = R.string.finished_message,
                convertTimestampToString(result.elapsedTime),
                result.moves
            ),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp),
                onClick = { onExit() }
            ) {
                Text(stringResource(id = R.string.exit))
            }
            Button(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp),
                onClick = { onRestartGame() }
            ) {
                Text(stringResource(id = R.string.play_again))
            }
        }
    }
}