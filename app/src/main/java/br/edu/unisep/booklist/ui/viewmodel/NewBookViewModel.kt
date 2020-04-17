package br.edu.unisep.booklist.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.booklist.domain.dto.BookDto
import br.edu.unisep.booklist.domain.dto.NewBookDto
import br.edu.unisep.booklist.domain.repository.BookRepository
import kotlinx.coroutines.launch

class NewBookViewModel : ViewModel() {

    private val bookRepository = BookRepository()

    val saveBook = MutableLiveData<Boolean>()

    fun save(newBook : NewBookDto) {
        viewModelScope.launch {
            bookRepository.save(newBook)
            saveBook.postValue(true)
        }
    }

}