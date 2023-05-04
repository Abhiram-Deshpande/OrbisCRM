package com.example.orbiscrm.main_activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R

class MessageHistoryAdapter(val context: Context): RecyclerView.Adapter<MessageHistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(context.getSystemService(LayoutInflater::class.java).inflate(R.layout.item_message_history,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val message_title = itemView.findViewById<TextView>(R.id.message_title)
        var message_body = itemView.findViewById<TextView>(R.id.message_body)
        var message_verdict = itemView.findViewById<TextView>(R.id.message_verdict)

    }
}