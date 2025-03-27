package com.nebsan.roverchallenge.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nebsan.roverchallenge.R
import com.nebsan.roverchallenge.domain.model.Rover

@Composable
fun RoverInfoCard(
    roverInfo: Rover,
    currentMovementIndex: Int,
    modifier: Modifier = Modifier,
) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(
            modifier = modifier
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(
                    id = R.string.top_right_corner,
                    roverInfo.topRightCorner.x,
                    roverInfo.topRightCorner.y
                )
            )

            Text(
                text = stringResource(
                    id = R.string.rover_position,
                    roverInfo.roverPosition.x,
                    roverInfo.roverPosition.y
                )
            )

            Text(
                text = stringResource(id = R.string.rover_direction, roverInfo.roverDirection.name)
            )

            MovementsRover(roverInfo.movements, currentMovementIndex)
        }
    }
}