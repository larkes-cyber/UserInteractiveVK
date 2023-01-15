package com.example.vkcupsteptwo.ui.screen.drag_text_variants_screen.state

import com.example.vkcupsteptwo.model.TextFormWithVariants

data class DragTextVariantsState(
    val isLoading:Boolean = false,
    val items: List<TextFormWithVariants> = emptyList(),
    val endReached:Boolean = false,
    val page:Int = 0
)