package com.example.apptraductor_grupo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apptraductor_grupo.viewmodel.usuarioviewmodel

@Composable
fun resumenscreen(viewmodel: usuarioviewmodel) {
    val estado by viewmodel.estado.collectAsState()

    Column(Modifier.padding(16.dp)) {
        Text(
            text = "Resumen del Registro",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(text = "Nombre: ${estado.nombre}")
        Text(text = "Correo: ${estado.correo}")
        Text(text = "Direccion: ${estado.direccion}")
        Text(text = "Contrasena: ${"*".repeat(estado.clave.length)}")
        Text(text = "Terminos: ${if (estado.aceptaterminos) "Aceptados" else "No aceptados"}")
    }
}
