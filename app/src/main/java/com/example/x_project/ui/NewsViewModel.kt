package com.example.x_project.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.x_project.model.Article
import com.example.x_project.network.Api
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    var newsUiState: List<Article> by mutableStateOf(listOf())
    init {
        getTopHeadlines()
    }

    fun getTopHeadlines() {
        viewModelScope.launch {
            val response = Api.newsApiService.getTopHeadline()

            response.articles.forEach { article: Article ->
                Log.d("response", article.title)
            }
            newsUiState = response.articles
        }
    }
}