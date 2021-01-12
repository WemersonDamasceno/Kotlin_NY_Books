package com.example.nybooks.presentation.books.data

import com.example.nybooks.presentation.books.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NYTServices {
    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey : String = "OVNF0YOSCkpfeYJMRkBCge5yVJpYqSHW",
        @Query("list") list : String = "hardcover-fiction"
    ) : Call<BookBodyResponse>


}