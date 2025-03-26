package com.nebsan.roverchallenge.presentation.ui.components

import androidx.annotation.StringRes
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun ButtonAction(
    @StringRes title: Int,
    onClick: () -> Unit,
    enable: Boolean = true
) {
    Button(
        onClick = { onClick() },
        enabled = enable
    ) {
        Text(text = stringResource(id = title))
    }
}