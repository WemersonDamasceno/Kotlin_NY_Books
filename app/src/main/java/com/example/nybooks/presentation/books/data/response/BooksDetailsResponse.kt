package com.example.nybooks.presentation.books.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BooksDetailsResponse(
    @Json(name = "title")
    val title : String,
    @Json(name = "author")
    val author : String,
    @Json(name = "description")
    val description : String
)