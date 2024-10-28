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
            Email("LinkedIn Job Alerts", "30+ new jobs in Vietnam", "13:10"),
            Email("Google Cloud Innovators", "Get started with Cloud APIs", "12:45"),
            Email("GDG Event Platform", "You're ready for GDG on Campus", "11:30",R.drawable.avatar_light_purple_background),
            Email("GitHub", "Welcome to GitHub! Let's get started", "10:20",R.drawable.avatar_red_background),
            Email("Stack Overflow", "Top questions for you this week", "09:50",R.drawable.avatar_orange_background),
            Email("Google Developers", "Join us at the next Developer Summit", "09:15",R.drawable.avatar_orange_background),
            Email("Medium Digest", "Top articles you may like", "08:35"),
            Email("Flutter Weekly", "Latest updates in Flutter", "08:10"),
            Email("Coursera", "Courses related to Software Development", "07:55"),
            Email("YouTube", "New videos on technology this week", "07:30",R.drawable.avatar_red_background),
            Email("CodePen Weekly", "Top trending projects on CodePen", "07:05"),
            Email("Android Weekly", "The latest Android news and resources", "06:50"),
            Email("Kotlin Blog", "New Kotlin tips and tricks", "06:25",R.drawable.avatar_orange_background),
            Email("JetBrains", "Explore new IntelliJ features", "06:00"),
            Email("Google Analytics", "Your weekly performance report", "05:45"),
            Email("Firebase Updates", "What's new in Firebase?", "05:30"),
            Email("Google Play Console", "App performance insights", "05:15",R.drawable.avatar_orange_background),
            Email("Udacity", "Programming Nanodegree courses available", "04:50"),
            Email("LinkedIn Learning", "Recommended learning paths for you", "04:30"),
            Email("TechCrunch", "Top tech news of the day", "04:10",R.drawable.avatar_light_purple_background)
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