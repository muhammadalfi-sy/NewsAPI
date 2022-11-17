package com.example.x_project.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.x_project.model.Article

@Composable
fun NewsApp(listArticle: List<Article>) {
    Scaffold(topBar = {
        TopAppBar() {
            Icon(Icons.Rounded.Menu, contentDescription = "Icon Home")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Headline News")
        }
    }) {
        LazyColumn {
            items(listArticle) { article ->
                NewsCard(article = article)
            }
        }
    }
}

@Composable
fun NewsCard(article: Article) {
    Card(elevation = 8.dp) {
        Column() {
            AsyncImage(
                model = article.urlToImage,
                contentDescription = "News Image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = article.title)
        }
    }
}