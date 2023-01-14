package com.example.vkcupsteptwo.ui.screen.compare_screen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.ui.theme.BackgroundColor
import com.example.vkcupsteptwo.ui.theme.ComparableButtonStrokeColor
import com.example.vkcupsteptwo.ui.theme.ComparableButtonTitleColor
import com.example.vkcupsteptwo.ui.theme.montserrat

@Composable
fun SecondComparableButtonComponent(
    title:String,
    callback:((Int,Float) -> Unit)?,
    index:Int
) {

    var columnWidthPx by remember {
        mutableStateOf(0f)
    }

    Button(
        onClick = {
                  if(callback != null){
                      callback(index, columnWidthPx)
                  }
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = BackgroundColor),
        elevation = ButtonDefaults.elevation(0.dp),
        shape = RoundedCornerShape(100),
        contentPadding = PaddingValues(vertical = 12.dp),
        modifier = Modifier.width(50.dp)
    ) {
        Text(
            text =  title,
            fontFamily = montserrat,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,
            color = ComparableButtonTitleColor
        )
    }
}