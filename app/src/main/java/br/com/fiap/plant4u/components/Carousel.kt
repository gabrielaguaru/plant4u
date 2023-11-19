package br.com.fiap.plant4u.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.plant4u.R

@Composable
fun Carousel(
    text: String,
    addCurrentIndex: () -> Unit,
    removeCurrentIndex: () -> Unit
) {

    var visible by remember {
        mutableStateOf(false)
    }

    var enter by remember {
        mutableStateOf(fadeIn())
    }

    var exit by remember {
        mutableStateOf(fadeOut())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(id = R.color.primary_green),
                shape = RoundedCornerShape(6.dp)
            )
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            IconButton(onClick = removeCurrentIndex) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_chevron_left_24),
                    contentDescription = "Seta para esquerda",
                    tint = Color.White
                )
            }
            Crossfade(
                targetState = text,
                animationSpec = tween(durationMillis = 500),
                label = "Fade",
                modifier = Modifier.weight(1f)
            ) { newText ->
                Text(
                    text = newText,
                    fontSize = 13.sp,
                    color = Color.White,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }

            IconButton(onClick = addCurrentIndex) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_chevron_right_30),
                    contentDescription = "Seta para direita",
                    tint = Color.White
                )
            }
        }
    }
}
