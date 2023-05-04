package com.example.orbiscrm.main_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityTaskRoomBinding
import com.example.orbiscrm.main_activities.adapters.TaskRoomAdapater

class TaskRoomActivity : AppCompatActivity() {
    private lateinit var layout:ActivityTaskRoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityTaskRoomBinding.inflate(layoutInflater)
        setContentView(layout.root)

        layout.tasjRoomRecyclerView.layoutManager =LinearLayoutManager(this)
        layout.tasjRoomRecyclerView.adapter =TaskRoomAdapater(this)
    }
}