package com.example.orbiscrm.main_activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R

class FollowOnAdapter (val context: Context): RecyclerView.Adapter<FollowOnAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(context.getSystemService(LayoutInflater::class.java).inflate(R.layout.item_follow_on,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val follow_on_title = itemView.findViewById<TextView>(R.id.follow_on_title)
        var follow_on_body = itemView.findViewById<TextView>(R.id.follow_on_body)
        var call_duration_seconds = itemView.findViewById<TextView>(R.id.follow_on_client_name)

    }
}