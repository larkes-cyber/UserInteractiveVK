package com.example.vkcupsteptwo.ui.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.ui.theme.vkdisplay

@Composable
fun SubTitleComponent(
    title:String,
    size:Int
) {
    Text(
        text = title,
        fontSize = size.sp,
        fontFamily = vkdisplay,
        fontWeight = FontWeight.Medium,
        color = Color.Black
    )
}