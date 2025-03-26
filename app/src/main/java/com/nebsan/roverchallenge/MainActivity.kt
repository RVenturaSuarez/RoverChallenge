package com.nebsan.roverchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.nebsan.roverchallenge.presentation.ui.RoverExpandedScreen
import com.nebsan.roverchallenge.presentation.ui.RoverScreen
import com.nebsan.roverchallenge.ui.theme.RoverChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoverChallengeTheme {
                val windowSizeClass = calculateWindowSizeClass(activity = this)

                if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
                    RoverScreen(this)
                } else {
                    RoverExpandedScreen(this)
                }
            }
        }
    }
}
