package com.example.orbiscrm.main_activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R
import com.example.orbiscrm.models.TechHistory

class TechHistoryAdapter
    (val context: Context,var techHistoryList:ArrayList<TechHistory>): RecyclerView.Adapter<TechHistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(context.getSystemService(LayoutInflater::class.java).inflate(R.layout.item_tech_history,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var history = techHistoryList.get(position)
        holder.tech_history_event_title.text =history.event_title
        holder.tech_history_what_steps_were_taken.text = "Steps taken to resolve: "+history.tech_history_what_steps_were_taken.toString()
        holder.tech_history_what_was_the_actual_problem.text ="The actual problem was, "+history.what_was_the_actual_problem
    }

    override fun getItemCount(): Int {
        return techHistoryList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tech_history_event_title = itemView.findViewById<TextView>(R.id.tech_history_event_title)
        var tech_history_what_was_the_actual_problem = itemView.findViewById<TextView>(R.id.tech_history_what_was_the_actual_problem)
        var tech_history_what_steps_were_taken = itemView.findViewById<TextView>(R.id.tech_history_what_steps_were_taken)

    }
}