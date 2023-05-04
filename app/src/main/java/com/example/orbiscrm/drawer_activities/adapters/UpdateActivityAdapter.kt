package com.example.orbiscrm.drawer_activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R

class UpdateActivityAdapter (val context: Context): RecyclerView.Adapter<UpdateActivityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(context.getSystemService(LayoutInflater::class.java).inflate(R.layout.item_update,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val update_title = itemView.findViewById<TextView>(R.id.update_title)
        var update_information = itemView.findViewById<TextView>(R.id.update_information)
        var update_action_employee = itemView.findViewById<TextView>(R.id.update_action_employee)
        var update_logo = itemView.findViewById<ImageView>(R.id.update_action_logo)


    }
}