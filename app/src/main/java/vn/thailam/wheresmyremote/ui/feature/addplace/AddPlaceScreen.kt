package vn.thailam.wheresmyremote.ui.feature.addplace

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddPlaceScreen(
    viewModel: AddPlaceViewModel = hiltViewModel()
) {
    val text = remember { mutableStateOf(TextFieldValue("")) }

    Column {
        TextField(value = text.value, onValueChange = { newText ->
            text.value = newText
            viewModel.onNameChanged(newText.text)
        })

        Button(onClick = {
            viewModel.confirmInsert()
        }) {
            Text(text = "Confirm")
        }
    }
}