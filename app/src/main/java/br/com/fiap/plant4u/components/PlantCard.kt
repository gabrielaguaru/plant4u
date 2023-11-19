package br.com.fiap.plant4u.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.plant4u.R

@Composable
fun PlantCard(
    idImage: Int,
    name: String,
    lastWatering: String,
    frequency: String,
    nextWatering: String,
    updateClickedButton: () -> Unit,
    isError: Boolean = false,
    hasEditIcons: Boolean = false
) {
    val cardColor = if (isError) R.color.secondary_red else R.color.secondary_green
    val nextWateringColor = if (isError) R.color.primary_red else R.color.black

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(105.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = cardColor))
    ) {

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Column(
                modifier = Modifier
                    .width(100.dp)
            ) {
                Image(
                    painter = painterResource(id = idImage),
                    contentDescription = "Imagem da planta",
                    modifier = Modifier
                        .width(100.dp)
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = name,
                            fontSize = 14.sp
                        )
                        if (isError) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_warning_22),
                                tint = colorResource(id = R.color.primary_red),
                                contentDescription = "Ícone de aviso"
                            )
                        }
                    }

                    if (hasEditIcons) {
                        Row {
                            IconButton(onClick = {  /*TODO*/ }, modifier = Modifier.height(30.dp)) {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_edit_20),
                                    contentDescription = "Ícone de lápis",
                                    tint = colorResource(id = R.color.primary_green)
                                )
                            }
                            IconButton(onClick = {  /*TODO*/ }, modifier = Modifier.height(30.dp)) {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_delete_20),
                                    contentDescription = "Ícone de lixeira",
                                    tint = colorResource(id = R.color.primary_green)
                                )
                            }
                        }
                    } else {
                        Button(
                            onClick = updateClickedButton,
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.White,
                                containerColor = colorResource(id = R.color.primary_green)
                            ),
                            contentPadding = PaddingValues(
                                horizontal = 5.dp
                            ),
                            shape = RoundedCornerShape(6.dp),
                            modifier = Modifier.height(30.dp)
                        ) {
                            Text(
                                text = "Regar",
                                fontSize = 14.sp
                            )
                            Image(
                                painter = painterResource(id = R.drawable.watering_can),
                                contentDescription = "Imagem de regador",
                                modifier = Modifier.size(width = 19.dp, height = 19.dp)
                            )
                        }
                    }
                }
                Column {
                    Text(
                        text = "Última rega: $lastWatering",
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Freq. de rega: $frequency",
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Próx. rega: $nextWatering",
                        fontSize = 14.sp,
                        color = colorResource(id = nextWateringColor)
                    )
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}