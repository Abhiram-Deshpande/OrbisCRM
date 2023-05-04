package com.example.orbiscrm.main_activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R
import com.example.orbiscrm.models.Payment

class PaymentsActivityAdapter (val context: Context,var paymentList:ArrayList<Payment>): RecyclerView.Adapter<PaymentsActivityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(context.getSystemService(LayoutInflater::class.java).inflate(R.layout.item_payments,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.payment_issuer.text="Payment issuer : "+paymentList.get(position).payment_issuer
        holder.payment_amount.text="Payment amount : "+paymentList.get(position).amount.toString()
        holder.payment_status.text="Payment issuer : "+paymentList.get(position).payment_status

    }

    override fun getItemCount(): Int {
        return paymentList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val payment_issuer = itemView.findViewById<TextView>(R.id.payment_issuer)
        var payment_status = itemView.findViewById<TextView>(R.id.payment_status)
        var payment_amount = itemView.findViewById<TextView>(R.id.payment_amount)
        var payment_logo = itemView.findViewById<ImageView>(R.id.payment_logo)


    }
}