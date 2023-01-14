package com.example.vkcupsteptwo.ui.component

import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.ui.theme.montserrat

@Composable
fun TitlePostComponent(
    title:String
) {
    Text(
        text = title,
        color = Color.Black,
        fontFamily = montserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.width(220.dp)
    )
}