package com.example.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R


@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var mailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    
    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column(
            modifier = Modifier.fillMaxSize().padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello!",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Sign In to your account",
                fontWeight = FontWeight.Bold
            )
            TextField(
                value = email,
                onValueChange = {
                    email = it
                    mailError = !isValidEmail(it)
                },
                placeholder = { Text("E-Mail", color = Color.Gray) },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null, tint = Color.Black)
                },
                modifier = Modifier.fillMaxWidth().padding(top = 60.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(30.dp)),
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            TextField(
                value = password,
                onValueChange = {
                    password = it
                    passwordError = it.isEmpty() 
                },
                placeholder = { Text("Password", color = Color.Gray) },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = null, tint = Color.Black)
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                    .border(width = 1.dp, Color.Gray, shape = RoundedCornerShape(size = 30.dp)),
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor =  Color.Transparent
                )
            )
            Text(
                text = "Forgot your password?",
                modifier = Modifier.padding(top = 20.dp),
                color = Color.Gray,
                fontSize = 20.sp
            )

            Button(
                onClick = {
                    navController.navigate("welcome")
                },
                modifier = Modifier.fillMaxWidth().padding(top = 52.dp).padding(vertical = 20.dp),
                shape = RoundedCornerShape(30.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF524eb6)
                )
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }

            Text(
                text = "Don't have an account? Create",
                modifier = Modifier.padding(top = 20.dp),
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = "or",
                modifier = Modifier.padding(top = 20.dp),
                fontSize = 20.sp
            )
            Row(
                modifier = Modifier.padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Facebook",
                    modifier = Modifier.size(40.dp)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Image(
                    painter = painterResource(id = R.drawable.github),
                    contentDescription = "Github",
                    modifier = Modifier.size(40.dp)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Image(
                    painter = painterResource(id = R.drawable.linkedln),
                    contentDescription = "Linkedin",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}