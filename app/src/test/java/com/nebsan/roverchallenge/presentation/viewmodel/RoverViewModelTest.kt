package com.nebsan.roverchallenge.presentation.viewmodel

import com.nebsan.roverchallenge.domain.model.Direction
import com.nebsan.roverchallenge.domain.model.Position
import com.nebsan.roverchallenge.domain.model.Rover
import com.nebsan.roverchallenge.domain.usecase.GetRoverDataUseCase
import com.nebsan.roverchallenge.domain.usecase.RoverUseCase
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@ExperimentalCoroutinesApi
class RoverViewModelTest {

    private val getRoverDataUseCase: GetRoverDataUseCase = mockk()
    private val roverUseCase: RoverUseCase = mockk()

    private lateinit var viewModel: RoverViewModel

    @get:Rule
    val dispatcherRule = TestViewModelScopeRule()

    @ExperimentalCoroutinesApi
    class TestViewModelScopeRule(private val dispatcher: TestDispatcher = StandardTestDispatcher()) :
        TestWatcher() {

        override fun starting(description: Description?) {
            super.starting(description)
            Dispatchers.setMain(dispatcher)
        }

        override fun finished(description: Description?) {
            super.finished(description)
            Dispatchers.resetMain()
        }
    }

    @Before
    fun setUp() {
        viewModel = RoverViewModel(getRoverDataUseCase, roverUseCase)
    }


    @Test
    fun `loadInfoRover update rover and isInfoLoaded variables if info is ok`() {
        // GIVEN
        val roverData = Rover(
            topRightCorner = Position(5, 5),
            roverPosition = Position(1, 2),
            roverDirection = Direction.N,
            movements = "LMLMLMLMM"
        )

        // WHEN
        every { getRoverDataUseCase.getRoverData() } returns roverData

        var onSuccessCalled = false
        var onFailureCalled = false

        viewModel.loadInfoRover(
            onDataLoadSuccess = { onSuccessCalled = true },
            onDataLoadFailure = { onFailureCalled = true }
        )

        // THEN
        assertEquals(roverData, viewModel.rover.value)
        assertTrue(viewModel.isInfoLoaded.value)
        assertTrue(onSuccessCalled)
        assertFalse(onFailureCalled)
    }

    @Test
    fun `loadInfoRover should call onDataLoadFailure when no data is available`() {
        // GIVEN
        every { getRoverDataUseCase.getRoverData() } returns null

        // WHEN
        var onSuccessCalled = false
        var onFailureCalled = false

        viewModel.loadInfoRover(
            onDataLoadSuccess = { onSuccessCalled = true },
            onDataLoadFailure = { onFailureCalled = true }
        )

        // THEN
        assertNull(viewModel.rover.value)
        assertFalse(viewModel.isInfoLoaded.value)
        assertFalse(onSuccessCalled)
        assertTrue(onFailureCalled)
    }

    @Test
    fun `executeRoverMovements should update rover info correctly`() = runTest {
        // GIVEN
        val initialRover = Rover(
            topRightCorner = Position(5, 5),
            roverPosition = Position(1, 2),
            roverDirection = Direction.N,
            movements = "LRM"
        )

        viewModel.rover.value = initialRover

        // Mock
        every {
            roverUseCase.executeMovement(any(), 'L')
        } returns initialRover.copy(roverDirection = Direction.W)

        every {
            roverUseCase.executeMovement(any(), 'R')
        } returns initialRover.copy(roverDirection = Direction.N)

        every {
            roverUseCase.executeMovement(any(), 'M')
        } returns initialRover.copy(roverPosition = Position(1, 3))


        // WHEN
        mockkStatic(Dispatchers::class)
        val dispatcher = StandardTestDispatcher()
        every { Dispatchers.IO } returns dispatcher

        viewModel.executeRoverMovements()
        advanceUntilIdle()


        // THEN
        assertEquals(Position(1, 3), viewModel.rover.value!!.roverPosition)
        assertEquals(Direction.N, viewModel.rover.value!!.roverDirection)
        assertEquals(-1, viewModel.currentMovementIndex.intValue)
        assertFalse(viewModel.isRoverInMovement.value)
    }
}

