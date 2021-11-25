package com.example.memory.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.memory.R

@Composable
fun GameStats(
    modifier: Modifier = Modifier,
    moves: Int,
    elapsedTime: String
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(36.dp),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp, start = 24.dp, end = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.moves, moves),
                color = MaterialTheme.colors.primary
            )
            Text(
                text = stringResource(id = R.string.elapsed_time, elapsedTime),
                color = MaterialTheme.colors.primary
            )
        }
    }
}