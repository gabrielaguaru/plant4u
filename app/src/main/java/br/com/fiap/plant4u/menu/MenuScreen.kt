package br.com.fiap.plant4u.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.plant4u.R
import br.com.fiap.plant4u.components.Header
import br.com.fiap.plant4u.components.MenuOption

@Composable
fun MenuScreen(navController: NavController, name: String, id: Long) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Header(
            navController = navController,
            isMenuOpen = true,
            id = id,
            name = name
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "O que deseja?",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.primary_green)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            MenuOption(
                navController,
                "Home",
                R.color.primary_green,
                R.color.secondary_green,
                "home/${name}/${id}"
            )
            MenuOption(
                navController,
                "Minha conta",
                R.color.primary_green,
                R.color.white,
                "my-account/${name}/${id}"
            )
            MenuOption(
                navController,
                "Minhas plantas",
                R.color.primary_green,
                R.color.secondary_green,
                "my-plants/${name}/${id}"
            )
            MenuOption(
                navController,
                "Cadastrar plantas",
                R.color.primary_green,
                R.color.white,
                "register-plant/${name}/${id}"
            )
            MenuOption(
                navController,
                "Sair",
                R.color.primary_red,
                R.color.white,
                "login"
            )

        }
    }

}