package br.com.fiap.plant4u.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.plant4u.R

@Composable
fun MenuOption(
    navController: NavController,
    name: String,
    textColor: Int,
    backgroundColor: Int,
    path: String
) {
    Button(
        onClick = {
            if (path.isNotEmpty()) {
                navController.navigate(path)
            }
        },
        colors = ButtonDefaults.buttonColors(
            contentColor = colorResource(id = textColor),
            containerColor = colorResource(id = backgroundColor)
        ),
        shape = RectangleShape,
        contentPadding = PaddingValues(horizontal = 35.dp, vertical = 25.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = name,
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 24.sp
        )
    }
}