package br.com.fiap.plant4u.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.plant4u.R
import br.com.fiap.plant4u.ui.theme.Montserrat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownInput(
    label: String = "Frequência de rega",
    options: List<String>,
    updateValue: (String) -> Unit
    ) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { updateValue },
            label = { Text(label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
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
            modifier = Modifier.menuAnchor().fillMaxWidth()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(text = selectionOption) },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}