package com.example.orbiscrm.main_activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R

class TaskRoomAdapater (val context: Context): RecyclerView.Adapter<TaskRoomAdapater.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(context.getSystemService(LayoutInflater::class.java).inflate(R.layout.item_task_room,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val task_name = itemView.findViewById<TextView>(R.id.task_name)
        var task_update_information = itemView.findViewById<TextView>(R.id.task_update_information)
        var task_due_in_days = itemView.findViewById<TextView>(R.id.task_due_in_days)

    }
}