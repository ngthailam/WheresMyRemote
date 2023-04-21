package vn.thailam.wheresmyremote.ui.feature.additem

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import vn.thailam.wheresmyremote.ui.utils.AutoRouteNavigator

@Composable
fun AddItemScreen(
    navController: NavController,
    placeId: Int? = null,
    viewModel: AddItemViewModel = hiltViewModel()
) {
    val text = remember { mutableStateOf(TextFieldValue("")) }
    AutoRouteNavigator(
        routeNavigator = viewModel,
        navController = navController
    )

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
