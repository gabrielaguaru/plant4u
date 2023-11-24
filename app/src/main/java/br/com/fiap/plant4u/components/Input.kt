package br.com.fiap.plant4u.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.plant4u.R
import br.com.fiap.plant4u.ui.theme.Montserrat

@Composable
fun Input(
    value: String,
    label: String,
    iconId: Int,
    updateValue: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedLabelColor = colorResource(id = R.color.primary_green),
            unfocusedLabelColor = colorResource(id = R.color.primary_green),
            focusedIndicatorColor = colorResource(id = R.color.primary_green),
            unfocusedIndicatorColor = colorResource(id = R.color.primary_green),
            focusedTrailingIconColor = colorResource(id = R.color.primary_green),
            unfocusedTrailingIconColor = colorResource(id = R.color.primary_green)
        ),
        textStyle = TextStyle(
            color = colorResource(id = R.color.primary_green),
            fontSize = 18.sp,
            textDecoration = TextDecoration.None,
            fontFamily = Montserrat
        ),
        onValueChange = updateValue,
        label = {
            Text(label)
        },
        trailingIcon = {
            if (iconId != 0) {
                Icon(
                    painter = painterResource(id = iconId),
                    contentDescription = "Ícone da caixa de texto"
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = if (keyboardType == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None
    )
    Spacer(modifier = Modifier.height(20.dp))
}