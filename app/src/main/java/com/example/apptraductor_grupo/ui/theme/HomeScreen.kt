package com.example.apptraductor_grupo.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apptraductor_grupo.R

@OptIn(ExperimentalMaterial3Api:: class)
@Composable
fun HomeScreen(){
    Scaffold(
        topBar = {
            TopAppBar({ Text("Mi app kotlin")})
        }
    ) {InnerPadding ->
        Column(
            modifier = Modifier
                .padding(InnerPadding)
                .fillMaxSize()
                .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "¡Bienvenido!",
            color = MaterialTheme.colorScheme.primary /* color primario para texto bienvenida */
            )
            Button (onClick = {/* accion futura */}) {
                Text("Presioname")
            }

            Image(
                painter = painterResource(id = R.drawable.logo_foreground),
                contentDescription = "Logo App",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}