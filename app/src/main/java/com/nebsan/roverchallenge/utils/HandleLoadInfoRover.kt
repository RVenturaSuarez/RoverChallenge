package com.nebsan.roverchallenge.utils

import android.content.Context
import androidx.compose.material3.SnackbarHostState
import com.nebsan.roverchallenge.R
import com.nebsan.roverchallenge.presentation.viewmodel.RoverViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun handleLoadInfoRover(
    roverViewModel: RoverViewModel,
    context: Context,
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
) {
    roverViewModel.loadInfoRover(
        onDataLoadSuccess = { scope.launch { snackbarHostState.showSnackbar(context.getString(R.string.load_info_success)) } },
        onDataLoadFailure = { scope.launch { snackbarHostState.showSnackbar(context.getString(R.string.load_info_failure)) } }
    )
}