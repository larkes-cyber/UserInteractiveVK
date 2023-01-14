package com.example.vkcupsteptwo.pagination

interface Paginator<Key, T> {
    suspend fun loadNextItems()
    fun reset()
}