package com.example.orbiscrm.drawer_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityEmailBinding

class EmailActivity : AppCompatActivity() {
    private lateinit var list:ArrayList<EmailDataClass>
    private lateinit var emailAdapter: Adapter
    private lateinit var layout:com.example.orbiscrm.databinding.ActivityEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityEmailBinding.inflate(layoutInflater)
        setContentView(layout.root)
        setSupportActionBar(layout.myToolbar)
        initialize()
        emailAdapter = Adapter(this,list)
        layout.emailRecyclerView.layoutManager = LinearLayoutManager(this)
        layout.emailRecyclerView.adapter = emailAdapter




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