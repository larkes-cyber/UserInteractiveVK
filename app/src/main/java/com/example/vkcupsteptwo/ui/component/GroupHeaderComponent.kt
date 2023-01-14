package com.example.vkcupsteptwo.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.model.GroupInfo
import com.example.vkcupsteptwo.ui.theme.SubTitleColor
import com.example.vkcupsteptwo.ui.theme.vkdisplay

@Composable
fun GroupHeaderComponent(
    groupInfo: GroupInfo
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = groupInfo.icon),
            contentDescription = "",
            modifier = Modifier.size(35.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            SubTitleComponent(
                title = groupInfo.name,
                size = 15
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = groupInfo.date,
                fontSize = 9.sp,
                fontFamily = vkdisplay,
                fontWeight = FontWeight.Medium,
                color = SubTitleColor
            )
        }
    }
}