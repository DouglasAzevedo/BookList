package br.edu.unisep.booklist.domain.repository

import br.edu.unisep.booklist.data.db.BookDb
import br.edu.unisep.booklist.data.entity.Book
import br.edu.unisep.booklist.domain.dto.BookDto
import br.edu.unisep.booklist.domain.dto.NewBookDto

class BookRepository {

    private val bookDao = BookDb.getInstance().getBookDao()

    suspend fun findAll(): List<BookDto> {
        val result = bookDao.findAll()
        return result.map { b ->
            BookDto(b.id ?: 0, b.name,b.author,b.note, b.status)
        }
    }

    suspend fun save(newBook: NewBookDto) {
        val book = Book(newBook.name, newBook.author, newBook.note, newBook.status)
        bookDao.save(book)
    }
}