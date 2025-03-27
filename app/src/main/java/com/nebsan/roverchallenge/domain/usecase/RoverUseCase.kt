package com.nebsan.roverchallenge.domain.usecase

import com.nebsan.roverchallenge.domain.model.Rover
import javax.inject.Inject

class RoverUseCase @Inject constructor(
    private val roverTurnLeftUseCase: RoverTurnLeftUseCase,
    private val roverTurnRightUseCase: RoverTurnRightUseCase,
    private val roverMoveForwardUseCase: RoverMoveForwardUseCase,
) {

    fun executeMovement(currentRover: Rover, movement: Char): Rover {
        var updatedRover = currentRover

        updatedRover = when (movement) {
            'L' -> roverTurnLeftUseCase.turnLeft(updatedRover)
            'R' -> roverTurnRightUseCase.turnRight(updatedRover)
            'M' -> roverMoveForwardUseCase.moveForward(updatedRover)
            else -> updatedRover
        }

        return updatedRover
    }
}