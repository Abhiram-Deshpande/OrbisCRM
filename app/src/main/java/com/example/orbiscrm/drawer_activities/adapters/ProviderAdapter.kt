package com.example.orbiscrm.drawer_activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R
import org.w3c.dom.Text

class ProviderAdapter (val context: Context): RecyclerView.Adapter<ProviderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(context.getSystemService(LayoutInflater::class.java).inflate(R.layout.item_providers,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val update_title = itemView.findViewById<TextView>(R.id.provider_name)
        var update_information = itemView.findViewById<TextView>(R.id.provider_chairperson)
        var update_action_employee = itemView.findViewById<TextView>(R.id.provider_office_address)
        var update_logo = itemView.findViewById<TextView>(R.id.provider_type_of_service_provided)
        var provider_contact = itemView.findViewById<TextView>(R.id.provider_contact)



    }
}