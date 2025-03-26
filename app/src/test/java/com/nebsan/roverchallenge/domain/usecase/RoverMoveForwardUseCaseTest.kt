package com.nebsan.roverchallenge.domain.usecase

import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Position
import com.nebsan.roverchallenge.domain.model.Rover
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RoverMoveForwardUseCaseTest {

    private lateinit var roverMoveForwardUseCase: RoverMoveForwardUseCase

    @Before
    fun setUp() {
        roverMoveForwardUseCase = RoverMoveForwardUseCase()
    }


    @Test
    fun `rover move forward correctly with N direction`() {
        // GIVEN
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "M"
        )

        // WHEN
        val result = roverMoveForwardUseCase.moveForward(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 3),
            roverDirection = Direction.N,
            movements = "M"
        )

        // THEN
        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover move forward correctly with S direction`() {
        // GIVEN
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.S,
            movements = "M"
        )

        // WHEN
        val result = roverMoveForwardUseCase.moveForward(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 1),
            roverDirection = Direction.S,
            movements = "M"
        )

        // THEN
        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover move forward correctly with E direction`() {
        // GIVEN
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.E,
            movements = "M"
        )

        // WHEN
        val result = roverMoveForwardUseCase.moveForward(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 2, y = 2),
            roverDirection = Direction.E,
            movements = "M"
        )

        // THEN
        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover move forward correctly with W direction`() {
        // GIVEN
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.W,
            movements = "M"
        )

        // WHEN
        val result = roverMoveForwardUseCase.moveForward(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 0, y = 2),
            roverDirection = Direction.W,
            movements = "M"
        )

        // THEN
        assertEquals(result, expectedRover)
    }


    @Test
    fun `rover does not move because it will be outside plateau bounds`() {
        // GIVEN
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 5),
            roverDirection = Direction.N,
            movements = "M"
        )

        // WHEN
        val result = roverMoveForwardUseCase.moveForward(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 5),
            roverDirection = Direction.N,
            movements = "M"
        )

        // THEN
        assertEquals(result, expectedRover)
    }

}