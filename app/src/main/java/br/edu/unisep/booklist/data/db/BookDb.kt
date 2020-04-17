package br.edu.unisep.booklist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.unisep.booklist.data.dao.BookDao
import br.edu.unisep.booklist.data.entity.Book


@Database(
    entities = arrayOf(Book::class),
    exportSchema = false,
    version = 1
)
abstract class BookDb : RoomDatabase() {

    abstract fun getBookDao(): BookDao

    companion object {

        private const val DB_NAME = "db_book"

        private lateinit var instance: BookDb

        fun createInstance(context: Context) {
            instance = Room.databaseBuilder(context,BookDb::class.java, DB_NAME).build()
        }

        fun getInstance() = instance

    }

}