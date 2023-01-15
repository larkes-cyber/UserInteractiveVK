package com.example.vkcupsteptwo.ui.screen.rate_article_screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.R
import com.example.vkcupsteptwo.ui.theme.montserrat

@Composable
fun ArticleButtonComponent(
    title:String
) {

    Button(
        onClick = {  },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues( horizontal = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.flash_icon),
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier.size(13.dp)
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = title,
                fontFamily = montserrat,
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp,
                color = Color.Black
            )
        }
    }

}