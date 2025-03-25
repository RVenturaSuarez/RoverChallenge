package com.nebsan.roverchallenge.domain.mapper

import com.nebsan.roverchallenge.data.model.PositionData
import com.nebsan.roverchallenge.data.model.DirectionData
import com.nebsan.roverchallenge.data.model.RoverData
import com.nebsan.roverchallenge.domain.model.Position
import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Rover

object RoverMapper {

    fun RoverData.toDomain(): Rover {
        return Rover(
            topRightCorner = topRightCorner.toDomain(),
            roverPosition = roverPosition.toDomain(),
            roverDirection = roverDirection.toDomain(),
            movements = movements
        )
    }

    private fun PositionData.toDomain(): Position {
        return Position(x = x, y = y)
    }

    private fun DirectionData.toDomain(): Direction {
        return when (direction) {
            "N" -> Direction.N
            "S" -> Direction.S
            "E" -> Direction.E
            "W" -> Direction.W
            else -> Direction.N
        }
    }
}