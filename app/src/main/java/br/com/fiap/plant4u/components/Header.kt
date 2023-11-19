package br.com.fiap.plant4u.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.plant4u.R

@Composable
fun Header(
    navController: NavController,
    isMenuOpen: Boolean = false,
    showBackButton: Boolean = true
) {
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.primary_green)),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(modifier = Modifier.width(80.dp)) {
            if(showBackButton) {
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Transparent
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_chevron_left_24),
                        contentDescription = "Ícone de voltar"
                    )
                }
            }
        }
        Button(
            onClick = { navController.navigate("home") },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Transparent
            )
        ) {
            Row {
                Text(
                    text = "Plant4U",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.leaf),
                    contentDescription = "Imagem de uma folha"
                )
            }
        }
        if(isMenuOpen) {
            Button(
                onClick = {
                    navController.navigate("home")
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Transparent
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_close_30),
                    contentDescription = "Ícone de fechar o menu",
                    modifier = Modifier.height(50.dp)
                )
            }
        } else {
            Button(
                onClick = {
                    navController.navigate("menu")
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Transparent
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_menu_30),
                    contentDescription = "Ícone de menu",
                    modifier = Modifier.height(50.dp)
                )
            }
        }
    }
}