package com.example.vkcupsteptwo.ui.screen.questions_screen.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.ui.theme.roboto

@Composable
fun AnswerTitleComponent(
    title:String
) {
    Text(
        text = title,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = roboto,
        color = Color.Black,
    )
}