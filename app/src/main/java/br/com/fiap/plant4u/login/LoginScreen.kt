package br.com.fiap.plant4u.login

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.plant4u.R
import br.com.fiap.plant4u.components.BigLogo
import br.com.fiap.plant4u.components.Input

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel
) {

    val email by loginViewModel.email.observeAsState(initial = "")
    val password by loginViewModel.password.observeAsState(initial = "")
    val loginState by loginViewModel.loginState.observeAsState()
    val showError by loginViewModel.showError.observeAsState(initial = false)
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        BigLogo(navController, true, "Preencha os dados abaixo para continuar")
        Column(modifier = Modifier.padding(horizontal = 72.dp)) {
            Spacer(modifier = Modifier.height(30.dp))
            Input(
                email,
                "E-mail",
                R.drawable.baseline_email_24,
                updateValue = {
                    loginViewModel.onEmailChange(it)
                },
                KeyboardType.Email
            )
            Input(
                password,
                "Senha",
                R.drawable.baseline_lock_24,
                updateValue = {
                    loginViewModel.onPasswordChange(it)
                },
                KeyboardType.Password
            )
            Spacer(modifier = Modifier.height(50.dp))
            Column() {
                if (showError) {
                    Text(
                        text = "Preencha todos os campos para continuar",
                        color = Color.Red,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
                Button(
                    onClick = {
                        if(email.isEmpty() || password.isEmpty()) {
                            loginViewModel.onShowErrorChange(true)
                        } else {
                            performLogin(email, password, context, navController)
                            loginViewModel.onShowErrorChange(false)
                        }
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
                        text = "Login"
                    )
                }
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = "Não tem uma conta?",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.primary_green),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(5.dp))
                Button(
                    onClick = {
                        navController.navigate("register")
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
                        text = "Registre-se"
                    )
                }
            }
        }
    }
}