package com.example.orbiscrm.drawer_activities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.orbiscrm.R
import com.example.orbiscrm.drawer_activities.adapters.EmailFragmentsAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class EmailSentFragment : Fragment() {

    private lateinit var emailFragmentsAdapter:EmailFragmentsAdapter
    private lateinit var pager: ViewPager2
    private lateinit var tablayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_email_sent, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        emailFragmentsAdapter = EmailFragmentsAdapter(this)
        pager = view.findViewById(R.id.email_view_pager)
        tablayout = view.findViewById(R.id.tablayout_email)
        pager.adapter = emailFragmentsAdapter
        TabLayoutMediator(tablayout,pager){tab, position ->

        }.attach()

    }

}