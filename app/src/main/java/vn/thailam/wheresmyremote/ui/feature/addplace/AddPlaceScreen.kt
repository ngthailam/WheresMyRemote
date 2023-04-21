package vn.thailam.wheresmyremote.ui.feature.addplace

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import vn.thailam.wheresmyremote.ui.composable.dashedBorder
import vn.thailam.wheresmyremote.ui.utils.AutoRouteNavigator

@Composable
fun AddPlaceScreen(
    navController: NavController,
    viewModel: AddPlaceViewModel = hiltViewModel()
) {
    val text = remember { mutableStateOf(TextFieldValue("")) }

    AutoRouteNavigator(
        routeNavigator = viewModel,
        navController = navController
    )


    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconButton(

            onClick = navController::popBackStack
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Name")
        TextField(
            value = text.value,
            onValueChange = { newText ->
                text.value = newText
                viewModel.onNameChanged(newText.text)
            },
        )

        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .aspectRatio(1f)
                .dashedBorder(1.dp, Color.Red, 8.dp),

            ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(
                    imageVector = Icons.Outlined.Call,
                    contentDescription = "Add A Place FAB",
                )
                Text(
                    textAlign = TextAlign.Center, text = "Add photo"
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        ExtendedFloatingActionButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp),
            text = {
                Text(text = "Confirm")
            },
            icon = {

            },
            onClick = viewModel::confirmInsert,
        )
    }
}