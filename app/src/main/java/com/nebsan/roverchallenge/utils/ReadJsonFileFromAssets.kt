package com.nebsan.roverchallenge.utils

import android.content.Context

fun readJsonFileFromAssets(context: Context ,fileName: String): String {
    return context.assets.open(fileName).bufferedReader().use { it.readText() }
}