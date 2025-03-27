package com.nebsan.roverchallenge.domain.usecase

import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Position
import com.nebsan.roverchallenge.domain.model.Rover
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RoverTurnLeftUseCaseTest {

    private lateinit var roverTurnLeftUseCase: RoverTurnLeftUseCase

    @Before
    fun setUp() {
        roverTurnLeftUseCase = RoverTurnLeftUseCase()
    }

    @Test
    fun `rover turn left with N initial position an return W`() {
        // GIVEN
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "L"
        )

        // WHEN
        val result = roverTurnLeftUseCase.turnLeft(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.W,
            movements = "L"
        )

        // THEN
        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover turn left with S initial position an return E`() {
        // GIVEN
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.S,
            movements = "L"
        )

        // WHEN
        val result = roverTurnLeftUseCase.turnLeft(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.E,
            movements = "L"
        )

        // THEN
        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover turn left with E initial position an return N`() {
        // GIVEN
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.E,
            movements = "L"
        )

        // WHEN
        val result = roverTurnLeftUseCase.turnLeft(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "L"
        )

        // THEN
        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover turn left with W initial position an return S`() {
        // GIVEN
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.W,
            movements = "L"
        )

        // WHEN
        val result = roverTurnLeftUseCase.turnLeft(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.S,
            movements = "L"
        )

        // THEN
        assertEquals(result, expectedRover)
    }

}