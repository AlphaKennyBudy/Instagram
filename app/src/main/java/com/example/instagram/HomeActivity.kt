package com.example.instagram

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(0) {

    private val TAG = "HomeActivity"
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupBottomNavigation()
        Log.d(TAG, "onCreate: ")

        mAuth = FirebaseAuth.getInstance()
//        mAuth.signOut()
//        mAuth.signInWithEmailAndPassword("mr.adil777@gmail.com","adil2000adil")
//            .addOnCompleteListener{
//                if (it.isSuccessful) {
//                    Log.d(TAG, "signIn: success")
//                } else {
//                    Log.e(TAG, "signIn: failure", it.exception)
//                }
//            }
        sign_out_text.setOnClickListener {
            mAuth.signOut()
        }
        mAuth.addAuthStateListener {
            if (mAuth.currentUser == null) {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (mAuth.currentUser == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
