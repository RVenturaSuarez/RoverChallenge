package com.nebsan.roverchallenge.domain.usecase

import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Position
import com.nebsan.roverchallenge.domain.model.Rover
import com.nebsan.roverchallenge.domain.repository.RoverRepository
import javax.inject.Inject

class RoverUseCase @Inject constructor(private val roverRepository: RoverRepository) {

    fun executeRoverMovements(rover: Rover): Rover {
        var updatedRover = rover

        rover.movements.forEach { movement ->
            updatedRover = when (movement) {
                'L' -> turnLeft(updatedRover)
                'R' -> turnRight(updatedRover)
                'M' -> moveForward(updatedRover)
                else -> updatedRover
            }
        }
        return updatedRover
    }

    fun executeSingleMovement(currentRover: Rover, movement: Char): Rover {
        var updatedRover = currentRover

        updatedRover = when (movement) {
            'L' -> turnLeft(updatedRover)
            'R' -> turnRight(updatedRover)
            'M' -> moveForward(updatedRover)
            else -> updatedRover
        }

        return updatedRover
    }


    private fun turnLeft(rover: Rover): Rover {
        val newDirection = when (rover.roverDirection) {
            Direction.N -> Direction.W
            Direction.S -> Direction.E
            Direction.E -> Direction.N
            Direction.W -> Direction.S
        }
        return rover.copy(roverDirection = newDirection)
    }

    private fun turnRight(rover: Rover): Rover {
        val newDirection = when (rover.roverDirection) {
            Direction.N -> Direction.E
            Direction.S -> Direction.W
            Direction.E -> Direction.S
            Direction.W -> Direction.N
        }
        return rover.copy(roverDirection = newDirection)
    }


    private fun moveForward(rover: Rover): Rover {
        var newPosition = rover.roverPosition

        newPosition = when (rover.roverDirection) {
            Direction.N -> newPosition.copy(y = newPosition.y + 1)
            Direction.S -> newPosition.copy(y = newPosition.y - 1)
            Direction.E -> newPosition.copy(x = newPosition.x + 1)
            Direction.W -> newPosition.copy(x = newPosition.x - 1)
        }

        // Check if rover is in Plateau
        if (isWithinPlateauBounds(newPosition, rover.topRightCorner)) {
            return rover.copy(roverPosition = newPosition)
        }

        // If rover is out of Plateau don't move and return the initial rover
        return rover
    }

    private fun isWithinPlateauBounds(position: Position, topRightCorner: Position): Boolean {
        return position.x in 0..topRightCorner.x && position.y in 0..topRightCorner.y
    }

}