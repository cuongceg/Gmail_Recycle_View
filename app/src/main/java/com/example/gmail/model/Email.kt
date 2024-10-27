package com.example.gmail.model

import com.example.gmail.R

data class Email(
    val title: String,
    val description: String,
    val time: String,
    val imageId:Int = R.drawable.ic_launcher_foreground
)
