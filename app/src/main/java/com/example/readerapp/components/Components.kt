package com.example.readerapp.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
 fun ReaderLogo() {
    Text(
        text = "A.Reader",
        color = Color.Red.copy(alpha = 0.5f),
        style = MaterialTheme.typography.displaySmall
    )
}