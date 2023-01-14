package com.example.vkcupsteptwo.model

data class QuestionForm(
  val answers:List<String>,
  val  currentValue:Int,
  val  count:Int,
  val  group: GroupInfo,
  val  postData: PostData
)