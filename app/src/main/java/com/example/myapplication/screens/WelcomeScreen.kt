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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R

@Composable
fun WelcomeScreen(navController: NavHostController) {

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

            Button(
                onClick = {
                    navController.navigate("login")
                },
                modifier = Modifier.fillMaxWidth().padding(top = 32.dp).height(55.dp),
                shape = RoundedCornerShape(30.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF524eb6)
                )
            ) {
                Text(
                    text = "Login",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White
                )
            }

            Button(
                onClick = {
                    navController.navigate("signup")
                },
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp).height(55.dp),
                shape = RoundedCornerShape(30.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                border = androidx.compose.foundation.BorderStroke(
                    2.dp,
                    Color(0xFF524eb6)
                )
            ) {
                Text(
                    text = "Sign Up",
                    color = Color(0xFF524eb6),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
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