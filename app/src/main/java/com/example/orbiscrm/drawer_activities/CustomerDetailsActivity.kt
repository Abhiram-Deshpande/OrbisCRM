package com.example.orbiscrm.drawer_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orbiscrm.databinding.ActivityCustomerDetailsBinding
import com.example.orbiscrm.drawer_activities.adapters.CustomerDetailsAdapter
import com.example.orbiscrm.models.Customer
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CustomerDetailsActivity : AppCompatActivity() {
    private lateinit var customers:DatabaseReference
    private lateinit var layout:ActivityCustomerDetailsBinding
    private lateinit var customersList:ArrayList<Customer>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityCustomerDetailsBinding.inflate(layoutInflater)
        setContentView(layout.root)

        customers = FirebaseDatabase.getInstance().reference.child("customers")
        customers.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                customersList =ArrayList()
                for (children in snapshot.children){
                    var customer =children.getValue(Customer::class.java)
                    customersList.add(customer!!)
                }
                layout.customerDetailsRecyclerView.adapter = CustomerDetailsAdapter(this@CustomerDetailsActivity,customersList)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        layout.customerDetailsRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}