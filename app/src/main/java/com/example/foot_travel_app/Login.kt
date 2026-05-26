package com.example.foot_travel_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foot_travel_app.navigation.Home
import com.example.foot_travel_app.navigation.Registro

@Composable
fun LoginScreen(navController: NavController, usuarioGuardado: String, passwordGuardado: String) {
    var userOrEmail by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf(false) }

    Scaffold(

    ) {
        paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Bienvenido de nuevo",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
            Text(
                text = "Ingresa tus credenciales para continuar",
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )


            //user
            OutlinedTextField(
                value = userOrEmail,
                onValueChange = { getuserOrEmail -> userOrEmail = getuserOrEmail },
                label = { Text(text = "Ingrese usuario o correo") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )

            //contrasenia
            OutlinedTextField(
                value = pass,
                onValueChange = { getPass -> pass = getPass },
                label = { Text(text = "Ingrese password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            //button
            Button(
                onClick = {
                    if (userOrEmail == usuarioGuardado && pass == passwordGuardado && userOrEmail.isNotBlank()) {
                        navController.navigate(Home)
                        loginError = false
                    } else {
                        loginError = true
                    }
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
            ) {
                Text(
                    text = "Iniciar Sesión",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,

                )
            }

            if (loginError) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Usuario o contraseña incorrectos",
                    color = Color.Red
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            //registrar
            Button(
                onClick = {
                    navController.navigate(Registro)

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),

            ){
                Text(text = "Registrate")
            }
        }
    }
}