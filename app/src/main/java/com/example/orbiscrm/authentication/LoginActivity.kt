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
import androidx.core.text.set
import com.example.orbiscrm.MainActivity
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlin.reflect.typeOf

class LoginActivity : AppCompatActivity() {

    private lateinit var layout:ActivityLoginBinding
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(layout.root)
        auth= FirebaseAuth.getInstance()

//        layout.paswor

        if(auth.currentUser!=null) {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
            layout.loginButton.setOnClickListener{
                Toast.makeText(this@LoginActivity,"Authenticating",Toast.LENGTH_SHORT).show()
                login(layout.username.text.trim().toString(),layout.pasword.toString().trim())
            }



//        var compoundDrawableList = layout.pasword.compoundDrawables
//        compoundDrawableList.forEach {
//            Log.i("LoginActivityCheckup: ","Drawable null: "+(it==null))
//        }



        var sign_up_string = SpannableString("Do not have an account yet ? Sign Up")
        var styleSpan = StyleSpan(Typeface.BOLD)
        sign_up_string.set(29,35,styleSpan)

        }





    private fun login(email:String,password:String){

        Log.i("LoginActivityCheckup--Email",email)
        Log.i("LoginActivityCheckup--Password",password)

        auth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener(this) {
            Toast.makeText(this@LoginActivity,"Welcome $email",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
            finish()
        }
            .addOnFailureListener(this@LoginActivity){e->
                Toast.makeText(this@LoginActivity,e.message.toString(),Toast.LENGTH_SHORT).show()

            }
    }
}