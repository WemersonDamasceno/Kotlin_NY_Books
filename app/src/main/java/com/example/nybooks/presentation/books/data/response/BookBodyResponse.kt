package com.example.nybooks.presentation.books.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class BookBodyResponse(
    @Json(name = "results")
    val bookResults : List<BookResultsResponse>
)

