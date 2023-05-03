package com.example.orbiscrm.drawer_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.orbiscrm.databinding.ActivityContactBinding
import com.example.orbiscrm.models.Customer
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CustomerDetailsActivity : AppCompatActivity() {
    private lateinit var customers:DatabaseReference
    private lateinit var layout:ActivityContactBinding
    private lateinit var cutomers:ArrayList<Customer>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityContactBinding.inflate(layoutInflater)
        setContentView(layout.root)
        customers = FirebaseDatabase.getInstance().reference.child("customers")
        customers.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (children in snapshot.children){

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })


    }
}