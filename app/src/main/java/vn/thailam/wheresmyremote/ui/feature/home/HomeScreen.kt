package vn.thailam.wheresmyremote.ui.feature.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import vn.thailam.wheresmyremote.data.entity.PlaceEntity
import vn.thailam.wheresmyremote.ui.utils.AppDestinations
import vn.thailam.wheresmyremote.ui.utils.toPlaceDetail

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val places by viewModel.places.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.observePlaces()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(all = 16.dp),
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 16.dp,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(places.size) { count ->
                PlaceItem(place = places[count], navController = navController)
            }
        }

        ExtendedFloatingActionButton(
            modifier = Modifier
                .padding(all = 16.dp)
                .align(alignment = Alignment.BottomEnd),
            elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp),
            text = {
                Text(text = "Add A Place")
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add A Place FAB",
                )
            },
            onClick = {
                navController.navigate(route = AppDestinations.ADD_PLACE)
            },
        )
    }
}

@Composable
fun PlaceItem(
    place: PlaceEntity,
    navController: NavController,
) {
    val height = place.id!! * 64
    Box(modifier = Modifier
        .background(color = Color.Blue)
        .height(height.dp)
        .clickable {
            navController.toPlaceDetail(placeId = place.id)
        }
    ) {
        Text(modifier = Modifier.padding(all = 16.dp), text = place.name)
    }
}
