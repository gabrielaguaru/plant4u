package br.com.fiap.plant4u.myplants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.plant4u.R
import br.com.fiap.plant4u.components.Header
import br.com.fiap.plant4u.components.PlantCard
import br.com.fiap.plant4u.repository.getAllPlants

@Composable
fun MyPlantsScreen(
    navController: NavController,
    myPlantsScreenViewModel: MyPlantsScreenViewModel,
    name: String,
    id: Long
) {
    val watering by myPlantsScreenViewModel.watering.observeAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Header(navController, id = id, name = name)
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Minhas plantas",
                    color = colorResource(id = R.color.primary_green),
                    fontSize = 22.sp
                )
                Button(
                    onClick = {
                        navController.navigate("register-plant/${name}/${id}")
                    }, colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = colorResource(id = R.color.primary_green)
                    ),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Cadastrar planta"
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            LazyColumn(
                modifier = Modifier
                    .height(600.dp)
            ) {
                items(getAllPlants()) {
                    PlantCard(
                        it.imageId,
                        it.name,
                        it.lastWatering,
                        it.frequency,
                        it.nextWatering,
                        updateClickedButton = {
                            myPlantsScreenViewModel.onWateringChanged(!watering)
                        },
                        it.isError,
                        hasEditIcons = true
                    )
                }
            }
        }
    }

}