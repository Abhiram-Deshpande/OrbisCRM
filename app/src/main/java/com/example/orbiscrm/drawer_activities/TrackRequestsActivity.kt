package com.example.orbiscrm.drawer_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityTrackRequestsBinding
import com.example.orbiscrm.drawer_activities.adapters.TrackRequestAdapter

class TrackRequestsActivity : AppCompatActivity() {
    private lateinit var layout:ActivityTrackRequestsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityTrackRequestsBinding.inflate(layoutInflater)
        setContentView(layout.root)

        layout.trackRequestRecyclerView.layoutManager = LinearLayoutManager(this)
        layout.trackRequestRecyclerView.adapter= TrackRequestAdapter(this)
    }
}