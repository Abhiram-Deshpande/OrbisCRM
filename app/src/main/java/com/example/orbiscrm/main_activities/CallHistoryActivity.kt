package com.example.orbiscrm.main_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityCallHistoryBinding
import com.example.orbiscrm.databinding.ActivityResolvedEmailBinding
import com.example.orbiscrm.main_activities.adapters.CallHistoryAdapter
import com.example.orbiscrm.main_activities.adapters.ResolvedEmailAdapter
import com.example.orbiscrm.models.CallHistory
import com.example.orbiscrm.models.ResolvedEmail
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CallHistoryActivity : AppCompatActivity() {

    private lateinit var layout: ActivityCallHistoryBinding
    private lateinit var callHistory: DatabaseReference
    private lateinit var callHistorylList:ArrayList<CallHistory>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout= ActivityCallHistoryBinding.inflate(layoutInflater)
        setContentView(layout.root)
        callHistory = FirebaseDatabase.getInstance().reference.child("call_history")
        callHistory.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                callHistorylList =ArrayList()
                for (children in snapshot.children){
                    var call_history =children.getValue(CallHistory::class.java)
                    callHistorylList.add(call_history!!)
                }
                layout.callHistoryRecyclerView.adapter = CallHistoryAdapter(this@CallHistoryActivity,callHistorylList)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        layout.callHistoryRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}