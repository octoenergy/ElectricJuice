package com.octopus.electricjuice.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val shapes = Shapes(
        small = RoundedCornerShape(topLeft = cornerRadius, topRight = cornerRadius, bottomLeft = 0.dp, bottomRight = cornerRadius),
        medium = RoundedCornerShape(topLeft = cornerRadius, topRight = cornerRadius, bottomLeft = 0.dp, bottomRight = cornerRadius),
        large = RoundedCornerShape(topLeft = cornerRadius, topRight = cornerRadius, bottomLeft = 0.dp, bottomRight = cornerRadius),
)