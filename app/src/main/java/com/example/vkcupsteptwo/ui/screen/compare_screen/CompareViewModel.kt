package com.example.vkcupsteptwo.ui.screen.compare_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkcupsteptwo.Repository
import com.example.vkcupsteptwo.model.CompareForm
import com.example.vkcupsteptwo.pagination.DefaultPaginator
import com.example.vkcupsteptwo.ui.screen.compare_screen.state.CompareState
import com.example.vkcupsteptwo.untils.Constants
import kotlinx.coroutines.launch

class CompareViewModel():ViewModel() {

    val repository = Repository()

    var state by mutableStateOf(CompareState())

    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = {nextPage ->
            repository.getData(nextPage, 5, Constants.CompareScreen)
        },
        getNextKey = {
            state.page + 1
        },
        onSuccess = { items, newKey ->
            state = state.copy(
                items = (state.items + items) as List<CompareForm>,
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