package com.example.atechydemo.presentation.ui.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atechydemo.R
import com.example.atechydemo.presentation.components.CustomButton
import com.example.atechydemo.presentation.components.CustomPasswordTextField
import com.example.atechydemo.presentation.components.CustomTextField
import com.example.atechydemo.util.TextFieldUtil


@Composable
fun LoginScreen(loginViewModel: LoginViewModel, mContext: Context) {

    Surface(Modifier.background(color = Color.White)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_teamio_logo),
                contentDescription = null,
                modifier = Modifier.padding(top = 120.dp, start = 113.dp, end = 113.dp)
            )

            Text(
                text = "Sign in to your Account",
                style = TextStyle(color = Color.Black, fontSize = 20.sp),
                modifier = Modifier
                    .padding(top = 80.dp, start = 16.dp, end = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            /**
             * Email field
             */
            val query = loginViewModel.emailString.value
            CustomTextField(
                query, onValueChange = { newValue -> loginViewModel.onQueryChange(newValue) },
                "Email",
                modifier = Modifier.padding(top = 30.dp, start = 16.dp, end = 16.dp),
                KeyboardType.Email
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_email_icon),
                    contentDescription = null
                )
            }

            /**
             * Password Field
             */
            val passwordString = loginViewModel.password.value
            CustomPasswordTextField(
                value = passwordString,
                onValueChange = { newValue1 -> loginViewModel.onPasswordChange(newValue1) },
                modifier = Modifier.padding(
                    top = 30.dp,
                    start = 16.dp,
                    end = 16.dp
                )
            )

            /**
             * login Button
             */
            val email = loginViewModel.emailString.value
            val password = loginViewModel.password.value
            CustomButton(
                modifier = Modifier.padding(top = 89.dp, start = 90.dp, end = 90.dp), onClick = {
                    if(!email.isNullOrEmpty() || !password.isNullOrEmpty()){
                        if(TextFieldUtil.validateEmail(email)){
                            loginViewModel.loginApplication(email = email, password = password)
                        }else{
                            Toast.makeText(mContext, "Please enter valid email", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(mContext, "Email and password should not be empty", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }

}


@Preview
@Composable
fun PreviewLoginScreen(){
   // LoginScreen()
}