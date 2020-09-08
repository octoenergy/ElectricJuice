package com.octopus.electricjuice

import androidx.compose.foundation.layout.InnerPadding
import androidx.compose.ui.unit.Dp

fun innerPadding(
    horizontalPadding: Dp,
    verticalPadding: Dp,
): InnerPadding {
    return InnerPadding(
        start = horizontalPadding,
        end = horizontalPadding,
        top = verticalPadding,
        bottom = verticalPadding
    )
}