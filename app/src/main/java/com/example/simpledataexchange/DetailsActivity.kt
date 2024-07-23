package com.example.simpledataexchange

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    private lateinit var bookDetailsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        bookDetailsTextView = findViewById(R.id.bookDetailsTextView)

        val bookDetails = intent.getStringExtra("BOOK_DETAILS")
        bookDetailsTextView.text = "Details of $bookDetails: This is a sample book description."
    }
}
