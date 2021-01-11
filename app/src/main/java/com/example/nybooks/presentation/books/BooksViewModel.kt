package com.example.nybooks.presentation.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nybooks.presentation.books.data.model.Book

class BooksViewModel : ViewModel(){

    val booksLiveData : MutableLiveData<List<Book>> = MutableLiveData()


    //NOTIFICAR A ACTIVITY QUE OS LIVROS CHEGARAM
    fun getBooks(){
        booksLiveData.value = getBooksAPI()
    }


    //TROCAR ESSA FUNCAO POR A FUNCAO QUE RECEBE OS LIVROS DA API
    fun getBooksAPI() : List<Book> {
        return listOf(
            Book("Senhor dos Aneis", "Autor 1"),
            Book("Chiquititas", "Autor 2"),
            Book("Chaves", "Autor 3"),
            Book("Avangers", "Autor 4")
        )
    }
}