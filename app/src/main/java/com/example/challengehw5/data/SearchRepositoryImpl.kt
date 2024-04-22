package com.example.challengehw5.data

import com.example.challengehw5.model.SearchEntity
import com.example.challengehw5.model.toEntity
import com.example.challengehw5.repository.SearchRepository

class SearchRepositoryImpl(
    private val searchRemoteDatasource: SearchRemoteDatasource
) : SearchRepository {
    override suspend fun getSearchImage(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ) = searchRemoteDatasource.getSearchImage(
        query,
        sort,
        page,
        size
    ).toEntity()
}