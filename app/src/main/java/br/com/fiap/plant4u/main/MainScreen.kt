package br.com.fiap.plant4u.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.plant4u.R
import br.com.fiap.plant4u.components.BigLogo

@Composable
fun MainScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        BigLogo(navController)

        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Image(
                painter = painterResource(id = R.drawable.gardener2),
                contentDescription = "Imagem de uma pessoa praticando jardinagem"
            )
            Spacer(modifier = Modifier.height(50.dp))
            Column(modifier = Modifier.padding(horizontal = 48.dp)) {
                Button(
                    onClick = {
                        navController.navigate("login")
                    }, colors = ButtonDefaults.buttonColors(
                        contentColor = colorResource(id = R.color.primary_green),
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(vertical = 15.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(2.dp, RoundedCornerShape(6.dp)),
                    border = BorderStroke(2.dp, colorResource(id = R.color.primary_green))
                ) {
                    Text(
                        text = "Login"
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Button(
                    onClick = {
                        navController.navigate("register")
                    }, colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = colorResource(id = R.color.primary_green)
                    ),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(vertical = 15.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(2.dp, RoundedCornerShape(6.dp))
                ) {
                    Text(
                        text = "Registre-se"
                    )
                }
            }
        }
    }
}