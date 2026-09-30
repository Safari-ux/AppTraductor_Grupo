package com.example.apptraductor_grupo.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apptraductor_grupo.ui.screens.registroscreen
import com.example.apptraductor_grupo.ui.screens.resumenscreen
import com.example.apptraductor_grupo.viewmodel.usuarioviewmodel

@Composable
fun appnavigation() {
    val navcontroller = rememberNavController()

    val usuariovm: usuarioviewmodel = viewModel()

    NavHost(
        navController = navcontroller,
        startDestination = "registro"
    ) {
        composable(route = "registro") {
            registroscreen(navcontroller, usuariovm)
        }
        composable(route = "resumen") {
            resumenscreen(usuariovm)
        }
    }
}
