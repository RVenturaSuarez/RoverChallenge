package com.nebsan.roverchallenge.domain.repository

import com.nebsan.roverchallenge.domain.model.Rover

interface RoverRepository {
    fun getRoverData() : Rover?
}