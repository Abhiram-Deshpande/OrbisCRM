package com.example.orbiscrm

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.orbiscrm.databinding.ActivityMainBinding
import com.example.orbiscrm.drawer_activities.EmailActivity
import com.example.orbiscrm.main_activities.AnalyticsActivity
import java.util.Date

class  MainActivity : AppCompatActivity() {
    private lateinit var doYouWantToExit: AlertDialog
    private lateinit var layout:ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityMainBinding.inflate(layoutInflater)
        setContentView(layout.root)
        window.statusBarColor = resources.getColor(R.color.main_activity_status_bar_color)
        toggle = ActionBarDrawerToggle(this,layout.mainDrawer,R.string.open_drawer,R.string.close_drawer)
        toggle.syncState()

        layout.mainDrawer.addDrawerListener(object:DrawerLayout.DrawerListener{
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                layout.userProfileLinearLayout.visibility= View.INVISIBLE

            }

            override fun onDrawerOpened(drawerView: View) {
            }

            override fun onDrawerClosed(drawerView: View) {
                layout.userProfileLinearLayout.visibility = View.VISIBLE
            }

            override fun onDrawerStateChanged(newState: Int) {
            }
        })



    }


    override fun onStart() {
        super.onStart()
        buildExitDialogue()
        layout.mainScrollView.isVerticalScrollBarEnabled= false
        layout.analytics.setOnClickListener{
            var intent = Intent(this,AnalyticsActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onBackPressed() {
        doYouWantToExit.show()
        if(layout.mainDrawer.isOpen)layout.mainDrawer.closeDrawer(GravityCompat.START)
    }

    private fun buildExitDialogue(){
        doYouWantToExit = AlertDialog.Builder(this)
            .setCancelable(true)
            .setTitle("Do you want to exit the App ?")
            .setPositiveButton("Yes",object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity,"Thank You for Using the OrbisCRM",Toast.LENGTH_SHORT).show()
                    this@MainActivity.finish()
                }
            }).create()
    }

    fun ButtonPressed(view: View) {
        var intent = Intent(this,EmailActivity::class.java)
        startActivity(intent)
    }

    private fun service()
    {
        Toast.makeText(this,"New Button pressed",Toast.LENGTH_SHORT).show()
    }
}