package com.example.orbiscrm.main_activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R
import com.example.orbiscrm.models.CallHistory

class CallHistoryAdapter(val context:Context,var callHistoryList:ArrayList<CallHistory>): RecyclerView.Adapter<CallHistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(context.getSystemService(LayoutInflater::class.java).inflate(R.layout.item_call_history,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var call = callHistoryList.get(position)
        holder.call_attendant.text = "Call attendant: "+ call.call_attendant
        holder.call_duration_.text = "The call lasted for: "+ call.call_duration_minutes+" minutes and "+call.call_duration_seconds+" seconds"
        holder.call_summary.text = "Call Summary: "+ call.call_summary
        holder.caller_name.text="Caller name is: "+call.caller
    }

    override fun getItemCount(): Int {
        return callHistoryList.size
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val call_attendant = itemView.findViewById<TextView>(R.id.call_attendant)
        var call_duration_ = itemView.findViewById<TextView>(R.id.call_duration)
        var caller_name =itemView.findViewById<TextView>(R.id.caller_name)
        var call_summary = itemView.findViewById<TextView>(R.id.call_summary)
    }
}