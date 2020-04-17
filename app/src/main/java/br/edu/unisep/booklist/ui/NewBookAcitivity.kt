package br.edu.unisep.booklist.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import br.edu.unisep.booklist.R
import br.edu.unisep.booklist.domain.dto.BookDto
import br.edu.unisep.booklist.domain.dto.NewBookDto
import br.edu.unisep.booklist.ui.viewmodel.NewBookViewModel
import kotlinx.android.synthetic.main.activity_list_books.*
import kotlinx.android.synthetic.main.activity_new_book_acitivity.*
import java.security.AccessController.getContext

class NewBookAcitivity : AppCompatActivity() {

    private val viewModel: NewBookViewModel by lazy {
        ViewModelProvider(this).get(NewBookViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_book_acitivity)

        buttonSave.setOnClickListener { saveBook() }
        viewModel.saveBook.observe(this, Observer { onSaveResult() })
    }

    private fun saveBook() {
        val status = when (RadioGroupL.checkedRadioButtonId) {
            R.id.rbLido -> 1
            R.id.rbQueroLer -> 2
            R.id.rbLendo -> 3
            else -> 4

        }

        val newBook = NewBookDto(
            editTextTitle.text.toString(),
            editTextAuthor.text.toString(),
            editTextNote.text.toString(),
            status
        )

        viewModel.save(newBook)
    }

    private fun onSaveResult() {
        setResult(Activity.RESULT_OK)
        finish()
    }

}
