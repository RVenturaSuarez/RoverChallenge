package com.nebsan.roverchallenge.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.nebsan.roverchallenge.data.model.RoverData
import com.nebsan.roverchallenge.domain.mapper.RoverMapper.toDomain
import com.nebsan.roverchallenge.domain.model.Rover
import com.nebsan.roverchallenge.domain.repository.RoverRepository
import com.nebsan.roverchallenge.utils.readJsonFileFromAssets

class RoverRepositoryImpl(private val context: Context) : RoverRepository {

    override fun getRoverData(): Rover? {
        return try {
            val json = readJsonFileFromAssets(context, "rover_data.json")
            val roverData = Gson().fromJson(json, RoverData::class.java)
            roverData.toDomain()
        } catch (e: JsonSyntaxException) {
            return null
        } catch (e: Exception) {
            return null
        }
    }
}