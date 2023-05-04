package com.example.orbiscrm.main_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orbiscrm.databinding.ActivityTechHistoryActicityBinding
import com.example.orbiscrm.main_activities.adapters.PaymentsActivityAdapter
import com.example.orbiscrm.main_activities.adapters.TechHistoryAdapter
import com.example.orbiscrm.models.Payment
import com.example.orbiscrm.models.TechHistory
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class TechHistoryActicity : AppCompatActivity() {
    private lateinit var layout:ActivityTechHistoryActicityBinding
    private lateinit var payments: DatabaseReference
    private lateinit var techHistoryList:ArrayList<TechHistory>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout= ActivityTechHistoryActicityBinding.inflate(layoutInflater)
        setContentView(layout.root)
        payments = FirebaseDatabase.getInstance().reference.child("tech_history")
        payments.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                techHistoryList =ArrayList()
                for (children in snapshot.children){
                    var tech_history =children.getValue(TechHistory::class.java)
                    techHistoryList.add(tech_history!!)
                }
                layout.techHistoryRecyclerView.adapter = TechHistoryAdapter(this@TechHistoryActicity,techHistoryList)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        layout.techHistoryRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}