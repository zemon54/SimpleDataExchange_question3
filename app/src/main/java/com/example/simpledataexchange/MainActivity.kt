package com.example.simpledataexchange

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var bookListView: ListView
    private lateinit var btnGoToDetails: Button
    private lateinit var fabAddBook: FloatingActionButton
    private val books = mutableListOf("Book 1", "Book 2", "Book 3")
    private var selectedBook: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookListView = findViewById(R.id.bookListView)
        btnGoToDetails = findViewById(R.id.btnGoToDetails)
        fabAddBook = findViewById(R.id.fabAddBook)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, books)
        bookListView.adapter = adapter
        bookListView.setOnItemClickListener { _, _, position, _ ->
            selectedBook = books[position]
        }

        btnGoToDetails.setOnClickListener {
            selectedBook?.let {
                val intent = Intent(this, DetailsActivity::class.java)
                intent.putExtra("BOOK_DETAILS", it)
                startActivity(intent)
            } ?: Toast.makeText(this, "Please select a book", Toast.LENGTH_SHORT).show()
        }

        fabAddBook.setOnClickListener {
            val newBook = "Book ${books.size + 1}"
            books.add(newBook)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "$newBook added", Toast.LENGTH_SHORT).show()
        }
    }
}
