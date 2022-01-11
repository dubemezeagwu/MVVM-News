package com.example.mvvm_news.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvm_news.models.Article

@Dao
interface ArticleDao {

    // Adds a new article to the database, and if already exists, it updates and replaces it.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles (): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticles(article: Article)
}