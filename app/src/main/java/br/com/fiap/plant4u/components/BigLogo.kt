package br.com.fiap.plant4u.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.plant4u.R

@Composable
fun BigLogo(
    navController: NavController,
    showBackButton: Boolean = false,
    text: String = "Seja bem vindo!"
) {
    Column(
        modifier = Modifier

            .fillMaxWidth()

    ) {
        Column(modifier = Modifier.height(50.dp)) {
            if (showBackButton) {
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.height(100.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = colorResource(id = R.color.primary_green),
                        containerColor = Color.Transparent
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_chevron_left_48),
                        contentDescription = "Ícone de voltar"
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Plant4U",

                fontSize = 48.sp,
                color = colorResource(id = R.color.primary_green)
            )
            Image(
                painter = painterResource(id = R.drawable.big_leaf),
                contentDescription = "Imagem de uma folha"
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                color = colorResource(id = R.color.primary_green),
                modifier = Modifier.width(200.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}