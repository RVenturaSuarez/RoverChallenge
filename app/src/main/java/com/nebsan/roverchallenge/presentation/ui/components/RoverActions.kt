package com.nebsan.roverchallenge.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nebsan.roverchallenge.R

@Composable
fun RoverActions(
    isInfoLoaded: Boolean,
    isRoverInMovement: Boolean,
    onLoadInfo: () -> Unit,
    onMoveRover: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {
        if (!isInfoLoaded) {
            ButtonAction(title = R.string.load_info, onClick = onLoadInfo)
        } else {
            ButtonAction(R.string.move_rover, onClick = onMoveRover, enable = !isRoverInMovement)
            ButtonAction(R.string.reset_info, onClick = onLoadInfo, enable = !isRoverInMovement)
        }
    }
}