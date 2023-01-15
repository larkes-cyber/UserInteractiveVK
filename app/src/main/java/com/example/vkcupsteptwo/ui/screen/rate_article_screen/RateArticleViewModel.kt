package com.example.vkcupsteptwo.ui.screen.rate_article_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkcupsteptwo.Repository
import com.example.vkcupsteptwo.model.ArticleForm
import com.example.vkcupsteptwo.model.QuestionForm
import com.example.vkcupsteptwo.pagination.DefaultPaginator
import com.example.vkcupsteptwo.ui.screen.questions_screen.QuestionsState
import com.example.vkcupsteptwo.ui.screen.rate_article_screen.state.RateArticleState
import com.example.vkcupsteptwo.untils.Constants
import kotlinx.coroutines.launch

class RateArticleViewModel():ViewModel() {

    private val repository = Repository()

    var state by mutableStateOf(RateArticleState())

    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = {nextPage ->
            repository.getData(nextPage, 5, Constants.RateArticleScreen)
        },
        getNextKey = {
            state.page + 1
        },
        onSuccess = { items, newKey ->
            state = state.copy(
                items = (state.items + items) as List<ArticleForm>,
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