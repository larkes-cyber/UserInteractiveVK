package com.example.vkcupsteptwo.ui.screen.drag_text_variants_screen.component

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
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
import com.example.vkcupsteptwo.model.TextFormWithVariants
import com.example.vkcupsteptwo.ui.component.TitlePostComponent
import com.example.vkcupsteptwo.ui.component.WrapperPostComponent
import com.example.vkcupsteptwo.ui.theme.montserrat


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DragVariantsFormComponent(
    textFormWithVariants: TextFormWithVariants
) {
    
    var splitedText = textFormWithVariants.variants.first.split(" ")

    val variantsList = textFormWithVariants.variants.second

    var columnHeightPx by remember {
        mutableStateOf(0f)
    }
    var columnWidthPx by remember {
        mutableStateOf(0f)
    }

    var selectedButton = remember{
        mutableStateOf<Int?>(null)
    }
    var selectedButtons = remember {
        mutableListOf<Int?>()
    }

    val gapsValuesState = (splitedText.filter { it == "&" }).map { mutableStateOf<String?>(null) }

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
        group = textFormWithVariants.group,
        actionsInfo = textFormWithVariants.actionsInfo,
        postComment = "попробуйте кайф"
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, top = 20.dp)
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
                TitlePostComponent(textFormWithVariants.postData.title)
                Spacer(modifier = Modifier.height(8.dp))
                var count =  0
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
                                    Log.d("counrer","##########")
                                    Log.d("thereis","#####")

                                    val index = remember {
                                        count
                                    }

                                    if(gapsValuesState[index].value == null) {
                                        Divider(modifier = Modifier
                                            .height(1.dp)
                                            .width(38.dp)
                                            .background(Color.Black)
                                            .align(Alignment.Bottom)
                                            .combinedClickable(
                                                onClick = {
                                                    if (selectedButton.value != null) {
                                                        gapsValuesState[index].value =
                                                            variantsList[selectedButton.value!!]
                                                        selectedButtons.add(selectedButton.value!!)
                                                    }
                                                }
                                            )
                                        )
                                        count++
                                    }else{

                                        fun unSelectButtonCallback(indexButton:Int){
                                            Log.d("check_selected","index:$index  selected:$indexButton")
                                            gapsValuesState[index].value = null
                                            selectedButtons.remove(indexButton)
                                        }

                                        PastedWordComponent(
                                            word = gapsValuesState[index].value!!,
                                            callback = ::unSelectButtonCallback,
                                            index = selectedButton.value!!
                                        )

                                        count++
                                    }

                                }
                                else{
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

            Log.d("check_val", gapsValuesState.toString())
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.padding(top = 15.dp)
            ) {
                textFormWithVariants.variants.second.forEachIndexed { index, item ->

                    fun setButtonToSelected(index:Int){
                        Log.d("index_selected",index.toString())
                        selectedButton.value = index
                    }
                    VariantButtonComponent(
                        title = item,
                        callback = ::setButtonToSelected,
                        index = index,
                        isSelected = index in selectedButtons
                    )
                }
            }

        }
    }

}