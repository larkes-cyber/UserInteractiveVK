package com.example.vkcupsteptwo.ui.screen.compare_screen.state

import com.example.vkcupsteptwo.model.CompareForm

data class CompareState(
    val isLoading:Boolean = false,
    val items: List<CompareForm> = emptyList(),
    val endReached:Boolean = false,
    val page:Int = 0
)