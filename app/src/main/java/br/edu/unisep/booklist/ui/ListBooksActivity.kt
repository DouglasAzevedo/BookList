package br.edu.unisep.booklist.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.booklist.R
import br.edu.unisep.booklist.domain.dto.BookDto
import br.edu.unisep.booklist.ui.adapter.ListBooksAdapter
import br.edu.unisep.booklist.ui.viewmodel.ListBookViewModel
import kotlinx.android.synthetic.main.activity_list_books.*

class ListBooksActivity : AppCompatActivity() {

    private val viewModel: ListBookViewModel by lazy {
        ViewModelProvider(this).get(ListBookViewModel::class.java)
    }

    private val adapter = ListBooksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_books)

        setupList()
        setupEvents()
    }

    private fun setupList() {
        listBooks.layoutManager = LinearLayoutManager(this)
        listBooks.adapter = adapter

        listBooks.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        viewModel.books.observe(this, Observer { onListResult(it) })
        viewModel.findAll()
    }

    private fun onListResult(list: List<BookDto>) {
        adapter.updateBook(list)
    }

    private fun setupEvents() {
        buttonNewBook.setOnClickListener {
            openNewBook()
        }
    }

    private fun openNewBook() {
        val intentNewBook = Intent(this, NewBookAcitivity::class.java)
        startActivityForResult(intentNewBook, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            viewModel.findAll()
        }
    }
}
