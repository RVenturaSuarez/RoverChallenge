package com.nebsan.roverchallenge.domain.mapper

import com.nebsan.roverchallenge.data.model.DirectionData
import com.nebsan.roverchallenge.data.model.PositionData
import com.nebsan.roverchallenge.data.model.RoverData
import com.nebsan.roverchallenge.domain.mapper.RoverMapper.toDomain
import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Rover
import org.junit.Assert.assertEquals
import org.junit.Test

class RoverMapperTest {

    @Test
    fun `rover data is correctly mapped to rover`() {
        val roverData = RoverData(
            topRightCorner = PositionData(x = 5, y = 5),
            roverPosition = PositionData(x = 1, y = 2),
            roverDirection = DirectionData("N"),
            movements = "LMLMLMLMM"
        )

        val rover: Rover = roverData.toDomain()

        assertEquals(5, rover.topRightCorner.x)
        assertEquals(5, rover.topRightCorner.y)
        assertEquals(1, rover.roverPosition.x)
        assertEquals(2, rover.roverPosition.y)
        assertEquals(Direction.N, rover.roverDirection)
        assertEquals("LMLMLMLMM", rover.movements)
    }

}