package com.example.orbiscrm.main_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityCriticalReviewsBinding
import com.example.orbiscrm.main_activities.adapters.CriticalReviewAdapter

class CriticalReviewsActivity : AppCompatActivity() {
    private lateinit var layout:ActivityCriticalReviewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityCriticalReviewsBinding.inflate(layoutInflater)
        setContentView(layout.root)


        layout.criticalReviewsRecyclerView.layoutManager =LinearLayoutManager(this)
        layout.criticalReviewsRecyclerView.adapter = CriticalReviewAdapter(this)
    }
}