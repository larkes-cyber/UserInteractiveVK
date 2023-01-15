package com.example.vkcupsteptwo.ui.screen.fill_gaps_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkcupsteptwo.Repository
import com.example.vkcupsteptwo.model.TextForm
import com.example.vkcupsteptwo.pagination.DefaultPaginator
import com.example.vkcupsteptwo.ui.screen.fill_gaps_screen.state.FillGapsState
import com.example.vkcupsteptwo.untils.Constants
import kotlinx.coroutines.launch

class FillGapsViewModel:ViewModel() {
    private val repository = Repository()

    var state by mutableStateOf(FillGapsState())

    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = {nextPage ->
            repository.getData(nextPage, 5, Constants.FillTextScreen)
        },
        getNextKey = {
            state.page + 1
        },
        onSuccess = { items, newKey ->
            state = state.copy(
                items = (state.items + items) as List<TextForm>,
                page = newKey,
                endReached = items.isEmpty()
            )
        }
    )

    init {
        loadNextItem()
    }

    fun loadNextItem(){
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }

}