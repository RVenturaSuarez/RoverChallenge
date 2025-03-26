package com.nebsan.roverchallenge.domain.usecase

import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Position
import com.nebsan.roverchallenge.domain.model.Rover
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RoverUseCaseTest {

    private lateinit var roverMovementsUseCase: RoverUseCase

    @Before
    fun setUp() {
        roverMovementsUseCase = RoverUseCase(
            RoverTurnLeftUseCase(),
            RoverTurnRightUseCase(),
            RoverMoveForwardUseCase()
        )
    }

    @Test
    fun `rover complete the movements correctly`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "LMLMLMLMM"
        )

        var result = rover

        rover.movements.forEach { movement ->
            result = roverMovementsUseCase.executeMovement(rover, movement)
        }

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 3),
            roverDirection = Direction.N,
            movements = "LMLMLMLMM"
        )

        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover complete the movements correctly with other movements`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "RMRMRMRMM"
        )

        var result = rover

        rover.movements.forEach { movement ->
            result = roverMovementsUseCase.executeMovement(rover, movement)
        }

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 3),
            roverDirection = Direction.N,
            movements = "RMRMRMRMM"
        )

        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover ignore wrong movements`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "LMXLMJLMZLMM"
        )

        var result = rover

        rover.movements.forEach { movement ->
            result = roverMovementsUseCase.executeMovement(rover, movement)
        }

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 3),
            roverDirection = Direction.N,
            movements = "LMXLMJLMZLMM"
        )

        assertEquals(result, expectedRover)

    }

}