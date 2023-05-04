package com.example.orbiscrm.main_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityMessageHistoryBinding
import com.example.orbiscrm.main_activities.adapters.MessageHistoryAdapter

class MessageHistoryActivity : AppCompatActivity() {
    private lateinit var layout:ActivityMessageHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityMessageHistoryBinding.inflate(layoutInflater)
        setContentView(layout.root)

        layout.messageHistoryRecyclerView.layoutManager = LinearLayoutManager(this)
        layout.messageHistoryRecyclerView.adapter = MessageHistoryAdapter(this)
    }
}