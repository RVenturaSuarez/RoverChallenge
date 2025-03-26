package com.nebsan.roverchallenge.data.model

data class RoverData(
    val topRightCorner: PositionData,
    val roverPosition: PositionData,
    val roverDirection: String,
    val movements: String
)
