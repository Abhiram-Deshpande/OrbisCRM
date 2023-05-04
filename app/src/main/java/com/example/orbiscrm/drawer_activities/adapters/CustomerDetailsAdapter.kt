package com.example.orbiscrm.drawer_activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R
import com.example.orbiscrm.models.Customer

class CustomerDetailsAdapter (val context: Context, var customerList: ArrayList<Customer>): RecyclerView.Adapter<CustomerDetailsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(context.getSystemService(LayoutInflater::class.java).inflate(R.layout.item_customer,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var customer = customerList.get(position)
        holder.customer_category.text ="Customer Category: "+customer.category
        holder.customer_conact.text ="Customer Contact: "+customer.contact
        holder.customer_location.text ="Customer Location: "+customer.address
        holder.customer_name.text ="Customer name: "+customer.name
    }

    override fun getItemCount(): Int {
        return customerList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val customer_name = itemView.findViewById<TextView>(R.id.customer_name)
        var customer_conact = itemView.findViewById<TextView>(R.id.customer_conact)
        var customer_category = itemView.findViewById<TextView>(R.id.customer_category)
        var customer_location = itemView.findViewById<TextView>(R.id.customer_location)


    }
}