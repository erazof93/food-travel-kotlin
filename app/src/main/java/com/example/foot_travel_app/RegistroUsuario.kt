package com.example.foot_travel_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foot_travel_app.navigation.Login
import kotlinx.coroutines.launch

@Composable
fun RegistroUsuario(navController : NavController, onUsuarioRegistrado: (String) -> Unit, onPasswordRegistrado: (String) -> Unit){
    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    //mensajeria
    var mostrarAlerta by remember { mutableStateOf(false) }
    var mensaje by remember { mutableStateOf("") }

    //dialog
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {SnackbarHost(snackBarHostState)}
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
            OutlinedTextField(
                value = nombre,
                onValueChange = { getNombre -> nombre = getNombre },
                label = { Text(text = "Ingrese nombre") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { getCorreo -> email = getCorreo },
                label = { Text(text = "Ingrese email") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { getNombre -> password = getNombre },
                label = { Text(text = "Ingrese password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )

            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    when{
                        nombre.isBlank() -> mensaje = "Ingresar Nombre"
                        email.isBlank() -> mensaje = "Ingresar correo"
                        password.isBlank() -> mensaje = "Ingresar password"
                        else ->{
                            onUsuarioRegistrado(nombre)
                            onPasswordRegistrado(password)
                            mensaje = "Usuario $nombre con correo $email se cre con exito!!"
                        }
                    }

                    mostrarAlerta = true
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Registrar")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navController.navigateUp()
                },
                modifier = Modifier.fillMaxWidth()

            ) {
                Text(text = "Regresar login")
            }

            if (mensaje.isNotEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = mensaje,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
    if (mostrarAlerta) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = "Registro") },
            text = { Text(text = mensaje) },
            confirmButton = {
                Button(
                    onClick = {
                        navController.navigate(Login)
                        scope.launch {
                            snackBarHostState.showSnackbar("Accion procesado...")
                        }
                    }
                ) { Text(text = "Aceptar") }
            }
        )
    }
}

