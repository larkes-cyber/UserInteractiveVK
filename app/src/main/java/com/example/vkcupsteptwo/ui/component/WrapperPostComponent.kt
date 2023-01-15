package com.example.vkcupsteptwo.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.vkcupsteptwo.model.ActionsInfo
import com.example.vkcupsteptwo.model.GroupInfo
import com.example.vkcupsteptwo.ui.theme.CardStrokeColor

@Composable
fun WrapperPostComponent(
    group: GroupInfo,
    postComment:String = "",
    actionsInfo: ActionsInfo? = null,
    content: @Composable() () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp,
        backgroundColor = Color.White
    ) {
        Column(Modifier.padding(top = 16.dp)) {

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 17.dp)
            ) {
                GroupHeaderComponent(groupInfo = group)
                Spacer(modifier = Modifier.height(17.dp))
                PostTextComponent(postComment)
            }

            Box(
                Modifier
                    .padding(horizontal = 6.dp)
                    .padding(top = 15.dp)
            ) {
                Card(
                    modifier = Modifier,
                    backgroundColor = Color.White,
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke((0.5).dp, CardStrokeColor),
                    elevation = 0.dp
                ) {
                    content()
                }
            }
            if(actionsInfo != null) {
                Box(Modifier
                    .padding(start = 24.dp)
                    .padding(vertical = 13.dp)
                ) {
                    ActionsBarComponent(actionsInfo.likes,
                        actionsInfo.comments,
                        actionsInfo.reposts)
                }
            }else{
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }

}