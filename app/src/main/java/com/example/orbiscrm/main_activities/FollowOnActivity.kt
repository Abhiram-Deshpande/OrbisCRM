package com.example.orbiscrm.main_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityFollowOnBinding
import com.example.orbiscrm.main_activities.adapters.FollowOnAdapter

class FollowOnActivity : AppCompatActivity() {

    private lateinit var layout:ActivityFollowOnBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityFollowOnBinding.inflate(layoutInflater)
        setContentView(layout.root)

        layout.followOnActivityRecyclerView.layoutManager = LinearLayoutManager(this)
        layout.followOnActivityRecyclerView.adapter = FollowOnAdapter(this)
    }
}