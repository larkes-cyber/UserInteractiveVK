package com.example.vkcupsteptwo.model

data class CompareForm(
    val  currentValue:Int,
    val  count:Int,
    val  compareItems:List<Pair<String,String>>,
    val  group: GroupInfo,
    val  postData: PostData
)