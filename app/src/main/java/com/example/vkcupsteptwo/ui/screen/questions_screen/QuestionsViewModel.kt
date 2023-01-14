package com.example.vkcupsteptwo.ui.screen.questions_screen


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkcupsteptwo.Repository
import com.example.vkcupsteptwo.model.QuestionForm
import com.example.vkcupsteptwo.pagination.DefaultPaginator
import com.example.vkcupsteptwo.untils.Constants.QuestionsScreen
import kotlinx.coroutines.launch


class QuestionsViewModel():ViewModel() {

    private val repository = Repository()

    var state by mutableStateOf(QuestionsState())

    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = {nextPage ->
            repository.getData(nextPage, 5, QuestionsScreen)
        },
        getNextKey = {
            state.page + 1
        },
        onSuccess = { items, newKey ->
            state = state.copy(
                items = (state.items + items) as List<QuestionForm>,
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


data class QuestionsState(
    val isLoading:Boolean = false,
    val items: List<QuestionForm> = emptyList(),
    val endReached:Boolean = false,
    val page:Int = 0
)