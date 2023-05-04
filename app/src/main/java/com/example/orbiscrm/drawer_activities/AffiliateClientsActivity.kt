package com.example.orbiscrm.drawer_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orbiscrm.databinding.ActivityAffiliateClientsBinding
import com.example.orbiscrm.drawer_activities.adapters.AffiliateClientsAdapter
import com.example.orbiscrm.drawer_activities.adapters.CustomerDetailsAdapter
import com.example.orbiscrm.models.AffiliateClient
import com.example.orbiscrm.models.Customer
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AffiliateClientsActivity : AppCompatActivity() {
    private lateinit var customers: DatabaseReference
    private lateinit var layout: ActivityAffiliateClientsBinding
    private lateinit var affiliateCientList:ArrayList<AffiliateClient>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityAffiliateClientsBinding.inflate(layoutInflater)
        setContentView(layout.root)

        customers = FirebaseDatabase.getInstance().reference.child("affiliate_clients")
        customers.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                affiliateCientList =ArrayList()
                for (children in snapshot.children){
                    var customer =children.getValue(AffiliateClient::class.java)
                    affiliateCientList.add(customer!!)
                }
                layout.affiliateClientsRecyclerView.adapter = AffiliateClientsAdapter(this@AffiliateClientsActivity,affiliateCientList)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        layout.affiliateClientsRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}