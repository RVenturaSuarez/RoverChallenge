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
        // GIVEN
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "LMLMLMLMM"
        )

        // WHEN
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

        // THEN
        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover complete the movements correctly with other movements`() {
        // GIVEN
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "RMRMRMRMM"
        )

        // WHEN
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

        // THEN
        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover ignore wrong movements`() {
        // GIVEN
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "LMXLMJLMZLMM"
        )

        // WHEN
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

        // THEN
        assertEquals(result, expectedRover)

    }

}