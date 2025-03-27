package com.nebsan.roverchallenge.presentation.viewmodel

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nebsan.roverchallenge.domain.model.Rover
import com.nebsan.roverchallenge.domain.usecase.GetRoverDataUseCase
import com.nebsan.roverchallenge.domain.usecase.RoverUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoverViewModel @Inject constructor(
    private val getRoverDataUseCase: GetRoverDataUseCase,
    private val roverUseCase: RoverUseCase,
) : ViewModel() {

    var rover = mutableStateOf<Rover?>(null)
        private set

    var isInfoLoaded = mutableStateOf(false)
        private set

    var currentMovementIndex = mutableIntStateOf(-1)
        private set

    var isRoverInMovement = mutableStateOf(false)
        private set

    fun loadInfoRover(
        onDataLoadSuccess: () -> Unit,
        onDataLoadFailure: () -> Unit,
    ) {
        val roverData = getInitialRoverData()

        if (roverData == null) {
            onDataLoadFailure()
        } else {
            rover.value = roverData
            isInfoLoaded.value = true
            onDataLoadSuccess()
        }
    }

    fun executeRoverMovements() {
        rover.value?.let { roverInfo ->
            viewModelScope.launch(Dispatchers.IO) {
                isRoverInMovement.value = true
                for ((index, movement) in roverInfo.movements.withIndex()) {
                    currentMovementIndex.intValue = index
                    val updatedRover = roverUseCase.executeMovement(rover.value!!, movement)
                    rover.value = updatedRover
                    delay(1500L)
                }
                currentMovementIndex.intValue = -1
                isRoverInMovement.value = false
            }
        }
    }

    private fun getInitialRoverData(): Rover? {
        return getRoverDataUseCase.getRoverData()
    }

}