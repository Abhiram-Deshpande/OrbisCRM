package com.example.orbiscrm.authentication

import android.content.Intent
import android.graphics.Typeface
import android.graphics.drawable.VectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.text.style.TypefaceSpan
import android.util.Log
import android.view.MotionEvent
import android.view.TouchDelegate
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.text.set
import com.example.orbiscrm.MainActivity
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.values
import com.google.firebase.storage.FirebaseStorage
import kotlin.reflect.typeOf

class LoginActivity : AppCompatActivity() {

    private lateinit var layout:ActivityLoginBinding
    private lateinit var auth:FirebaseAuth
    private lateinit var signUpDialogBuilder:AlertDialog.Builder
    private lateinit var database:DatabaseReference
    private lateinit var storage:FirebaseStorage
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(layout.root)
        auth= FirebaseAuth.getInstance()
        storage= FirebaseStorage.getInstance()

//        layout.paswor

        if(auth.currentUser!=null) {
            var intent = Intent(this@LoginActivity, MainActivity::class.java)
            var databaseReference = FirebaseDatabase.getInstance().reference.child("users").child(
                auth.currentUser!!.email?.split(".")?.get(0) ?: "prasadkhurd964@gmail.com"
            )

            layout.progressBar.visibility = View.VISIBLE

            //intent.putExtra("image_path",databaseReference.))
//                Toast.makeText(this@LoginActivity,"Children count ${databaseReference.getc}",Toast.LENGTH_SHORT).show()

            databaseReference.addValueEventListener(object:ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var name = snapshot.child("name").value as String
                    intent.putExtra("name",name)
                    layout.progressBar.visibility= View.GONE
                    startActivity(intent)
                    finish()
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@LoginActivity,error.message,Toast.LENGTH_SHORT).show()
                }
            })
        }
            layout.loginButton.setOnClickListener{
                login(layout.username.text.trim().toString(),layout.pasword.text.toString().trim())
            }



//        var compoundDrawableList = layout.pasword.compoundDrawables
//        compoundDrawableList.forEach {
//            Log.i("LoginActivityCheckup: ","Drawable null: "+(it==null))
//        }



        var sign_up_string = SpannableString("Do not have an account yet ? Sign Up")
        var styleSpan = StyleSpan(Typeface.BOLD)
        sign_up_string.set(29,35,styleSpan)
        layout.tvSignUp.setOnClickListener{
            signUpDialogBuilder = AlertDialog.Builder(this)
            var dialog  = signUpDialogBuilder.create()
            dialog.setView(layoutInflater.inflate(R.layout.dialog_sign_up,null))
            dialog.setCancelable(true)
            dialog.show()
        }

        }





    private fun login(email:String,password:String){


        auth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener(this) {
                 var name:String?=null
                 var imagePath:String?=null
//            Toast.makeText(this@LoginActivity,"Welcome $email",Toast.LENGTH_SHORT).show()
                intent = Intent(this@LoginActivity,MainActivity::class.java)
                var databaseReference = FirebaseDatabase.getInstance().reference.child("users").child(email.split(".")[0])

                //intent.putExtra("image_path",databaseReference.))
//                Toast.makeText(this@LoginActivity,"Children count ${databaseReference.getc}",Toast.LENGTH_SHORT).show()

                databaseReference.addValueEventListener(object:ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        name = snapshot.child("name").value as String
                        imagePath = snapshot.child("image").value as String
                        intent.putExtra("name",name)
                        intent.putExtra("image",imagePath)
                        startActivity(intent)
                        finish()

                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(this@LoginActivity,error.message,Toast.LENGTH_SHORT).show()
                    }
                })





        }
            .addOnFailureListener(this@LoginActivity){e->
                Toast.makeText(this@LoginActivity,e.message.toString(),Toast.LENGTH_SHORT).show()

            }
    }

    override fun onStart() {
        super.onStart()

    }
}