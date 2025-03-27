package com.nebsan.roverchallenge.domain.model

data class Rover(
    val topRightCorner: Position,
    val roverPosition: Position,
    val roverDirection: Direction,
    val movements: String
)