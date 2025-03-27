package com.nebsan.roverchallenge.presentation.ui

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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
fun RoverScreen(
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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            RoverImage()

            AnimatedVisibility(
                visible = isInfoLoaded && roverInfo != null,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                RoverInfoCard(roverInfo = roverInfo!!, currentMovementIndex = currentMovementIndex)
            }

            RoverActions(
                isInfoLoaded = isInfoLoaded,
                isRoverInMovement = isRoverInMovement,
                onLoadInfo = { handleLoadInfoRover(roverViewModel, context, scope, snackbarHostState) },
                onMoveRover = { roverViewModel.executeRoverMovements() }
            )
        }
    }
}



