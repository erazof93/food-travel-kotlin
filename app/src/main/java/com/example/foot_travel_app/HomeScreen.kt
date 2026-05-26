package com.example.foot_travel_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foot_travel_app.navigation.DetallePlato
import androidx.navigation.toRoute

@Composable
fun HomeScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(platosArgentina) { plato ->
            PlatoCard(
                plato = plato,
                onClick = {
                    navController.navigate(DetallePlato(platoId = plato.id))
                }
            )
        }
    }
}