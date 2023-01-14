package com.example.vkcupsteptwo.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.ui.theme.montserrat

@Composable
fun TitleHeaderComponent(
    title:String
) {
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp)
    ) {
        Text(
            text = title,
            fontFamily = montserrat,
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 27.dp, top = 35.dp, bottom = 20.dp)
        )
    }
    
}