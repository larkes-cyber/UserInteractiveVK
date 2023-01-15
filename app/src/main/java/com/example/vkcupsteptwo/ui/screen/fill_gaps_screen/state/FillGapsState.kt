package com.example.vkcupsteptwo.ui.screen.fill_gaps_screen.state
import com.example.vkcupsteptwo.model.TextForm


data class FillGapsState(
    val isLoading:Boolean = false,
    val items: List<TextForm> = emptyList(),
    val endReached:Boolean = false,
    val page:Int = 0
)
