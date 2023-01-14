package com.example.vkcupsteptwo.ui.screen.questions_screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.ui.component.*
import com.example.vkcupsteptwo.model.ActionsInfo
import com.example.vkcupsteptwo.model.QuestionForm
import com.example.vkcupsteptwo.ui.theme.SubTitleColor
import com.example.vkcupsteptwo.ui.theme.montserrat

@Composable
fun QuestionFormComponent(
    data: QuestionForm
) {

    val alreadyAnsweredState = rememberSaveable{
        mutableStateOf(true)
    }

    fun callback(){
        alreadyAnsweredState.value = false
    }

    fun backCallback(){
        alreadyAnsweredState.value = true
    }
    WrapperPostComponent(
        group = data.group,
        postComment = "Вопрос:${data.count}/${data.currentValue}",
        actionsInfo = ActionsInfo(12,12,12)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 27.dp)
                .padding(horizontal = 22.dp)
        ) {
            TitlePostComponent(data.postData.title)
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = data.postData.postKind,
                color = SubTitleColor,
                fontFamily = montserrat,
                fontWeight = FontWeight.Medium,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(12.dp))

            data.answers.forEachIndexed { index, s ->
                AnswerButtonComponent(
                    answer = s,
                    callback = ::callback,
                    isActive = alreadyAnsweredState.value,
                    backCallback = ::backCallback
                )
                Spacer(modifier = Modifier.height(9.dp))
            }
        }
    }


}