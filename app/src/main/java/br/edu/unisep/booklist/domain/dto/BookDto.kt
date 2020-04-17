package br.edu.unisep.booklist.domain.dto


data class BookDto(
    val id: Int,
    val title: String,
    val authorName: String,
    val note: String,
    val status: Int
)