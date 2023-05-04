package com.example.orbiscrm.drawer_activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R
import com.example.orbiscrm.models.AffiliateClient

class AffiliateClientsAdapter  (val context: Context,var affiliateClientLiist: ArrayList<AffiliateClient>): RecyclerView.Adapter<AffiliateClientsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(context.getSystemService(LayoutInflater::class.java).inflate(R.layout.item_affiliate_clients,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var affiliateClient = affiliateClientLiist.get(position)

        holder.affiliate_client_name.text = affiliateClient.affiliate_client_name
        holder.afiliate_client_company.text = "Affiliate Client Company: "+affiliateClient.company_name
        holder.affiliate_client_location.text = "Affiliate Client Location: "+affiliateClient.location
        holder.affiliate_clinet_revenue.text = "Revenue Stream Generated: "+affiliateClient.revenue_stream_generated
        holder.sub_clients_affiliated.text = "Sub-Clients affiliated: "+affiliateClient.sub_clients_affiliated
    }

    override fun getItemCount(): Int {
        return affiliateClientLiist.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val affiliate_client_name = itemView.findViewById<TextView>(R.id.affiliate_client_name)
        var afiliate_client_company = itemView.findViewById<TextView>(R.id.afiliate_client_company)
        var affiliate_client_location = itemView.findViewById<TextView>(R.id.affiliate_client_location)
        var affiliate_clinet_revenue = itemView.findViewById<TextView>(R.id.affiliate_clinet_revenue)
        var sub_clients_affiliated = itemView.findViewById<TextView>(R.id.sub_clients_affiliated)



    }
}