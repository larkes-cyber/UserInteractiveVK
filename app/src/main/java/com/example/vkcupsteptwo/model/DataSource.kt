package com.example.vkcupsteptwo.model

data class DataSource(
    val questions:List<QuestionForm>,
    val compareItems:List<CompareForm>,
    val textExamplesWithVariants:List<TextFormWithVariants>,
    val textExamples:List<TextForm>,
    val articleData:List<ArticleForm>
)
