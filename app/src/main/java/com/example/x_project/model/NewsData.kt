package com.example.x_project.model

data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResult: Int
)
