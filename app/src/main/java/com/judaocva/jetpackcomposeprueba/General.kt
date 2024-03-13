package com.judaocva.jetpackcomposeprueba

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Button(text: String, btnColors: ButtonColors, textColor: Color, modifier: Modifier) {
    Button(
        onClick = {},
        shape = RoundedCornerShape(20.dp),
        colors = btnColors,
        modifier = modifier,
    ) {
        Text(text = text, color = textColor)
    }
}