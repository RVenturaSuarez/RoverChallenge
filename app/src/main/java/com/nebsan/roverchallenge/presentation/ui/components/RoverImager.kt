package com.nebsan.roverchallenge.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nebsan.roverchallenge.R

@Composable
fun RoverImage(modifier: Modifier = Modifier, size: Dp = 150.dp) {
    Image(
        painter = painterResource(id = R.drawable.rover),
        contentDescription = stringResource(id = R.string.content_desc_rove),
        contentScale = ContentScale.Crop,
        alignment = Alignment.TopCenter,
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(10.dp))
    )
}