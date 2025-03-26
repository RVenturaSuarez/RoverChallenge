package com.nebsan.roverchallenge.domain.usecase

import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Rover
import javax.inject.Inject

class RoverTurnRightUseCase @Inject constructor() {

    fun turnRight(rover: Rover): Rover {
        val newDirection = when (rover.roverDirection) {
            Direction.N -> Direction.E
            Direction.S -> Direction.W
            Direction.E -> Direction.S
            Direction.W -> Direction.N
        }
        return rover.copy(roverDirection = newDirection)
    }
}