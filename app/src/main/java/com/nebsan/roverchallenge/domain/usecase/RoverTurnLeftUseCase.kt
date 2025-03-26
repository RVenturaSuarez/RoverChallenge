package com.nebsan.roverchallenge.domain.usecase

import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Rover
import javax.inject.Inject

class RoverTurnLeftUseCase @Inject constructor() {

    fun turnLeft(rover: Rover): Rover {
        val newDirection = when (rover.roverDirection) {
            Direction.N -> Direction.W
            Direction.S -> Direction.E
            Direction.E -> Direction.N
            Direction.W -> Direction.S
        }
        return rover.copy(roverDirection = newDirection)
    }
}