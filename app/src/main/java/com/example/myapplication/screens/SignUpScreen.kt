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
import androidx.compose.material.icons.filled.Call
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SignUpScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    val passwordsMatch = password == repeatPassword && password.isNotEmpty()

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    val isNameValid = username.isNotEmpty()
    val isEmailValid = isValidEmail(email)
    val isPhoneValid = phone.length == 10
    val isPasswordValid = password.isNotEmpty()
    val isFormValid = isNameValid && isEmailValid && isPhoneValid && isPasswordValid && passwordsMatch

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
                value = phone,
                onValueChange = { newValue ->
                    if(newValue.all { it.isDigit() } && newValue.length <= 10) {
                        phone = newValue
                    }
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Call, contentDescription = null, tint = Color.Black)
                },
                placeholder = { Text("Phone Number", color = Color.Gray) },
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
            TextField(
                value = repeatPassword,
                onValueChange = { repeatPassword = it },
                placeholder = {Text("Repeat password", color = Color.Gray)},
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

            Button(
                onClick = {
                    navController.navigate(route = "login")
                },
                enabled = isFormValid,
                modifier = Modifier.fillMaxWidth().padding(top = 40.dp).height(55.dp),
                shape = RoundedCornerShape(30.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = if (isFormValid) Color(0xFF524eb6) else Color.Gray
                )
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