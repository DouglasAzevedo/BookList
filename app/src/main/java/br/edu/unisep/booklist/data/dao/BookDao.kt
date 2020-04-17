package br.edu.unisep.booklist.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.edu.unisep.booklist.data.entity.Book

@Dao
interface BookDao {

    @Insert
    suspend fun save(book: Book)

    @Query("select * from book")
    suspend fun findAll(): List<Book>

}