package com.example.atechydemo.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.atechydemo.presentation.ui.login.LoginViewModel

@Composable
fun GradientButton(
    text: String,
    gradient: Brush,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { onClick() },
        shape = RoundedCornerShape(50)
    ) {
        Box(
            modifier = Modifier
                .background(gradient)
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = text,
                color = Color.White,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            )
        }
    }
}

@Composable
fun CustomButton(modifier: Modifier = Modifier, email: String, password: String) {
    val gradient =
        Brush.horizontalGradient(listOf(Color(0xFF3CB187), Color(0xFF6FCDD6)))
    Column(modifier = modifier) {
        GradientButton(
            text = "Login",
            gradient = gradient,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .align(Alignment.CenterHorizontally),
            onClick = { println("entered email $email and password $password")}
        )
    }
}

@Preview
@Composable
fun PreviewButton() {
   // CustomButton()
}

