package com.example.orbiscrm.drawer_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityUpdatesBinding
import com.example.orbiscrm.drawer_activities.adapters.UpdateActivityAdapter

class UpdatesActivity : AppCompatActivity() {
    private lateinit var layout:ActivityUpdatesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityUpdatesBinding.inflate(layoutInflater)
        setContentView(layout.root)

        layout.updatesActivityRecyclerView.layoutManager = LinearLayoutManager(this)
        layout.updatesActivityRecyclerView.adapter = UpdateActivityAdapter(this)
    }
}