package com.example.foot_travel_app

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.example.foot_travel_app.navigation.Login
import com.example.foot_travel_app.navigation.Splash

@Composable
fun SplashScreen(navController: NavController){

    //estado de animacion y barra
    var startAnimation by remember { mutableStateOf(false) }
    val progressAnimation by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(2000),
        label = "SplashProgressAnimation"
    )


    //logica de tiempo y navegacion
    LaunchedEffect(true) {
        startAnimation = true
        delay(2000)
        navController.navigate(Login){
            popUpTo(Splash){
                inclusive=true
            }
        }
    }

    //Disenio
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logosplashinicio),
            contentDescription = "Logo",
            modifier = Modifier.size(180.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Food Travel",
            color = Color(0xFF235328),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        LinearProgressIndicator(
            progress = {progressAnimation},
            color = Color(0xFF235328),
            trackColor = Color(0xFFE0E0E0),
            modifier = Modifier.width(200.dp)
        )
        Text(
            text = "Cargando...",
            fontSize = 14.sp
        )
    }


}