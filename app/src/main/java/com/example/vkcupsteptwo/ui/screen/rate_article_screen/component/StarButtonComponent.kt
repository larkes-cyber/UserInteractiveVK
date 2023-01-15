package com.example.vkcupsteptwo.ui.screen.rate_article_screen.component

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vkcupsteptwo.R
import com.example.vkcupsteptwo.ui.screen.questions_screen.component.AnswerTitleComponent
import com.example.vkcupsteptwo.ui.theme.MarkColor
import com.example.vkcupsteptwo.ui.theme.SelectedNavItemColor

@Composable
fun StarButtonComponent(
     isSelected:Boolean,
     index:Int,
     callback:(Int) -> Unit
) {

    IconButton(
        onClick = {
            callback(index)
        },
        modifier = Modifier.size(34.dp)
    ) {
        if(!isSelected) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_star_border_24),
                contentDescription = "",
                tint = SelectedNavItemColor,
                modifier = Modifier.size(34.dp)
            )
        }
        AnimatedVisibility(
            visible = isSelected,
            enter = slideInVertically()  + fadeIn(),
            exit = slideOutVertically() + fadeOut()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_star_24),
                contentDescription = "",
                tint = SelectedNavItemColor,
                modifier = Modifier.size(34.dp)
            )
        }
    }

}