package com.example.orbiscrm.drawer_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityContactBinding

class ContactActivity : AppCompatActivity() {
    private lateinit var layout:ActivityContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityContactBinding.inflate(layoutInflater)
        setContentView(layout.root)


    }
}