package com.example.vkcupsteptwo.ui.screen.compare_screen.component

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.ui.theme.ComparableButtonStrokeColor
import com.example.vkcupsteptwo.ui.theme.ComparableButtonTitleColor
import com.example.vkcupsteptwo.ui.theme.SelectedFirstComparableColor
import com.example.vkcupsteptwo.ui.theme.montserrat

@Composable
fun FirstComparableButtonComponent(
    title:String,
    callback:(Int, Float) -> Unit,
    index:Int,
    removeCompareCallback:(Int) -> Unit,
    isSelected:Boolean
) {
        var columnWidthPx by remember {
            mutableStateOf(0f)
        }


        val selectedState = rememberSaveable{
            mutableStateOf(false)
        }

        Button(
            modifier = Modifier
                .onGloballyPositioned { coordinates ->
                    // Set column height using the LayoutCoordinates
                    columnWidthPx = coordinates.size.width.toFloat()
                },
            onClick = {
                if(!selectedState.value) callback(index, columnWidthPx)
                else {
                    Log.d("thereis","selectedState.value.toString()")

                    removeCompareCallback(index)
                }
                selectedState.value = !selectedState.value
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = if(isSelected) SelectedFirstComparableColor else Color.White),
            elevation = ButtonDefaults.elevation(0.dp),
            border = BorderStroke(width = 1.dp, ComparableButtonStrokeColor),
            shape = RoundedCornerShape(30.dp),
            contentPadding = PaddingValues(vertical = 12.dp, horizontal = 16.dp)
        ) {
            Text(
                text =  title,
                fontFamily = montserrat,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                color = ComparableButtonStrokeColor
            )
        }
}