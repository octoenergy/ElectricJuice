package com.octopus.electricjuice.common

import androidx.compose.foundation.Box
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorApplier
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import androidx.ui.tooling.preview.datasource.LoremIpsum
import com.octopus.electricjuice.R
import com.octopus.electricjuice.innerPadding
import com.octopus.electricjuice.theme.*

@Composable
fun LayeredButton(
    string: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primary,
    textColor: Color = MaterialTheme.colors.onPrimary,
    shape: CornerBasedShape = MaterialTheme.shapes.small,
) {
    val contentPadding = innerPadding(horizontalPadding = grid16, verticalPadding = grid16)
    Stack(modifier = modifier.wrapContentSize()) {
        Button(
            onClick = {},
            backgroundColor = backgroundColor.copy(alpha = 0.1f),
            contentColor = backgroundColor.copy(alpha = 0.2f),
            elevation = 0.dp,
            contentPadding = contentPadding,
            shape = shape,
            modifier = Modifier.padding(end = grid24).gravity(Alignment.CenterEnd)) {
            Text(
                string,
                color = transparent
            )
        }
        Button(
            onClick = {},
            backgroundColor = backgroundColor.copy(alpha = 0.2f),
            contentColor = backgroundColor.copy(alpha = 0.2f),
            elevation = 0.dp,
            contentPadding = contentPadding,
            shape = shape,
            modifier = Modifier.padding(end = grid16).gravity(Alignment.CenterEnd)) {
            Text(
                string,
                color = transparent
            )
        }
        Button(
            onClick = {},
            backgroundColor = backgroundColor.copy(alpha = 0.5f),
            contentColor = backgroundColor.copy(alpha = 0.2f),
            elevation = 0.dp,
            contentPadding = contentPadding,
            shape = shape,
            modifier = Modifier.padding(end = grid8).gravity(Alignment.CenterEnd)) {
            Text(
                string,
                color = transparent
            )
        }
        Button(
            onClick = onClick,
            shape = shape,
            elevation = 0.dp,
            contentPadding = contentPadding,
            modifier = Modifier.gravity(Alignment.CenterEnd)) {
            Text(
                string,
                style = MaterialTheme.typography.button,
                color = textColor
            )
        }
    }
}

@Preview
@Composable
fun LayeredButtonPreview() {
    ElectricJuiceTheme {
        LayeredButton(PREVIEW_SHORT_TEXT)
    }
}

@Composable
fun LayeredFab(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primary,
    iconColor: Color = MaterialTheme.colors.onPrimary,
    icon: VectorAsset = vectorResource(id = R.drawable.ic_arrow_right)
) {
    val shape = CircleShape
    Stack(modifier = modifier.wrapContentSize()) {
        Box(
            shape = shape,
            modifier = Modifier.padding(end = grid24).size(fabSize).gravity(Alignment.CenterEnd),
            backgroundColor = backgroundColor.copy(alpha = 0.1f),
        )
        Box(
            shape = shape,
            modifier = Modifier.padding(end = grid16).size(fabSize).gravity(Alignment.CenterEnd),
            backgroundColor = backgroundColor.copy(alpha = 0.2f),
        )
        Box(
            shape = shape,
            modifier = Modifier.padding(end = grid8).size(fabSize).gravity(Alignment.CenterEnd),
            backgroundColor = backgroundColor.copy(alpha = 0.5f),
        )
        FloatingActionButton(
            backgroundColor = backgroundColor,
            elevation = 0.dp,
            modifier = Modifier.gravity(Alignment.CenterEnd),
            onClick = onClick,
        ) {
            Icon(
                asset = icon,
                tint = iconColor,
            )
        }
    }
}

@Preview
@Composable
fun LayeredFabPreview() {
    ElectricJuiceTheme {
        LayeredFab()
    }
}