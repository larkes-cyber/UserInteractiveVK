package com.example.vkcupsteptwo.ui.screen.drag_text_variants_screen.component

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.ui.theme.ComparableButtonStrokeColor
import com.example.vkcupsteptwo.ui.theme.SelectedFirstComparableColor
import com.example.vkcupsteptwo.ui.theme.SelectedPasteButton
import com.example.vkcupsteptwo.ui.theme.montserrat

@Composable
fun VariantButtonComponent(
    title:String,
    callback:(Int) -> Unit,
    index:Int,
    isSelected:Boolean
) {
    val onClickState = remember{
        mutableStateOf(false)
    }

    if(!isSelected)
    Button(
        onClick = {
            callback(index)
            onClickState.value = !onClickState.value
        },
        colors = ButtonDefaults.buttonColors(if(onClickState.value) ComparableButtonStrokeColor else Color.White),
        elevation = ButtonDefaults.elevation(0.dp),
        border = BorderStroke(width = 1.dp, if(onClickState.value)SelectedPasteButton else ComparableButtonStrokeColor),
        shape = RoundedCornerShape(30.dp),
        contentPadding = PaddingValues(vertical = 1.dp, horizontal = 8.dp)
    ) {
        Text(
            text =  title,
            fontFamily = montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 13.sp,
            color = if(onClickState.value) Color.White else ComparableButtonStrokeColor
        )
    }
    else Box(modifier = Modifier.padding(vertical = 1.dp, horizontal = 8.dp).background(Color.Transparent)) {
        Text(
            text =  title,
            fontFamily = montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 13.sp,
            color = Color.Transparent
        )
    }
}