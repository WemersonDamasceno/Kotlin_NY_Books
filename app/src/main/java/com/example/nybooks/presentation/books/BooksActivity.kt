package com.example.nybooks.presentation.books

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nybooks.R
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        //O KOTLIN JÁ FAZ AUTOMATICAMENTE O 'FINDVIEWBYID' DO JAVA
        toolbarMain.title = getString(R.string.books)
        setSupportActionBar(toolbarMain)


        //viewModel
        val viewModel : BooksViewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)

        //TODA VEZ QUE TIVER UMA ALTERAÇÃO NA LISTA
        //O OBSERVER VAI RODAR E O
        //O RECYCLER VIEW SERÁ ATUALIZADO
        viewModel.booksLiveData.observe(this, Observer {
            //O ?.let VERIFICA SE O VALOR NAO É NULO
            it?.let {
                //O -> SERVE PARA SUBSTITUIR O NOME it
                //PARA NAO PRECISAR FICAR USANDO rvList.adapter OU rvList.layout
                books ->
                //USAMOS O WITH PARA ACESSAR OS ATRIBUTOS DAQUELE OBJETO DE UMA FORMA MAIS RAPIDA
                with(rvListBooks){
                    layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books)
                }
            }
        })

        //É FEITA A CHAMADA DA FUNÇÃO PARA COLOCAR OS LISVROS NA LISTA
        viewModel.getBooks()



        }

    }