package com.nebsan.roverchallenge.domain.usecase

import com.nebsan.roverchallenge.domain.repository.RoverRepository
import javax.inject.Inject

class GetRoverDataUseCase @Inject constructor(private val roverRepository: RoverRepository) {
    fun getRoverData() = roverRepository.getRoverData()
}