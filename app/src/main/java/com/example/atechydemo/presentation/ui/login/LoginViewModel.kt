package com.example.atechydemo.presentation.ui.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Shital Awathe
 *
 * Login view model business logic
 */
class LoginViewModel: ViewModel() {
    private var auth: FirebaseAuth = Firebase.auth
    private lateinit var databaseReference: DatabaseReference

    private val loginSuccessFul: MutableLiveData<String> = MutableLiveData()
    val loginResponse: LiveData<String>
        get() = loginSuccessFul

    companion object {
        val TAG = LoginViewModel::class.qualifiedName
    }

    /**
     * get updated text from TextField
     */
    val emailString = mutableStateOf("")

    fun onQueryChange(query: String){
        this.emailString.value = query
    }

    /**
     * get updated password from password field
     */
    val password = mutableStateOf("")

    fun onPasswordChange(query: String){
        this.password.value = query
    }


    /**
     * Login in application
     *
     * @param email
     * @param password
     */
    fun loginApplication(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (auth.currentUser == null) {
                databaseReference = FirebaseDatabase.getInstance().reference.child("Users")
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        loginSuccessFul.postValue("SUCCESS")
                        Log.e(TAG, "Authentication Success")
                        println("Authentication Success... :-)")
                    } else {
                        loginSuccessFul.postValue("FAIL")
                        Log.e(TAG, "Authentication Fail")
                        println("Authentication Fail.. ;-(")
                    }
                }
            }
        }
    }
}