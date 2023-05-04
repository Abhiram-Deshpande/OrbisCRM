package com.example.orbiscrm.main_activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R
import com.example.orbiscrm.models.ResolvedEmail

class ResolvedEmailAdapter (val context: Context,var resolvedEmailList:ArrayList<ResolvedEmail>): RecyclerView.Adapter<ResolvedEmailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(context.getSystemService(LayoutInflater::class.java).inflate(R.layout.item_resolved_email,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var resolvedEmail = resolvedEmailList.get(position)
        holder.resolved_email_title.text = resolvedEmail.title
        holder.resolved_email_review.text = resolvedEmail.review
        holder.resolved_email_client_name.text ="Client Name: "+ resolvedEmail.client_name
        holder.resolved_email_reply_body.text =resolvedEmail.body

    }

    override fun getItemCount(): Int {
        return resolvedEmailList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val resolved_email_title = itemView.findViewById<TextView>(R.id.resolved_email_title)
        var resolved_email_reply_body = itemView.findViewById<TextView>(R.id.resolved_email_reply_body)
        var resolved_email_review = itemView.findViewById<TextView>(R.id.resolved_email_review)
        var resolved_email_client_name = itemView.findViewById<TextView>(R.id.resolved_email_client_name)

    }
}