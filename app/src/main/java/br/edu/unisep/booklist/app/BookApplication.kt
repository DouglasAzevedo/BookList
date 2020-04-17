package br.edu.unisep.booklist.app

import android.app.Application
import br.edu.unisep.booklist.data.db.BookDb

class BookApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        BookDb.createInstance(applicationContext)
    }
}