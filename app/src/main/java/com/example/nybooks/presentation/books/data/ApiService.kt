package com.example.nybooks.presentation.books.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object ApiService {
    private fun initRetrofit() : Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/books/v3/")

            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit
    }

    //Quando eu for utilizar o ApiService.service
    //será retornado o retrofite ja criado
    val service : NYTServices = initRetrofit().create(NYTServices::class.java)

}