package com.example.orbiscrm

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.bumptech.glide.Glide
import com.example.orbiscrm.authentication.LoginActivity
import com.example.orbiscrm.databinding.ActivityMainBinding
import com.example.orbiscrm.drawer_activities.AffiliateClientsActivity
import com.example.orbiscrm.drawer_activities.CustomerDetailsActivity
import com.example.orbiscrm.drawer_activities.DeveloperActivity
import com.example.orbiscrm.drawer_activities.EmailActivity
import com.example.orbiscrm.drawer_activities.PipelineActivity
import com.example.orbiscrm.main_activities.AdminSpaceActivity
import com.example.orbiscrm.main_activities.AnalyticsActivity
import com.example.orbiscrm.main_activities.CallHistoryActivity
import com.example.orbiscrm.main_activities.CriticalReviewsActivity
import com.example.orbiscrm.main_activities.FollowOnActivity
import com.example.orbiscrm.main_activities.MessageHistoryActivity
import com.example.orbiscrm.main_activities.ResolvedEmailActivity
import com.example.orbiscrm.main_activities.TaskRoomActivity
import com.example.orbiscrm.main_activities.TechHistoryActicity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import java.security.AllPermission

class MainActivity : AppCompatActivity() {
    private lateinit var doYouWantToExit: AlertDialog
    private lateinit var layout: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var storageReference:FirebaseStorage
    private lateinit var databaseReference:FirebaseDatabase
    private lateinit var newRegistrationdialog:AlertDialog.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityMainBinding.inflate(layoutInflater)
        setContentView(layout.root)
        storageReference= FirebaseStorage.getInstance()
        databaseReference = FirebaseDatabase.getInstance()
        window.statusBarColor = resources.getColor(R.color.main_activity_status_bar_color)
        toggle = ActionBarDrawerToggle(
            this,
            layout.mainDrawer,
            R.string.open_drawer,
            R.string.close_drawer
        )
        toggle.syncState()
        registerListener()

