package com.example.firebasesdk.authentication

import com.example.firebasesdk.enum.LoginAuth
import com.example.firebasesdk.events.LoginEvent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import org.greenrobot.eventbus.EventBus

/**
 * @author Shital Awathe
 *
 * This class use to do user authentication with email and password
 */
class UserAuthentication {
    private var auth: FirebaseAuth = Firebase.auth
    private lateinit var databaseReference: DatabaseReference

    fun authenticate(email:String, password:String){
        if (auth.currentUser == null) {
            databaseReference = FirebaseDatabase.getInstance().reference.child("Users")
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    println(">>>>>>>loginSuccessFul")
                    EventBus.getDefault().post(LoginEvent(LoginAuth.SUCCESS))
                } else {
                    println(">>>>>>>login Fail")
                    EventBus.getDefault().post(LoginEvent(LoginAuth.FAIL))
                }
            }
        }
    }
}