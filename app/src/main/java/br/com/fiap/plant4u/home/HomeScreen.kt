package br.com.fiap.plant4u.home

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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.plant4u.R
import br.com.fiap.plant4u.components.Carousel
import br.com.fiap.plant4u.components.Header
import br.com.fiap.plant4u.components.PlantCard
import br.com.fiap.plant4u.repository.getAllPlants
import br.com.fiap.plant4u.repository.getAllTexts

@Composable
fun HomeScreen(
    navController: NavController, homeScreenViewModel: HomeScreenViewModel
) {

    val watering by homeScreenViewModel.watering.observeAsState(initial = false)
    val carouselCurrentIndex by homeScreenViewModel.carouselCurrentIndex.observeAsState(initial = 0)

    val texts = getAllTexts()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Header(
            navController, showBackButton = false
        )
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Olá, Gabriela",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.primary_green)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Minhas plantas",
                    color = colorResource(id = R.color.primary_green),
                    fontSize = 18.sp
                )
                Button(
                    onClick = {
                        navController.navigate("my-plants")
                    }, colors = ButtonDefaults.buttonColors(
                        contentColor = colorResource(id = R.color.primary_green),
                        containerColor = Color.Transparent
                    ), contentPadding = PaddingValues(horizontal = 5.dp)
                ) {
                    Text(
                        text = "Ver todas", fontSize = 14.sp
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Ícone seta para direita"
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.height(355.dp)
            ) {
                items(getAllPlants().take(3)) {
                    PlantCard(
                        it.imageId,
                        it.name,
                        it.lastWatering,
                        it.frequency,
                        it.nextWatering,
                        updateClickedButton = {
                            homeScreenViewModel.onWateringChanged(!watering)
                        },
                        it.isError
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Dicas",
                    color = colorResource(id = R.color.primary_green),
                    fontSize = 18.sp
                )
//                Botão de ver mais dicas - futuramente
//                Button(
//                    onClick = {
//                        //navController.navigate("tips")
//                    }, colors = ButtonDefaults.buttonColors(
//                        contentColor = colorResource(id = R.color.primary_green),
//                        containerColor = Color.Transparent
//                    ), contentPadding = PaddingValues(horizontal = 5.dp)
//                ) {
//                    Text(
//                        text = "Ver mais", fontSize = 14.sp
//                    )
//                    Icon(
//                        imageVector = Icons.Default.KeyboardArrowRight,
//                        contentDescription = "Ícone seta para direita"
//                    )
//                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Carousel(texts[carouselCurrentIndex], addCurrentIndex = {
                homeScreenViewModel.onCarouselCurrentIndexChanged((carouselCurrentIndex + 1) % texts.size)
            }, removeCurrentIndex = {
                homeScreenViewModel.onCarouselCurrentIndexChanged((carouselCurrentIndex - 1 + texts.size) % texts.size)
            })
            Spacer(modifier = Modifier.height(20.dp))
        }

    }
}

