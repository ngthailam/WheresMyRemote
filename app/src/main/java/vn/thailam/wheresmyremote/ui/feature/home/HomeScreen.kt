package vn.thailam.wheresmyremote.ui.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val places by viewModel.places.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.observePlaces()
    }

    Box {
       Text(text = "${places.size}")
    }
}
