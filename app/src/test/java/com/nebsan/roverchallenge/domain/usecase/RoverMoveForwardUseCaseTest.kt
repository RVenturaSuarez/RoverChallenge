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
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "M"
        )

        val result = roverMoveForwardUseCase.moveForward(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 3),
            roverDirection = Direction.N,
            movements = "M"
        )

        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover move forward correctly with S direction`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.S,
            movements = "M"
        )

        val result = roverMoveForwardUseCase.moveForward(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 1),
            roverDirection = Direction.S,
            movements = "M"
        )

        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover move forward correctly with E direction`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.E,
            movements = "M"
        )

        val result = roverMoveForwardUseCase.moveForward(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 2, y = 2),
            roverDirection = Direction.E,
            movements = "M"
        )

        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover move forward correctly with W direction`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.W,
            movements = "M"
        )

        val result = roverMoveForwardUseCase.moveForward(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 0, y = 2),
            roverDirection = Direction.W,
            movements = "M"
        )

        assertEquals(result, expectedRover)
    }


    @Test
    fun `rover does not move because it will be outside plateau bounds`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 5),
            roverDirection = Direction.N,
            movements = "M"
        )

        val result = roverMoveForwardUseCase.moveForward(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 5),
            roverDirection = Direction.N,
            movements = "M"
        )

        assertEquals(result, expectedRover)
    }

}