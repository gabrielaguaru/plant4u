package br.com.fiap.plant4u.register_plant

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.plant4u.R
import br.com.fiap.plant4u.components.DropdownInput
import br.com.fiap.plant4u.components.Header
import br.com.fiap.plant4u.components.Input

@Composable
fun RegisterPlantScreen(
    navController: NavController,
    registerPlantViewModel: RegisterPlantViewModel,
    fullName: String,
    id: Long
) {

    val name by registerPlantViewModel.name.observeAsState(initial = "")
    val frequency by registerPlantViewModel.frequency.observeAsState(initial = "")
    val interval by registerPlantViewModel.interval.observeAsState(initial = "")
    val showError by registerPlantViewModel.showError.observeAsState(initial = false)

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
                text = "Cadastrar planta",
                color = colorResource(id = R.color.primary_green),
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            Input(
                name,
                "Nome da planta*",
                0,
                updateValue = {
                    registerPlantViewModel.onNameChange(it)
                }
            )
            DropdownInput(options = listOf("1x", "2x", "3x", "4x", "5x"),
                updateValue = {
                    registerPlantViewModel.onFrequencyChange(it)
                })
            DropdownInput(
                "Intervalo de tempo*",
                listOf("Por dia", "Por semana", "Por mês"),
                updateValue = {
                    registerPlantViewModel.onIntervalChange(it)
                }
            )

            var imageUri by remember { mutableStateOf<Uri?>(null) }
            val context = LocalContext.current
            val bitmap = remember { mutableStateOf<Bitmap?>(null) }
            val launcher =
                rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
                    imageUri = uri
                }
            Button(
                onClick = {
                    launcher.launch("image/*")
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
                    text = "Adicione uma imagem"
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier.height(80.dp)
            ) {
                imageUri?.let {
                    if (Build.VERSION.SDK_INT < 28) {
                        bitmap.value = MediaStore.Images
                            .Media.getBitmap(context.contentResolver, it)
                    } else {
                        val source = ImageDecoder
                            .createSource(context.contentResolver, it)
                        bitmap.value = ImageDecoder.decodeBitmap(source)
                    }

                    bitmap.value?.let { btm ->
                        Image(
                            bitmap = btm.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier.size(400.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Deseja receber notificações  sobre a frequência de rega?",
                    modifier = Modifier.weight(1f),
                    color = colorResource(id = R.color.primary_green)
                )
                Switch(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                    colors = SwitchDefaults.colors(checkedTrackColor = colorResource(id = R.color.primary_green))
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            if (showError) {
                Text(
                    text = "Os campos nome da planta, frequência e intervalo são obrigatórios.",
                    color = Color.Red,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
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
                    text = "Cadastrar"
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}