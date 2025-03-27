package com.nebsan.roverchallenge.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nebsan.roverchallenge.R

@Composable
fun MovementsRover(
    movements: String,
    currentMovementIndex: Int
) {
    Text(text = stringResource(id = R.string.movements_title), fontWeight = FontWeight.Bold)
    Row {
        movements.forEachIndexed { index, movement ->
            Text(
                text = movement.toString(),
                fontWeight = if (index == currentMovementIndex) FontWeight.Bold else FontWeight.Normal,
                color = if (index == currentMovementIndex) Color.Red else Color.Unspecified,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
    }
}