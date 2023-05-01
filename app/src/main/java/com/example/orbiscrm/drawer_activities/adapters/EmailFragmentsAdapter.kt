package com.example.orbiscrm.drawer_activities.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.orbiscrm.drawer_activities.fragments.EmailReceivedFragment
import com.example.orbiscrm.drawer_activities.fragments.EmailSentFragment

class EmailFragmentsAdapter(fa:Fragment) : FragmentStateAdapter(fa){

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->{
                return EmailSentFragment()
            }
            1->{
                return EmailReceivedFragment()
            }
        }
        return EmailSentFragment()
    }
}