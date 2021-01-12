package com.example.nybooks.presentation.books.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookResultsResponse (
    @Json(name = "book_details")
    val book_details : List<BooksDetailsResponse>
)