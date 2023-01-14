package com.example.vkcupsteptwo

import com.example.vkcupsteptwo.model.CompareForm

data class DefaultState<T>(
    val isLoading:Boolean = false,
    val items: List<T>? = emptyList(),
    val endReached:Boolean = false,
    val page:Int = 0
)