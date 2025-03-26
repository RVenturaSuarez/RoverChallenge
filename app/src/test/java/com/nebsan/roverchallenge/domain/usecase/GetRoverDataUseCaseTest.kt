package com.nebsan.roverchallenge.domain.usecase

import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Position
import com.nebsan.roverchallenge.domain.model.Rover
import com.nebsan.roverchallenge.domain.repository.RoverRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Assert.assertEquals
import org.junit.Test

class GetRoverDataUseCaseTest {

    private lateinit var getRoverDataUseCase: GetRoverDataUseCase
    private val roverRepository : RoverRepository = mockk()

    @Before
    fun setUp() {
        getRoverDataUseCase = GetRoverDataUseCase(roverRepository)
    }

    @Test
    fun `get rover data correctly from JSON`() {
        // GIVEN
        val expectedRover = Rover(
            topRightCorner = Position(x = 5, y = 5),
            roverPosition = Position(x = 1, y = 2),
            roverDirection = Direction.N,
            movements = "LMLMLMLMM"
        )

        // WHEN
        every { getRoverDataUseCase.getRoverData() } returns expectedRover

        val result = getRoverDataUseCase.getRoverData()

        // THEN
        assertEquals(result, expectedRover)
    }
}