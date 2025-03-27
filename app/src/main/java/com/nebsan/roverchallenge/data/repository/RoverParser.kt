package com.nebsan.roverchallenge.data.repository

import com.google.gson.Gson
import com.nebsan.roverchallenge.data.model.RoverData
import javax.inject.Inject

class RoverParser @Inject constructor() {

    fun parseJson(json: String) : RoverData {
        return Gson().fromJson(json, RoverData::class.java)
    }

}