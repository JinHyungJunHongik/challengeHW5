package com.example.challengehw5.repository


import com.example.challengehw5.model.SearchEntity

interface SearchRepository {

    suspend fun getSearchImage(
        query: String,
        sort: String = "accuracy",
        page: Int = 1,
        size: Int = 80
    ): SearchEntity.SearchImageEntity
}