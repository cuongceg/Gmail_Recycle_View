package com.example.gmail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail.R
import com.example.gmail.model.Email

class EmailAdapter(private var emails: List<Email>):RecyclerView.Adapter<EmailAdapter.EmailViewHolder>(){
    private var allEmails: List<Email> = emails

    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iconImageView: ImageView = itemView.findViewById(R.id.iconImageView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        val timestampTextView: TextView = itemView.findViewById(R.id.timestampTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false)
        return EmailViewHolder(view)
    }

    override fun getItemCount() = emails.size

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emails[position]
        holder.iconImageView.setImageResource(email.imageId)
        holder.titleTextView.text = email.title
        holder.descriptionTextView.text = email.description
        holder.timestampTextView.text = email.time
    }

    fun filter(query: String) {
        emails = if (query.isEmpty()) {
            allEmails
        } else {
            allEmails.filter {
                it.title.contains(query, ignoreCase = true) ||
                        it.description.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }
}