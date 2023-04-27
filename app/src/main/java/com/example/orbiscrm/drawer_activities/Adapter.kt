package com.example.orbiscrm.drawer_activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R
import org.w3c.dom.Text

class Adapter(val context:Context, var list:ArrayList<EmailDataClass>): RecyclerView.Adapter<com.example.orbiscrm.drawer_activities.Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view = context.getSystemService(LayoutInflater::class.java).inflate(R.layout.email_card_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.received_email_from.text = "From: "+ list.get(position).received_email_from
        holder.received_email_subject.text = "Subject: "+list.get(position).received_email_subject
        holder.received_email_content.text = list.get(position).received_email_content

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        var received_email_from = itemView.findViewById<TextView>(R.id.received_email_from)
        var received_email_subject = itemView.findViewById<TextView>(R.id.received_email_subject)
        var received_email_content = itemView.findViewById<TextView>(R.id.received_email_content)
    }
}