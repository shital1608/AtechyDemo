package com.example.atechydemo.presentation.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.firebasesdk.enum.LoginAuth
import com.example.firebasesdk.events.LoginEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class LoginFragment: Fragment() {
    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
           setContent {
               activity?.let { LoginScreen(loginViewModel, it.applicationContext) }
           }
        }
    }


    override fun onStart() {
        super.onStart()
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    override fun onStop() {
        super.onStop()
        if (EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun onMessageEvent(event: LoginEvent){
        Toast.makeText(activity, "${event.message}", Toast.LENGTH_SHORT).show()
        when (event.message) {
            LoginAuth.SUCCESS -> {
                Toast.makeText(activity, "Login Successful", Toast.LENGTH_SHORT).show()
            }
            LoginAuth.FAIL -> {
                Toast.makeText(activity, "Authentication Fail", Toast.LENGTH_SHORT).show()
            }
        }
    }
}