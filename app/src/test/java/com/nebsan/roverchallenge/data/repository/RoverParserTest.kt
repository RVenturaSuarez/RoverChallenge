package com.nebsan.roverchallenge.data.repository

import com.nebsan.roverchallenge.data.model.PositionData
import com.nebsan.roverchallenge.data.model.RoverData
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RoverParserTest {

    private lateinit var roverParser: RoverParser

    @Before
    fun setUp() {
        roverParser = RoverParser()
    }

    @Test
    fun `parse json data to RoverData correctly`() {
        // GIVEN
        val json = """
            {
                "topRightCorner": { "x": 5, "y": 5 },
                "roverPosition": { "x": 1, "y": 2 },
                "roverDirection": "N",
                "movements": "LMLMLMLMM"
            }
        """.trimIndent()

        // WHEN
        val result = roverParser.parseJson(json)

        val expectedRover = RoverData(
            topRightCorner = PositionData(x = 5, y = 5),
            roverPosition = PositionData(x = 1, y = 2),
            roverDirection = "N",
            movements = "LMLMLMLMM"
        )

        // THEN
        assertEquals(result, expectedRover)
    }
}