package com.example.orbiscrm.drawer_activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R

class TrackRequestAdapter (val context: Context): RecyclerView.Adapter<TrackRequestAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(context.getSystemService(LayoutInflater::class.java).inflate(R.layout.item_track_request,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val track_request_title = itemView.findViewById<TextView>(R.id.track_request_title)
        var track_request_summary = itemView.findViewById<TextView>(R.id.track_request_summary)
        var tracked_request_client_name = itemView.findViewById<TextView>(R.id.tracked_request_client_name)
        var last_checked_track_request = itemView.findViewById<TextView>(R.id.last_checked_track_request)
        var track_request_logo = itemView.findViewById<ImageView>(R.id.track_request_logo)



    }
}