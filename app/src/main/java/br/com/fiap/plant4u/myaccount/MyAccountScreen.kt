package br.com.fiap.plant4u.myaccount

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.plant4u.R
import br.com.fiap.plant4u.components.AccordionHeader
import br.com.fiap.plant4u.components.Header
import br.com.fiap.plant4u.components.Input

@Composable
fun MyAccountScreen(
    navController: NavController,
    myAccountViewModel: MyAccountViewModel,
    fullName: String,
    id: Long
) {

    val email by myAccountViewModel.email.observeAsState(initial = "")
    val currPassword by myAccountViewModel.currPassword.observeAsState(initial = "")
    val newPassword by myAccountViewModel.newPassword.observeAsState(initial = "")

    val checkedState = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Header(navController, id = id, name = fullName)
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Minha conta",
                color = colorResource(id = R.color.primary_green),
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            Input(
                fullName,
                "Nome",
                0,
                updateValue = {

                }
            )
            Input(
        "*********@******.com",
                "Email",
                0,
                updateValue = {

                },
                KeyboardType.Email
            )


            var expanded by remember { mutableStateOf(false) }
            @OptIn(ExperimentalAnimationApi::class)
            Column(modifier = Modifier.height(250.dp)) {
                AccordionHeader(isExpanded = expanded) {
                    expanded = !expanded
                }
                AnimatedVisibility(visible = expanded) {
                    Surface(
                        color = colorResource(id = R.color.secondary_green),
                        shape = RoundedCornerShape(8.dp)

                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                                Input(
                                    currPassword,
                                    "Senha atual",
                                    0,
                                    updateValue = {
                                        myAccountViewModel.onCurrPasswordChange(it)
                                    },
                                    KeyboardType.Password
                                )
                                Input(
                                    newPassword,
                                    "Nova senha",
                                    0,
                                    updateValue = {
                                        myAccountViewModel.onNewPasswordChange(it)
                                    },
                                    KeyboardType.Password
                                )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {
                    navController.navigate("my-plants/${fullName}/${id}")
                }, colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = colorResource(id = R.color.primary_green)
                ),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(vertical = 15.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Confirmar"
                )
            }
        }
    }
}