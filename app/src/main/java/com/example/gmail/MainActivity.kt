package com.example.gmail

import android.os.Bundle
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail.adapter.EmailAdapter
import com.example.gmail.model.Email

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val emails = listOf(
            Email("Do Manh Cuong","20225172"),
            Email("Le Minh Manh","20225360"),
            Email("Nguyen Van A", "20225173"),
            Email("Tran Thi B", "20225174"),
            Email("Pham Van C", "20225175"),
            Email("Hoang Thi D", "20225176"),
            Email("Le Van E", "20225177"),
            Email("Nguyen Thi F", "20225178"),
            Email("Tran Van G", "20225179"),
            Email("Pham Thi H", "20225180"),
            Email("Hoang Van I", "20225181"),
            Email("Le Thi J", "20225182"),
            Email("Nguyen Van K", "20225183"),
            Email("Tran Thi L", "20225184")
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val emailAdapter = EmailAdapter(emails)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = emailAdapter

        val searchView: SearchView = findViewById(R.id.searchView)
        searchView.setOnSearchClickListener{
            searchView.isIconified = false
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                emailAdapter.filter(query ?: "")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                emailAdapter.filter(newText ?: "")
                return true
            }
        })
    }
}