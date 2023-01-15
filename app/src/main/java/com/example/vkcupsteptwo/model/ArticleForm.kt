package com.example.vkcupsteptwo.model

data class ArticleForm(
    val  currentValue:Int,
    val  count:Int,
    val  title:String,
    val  group: GroupInfo,
    val  postData: PostData
)