        layout.mainDrawer.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                layout.userProfileLinearLayout.visibility = View.INVISIBLE

            }

            override fun onDrawerOpened(drawerView: View) {
            }

            override fun onDrawerClosed(drawerView: View) {
                layout.userProfileLinearLayout.visibility = View.VISIBLE
            }

            override fun onDrawerStateChanged(newState: Int) {
            }
        })

        layout.activityMainName.text= intent.getStringExtra("name")
        Glide.with(this).load(intent.getStringExtra("image")).into(layout.profilePicture)

    }


    override fun onStart() {
        super.onStart()
        buildExitDialogue()
        layout.mainScrollView.isVerticalScrollBarEnabled = false
        layout.analytics.setOnClickListener {
            var intent = Intent(this, AnalyticsActivity::class.java)
            startActivity(intent)
        }
        setDrawerItemListener()
        setProfileImage(intent.extras?.getString("email","null"))


    }

    override fun onBackPressed() {
        doYouWantToExit.show()
        if (layout.mainDrawer.isOpen) layout.mainDrawer.closeDrawer(GravityCompat.START)
    }

    private fun buildExitDialogue() {
        doYouWantToExit = AlertDialog.Builder(this)
            .setCancelable(true)
            .setTitle("Do you want to exit the App ?")
            .setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(
                        this@MainActivity,
                        "Thank You for Using the OrbisCRM",
                        Toast.LENGTH_SHORT
                    ).show()
                    this@MainActivity.finish()
                }
            }).create()
    }

    fun ButtonPressed(view: View) {
        var intent = Intent(this, EmailActivity::class.java)
        startActivity(intent)
    }

    private fun service() {
        Toast.makeText(this, "New Button pressed", Toast.LENGTH_SHORT).show()
    }

    private fun setDrawerItemListener(){

        layout.drawerrNavigationView.setNavigationItemSelectedListener { item->
            var intent: Intent

            when (item.itemId) {

                R.id.menudrawer__affiliate_clients -> {
                    Toast.makeText(this,"Affiliate clients selected",Toast.LENGTH_SHORT).show()
                    intent = Intent(this, AffiliateClientsActivity::class.java)
                    layout.mainDrawer.closeDrawer(GravityCompat.START)
                    startActivity(intent)
                     true
                }

                R.id.menu_drawer_emails -> {
                    intent = Intent(this, EmailActivity::class.java)
                    layout.mainDrawer.closeDrawer(GravityCompat.START)
                    startActivity(intent)
                     true
                }

                R.id.menu_drawer_updates -> {
                    intent = Intent(this, AffiliateClientsActivity::class.java)
                    layout.mainDrawer.closeDrawer(GravityCompat.START)
                    startActivity(intent)
                     true
                }




                R.id.menu_drawer_contacts -> {
                    intent = Intent(this, CustomerDetailsActivity::class.java)
                    layout.mainDrawer.closeDrawer(GravityCompat.START)
                    startActivity(intent)
                     true
                }

                R.id.menu_drawer_track_requests -> {
                    intent = Intent(this, AffiliateClientsActivity::class.java)
                    layout.mainDrawer.closeDrawer(GravityCompat.START)
                    startActivity(intent)
                     true
                }

                R.id.menu_drawer_providers -> {
                    intent = Intent(this, AffiliateClientsActivity::class.java)
                    layout.mainDrawer.closeDrawer(GravityCompat.START)
                    startActivity(intent)
                     true
                }

                R.id.menu_drawer_about_developers -> {
                    intent = Intent(this, DeveloperActivity::class.java)
                    layout.mainDrawer.closeDrawer(GravityCompat.START)
                    startActivity(intent)
                     true
                }

                R.id.menu_drawer_data_privacy -> {
                    val uri = Uri.parse("https://sites.google.com/view/orbiscrmprivacypolicy/home")
                    intent = Intent(Intent.ACTION_VIEW)
                    intent.setData(uri)
                    layout.mainDrawer.closeDrawer(GravityCompat.START)
                    startActivity(intent)
                     true
                }

                R.id.menu_drawer_sign_out -> {
                    FirebaseAuth.getInstance().signOut()
                    layout.mainDrawer.closeDrawer(GravityCompat.START)
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
            }
             false
        }
    }
    private fun setProfileImage(email:String?){
        var firestore = FirebaseStorage.getInstance()
        var emailString = email?.split(".")?.get(0)
        var usersNode = databaseReference.getReference("/users/$emailString").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        when(emailString){

            "atharvalangote123@gmail.com"->{
                firestore.getReference()
            }
            "pratiklagad11@gmail.com"->{

            }
            "prasadkhurd964@gmail.com"->{

            }
        }

    }

    private fun registerListener(){
        layout.newRegistration.setOnClickListener{
        }

        layout.adminSpace.setOnClickListener{
            startActivity(Intent(this@MainActivity,AdminSpaceActivity::class.java))
        }
        layout.criticalReviews.setOnClickListener{
            startActivity(Intent(this@MainActivity,CriticalReviewsActivity::class.java))
        }
        layout.techHistory.setOnClickListener{
            startActivity(Intent(this@MainActivity,TechHistoryActicity::class.java))
        }
        layout.taskRoom.setOnClickListener{
            startActivity(Intent(this@MainActivity,TaskRoomActivity::class.java))
        }
        layout.callHistory.setOnClickListener{
            startActivity(Intent(this@MainActivity,CallHistoryActivity::class.java))
        }
        layout.followOn.setOnClickListener{
            startActivity(Intent(this@MainActivity,FollowOnActivity::class.java))
        }
        layout.messageHistory.setOnClickListener{
            startActivity(Intent(this@MainActivity,MessageHistoryActivity::class.java))
        }

        layout.newRegistration.setOnClickListener{
            newRegistrationdialog = AlertDialog.Builder(this)
            var dialog = newRegistrationdialog.create()
            dialog.setView(layoutInflater.inflate(R.layout.dialog_add_customer_detail,null))
            dialog.show()
        }

    }
}