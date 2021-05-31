package com.example.atechydemo.presentation.ui.login

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    val emailString = mutableStateOf("")

    fun onQueryChange(query: String){
        this.emailString.value = query
    }

    val password = mutableStateOf("")

    fun onPasswordChange(query: String){
        this.password.value = query
    }
}