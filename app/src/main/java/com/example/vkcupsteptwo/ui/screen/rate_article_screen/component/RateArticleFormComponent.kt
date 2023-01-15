package com.example.vkcupsteptwo.ui.screen.rate_article_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupsteptwo.R
import com.example.vkcupsteptwo.model.ActionsInfo
import com.example.vkcupsteptwo.model.ArticleForm
import com.example.vkcupsteptwo.ui.component.WrapperPostComponent
import com.example.vkcupsteptwo.ui.theme.TopArticleLayoutColor
import com.example.vkcupsteptwo.ui.theme.montserrat

@Composable
fun RateArticleFormComponent(
    articleForm: ArticleForm
) {

    val selectedButton = rememberSaveable{
        mutableStateOf(-1)
    }

    fun selectButton(index:Int){
        selectedButton.value = index
    }


    WrapperPostComponent(
        group = articleForm.group,
        postComment = "Как вам статья?"
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            Box(Modifier
                .fillMaxWidth()
                .height(240.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.article_background_second),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(Modifier
                    .fillMaxSize()
                    .background(TopArticleLayoutColor))

                Box(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 70.dp)
                ) {
                    Text(
                        text = articleForm.title,
                        fontSize = 17.sp,
                        color = Color.White,
                        fontFamily = montserrat,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }


                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 20.dp)
                ) {
                    ArticleButtonComponent("Читать")
                }

            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier.width(185.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                (0..4).map {
                    StarButtonComponent(
                        it <= selectedButton.value,
                        index = it,
                        callback = ::selectButton
                    )
                }

            }
        }
        
    }

}