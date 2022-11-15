package com.example.x_project.network

import com.example.x_project.model.NewsData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://newsapi.org/v2/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService { // Untuk define API yang dipakai
    @GET("top-headlines?country=id&apiKey=1c0bed622df14993bab444ba3742f369")
    suspend fun getTopHeadline(): NewsData
}

object Api {
    val newsApiService: NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}