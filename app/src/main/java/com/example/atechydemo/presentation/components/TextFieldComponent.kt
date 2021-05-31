package com.example.atechydemo.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atechydemo.R
import com.example.atechydemo.presentation.ui.login.LoginViewModel

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    text : String,
    modifier: Modifier= Modifier,
    keyboardType: KeyboardType,
    leadingIcon: (@Composable() () -> Unit)? = null
) {
    Column(
        modifier = modifier
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(28.dp))
                .border(width = 0.5.dp, color = Color.Gray, shape = RoundedCornerShape(28.dp))
        ) {
            Box(modifier = Modifier.padding(start = 10.dp)) {
                TextField(
                    value = value,
                    onValueChange = onValueChange,
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    leadingIcon = leadingIcon,
                    placeholder = { Text(text = text, color = Color.Gray, style = TextStyle(fontSize = 12.sp))},
                    keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        backgroundColor = Color.White,
                    )
                )
            }
        }
    }

}

@Preview
@Composable
fun Preview(){
   /* CustomTextField("email", modifier = Modifier.padding(), KeyboardType.Email) {
        Icon(
            painter = painterResource(id = R.drawable.ic_email_icon),
            contentDescription = null
        )
    }*/
}