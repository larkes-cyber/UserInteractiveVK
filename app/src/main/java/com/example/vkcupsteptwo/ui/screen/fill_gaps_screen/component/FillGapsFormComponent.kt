package com.example.vkcupsteptwo.ui.screen.fill_gaps_screen.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.model.ActionsInfo
import com.example.vkcupsteptwo.model.TextForm
import com.example.vkcupsteptwo.ui.component.TitlePostComponent
import com.example.vkcupsteptwo.ui.component.WrapperPostComponent
import com.example.vkcupsteptwo.ui.screen.drag_text_variants_screen.component.PastedWordComponent
import com.example.vkcupsteptwo.ui.screen.drag_text_variants_screen.component.VariantButtonComponent
import com.example.vkcupsteptwo.ui.theme.montserrat

@Composable
fun FillGapsFormComponent(
    textForm: TextForm
) {
    var splitedText = textForm.text.split(" ")

    var columnHeightPx by remember {
        mutableStateOf(0f)
    }
    var columnWidthPx by remember {
        mutableStateOf(0f)
    }


    val textColumns = mutableListOf<MutableList<String>>()
    var started = true
    var currentColumn = 0
    var rowWidthCount = 0

    fun traserToNextColumn(){
        textColumns.add(mutableListOf())
        currentColumn += 1
        started = false
        rowWidthCount = 0
    }

    for(i in splitedText){
        if(started){
            traserToNextColumn()
        }
        if(rowWidthCount > 280){
            traserToNextColumn()
        }
        textColumns[currentColumn - 1].add(i)
        if(i == "&") rowWidthCount += 15
        else rowWidthCount += i.length * 16
    }


    WrapperPostComponent(
        group = textForm.group,
        actionsInfo = textForm.actionsInfo,
        postComment = "попробуйте кайф"
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, top = 20.dp, bottom = 16.dp)
                .onGloballyPositioned { coordinates ->
                    columnHeightPx = coordinates.size.height.toFloat()
                    columnWidthPx = coordinates.size.width.toFloat()
                }
        ) {



            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TitlePostComponent(textForm.postData.title)
                Spacer(modifier = Modifier.height(8.dp))
                Column(
                    modifier = Modifier.width(280.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    textColumns.forEach { items ->

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            items.forEach {
                                if(it == "&"){
                                    FillTextFieldComponent()
                                }else{
                                    Text(
                                        text = it,
                                        fontFamily = montserrat,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 13.sp,
                                        color = Color.Black
                                    )
                                }

                            }
                        }
                    }
                }
            }


        }
    }
}