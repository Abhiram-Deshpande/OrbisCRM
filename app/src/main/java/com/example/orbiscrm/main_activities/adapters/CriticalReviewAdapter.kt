package com.example.orbiscrm.main_activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R
import com.example.orbiscrm.main_activities.CriticalReviewsActivity

class CriticalReviewAdapter(val context: Context): RecyclerView.Adapter<CriticalReviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(context.getSystemService(LayoutInflater::class.java).inflate(R.layout.item_critical_reviews,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val critical_title = itemView.findViewById<TextView>(R.id.critical_title)
        var critical_review = itemView.findViewById<TextView>(R.id.critical_review)
        var what_went_critical_in_system = itemView.findViewById<TextView>(R.id.what_went_critical_in_system)

    }
}