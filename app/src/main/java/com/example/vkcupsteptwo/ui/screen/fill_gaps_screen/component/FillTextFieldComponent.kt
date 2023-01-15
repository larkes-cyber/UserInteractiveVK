package com.example.vkcupsteptwo.ui.screen.fill_gaps_screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.ui.theme.montserrat

@Composable
fun FillTextFieldComponent() {

    val textState = remember{
        mutableStateOf(TextFieldValue(""))
    }

    val widthState = remember {
        mutableStateOf(36.dp)
    }

    BasicTextField(
        value = textState.value,
        onValueChange = {
            if(it.text.length > 6) return@BasicTextField
            if(it.text.length > 3 && textState.value.text.length > it.text.length){
                widthState.value -= 10.dp
                textState.value = it
                return@BasicTextField
            }
            if(it.text.length > 3) widthState.value += 3.dp
            textState.value = it
        },
        singleLine = true,
        modifier = Modifier
            .width(widthState.value)
            .height(20.dp)
        ,
        decorationBox = {
            Box(modifier = Modifier.widthIn(36.dp, Dp.Infinity)) {
                Divider(
                   modifier =  Modifier.height(1.dp).background(Color.Black).align(Alignment.BottomCenter).widthIn(36.dp, Dp.Infinity)
                )
            }
            it()
        },
        textStyle = TextStyle(
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = montserrat,
            fontSize = 12.sp
        )
    )

}