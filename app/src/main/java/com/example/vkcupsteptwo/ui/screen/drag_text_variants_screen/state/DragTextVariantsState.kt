package com.example.vkcupsteptwo.ui.screen.drag_text_variants_screen.state

import com.example.vkcupsteptwo.model.QuestionForm
import com.example.vkcupsteptwo.model.TextForm

data class DragTextVariantsState(
    val isLoading:Boolean = false,
    val items: List<TextForm> = emptyList(),
    val endReached:Boolean = false,
    val page:Int = 0
)