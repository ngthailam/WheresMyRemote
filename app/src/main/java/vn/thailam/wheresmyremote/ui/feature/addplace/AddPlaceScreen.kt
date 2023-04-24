package vn.thailam.wheresmyremote.ui.feature.addplace

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import vn.thailam.wheresmyremote.ui.composable.BasicAppBar
import vn.thailam.wheresmyremote.ui.feature.addplace.composable.AddPhoto
import vn.thailam.wheresmyremote.ui.utils.AutoRouteNavigator
import vn.thailam.wheresmyremote.ui.utils.DestinationArg

@Composable
fun AddPlaceScreen(
    navController: NavController,
    savedStateHandle: SavedStateHandle? = null,
    viewModel: AddPlaceViewModel = hiltViewModel()
) {
    val cameraPathUri = remember { mutableStateOf("") }
    val setImageUri = { uri: String ->
        cameraPathUri.value = uri
        viewModel.onImageUriPathChanged(uri)
    }

    LaunchedEffect(Unit) {
        val pathUri = savedStateHandle?.get<String>(DestinationArg.CAMERA_IMG_URI).orEmpty()
        if (pathUri.isNotEmpty()) {
            setImageUri(pathUri)
            savedStateHandle?.remove<String>(DestinationArg.CAMERA_IMG_URI)
        }
    }

    AutoRouteNavigator(
        routeNavigator = viewModel,
        navController = navController
    )

    Column {
        BasicAppBar(
            onIconClick = navController::popBackStack,
            title = "Add A Location"
        )

        Box(modifier = Modifier.weight(1f)) {
            Content(
                cameraPathUri = cameraPathUri.value,
                viewModel = viewModel,
                navController = navController,
                onRemovePhoto = {
                    setImageUri("")
                }
            )
        }

        ConfirmButton(onClick = viewModel::confirmInsert)
    }
}

@Composable
private fun Content(
    navController: NavController,
    viewModel: AddPlaceViewModel,
    cameraPathUri: String,
    onRemovePhoto: () -> Unit,
) {
    val nameText = remember { mutableStateOf(TextFieldValue("")) }
    val descText = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        TextField(
            value = nameText.value,
            onValueChange = { newText ->
                nameText.value = newText
                viewModel.onNameChanged(newText.text)
            },
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent,
            ),
            placeholder = { Text(text = "Location", color = Color.Gray) }
        )
        TextField(
            value = descText.value,
            onValueChange = { newText ->
                descText.value = newText
                viewModel.onDescChanged(newText.text)
            },
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent,
            ),
            placeholder = { Text(text = "Description", color = Color.Gray) }
        )
        Spacer(modifier = Modifier.height(16.dp))

        AddPhoto(
            navController = navController,
            cameraPathUri = cameraPathUri,
            onRemovePhoto = onRemovePhoto,
        )
    }
}

@Composable
private fun ConfirmButton(
    onClick: () -> Unit
) {
    ExtendedFloatingActionButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp),
        text = {
            Text(text = "Confirm")
        },
        icon = {
            // Do nothing here
        },
        onClick = onClick,
    )
}
