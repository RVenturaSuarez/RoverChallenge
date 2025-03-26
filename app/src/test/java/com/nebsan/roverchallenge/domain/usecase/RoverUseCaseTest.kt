package com.nebsan.roverchallenge.domain.usecase

import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Position
import com.nebsan.roverchallenge.domain.model.Rover
import com.nebsan.roverchallenge.domain.repository.RoverRepository
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RoverUseCaseTest {

    private lateinit var roverUseCase: RoverUseCase
    private val roverRepository : RoverRepository = mockk()

    @Before
    fun setUp() {
        roverUseCase = RoverUseCase(roverRepository)
    }

    @Test
    fun `rover turn left correctly`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "L"
        )

        val result = roverUseCase.executeRoverMovements(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.W,
            movements = "L"
        )

        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover turn right correctly`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "R"
        )

        val result = roverUseCase.executeRoverMovements(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.E,
            movements = "R"
        )

        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover move forward correctly`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "M"
        )

        val result = roverUseCase.executeRoverMovements(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 3),
            roverDirection = Direction.N,
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

        val result = roverUseCase.executeRoverMovements(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 5),
            roverDirection = Direction.N,
            movements = "M"
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

        val result = roverUseCase.executeRoverMovements(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 3),
            roverDirection = Direction.N,
            movements = "LMXLMJLMZLMM"
        )

        assertEquals(result, expectedRover)

    }


    @Test
    fun `rover complete the movements correctly`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "LMLMLMLMM"
        )

        val result = roverUseCase.executeRoverMovements(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 3),
            roverDirection = Direction.N,
            movements = "LMLMLMLMM"
        )

        assertEquals(result, expectedRover)
    }

    @Test
    fun `rover complete the movements correctly with right movements`() {
        val rover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "RMRMRMRMM"
        )

        val result = roverUseCase.executeRoverMovements(rover)

        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 3),
            roverDirection = Direction.N,
            movements = "RMRMRMRMM"
        )

        assertEquals(result, expectedRover)
    }

}