package com.example.orbiscrm.drawer_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.orbiscrm.databinding.ActivityEmailBinding
import com.example.orbiscrm.drawer_activities.adapters.EmailFragmentsAdapter
import com.google.android.material.tabs.TabLayout

class EmailActivity : AppCompatActivity() {
    private lateinit var list:ArrayList<EmailDataClass>
    private lateinit var emailAdapter: Adapter
    private lateinit var binding:ActivityEmailBinding
    private lateinit var emailViewPagerAdapter: EmailFragmentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.myToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        initialize()
        //emailAdapter = Adapter(this,list)
//        layout.emailRecyclerView.layoutManager = LinearLayoutManager(this)
//        layout.emailRecyclerView.adapter = emailAdapter


        binding.tablayoutEmail.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.emailViewPager.currentItem = tab!!.position

            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })







    }

    private fun initialize()
    {
        list = ArrayList()
        var obj = EmailDataClass("Abhiram Deshpande","Bad quality of goods","The [Product Name] that I received was not as described on your website. The color was different, and the material used was of very low quality. Additionally, the product was poorly made, with many visible defects and imperfections. I was extremely disappointed with the overall quality of the product.")
        for(i in 1..5){
            list.add(obj)
        }
    }
}