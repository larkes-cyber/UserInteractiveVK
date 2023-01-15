package com.example.vkcupsteptwo.ui.component

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.R
import com.example.vkcupsteptwo.ui.theme.*

@Composable
fun ActionsBarComponent(
    likes:Int,
    comments:Int,
    reposts:Int
) {
    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        LikeButtonComponent(likes.toString())
        ButtonActionBar(
            icon = R.drawable.comment_outline,
            title = comments.toString()
        )
        ButtonActionBar(
            icon = R.drawable.reply_outline,
            title = reposts.toString()
        )
    }
}

@Composable
fun ButtonActionBar(
    icon:Int,
    title:String
){
    Button(
        modifier = Modifier.height(33.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = ButtonDefaults.elevation(0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = ButtonActionColor),
        onClick = {},
        contentPadding = PaddingValues(start = 5.dp, end = 5.dp, top = 4.dp, bottom = 3.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "",
                modifier = Modifier.size(19.dp),
                tint = ButtonActionContentColor
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = title,
                fontSize = 12.sp,
                color = ButtonActionContentColor,
                fontWeight = FontWeight.Bold,
                fontFamily = montserrat
            )
        }
    }
}

@Composable
fun LikeButtonComponent(
    title:String
){
    val selectedState = rememberSaveable {
        mutableStateOf(false)
    }

    val titleNum = title.toInt()

    Button(
        modifier = Modifier.height(33.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = ButtonDefaults.elevation(0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = if(selectedState.value) FirstLikeLayerColor else ButtonActionColor),
        onClick = {
                  selectedState.value = !selectedState.value
        },
        contentPadding = PaddingValues(start = 5.dp, end = 5.dp, top = 4.dp, bottom = 3.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if(selectedState.value){
                Card(
                    modifier = Modifier.size(21.dp),
                    shape = RoundedCornerShape(100),
                    backgroundColor = SecondLikeLayerColor
                ) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Icon(
                            painter = painterResource(id = R.drawable.like_inline),
                            contentDescription = "",
                            modifier = Modifier.size(14.dp),
                            tint = Color.White
                        )
                    }
                }
            }else{
                Icon(
                    painter = painterResource(id = R.drawable.like_outline),
                    contentDescription = "",
                    modifier = Modifier.size(19.dp),
                    tint = ButtonActionContentColor
                )
            }
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = if(selectedState.value) (titleNum+1).toString() else title,
                fontSize = 12.sp,
                color = if(selectedState.value) SecondLikeLayerColor else ButtonActionContentColor,
                fontWeight = FontWeight.Bold,
                fontFamily = montserrat
            )
        }
    }
}
