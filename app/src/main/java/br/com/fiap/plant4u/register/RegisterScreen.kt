package br.com.fiap.plant4u.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
import br.com.fiap.plant4u.components.Header
import br.com.fiap.plant4u.components.Input

@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel
) {

    val name by registerViewModel.name.observeAsState(initial = "")
    val email by registerViewModel.email.observeAsState(initial = "")
    val confirmEmail by registerViewModel.confirmEmail.observeAsState(initial = "")
    val password by registerViewModel.password.observeAsState(initial = "")
    val confirmPassword by registerViewModel.confirmPassword.observeAsState(initial = "")
    val showError by registerViewModel.showError.observeAsState(initial = false)
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        BigLogo(navController, true, "Preencha os dados abaixo para continuar")
        Column(modifier = Modifier.padding(horizontal = 72.dp)) {
            Input(
                name,
                "Nome",
                0,
                updateValue = {
                    registerViewModel.onNameChange(it)
                }
            )
            Input(
                email,
                "E-mail",
                0,
                updateValue = {
                    registerViewModel.onEmailChange(it)
                },
                KeyboardType.Email
            )
            Input(
                confirmEmail,
                "Confirmar e-mail",
                0,
                updateValue = {
                    registerViewModel.onConfirmEmailChange(it)
                },
                KeyboardType.Email
            )
            Input(
                password,
                "Senha",
                0,
                updateValue = {
                    registerViewModel.onPasswordChange(it)
                },
                KeyboardType.Password
            )
            Input(
                confirmPassword,
                "Confirmar senha",
                0,
                updateValue = {
                    registerViewModel.onConfirmPasswordChange(it)
                },
                KeyboardType.Password
            )
            Spacer(modifier = Modifier.height(10.dp))
            Column() {
                if (showError) {
                    Text(
                        text = "Os e-mails ou senhas não coincidem.",
                        color = Color.Red,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                Button(
                    onClick = {
                        //navController.navigate("home")
                        if(email == confirmEmail && password == confirmPassword) {
                            registerViewModel.performRegistration(name, email, password, context, navController)
                            registerViewModel.onShowErrorChange(false)
                        } else {
                            registerViewModel.onShowErrorChange(true)
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
                        text = "Concluir"
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}