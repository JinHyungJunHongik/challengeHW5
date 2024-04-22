package com.example.challengehw5.model

import com.example.challengehw5.data.ImageDocumentResponse
import com.example.challengehw5.data.MetaResponse
import com.example.challengehw5.data.SearchResponse

fun SearchResponse.toEntity() = SearchEntity.SearchImageEntity(
    meta = meta?.toEntity(),
    documents = documents?.map {
        it.toEntity()
    }
)

fun MetaResponse.toEntity() = SearchEntity.MetaEntity(
    totalCount = totalCount,
    pageableCount = pageableCount,
    isEnd = isEnd,
)

fun ImageDocumentResponse.toEntity() = SearchEntity.ImageDocumentEntity(
    collection = collection,
    thumbnailUrl = thumbnailUrl,
    imageUrl = imageUrl,
    width = width,
    height = height,
    displaySitename = displaySitename,
    docUrl = docUrl,
    datetime = datetime,
)