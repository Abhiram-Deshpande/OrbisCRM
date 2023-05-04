package com.example.orbiscrm.main_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityResolvedEmailBinding
import com.example.orbiscrm.databinding.ActivityTechHistoryActicityBinding
import com.example.orbiscrm.main_activities.adapters.ResolvedEmailAdapter
import com.example.orbiscrm.main_activities.adapters.TechHistoryAdapter
import com.example.orbiscrm.models.ResolvedEmail
import com.example.orbiscrm.models.TechHistory
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ResolvedEmailActivity : AppCompatActivity() {

    private lateinit var layout: ActivityResolvedEmailBinding
    private lateinit var payments: DatabaseReference
    private lateinit var resolvedEmailList:ArrayList<ResolvedEmail>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout= ActivityResolvedEmailBinding.inflate(layoutInflater)
        setContentView(layout.root)
        payments = FirebaseDatabase.getInstance().reference.child("resolved_emails")
        payments.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                resolvedEmailList =ArrayList()
                for (children in snapshot.children){
                    var tech_history =children.getValue(ResolvedEmail::class.java)
                    resolvedEmailList.add(tech_history!!)
                }
                layout.resolvedEmailRecyclerView.adapter = ResolvedEmailAdapter(this@ResolvedEmailActivity,resolvedEmailList)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        layout.resolvedEmailRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}