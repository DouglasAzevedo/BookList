package br.edu.unisep.booklist.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book(var name: String,
                var author: String,
                var note: String,
                var status: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}