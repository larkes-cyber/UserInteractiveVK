package com.example.vkcupsteptwo.model

data class TextForm(
    val  currentValue:Int,
    val  count:Int,
    val  text:String,
    val  group: GroupInfo,
    val  postData: PostData,
    val actionsInfo: ActionsInfo
)