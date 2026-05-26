package com.example.foot_travel_app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.foot_travel_app.DetailScreen
import com.example.foot_travel_app.HomeScreen
import com.example.foot_travel_app.LoginScreen
import com.example.foot_travel_app.RegistroUsuario
import com.example.foot_travel_app.SplashScreen

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    var usuarioRegistrado by remember { mutableStateOf("") }
    var passwordRegistrado by remember { mutableStateOf("") }



    NavHost(
        navController = navController,
        startDestination = Splash
    ) {
        // vista Splash
        composable<Splash> {
            SplashScreen(navController = navController)
        }

        // vista Login
        composable<Login> {
            LoginScreen(
                navController = navController,
                usuarioGuardado = usuarioRegistrado,
                passwordGuardado = passwordRegistrado
            )
        }

        composable<Registro> {
            RegistroUsuario(
                navController = navController,
                onUsuarioRegistrado = { nombre -> usuarioRegistrado = nombre },
                onPasswordRegistrado = { clave -> passwordRegistrado = clave }
            )
        }

        // vista home
        composable<Home> {
            HomeScreen(navController = navController)
        }

        composable<DetallePlato> { backStackEntry ->
            val detalle = backStackEntry.toRoute<DetallePlato>()
            DetailScreen(navController = navController, platoId = detalle.platoId)
        }

    }
}