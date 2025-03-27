package com.nebsan.roverchallenge.domain.mapper

import com.nebsan.roverchallenge.data.model.PositionData
import com.nebsan.roverchallenge.data.model.RoverData
import com.nebsan.roverchallenge.domain.mapper.RoverMapper.toDomain
import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Rover
import org.junit.Assert.assertEquals
import org.junit.Test

class RoverMapperTest {

    @Test
    fun `rover data is correctly mapped to rover with N direction`() {
        // GIVEN
        val roverData = RoverData(
            topRightCorner = PositionData(x = 5, y = 5),
            roverPosition = PositionData(x = 1, y = 2),
            roverDirection = "N",
            movements = "LMLMLMLMM"
        )

        // WHEN
        val rover: Rover = roverData.toDomain()

        // THEN
        assertEquals(5, rover.topRightCorner.x)
        assertEquals(5, rover.topRightCorner.y)
        assertEquals(1, rover.roverPosition.x)
        assertEquals(2, rover.roverPosition.y)
        assertEquals(Direction.N, rover.roverDirection)
        assertEquals("LMLMLMLMM", rover.movements)
    }

    @Test
    fun `rover data is correctly mapped to rover with S direction`() {
        // GIVEN
        val roverData = RoverData(
            topRightCorner = PositionData(x = 5, y = 5),
            roverPosition = PositionData(x = 1, y = 2),
            roverDirection = "S",
            movements = "LMLMLMLMM"
        )

        // WHEN
        val rover: Rover = roverData.toDomain()

        // THEN
        assertEquals(5, rover.topRightCorner.x)
        assertEquals(5, rover.topRightCorner.y)
        assertEquals(1, rover.roverPosition.x)
        assertEquals(2, rover.roverPosition.y)
        assertEquals(Direction.S, rover.roverDirection)
        assertEquals("LMLMLMLMM", rover.movements)
    }


    @Test
    fun `rover data is correctly mapped to rover with E direction`() {
        // GIVEN
        val roverData = RoverData(
            topRightCorner = PositionData(x = 5, y = 5),
            roverPosition = PositionData(x = 1, y = 2),
            roverDirection = "E",
            movements = "LMLMLMLMM"
        )

        // WHEN
        val rover: Rover = roverData.toDomain()

        // THEN
        assertEquals(5, rover.topRightCorner.x)
        assertEquals(5, rover.topRightCorner.y)
        assertEquals(1, rover.roverPosition.x)
        assertEquals(2, rover.roverPosition.y)
        assertEquals(Direction.E, rover.roverDirection)
        assertEquals("LMLMLMLMM", rover.movements)
    }

    @Test
    fun `rover data is correctly mapped to rover with W direction`() {
        // GIVEN
        val roverData = RoverData(
            topRightCorner = PositionData(x = 5, y = 5),
            roverPosition = PositionData(x = 1, y = 2),
            roverDirection = "W",
            movements = "LMLMLMLMM"
        )

        // WHEN
        val rover: Rover = roverData.toDomain()

        // THEN
        assertEquals(5, rover.topRightCorner.x)
        assertEquals(5, rover.topRightCorner.y)
        assertEquals(1, rover.roverPosition.x)
        assertEquals(2, rover.roverPosition.y)
        assertEquals(Direction.W, rover.roverDirection)
        assertEquals("LMLMLMLMM", rover.movements)
    }

    @Test
    fun `rover data is correctly mapped to rover with wrong direction`() {
        // GIVEN
        val roverData = RoverData(
            topRightCorner = PositionData(x = 5, y = 5),
            roverPosition = PositionData(x = 1, y = 2),
            roverDirection = "Z",
            movements = "LMLMLMLMM"
        )

        // WHEN
        val rover: Rover = roverData.toDomain()

        // THEN
        assertEquals(5, rover.topRightCorner.x)
        assertEquals(5, rover.topRightCorner.y)
        assertEquals(1, rover.roverPosition.x)
        assertEquals(2, rover.roverPosition.y)
        assertEquals(Direction.N, rover.roverDirection)
        assertEquals("LMLMLMLMM", rover.movements)
    }

}