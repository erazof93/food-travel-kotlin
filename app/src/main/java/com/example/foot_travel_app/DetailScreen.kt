package com.example.foot_travel_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, platoId: Int) {
    // Buscamos en tu lista platosArgentina el plato que coincida con el ID que viajó
    val plato = platosArgentina.find { it.id == platoId }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (plato != null){
                Image(
                    painter = painterResource(id = plato.imagen),
                    contentDescription = plato.nombre,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),

                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = plato.nombre,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = plato.descripcion,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {
                        navController.popBackStack()
                    }
                ){
                    Text(text = "Regresar")
                }


            }


            /*
            if (plato != null) {
                Text(text = "Detalle del Plato: ${plato.nombre}", style = MaterialTheme.typography.headlineMedium)
                Text(text = plato.descripcion, modifier = Modifier.padding(top = 8.dp))
            } else {
                Text(text = "Plato no encontrado")
            }*/
        }
    }
}