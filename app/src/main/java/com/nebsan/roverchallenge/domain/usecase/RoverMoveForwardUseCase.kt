package com.nebsan.roverchallenge.domain.usecase

import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Position
import com.nebsan.roverchallenge.domain.model.Rover
import javax.inject.Inject

class RoverMoveForwardUseCase @Inject constructor() {

    fun moveForward(rover: Rover): Rover {
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