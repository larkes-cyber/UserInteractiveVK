package com.example.vkcupsteptwo.ui.screen.rate_article_screen.state

import com.example.vkcupsteptwo.model.ArticleForm
import com.example.vkcupsteptwo.model.TextForm

data class RateArticleState(
    val isLoading:Boolean = false,
    val items: List<ArticleForm> = emptyList(),
    val endReached:Boolean = false,
    val page:Int = 0
)