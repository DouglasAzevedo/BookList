package br.edu.unisep.booklist.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.booklist.domain.dto.BookDto
import br.edu.unisep.booklist.domain.repository.BookRepository
import kotlinx.coroutines.launch

class ListBookViewModel : ViewModel() {

    private val bookRepository = BookRepository()

    val books = MutableLiveData<List<BookDto>>()

    fun findAll() {
        viewModelScope.launch {
            val result = bookRepository.findAll()
            books.postValue(result)
        }
    }

}