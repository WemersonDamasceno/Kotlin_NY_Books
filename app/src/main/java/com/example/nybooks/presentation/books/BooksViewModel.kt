package com.example.nybooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nybooks.presentation.books.data.ApiService
import com.example.nybooks.presentation.books.data.model.Book
import com.example.nybooks.presentation.books.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel(){

    val booksLiveData : MutableLiveData<List<Book>> = MutableLiveData()


    //NOTIFICAR A ACTIVITY QUE OS LIVROS CHEGARAM
    fun getBooks(){
        //booksLiveData.value = getBooksAPI()
        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse>{
            override fun onResponse(call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {
                if(response.isSuccessful){
                    val books: MutableList<Book> = mutableListOf()

                    response.body()?.let { bookBodyResponse ->
                        for(result in bookBodyResponse.bookResults) {
                            val book = Book(
                                title = result.book_details[0].title,
                                author = result.book_details[0].author,
                                description = result.book_details[0].description
                            )
                            books.add(book)
                        }

                    }
                    booksLiveData.value = books

                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

            }
        })
    }

}