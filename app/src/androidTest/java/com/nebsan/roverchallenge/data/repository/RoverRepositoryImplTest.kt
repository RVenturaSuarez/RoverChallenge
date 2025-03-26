package com.nebsan.roverchallenge.data.repository

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Position
import com.nebsan.roverchallenge.domain.model.Rover
import com.nebsan.roverchallenge.domain.repository.RoverRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoverRepositoryImplTest {

    private lateinit var roverRepository: RoverRepository
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
        roverRepository = RoverRepositoryImpl(context)
    }

    @Test
    fun getRoverDataFromFile() {
        val expectedRover = Rover(
            topRightCorner = Position(5, 5),
            roverPosition = Position(1, 2),
            roverDirection = Direction.N,
            movements = "LMLMLMLMM"
        )

        val result = roverRepository.getRoverData()

        assertEquals(expectedRover, result)
    }
}