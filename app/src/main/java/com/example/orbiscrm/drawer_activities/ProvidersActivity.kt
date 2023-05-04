package com.example.orbiscrm.drawer_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityProvidersBinding
import com.example.orbiscrm.drawer_activities.adapters.ProviderAdapter
import com.google.api.Distribution.BucketOptions.Linear

class ProvidersActivity : AppCompatActivity() {
    private lateinit var layout:ActivityProvidersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityProvidersBinding.inflate(layoutInflater)
        setContentView(layout.root)

        layout.providersRecyclerView.layoutManager =LinearLayoutManager(this)
        layout.providersRecyclerView.adapter = ProviderAdapter(this)
    }
}