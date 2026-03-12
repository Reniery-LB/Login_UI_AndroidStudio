package com.example.myapplication.screens

import android.text.InputFilter
import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SignUpScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(all = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Create Account",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(50.dp))

            TextField(
                value = username,
                onValueChange = { newValue ->
                    if (newValue.all { it.isLetter() || it == ' ' }) {
                        username = newValue
                    }
                },
                placeholder = { Text("User Name", color = Color.Gray) },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null, tint = Color.Black)
                },
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
            TextField(
                value = email,
                onValueChange = {
                    email = it
                },
                placeholder = {Text("E-mail", color = Color.Gray)},
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null, tint = Color.Black)
                },
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
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = {Text("Password", color = Color.Gray)},
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = null, tint = Color.Black)
                },
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
            TextField(
                value = repeatPassword,
                onValueChange = { repeatPassword = it },
                placeholder = {Text("Repeat password", color = Color.Gray)},
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = null, tint = Color.Black)
                },
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
            Box(
                modifier = Modifier.fillMaxWidth().padding(top = 40.dp)
                    .background(
                        color = Color(0xFF524eb6),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(vertical = 18.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Create Account",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }

            Spacer(modifier = Modifier.padding(top = 30.dp))

            Button(
                onClick = {
                    navController.navigate(route = "welcome")
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack, contentDescription = null,
                    modifier = Modifier.size(60.dp)
                )
            }
        }
    }
}