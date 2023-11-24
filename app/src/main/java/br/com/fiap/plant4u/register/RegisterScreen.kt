package br.com.fiap.plant4u.register

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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.plant4u.R
import br.com.fiap.plant4u.components.BigLogo
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
    val showErrorEmailOrPassword by registerViewModel.showErrorEmailOrPassword.observeAsState(initial = false)
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
                        text = "Preencha todos os campos para continuar",
                        color = Color.Red,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                } else if (showErrorEmailOrPassword) {
                    Text(
                        text = "Os e-mails ou senhas não coincidem.",
                        color = Color.Red,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
                Button(
                    onClick = {
                        if(email.isEmpty() || confirmEmail.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                            registerViewModel.onShowErrorChange(true)
                        } else if (email != confirmEmail || password != confirmPassword) {
                            registerViewModel.onShowErrorEmailOrPasswordChange(true)
                            registerViewModel.onShowErrorChange(false)
                        } else {
                            registerViewModel.performRegistration(name, email, password, context, navController)
                            registerViewModel.onShowErrorEmailOrPasswordChange(false)
                            registerViewModel.onShowErrorChange(false)
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