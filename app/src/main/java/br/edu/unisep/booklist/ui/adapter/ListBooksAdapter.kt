package br.edu.unisep.booklist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.booklist.R
import br.edu.unisep.booklist.domain.dto.BookDto
import kotlinx.android.synthetic.main.item_book.view.*

class ListBooksAdapter : RecyclerView.Adapter<ListBooksAdapter.BookViewHolder>() {

    private var books = listOf<BookDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(itemView)
    }

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bindItem(books[position])
    }

    fun updateBook(items: List<BookDto>) {
        this.books = items
        notifyDataSetChanged()
    }

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(book: BookDto) {

            with (itemView) {
                textViewTitle.text = book.title
                textViewAuthor.text = book.authorName
                textViewNote.text = book.note

               val color =  when (book.status) {
                    1 -> R.color.colorLido
                    2 -> R.color.colorQl
                    3 -> R.color.colorLendo
                    else -> R.color.colorAbnd
                }
                setBackgroundColor(context.getColor(color))
            }
        }
    }
}


