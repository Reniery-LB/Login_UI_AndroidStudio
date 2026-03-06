package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Register()
        }
    }
}

@Composable
fun Login() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                onValueChange = { email = it },
                placeholder = { Text("E-Mail", color = Color.Gray) },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null, tint = Color.Black)
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
                onValueChange = { password = it },
                placeholder = { Text("Password", color = Color.Gray) },
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
            Text(
                text = "Forgot your password?",
                modifier = Modifier.padding(top = 20.dp),
                color = Color.Gray,
                fontSize = 20.sp
            )
            Box(
                modifier = Modifier.fillMaxWidth().padding(top = 52.dp)
                    .background(
                        color = Color(0xFF524eb6),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(vertical = 20.dp),
                contentAlignment = Alignment.Center,
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

@Composable
@Preview
fun Register() {
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
                onValueChange = { username = it },
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
                onValueChange = { email = it },
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
            
            Icon(
                imageVector = Icons.Default.ArrowBack, contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
        }
    }
}

@Composable
fun Home() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "App Image",
                modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "Hello",
                modifier = Modifier.padding(top = 40.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Welcome To Little Drop, where you manage you daily tasks",
                modifier = Modifier.padding(top = 16.dp),
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier.padding(top = 32.dp)
                    .background(
                        color = Color(0xFF524eb6),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(horizontal = 90.dp, vertical = 14.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Box(
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
                    .padding(horizontal = 60.dp, vertical = 12.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF524eb6),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(vertical = 14.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Sign Up",
                    color = Color(0xFF524eb6),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = "Sign up using",
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(top = 24.dp)
            )
            Row(
                modifier = Modifier.padding(top = 16.dp),
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
