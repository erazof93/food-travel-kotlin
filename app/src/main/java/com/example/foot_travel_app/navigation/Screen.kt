package com.example.foot_travel_app.navigation

import kotlinx.serialization.Serializable


@Serializable
object Splash

@Serializable
object Login
@Serializable
object Registro
@Serializable
object Home
@Serializable
data class DetallePlato(val platoId: Int)