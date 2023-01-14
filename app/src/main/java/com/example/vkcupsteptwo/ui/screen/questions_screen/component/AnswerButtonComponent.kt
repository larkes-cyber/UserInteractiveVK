package com.example.vkcupsteptwo.ui.screen.questions_screen.component

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vkcupsteptwo.R
import com.example.vkcupsteptwo.ui.theme.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AnswerButtonComponent(
    answer:String,
    callback:() -> Unit,
    backCallback:() -> Unit,
    isActive:Boolean
) {
    val selectState = rememberSaveable{
        mutableStateOf(false)
    }

    val transition = updateTransition(
        targetState = selectState.value,
        label = ""
    )
    val number by transition.animateInt(
        transitionSpec = { tween(700) },
        label = "",
        targetValueByState = { isSelect ->
            if(isSelect) 100 else 0
        }
    )

    val transitionForSize = updateTransition(
        targetState = number,
        label = ""
    )

    val size by transitionForSize.animateFloat(
        transitionSpec = { tween(600) },
        label = "",
        targetValueByState = { isSelect ->
            if(isSelect > 20) 1.1f else 0.0f
        }
    )


    Card(

        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
            .combinedClickable(
                onClick = {
                    if(isActive){
                        selectState.value = true
                        callback()
                    }
                },
                onLongClick = {
                    if(selectState.value){
                        selectState.value = false
                        backCallback()
                    }
                },
            )
        ,
        backgroundColor = ButtonColor,
        elevation = 0.dp,
        shape = RoundedCornerShape(6.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .background(SelectedButtonColor)
                .fillMaxHeight()
                .fillMaxWidth(size)
            ) {

            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 19.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AnswerTitleComponent(answer)
                AnimatedVisibility(
                    visible = selectState.value,
                    enter = slideInHorizontally()  + fadeIn(),
                    exit = slideOutHorizontally() + fadeOut()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_check_24),
                            contentDescription = "",
                            modifier = Modifier.size(23.dp),
                            tint = MarkColor
                        )
                        Spacer(modifier = Modifier.width(14.dp))
                        if(selectState.value) AnswerTitleComponent(title = "100%")
                    }
                }

            }
        }
    }
}