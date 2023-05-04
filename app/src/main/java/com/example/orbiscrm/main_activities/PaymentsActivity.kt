package com.example.orbiscrm.main_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityCustomerDetailsBinding
import com.example.orbiscrm.databinding.ActivityPaymentsBinding
import com.example.orbiscrm.drawer_activities.adapters.CustomerDetailsAdapter
import com.example.orbiscrm.main_activities.adapters.PaymentsActivityAdapter
import com.example.orbiscrm.models.Customer
import com.example.orbiscrm.models.Payment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PaymentsActivity : AppCompatActivity() {
    private lateinit var payments: DatabaseReference
    private lateinit var layout: ActivityPaymentsBinding
    private lateinit var paymentList:ArrayList<Payment>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityPaymentsBinding.inflate(layoutInflater)
        setContentView(layout.root)
        payments = FirebaseDatabase.getInstance().reference.child("payments")
        payments.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                paymentList =ArrayList()
                for (children in snapshot.children){
                    var payment =children.getValue(Payment::class.java)
                    paymentList.add(payment!!)
                }
                layout.paymentsActivityRecyclerView.adapter = PaymentsActivityAdapter(this@PaymentsActivity,paymentList)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        layout.paymentsActivityRecyclerView.layoutManager = LinearLayoutManager(this)
    }
    }
