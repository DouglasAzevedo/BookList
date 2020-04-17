package br.edu.unisep.booklist.domain.dto

data class NewBookDto(
    val name: String,
    val author: String,
    val note: String,
    val status: Int
) {
}