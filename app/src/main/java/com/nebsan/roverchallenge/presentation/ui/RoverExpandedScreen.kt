package com.nebsan.roverchallenge.presentation.ui

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nebsan.roverchallenge.presentation.ui.components.RoverActions
import com.nebsan.roverchallenge.presentation.ui.components.RoverImage
import com.nebsan.roverchallenge.presentation.ui.components.RoverInfoCard
import com.nebsan.roverchallenge.presentation.ui.components.TopBarRover
import com.nebsan.roverchallenge.presentation.viewmodel.RoverViewModel
import com.nebsan.roverchallenge.utils.handleLoadInfoRover

@Composable
fun RoverExpandedScreen(
    context: Context,
    roverViewModel: RoverViewModel = hiltViewModel(),
) {
    val roverInfo by remember { derivedStateOf { roverViewModel.rover.value } }
    val isInfoLoaded by remember { derivedStateOf { roverViewModel.isInfoLoaded.value } }
    val isRoverInMovement by remember { derivedStateOf { roverViewModel.isRoverInMovement.value } }
    val currentMovementIndex by remember { derivedStateOf { roverViewModel.currentMovementIndex.intValue } }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = { TopBarRover() },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 20.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.weight(1f))
            RoverImage(size = 200.dp)

            AnimatedVisibility(
                visible = isInfoLoaded && roverInfo != null,
                enter = fadeIn() + expandHorizontally(),
                exit = fadeOut() + shrinkHorizontally()
            ) {
                RoverInfoCard(
                    roverInfo = roverInfo!!,
                    currentMovementIndex = currentMovementIndex,
                    modifier = Modifier.verticalScroll(rememberScrollState())
                )
            }

            RoverActions(
                isInfoLoaded = isInfoLoaded,
                isRoverInMovement = isRoverInMovement,
                onLoadInfo = { handleLoadInfoRover(roverViewModel, context, scope, snackbarHostState) },
                onMoveRover = { roverViewModel.executeRoverMovements() }
            )

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}



