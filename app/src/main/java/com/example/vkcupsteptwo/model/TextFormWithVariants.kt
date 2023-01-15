package com.example.vkcupsteptwo.model

data class TextFormWithVariants(
    val  currentValue:Int,
    val  count:Int,
    val  variants:Pair<String, List<String>>,
    val  group: GroupInfo,
    val  postData: PostData,
    val actionsInfo: ActionsInfo
)