package com.nebsan.roverchallenge.domain.usecase

import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Position
import com.nebsan.roverchallenge.domain.model.Rover
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RoverTurnRightUseCaseTest {

    private lateinit var roverTurnRightUseCase: RoverTurnRightUseCase

    @Before
    fun setUp() {
        roverTurnRightUseCase = RoverTurnRightUseCase()
    }

    @Test
    fun `rover turn right with N initial position an return E`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "R"
        )

        val result = roverTurnRightUseCase.turnRight(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.E,
            movements = "R"
        )

        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover turn right with S initial position an return W`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.S,
            movements = "R"
        )

        val result = roverTurnRightUseCase.turnRight(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.W,
            movements = "R"
        )

        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover turn right with E initial position an return S`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.E,
            movements = "R"
        )

        val result = roverTurnRightUseCase.turnRight(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.S,
            movements = "R"
        )

        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover turn right with W initial position an return N`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.W,
            movements = "R"
        )

        val result = roverTurnRightUseCase.turnRight(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "R"
        )

        assertEquals(result, expectedRover)
    }

}