package com.example.vkcupsteptwo.ui.screen.drag_text_variants_screen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.ui.theme.ComparableButtonStrokeColor
import com.example.vkcupsteptwo.ui.theme.montserrat

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PastedWordComponent(
    word:String,
    callback:(Int) -> Unit,
    index:Int
) {

    val indexState = remember{
        mutableStateOf(index)
    }

    Column(
        Modifier.padding(bottom = 5.dp)
    ) {
        Card(

            backgroundColor = Color.White,
            elevation = 0.dp,
            border = BorderStroke(width = 1.dp, ComparableButtonStrokeColor),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.height(22.dp),
            onClick = {
                callback(indexState.value)
            }
        ) {
            Box(modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)) {
                Text(
                    text =  word,
                    fontFamily = montserrat,
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp,
                    color = ComparableButtonStrokeColor
                )
            }
        }
    }

}